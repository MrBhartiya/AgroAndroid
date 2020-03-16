package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.DownloadedVideoModel;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.model.SearchModel;
import com.mrbhartiya.education.ui.adapter.DemoVideoPagerAdapter;
import com.mrbhartiya.education.ui.adapter.DownloadAdapter;
import com.mrbhartiya.education.ui.adapter.FavouriteAdapter;
import com.mrbhartiya.education.ui.adapter.SubjectAdapter;
import com.mrbhartiya.education.ui.adapter.TeacherAdapter;
import com.mrbhartiya.education.utility.Constant;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.SystemUtility;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends BaseActivity implements View.OnClickListener, SubjectAdapter.onSubjectClick, FavouriteAdapter.onFavouriteClick, DownloadAdapter.onDownloadClick {
    ViewPager mPager;
    CircleIndicator mIndicator;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private RecyclerView horizontal_recycler_view;
    private RecyclerView teacherrecyclerView;
    private RecyclerView favouriterecyclerView;
    private RecyclerView downloadedrecyclerView;
    private SubjectAdapter subjectAdapter;
    private TeacherAdapter teacherAdapter;
    private FavouriteAdapter favouriteAdapter;
    private DownloadAdapter downloadAdapter;
    private List<HomeModel.DataBean.SubjectListBean> subject = new ArrayList<>();
    private List<HomeModel.DataBean.DemoVideoListBean> demoList = new ArrayList<>();
    private List<HomeModel.DataBean.TeacherListBean> teacherList = new ArrayList<>();
    private List<HomeModel.DataBean.FavouriteVideosBean> favouriteVideosBeans = new ArrayList<>();
    private List<SearchModel.DataBean> searchResult = new ArrayList<>();
    private List<DownloadedVideoModel> downloadedVideo = new ArrayList<>();
    private List<HomeModel.DataBean.SubscriptionBean> subscriptionBeans = new ArrayList<>();
    private ImageView imgNavToggle;
    private TextView txtDemoViewAll, txtFavViewAll;
    private View mTeacherView;
    private View mDownloadView;
    private View mFavouriteVideo;
    private String userName;
    private String userEmail;
    private TextView mUserName;
    private TextView mUserEmail;
    private Boolean isVideoPurchased = false;
    private EditText mSearch;
    private String userImageURL = "";
    private LinearLayout mDemoHeader;
    private CircleImageView mProfileImage;
    private ImageView fab;
    private ImageView mSubscriptionView;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initializeView();
        try {
            JSONObject obj = new JSONObject(PreferenceHelper.getKeyUserData());
            JSONObject userObject = obj.getJSONObject("data");
            mUserName.setText(userObject.getString("name"));
            mUserEmail.setText(userObject.getString("email_id"));
            isVideoPurchased = userObject.getBoolean("is_video_purchased");
            userImageURL = userObject.getString("profile_image");
            Picasso.get().load(userImageURL).into(mProfileImage);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        getHomeData("Loading...");

    }

    private void initializeView() {
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        mPager = findViewById(R.id.pager);
        mIndicator = findViewById(R.id.indicator);
        subjectAdapter = new SubjectAdapter(subject, this);
        teacherAdapter = new TeacherAdapter(teacherList, this);
        favouriteAdapter = new FavouriteAdapter(favouriteVideosBeans, this);
        downloadAdapter = new DownloadAdapter(downloadedVideo, this);
        mTeacherView = findViewById(R.id.teacher_view);
        mDownloadView = findViewById(R.id.download_view);
        mFavouriteVideo = findViewById(R.id.fav_viideo);
        mDemoHeader = findViewById(R.id.demo_header);
        mSubscriptionView = findViewById(R.id.subsctiption_back);
        fab = findViewById(R.id.fab);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PreferenceHelper.getLastPlayed() != null && !PreferenceHelper.getLastPlayed().equalsIgnoreCase("")) {
                    Intent player = new Intent(HomeActivity.this, VideoPlayer.class);
                    player.putExtra("url", PreferenceHelper.getLastPlayed());
                    startActivity(player);
                }
            }
        });
        dl.addDrawerListener(t);
        t.syncState();
        nv = findViewById(R.id.nv);
        View headerLayout = nv.inflateHeaderView(R.layout.nav_header);
        mUserName = headerLayout.findViewById(R.id.user_name);
        mUserEmail = headerLayout.findViewById(R.id.user_email);
        mProfileImage = headerLayout.findViewById(R.id.profile_image);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_logout:
                        SystemUtility.showAlert(HomeActivity.this, getResources().getString(R.string.app_name), "Are you sure want to logout ?", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                PreferenceHelper.clear();
                                deleteFiles(Constant.STORAGE_LOCATION);
                                PreferenceHelper.setDeviceUuid(Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID));
                                startActivity(new Intent(HomeActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                            }
                        });
                        break;
                    case R.id.nav_fav_video:
                        favouriteVideo();
                        break;
                    case R.id.nav_need_help:
                        startActivity(new Intent(HomeActivity.this, NeedHelpActivity.class));
                        break;
                    case R.id.nav_downloaded_video:
                        if (downloadedVideo != null && downloadedVideo.size() > 0) {
                            startActivity(new Intent(HomeActivity.this, DownloadedVideoActivity.class));
                        } else {
                            Toast.makeText(HomeActivity.this, getResources().getString(R.string.str_no_download_video), Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_refer_earn:
                        startActivity(new Intent(HomeActivity.this, ReferEarnActivity.class));
                        break;
                    case R.id.nav_about_us:
                        startActivity(new Intent(HomeActivity.this, AboutUsActivity.class));

                        break;

                    case R.id.nav_wallet:
                        startActivity(new Intent(HomeActivity.this, WalletActivity.class));
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });
        mPager.setClipToPadding(false);
        mPager.setPadding(120, 0, 120, 0);
        mPager.setPageMargin(20);
        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_subject_view);
        teacherrecyclerView = (RecyclerView) findViewById(R.id.teacher_recycler_view);
        favouriterecyclerView = (RecyclerView) findViewById(R.id.favourite_recycler_view);
        downloadedrecyclerView = (RecyclerView) findViewById(R.id.downloaded_recycler_view);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManagaerTeacher = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManagaerFavourite = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManagaerDownloads = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        teacherrecyclerView.setLayoutManager(horizontalLayoutManagaerTeacher);
        favouriterecyclerView.setLayoutManager(horizontalLayoutManagaerFavourite);
        downloadedrecyclerView.setLayoutManager(horizontalLayoutManagaerDownloads);
        imgNavToggle = findViewById(R.id.drawer_toolbar).findViewById(R.id.img_drawer_togle);
        mSearch = findViewById(R.id.drawer_toolbar).findViewById(R.id.inputSearch);
        imgProfile = findViewById(R.id.drawer_toolbar).findViewById(R.id.profile_image);
        imgProfile.setOnClickListener(this);
        imgNavToggle.setOnClickListener(this);
        txtDemoViewAll = findViewById(R.id.txt_demo_view_all);
        txtDemoViewAll.setOnClickListener(this);
        txtFavViewAll = findViewById(R.id.fav_viideo).findViewById(R.id.txt_fav_view_all);
        txtFavViewAll.setOnClickListener(this);
        mSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    getSearchedItem(mSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });

    }

    private void getSearchedItem(String s) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Searching...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<SearchModel> call = apiService.performSearchOperation(s);
        call.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, retrofit2.Response<SearchModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        searchResult.clear();
                        for (int i = 0; i < response.body().getData().size(); i++)
                            searchResult.add(response.body().getData().get(i));
                        if (searchResult.size() == 0) {
                            Toast.makeText(HomeActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(HomeActivity.this, SearchResultActivity.class).putParcelableArrayListExtra("search_result", (ArrayList<? extends Parcelable>) searchResult));

                        }

                    } else {
                        Toast.makeText(HomeActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(HomeActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(HomeActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void deleteFiles(String path) {

        File file = new File(path);

        if (file.exists()) {
            String deleteCmd = "rm -r " + path;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) {
            }

            downloadedVideo.clear();
        }


    }

    private void getDownloadedVideo() {
        downloadedVideo.clear();
        // String path = Environment.getExternalStorageDirectory().toString();
        File f = new File(Constant.STORAGE_LOCATION);
        File file[] = f.listFiles();
        if (file != null) {
            for (int i = 0; i < file.length; i++) {
                DownloadedVideoModel downloadedVideoModel = new DownloadedVideoModel();
                downloadedVideoModel.setFileName(file[i].getName());
                downloadedVideoModel.setFilePath(file[i].getPath());
                downloadedVideo.add(downloadedVideoModel);
            }

        }
        if (downloadedVideo.size() > 0)
            mDownloadView.setVisibility(View.VISIBLE);
        else
            mDownloadView.setVisibility(View.GONE);
        downloadedrecyclerView.setAdapter(downloadAdapter);


    }

    private void getHomeData(String message) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        progressDialog.setCanceledOnTouchOutside(false);
        if(!message.equalsIgnoreCase(""))
           progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<HomeModel> call = apiService.performHome();
        call.enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, retrofit2.Response<HomeModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        subject.clear();
                        demoList.clear();
                        teacherList.clear();
                        favouriteVideosBeans.clear();
                        subscriptionBeans.clear();
                        for (int i = 0; i < response.body().getData().getSubject_list().size(); i++)
                            subject.add(response.body().getData().getSubject_list().get(i));

                        for (int i = 0; i < response.body().getData().getDemo_video_list().size(); i++)
                            demoList.add(response.body().getData().getDemo_video_list().get(i));

                        for (int i = 0; i < response.body().getData().getTeacher_list().size(); i++)
                            teacherList.add(response.body().getData().getTeacher_list().get(i));

                        for (int i = 0; i < response.body().getData().getFavourite_videos().size(); i++)
                            favouriteVideosBeans.add(response.body().getData().getFavourite_videos().get(i));

//                        for (int i = 0; i < response.body().getData().getSubscription().size(); i++)
//                            subscriptionBeans.add(response.body().getData().getSubscription().get(i));

                        if (favouriteVideosBeans.size() > 0)
                            mFavouriteVideo.setVisibility(View.VISIBLE);
                        else
                            mFavouriteVideo.setVisibility(View.GONE);
                        if (demoList.size() > 0)
                            mDemoHeader.setVisibility(View.VISIBLE);
                        else
                            mDemoHeader.setVisibility(View.GONE);
                        mPager.setAdapter(new DemoVideoPagerAdapter(demoList, HomeActivity.this));
                        mIndicator.setViewPager(mPager);
                        horizontal_recycler_view.setAdapter(subjectAdapter);
                        teacherrecyclerView.setAdapter(teacherAdapter);
                        favouriterecyclerView.setAdapter(favouriteAdapter);
                       // setSubscriptionView(response.body().getData().getSubscription().get(0).getBanner_image());



                    } else {

                        Toast.makeText(HomeActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(HomeActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(HomeActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setSubscriptionView(String banner_image) {
        Picasso.get().load(banner_image).placeholder(R.drawable.profile_pic).into(mSubscriptionView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_drawer_togle:
                if (dl.isDrawerOpen(GravityCompat.START)) {
                    dl.closeDrawer(GravityCompat.END);
                } else {
                    dl.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.txt_demo_view_all:
                if (demoList.size() > 0) {
                    startActivity(new Intent(this, DemoVideoActivity.class).putParcelableArrayListExtra("demoVideo", (ArrayList<? extends Parcelable>) demoList));

                }
                break;

            case R.id.txt_fav_view_all:
                favouriteVideo();
                break;
            case R.id.profile_image:
                startActivity(new Intent(HomeActivity.this, EditProfileActivity.class));
                break;
            default:
                break;
        }
    }


    private void favouriteVideo() {
        if (favouriteVideosBeans != null && favouriteVideosBeans.size() > 0) {
            startActivity(new Intent(this, FavouriteVideoActivity.class).putParcelableArrayListExtra("favVideo", (ArrayList<? extends Parcelable>) favouriteVideosBeans));
        } else {
            Toast.makeText(this, "You don't have any favourite video.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onSubjectItemClick(int position) {
        //  if(isVideoPurchased){
        Intent intent = new Intent(this, ChapterListActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("subject_data", subject.get(position));
        intent.putExtras(b);
        startActivity(intent);
//        }
//        else
//            Toast.makeText(this, "Please Buy Course to view videos", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onFavouriteItemClick(int position) {
        Intent intent = new Intent(this, VideoDiscription.class);
        intent.putExtra("id", favouriteVideosBeans.get(position).getChapter_id());
        intent.putExtra("url", PreferenceHelper.getBucketUrl()+favouriteVideosBeans.get(position).getVideo_url());
        intent.putExtra("description", favouriteVideosBeans.get(position).getDescription());
        intent.putExtra("likes", favouriteVideosBeans.get(position).getVideo_like());
        intent.putExtra("thumbnail", PreferenceHelper.getBucketUrl()+favouriteVideosBeans.get(position).getThumbnail());
        intent.putExtra("notes_url", PreferenceHelper.getBucketUrl()+favouriteVideosBeans.get(position).getVideo_notes_url());
        intent.putExtra("video_name", favouriteVideosBeans.get(position).getVideo_name());
        intent.putExtra("isFavourited", true);
        startActivity(intent);
    }

    @Override
    public void onDownloadItemClick(int position) {
        Intent intent = new Intent(this, VideoPlayer.class);
        intent.putExtra("path", downloadedVideo.get(position).getFilePath());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getHomeData("");
        getDownloadedVideo();

    }
}
