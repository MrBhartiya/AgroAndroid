package com.mrbhartiya.education.ui.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.BaseModel;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.utility.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.WeakHashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {
    TextView txt_username,txt_useremail,txt_userdob,txt_userclass,txt_userphone,txt_city,txt_userstate;
CircleImageView circleimageview;
ImageView img_edtbutton;
    private RequestBody requestBody;
    private File profileFile;
    private MultipartBody.Part multipartBody;
    private static final int SELCT_GALLERY = 2;
    private static final int SELCT_CAMERA = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        JSONObject obj = null;
        try {
            obj = new JSONObject(PreferenceHelper.getKeyUserData());
            JSONObject userObject = obj.getJSONObject("data");
            txt_username=findViewById(R.id.txt_username);
            txt_useremail=findViewById(R.id.txt_useremail);
            txt_userdob=findViewById(R.id.txt_userdob);
            txt_userclass=findViewById(R.id.txt_userclass);
            txt_userphone=findViewById(R.id.txt_userphone);
            txt_city=findViewById(R.id.txt_city);
            txt_userstate=findViewById(R.id.txt_userstate);

            txt_username.setText(userObject.getString("name"));
            txt_useremail.setText(userObject.getString("email"));
            txt_userdob.setText(userObject.getString("dob"));
            txt_userclass.setText(userObject.getString("user_class"));
            txt_userphone.setText(userObject.getString("mobile_no"));
            txt_city.setText(userObject.getString("city"));
            txt_userstate.setText(userObject.getString("state"));


            circleimageview=findViewById(R.id.circleimageview);
            img_edtbutton=findViewById(R.id.img_edtbutton);

            img_edtbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
                    builder.setTitle("Add Photo!");
                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            if (options[item].equals("Take Photo"))
                            {

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                                {

                                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                                        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA}, SELCT_GALLERY);
                                    }
                                    else {
                                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        File f = new File(android.os.Environment.getExternalStorageDirectory(), "btrausrprofile.jpg");
                                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                                        startActivityForResult(intent, SELCT_CAMERA);
                                    }


                                }
                                else {
                                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "btrausrprofile.jpg");
                                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                                    startActivityForResult(intent, SELCT_CAMERA);
                                }
                            }
                            else if (options[item].equals("Choose from Gallery"))
                            {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                                        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, SELCT_GALLERY);
                                    }
                                    else {
                                        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        intent.setType("image/*");
                                        startActivityForResult(
                                                Intent.createChooser(intent, "Select Image"),
                                                SELCT_GALLERY);
                                    }
                                }
                                else {
                                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    intent.setType("image/*");
                                    startActivityForResult(
                                            Intent.createChooser(intent, "Select Image"),
                                            SELCT_GALLERY);
                                }
                                /*Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(intent, 2);*/
                            }
                            else if (options[item].equals("Cancel")) {
                                dialog.dismiss();
                            }
                        }
                    });
                    builder.show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SELCT_GALLERY && PackageManager.PERMISSION_GRANTED == grantResults[0]) {

            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(
                    Intent.createChooser(intent, "Select Image"),
                    SELCT_GALLERY);
        }
        else if (requestCode == SELCT_CAMERA && PackageManager.PERMISSION_GRANTED == grantResults[0]){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File f = new File(android.os.Environment.getExternalStorageDirectory(), "btrausrprofile.jpg");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
            startActivityForResult(intent, SELCT_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SELCT_CAMERA&&resultCode==RESULT_OK){
            try {
                Uri selectedImageUri = data.getData();
                String picturePath = getPath(getApplicationContext(), selectedImageUri);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Bitmap bitmap = BitmapFactory.decodeFile(picturePath);

                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
                byte[] imageBytes = baos.toByteArray();
               String encoded_membercamera = Base64.encodeToString(imageBytes, Base64.DEFAULT);
                byte[] decodedString = Base64.decode(encoded_membercamera, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString,
                        0, decodedString.length);
                circleimageview.setImageBitmap(decodedByte);
                _callapiforpost(data);

            }catch (Exception e){
                e.printStackTrace();
                String s=e.toString();
            }
        }
        else if (requestCode==SELCT_GALLERY&&resultCode==RESULT_OK){
            try {

                Uri selectedImageUri = data.getData();
                String picturePath = getPath(getApplicationContext(), selectedImageUri);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Bitmap bitmap = BitmapFactory.decodeFile(picturePath);

                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
                byte[] imageBytes = baos.toByteArray();
             String   encoded_membergallery = Base64.encodeToString(imageBytes, Base64.DEFAULT);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos); // bm is
                byte[]    photoimage = baos.toByteArray();
                  circleimageview.setImageBitmap(BitmapFactory.decodeByteArray(photoimage, 0, photoimage.length));
               String changeImageProfilePicturePath=picturePath;
                Cursor returnCursor = getContentResolver().query(selectedImageUri, null,
                        null, null, null);

                int nameIndex = returnCursor
                        .getColumnIndex(OpenableColumns.DISPLAY_NAME);

                returnCursor.moveToFirst();



                _callapiforpost(data);


            }catch (Exception e){
                e.printStackTrace();
                String s=e.toString();
            }
    }}

    private void _callapiforpost(Intent data) {
        try{


        Uri selectedImageUri = data.getData();
        String picturePath = getPath(getApplicationContext(), selectedImageUri);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
        final Bitmap photo = bitmap;
        File file = savebitmap(photo);

        requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        multipartBody = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<BaseModel> call = apiService.userprofileupdate(multipartBody);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, retrofit2.Response<BaseModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    Toast.makeText(EditProfileActivity.this, "Profile uploaded successfully..", Toast.LENGTH_SHORT).show();
finish();
                } else
                    Toast.makeText(EditProfileActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditProfileActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
        }catch (Exception e)
        {
            String jj=e.toString();
        }


    }

    public static String getPath(Context context, Uri uri ) {
            String result = null;
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor cursor = context.getContentResolver( ).query( uri, proj, null, null, null );
            if(cursor != null){
                if ( cursor.moveToFirst( ) ) {
                    int column_index = cursor.getColumnIndexOrThrow( proj[0] );
                    result = cursor.getString( column_index );
                }
                cursor.close( );
            }
            if(result == null) {
                result = "Not found";
            }
            return result;
        }
    private File savebitmap(Bitmap bmp) {
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        OutputStream outStream = null;
        // String temp = null;
        File file = new File(extStorageDirectory, "userimage.png");
        if (file.exists()) {
            file.delete();
            file = new File(extStorageDirectory, "userimage.png");

        }

        try {
            outStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }
}
