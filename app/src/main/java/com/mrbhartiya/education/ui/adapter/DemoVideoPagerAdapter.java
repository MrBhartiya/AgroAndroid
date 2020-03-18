package com.mrbhartiya.education.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.ui.activity.VideoDiscription;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DemoVideoPagerAdapter extends PagerAdapter {


    private LayoutInflater inflater;
    private Context context;
    private List<HomeModel.DataBean.DemoVideoListBean> demoVideoList = new ArrayList<>();

    public DemoVideoPagerAdapter(List<HomeModel.DataBean.DemoVideoListBean> demoList, Context context) {
        this.context = context;
        this.demoVideoList = demoList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return demoVideoList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.item_demo_video, view, false);
        view.addView(imageLayout, 0);
        ImageView tvLabel = imageLayout.findViewById(R.id.demo_video_view);


        Picasso.get().load(PreferenceHelper.getBucketUrl()+demoVideoList.get(position).getThumbnail()).placeholder(R.color.demo_background_color).into(tvLabel);
        tvLabel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(context, VideoDiscription.class);
                intent.putExtra("url", demoVideoList.get(position).getVideo_url());
                intent.putExtra("description", demoVideoList.get(position).getDescription());
                intent.putExtra("isLike", demoVideoList.get(position).isIsLiked());
                intent.putExtra("isFavourited", demoVideoList.get(position).isIsFavourited());
                intent.putExtra("thumbnail", demoVideoList.get(position).getThumbnail());
                intent.putExtra("notes_url", demoVideoList.get(position).getVideo_notes_url());
                intent.putExtra("video_name", demoVideoList.get(position).getVideo_name());
                intent.putExtra("video_id", demoVideoList.get(position).getVideo_id());
                context.startActivity(intent);
            }
        });
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
