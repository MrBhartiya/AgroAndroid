package com.mrbhartiya.education.api;

import com.mrbhartiya.education.api.response.BaseResponse;
import com.mrbhartiya.education.model.AssessmentModel;
import com.mrbhartiya.education.model.ChapterModel;
import com.mrbhartiya.education.model.CitiesModel;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.model.SearchModel;
import com.mrbhartiya.education.model.SignupModel;
import com.mrbhartiya.education.model.StatesModel;
import com.mrbhartiya.education.model.TopicModel;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.model.VideoOperation;
import com.mrbhartiya.education.utility.Constant;
import com.mrbhartiya.education.utility.PreferenceHelper;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {
     

    @GET("stateClass/list")
    Call<StatesModel> getAllStates();

    @GET("city/list/")
    Call<CitiesModel> getAllCities(@Query("state") String stateName);


    @POST("student/registration")
    Call<SignupModel> performSignup(@Body WeakHashMap<String, String> userDetails);

    @POST("VerifyOTP")
    Call<UserModel> performOTPVerification(@Body WeakHashMap<String, String> userDetails);

    @POST("student/login")
    Call<UserModel> performLogin(@Body WeakHashMap<String, String> userDetails);


    @GET("student/homeapi")
    Call<HomeModel> performHome();


    @GET("subject/list")
    Call<ChapterModel> perfromChapterFetchOperation(@Query("subject_id") String userClass);


    @GET("topic/list/")
    Call<TopicModel> perfromVideoFetchOperation(@Query("chapter_id") String userClass);

    @POST("likeAndComment")
    Call<BaseResponse> performVideoLike(@Body WeakHashMap<String, String> param);

    @POST("favourite")
    Call<VideoOperation> performVideoFavourite( @Body WeakHashMap<String, String> param);


    @HTTP(method = "DELETE", path = "favourite", hasBody = true)
    Call<BaseResponse> performDeleteFavourite(@Body WeakHashMap<String, String> param);


    @HTTP(method = "DELETE", path = "clearAllFavourite", hasBody = true)
    Call<BaseResponse> performDeleteAllFavourite();

    @GET("search")
    Call<SearchModel> performSearchOperation(@Query("search_video") String userClass);

    @GET("assessment")
    Call<AssessmentModel> performAssessmentOperation(@Query("video_id") String userClass);

    @POST("assessment")
    Call<AssessmentModel> performResultOperation(@Body WeakHashMap<String, String> param);

    @GET("forgotPassword")
    Call<UserModel> performForgotPassword(@Query("contact_no") String userClass);

    @PUT("forgotPassword")
    Call<UserModel> performForgotPasswordWithDetail(@Body WeakHashMap<String, String> userDetails);

}
