package com.mrbhartiya.education.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class HomeModel {


    /**
     * status : true
     * message : Get Home Data successfully!!!
     * data : {"teacher_list":[{"teacher_id":"MRT001","teacher_name":"Chhavi Gupta","subject_id":"MRS005","teacher_subject":"Biology","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572588980092","description":"Gold Medallist, PHD","created_timestamp":"1575376215","updated_timestamp":"1575376215","delete_flag":false},{"teacher_id":"MRT002","teacher_name":"Monika Kumawat","subject_id":"MRS006","teacher_subject":"Chemistry","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589343981","description":"Gold Medallist, PHD","created_timestamp":"1575376271","updated_timestamp":"1575376271","delete_flag":false},{"teacher_id":"MRT003","teacher_name":"Anil Menaria","subject_id":"MRS001","teacher_subject":"Mathematics","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589457972","description":"Gold Medallist, PHD","created_timestamp":"1575376301","updated_timestamp":"1575376301","delete_flag":false},{"teacher_id":"MRT004","teacher_name":"Kajal Joshi","subject_id":"MRS002","teacher_subject":"English-First Flight-Poems","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589624084","description":"Gold Medallist, PHD","created_timestamp":"1575376332","updated_timestamp":"1575376332","delete_flag":false},{"teacher_id":"MRT005","teacher_name":"Disha Madrecha","subject_id":"MRS003","teacher_subject":"Science","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589690154","description":"Gold Medallist, PHD","created_timestamp":"1575376371","updated_timestamp":"1575376371","delete_flag":false}],"subject_list":[{"subject_id":"MRS001","class_id":"1","subject_name":"Mathematics","medium":"Hindi","color_code":"#00A1FF","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/maths.png","created_timestamp":"1575375559","updated_timestamp":"1575375559","delete_flag":false},{"subject_id":"MRS002","class_id":"1","subject_name":"English-First Flight-Prose","medium":"English","color_code":"#D4145A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/english.png","created_timestamp":"1575375603","updated_timestamp":"1575375603","delete_flag":false},{"subject_id":"MRS003","class_id":"1","subject_name":"Science","medium":"Hindi","color_code":"#00774A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/science.png","created_timestamp":"1575375681","updated_timestamp":"1575375681","delete_flag":false},{"subject_id":"MRS004","class_id":"1","subject_name":"English-First Flight-poems","medium":"Hindi","color_code":"#D4145A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/english.png","created_timestamp":"1575375763","updated_timestamp":"1575375763","delete_flag":false}],"demo_video_list":[{"video_id":"MRV001","chapter_id":"MRC001","video_name":"Quadratic Equations(Introduction)","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Quadratic+Equations+Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Quadratic+Equations+(Introduction).pdf","video_like":20,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/ezgif-4-6001e08ecd3b.jpg","isdemovideo":true,"description":"demo description Quadratic Equations(Introduction)","created_timestamp":"1575435367","updated_timestamp":"1575435367","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV006","chapter_id":"MRC002","video_name":"Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575435564","updated_timestamp":"1575435564","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV007","chapter_id":"MRC002","video_name":"Nutrition in Green Plant","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2.Nutrition+In+Green+Plant.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2.Nutrition+in+Green+Plant.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575435588","updated_timestamp":"1575435588","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV017","chapter_id":"MRC007","video_name":"Types Of A sexual Reproduction Part-1","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.1+Types+Of+Asesxual+Reproduction+Part-1.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.1+Types+of+asesxual+reproduction+part-1.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575437768","updated_timestamp":"1575437768","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV024","chapter_id":"MRC010","video_name":"General Introduction And Electronic structure","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.+General+Introduction+And+Electronic+Structure.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.+General+introduction+and+electronic+structure.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575437968","updated_timestamp":"1575437968","delete_flag":false,"isLiked":false,"isFavourited":false}],"subscription":[{"subscription_id":"MRS001","class_id":"1","amount":700,"expiry_date":"1585567982","banner_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/subscription_image/premium_pack.png","description":"valid for 31/11/2019","created_timestamp":"1575376043","updated_timestamp":"1575376043","delete_flag":false}],"favourite_videos":[{"video_id":"MRV006","chapter_id":"MRC002","video_name":"Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"1575435564","updated_timestamp":"1575435564","delete_flag":false,"user_name":"Rohit Kumar"}],"app_expiry":"1585699160000","wallet":0}
     */

    private boolean status;
    private String message;
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * teacher_list : [{"teacher_id":"MRT001","teacher_name":"Chhavi Gupta","subject_id":"MRS005","teacher_subject":"Biology","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572588980092","description":"Gold Medallist, PHD","created_timestamp":"1575376215","updated_timestamp":"1575376215","delete_flag":false},{"teacher_id":"MRT002","teacher_name":"Monika Kumawat","subject_id":"MRS006","teacher_subject":"Chemistry","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589343981","description":"Gold Medallist, PHD","created_timestamp":"1575376271","updated_timestamp":"1575376271","delete_flag":false},{"teacher_id":"MRT003","teacher_name":"Anil Menaria","subject_id":"MRS001","teacher_subject":"Mathematics","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589457972","description":"Gold Medallist, PHD","created_timestamp":"1575376301","updated_timestamp":"1575376301","delete_flag":false},{"teacher_id":"MRT004","teacher_name":"Kajal Joshi","subject_id":"MRS002","teacher_subject":"English-First Flight-Poems","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589624084","description":"Gold Medallist, PHD","created_timestamp":"1575376332","updated_timestamp":"1575376332","delete_flag":false},{"teacher_id":"MRT005","teacher_name":"Disha Madrecha","subject_id":"MRS003","teacher_subject":"Science","teacher_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572589690154","description":"Gold Medallist, PHD","created_timestamp":"1575376371","updated_timestamp":"1575376371","delete_flag":false}]
         * subject_list : [{"subject_id":"MRS001","class_id":"1","subject_name":"Mathematics","medium":"Hindi","color_code":"#00A1FF","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/maths.png","created_timestamp":"1575375559","updated_timestamp":"1575375559","delete_flag":false},{"subject_id":"MRS002","class_id":"1","subject_name":"English-First Flight-Prose","medium":"English","color_code":"#D4145A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/english.png","created_timestamp":"1575375603","updated_timestamp":"1575375603","delete_flag":false},{"subject_id":"MRS003","class_id":"1","subject_name":"Science","medium":"Hindi","color_code":"#00774A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/science.png","created_timestamp":"1575375681","updated_timestamp":"1575375681","delete_flag":false},{"subject_id":"MRS004","class_id":"1","subject_name":"English-First Flight-poems","medium":"Hindi","color_code":"#D4145A","icons":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/english.png","created_timestamp":"1575375763","updated_timestamp":"1575375763","delete_flag":false}]
         * demo_video_list : [{"video_id":"MRV001","chapter_id":"MRC001","video_name":"Quadratic Equations(Introduction)","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Quadratic+Equations+Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Quadratic+Equations+(Introduction).pdf","video_like":20,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/ezgif-4-6001e08ecd3b.jpg","isdemovideo":true,"description":"demo description Quadratic Equations(Introduction)","created_timestamp":"1575435367","updated_timestamp":"1575435367","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV006","chapter_id":"MRC002","video_name":"Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575435564","updated_timestamp":"1575435564","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV007","chapter_id":"MRC002","video_name":"Nutrition in Green Plant","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2.Nutrition+In+Green+Plant.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2.Nutrition+in+Green+Plant.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575435588","updated_timestamp":"1575435588","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV017","chapter_id":"MRC007","video_name":"Types Of A sexual Reproduction Part-1","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.1+Types+Of+Asesxual+Reproduction+Part-1.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.1+Types+of+asesxual+reproduction+part-1.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575437768","updated_timestamp":"1575437768","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV024","chapter_id":"MRC010","video_name":"General Introduction And Electronic structure","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.+General+Introduction+And+Electronic+Structure.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.+General+introduction+and+electronic+structure.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":true,"description":"demo description","created_timestamp":"1575437968","updated_timestamp":"1575437968","delete_flag":false,"isLiked":false,"isFavourited":false}]
         * subscription : [{"subscription_id":"MRS001","class_id":"1","amount":700,"expiry_date":"1585567982","banner_image":"https://mrb-data.s3.ap-south-1.amazonaws.com/subscription_image/premium_pack.png","description":"valid for 31/11/2019","created_timestamp":"1575376043","updated_timestamp":"1575376043","delete_flag":false}]
         * favourite_videos : [{"video_id":"MRV006","chapter_id":"MRC002","video_name":"Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"1575435564","updated_timestamp":"1575435564","delete_flag":false,"user_name":"Rohit Kumar"}]
         * app_expiry : 1585699160000
         * wallet : 0
         */

        private String app_expiry;
        private int wallet;
        private List<TeacherListBean> teacher_list;
        private List<SubjectListBean> subject_list;
        private List<DemoVideoListBean> demo_video_list;
        private List<SubscriptionBean> subscription;
        private List<FavouriteVideosBean> favourite_videos;

        public String getApp_expiry() {
            return app_expiry;
        }

        public void setApp_expiry(String app_expiry) {
            this.app_expiry = app_expiry;
        }

        public int getWallet() {
            return wallet;
        }

        public void setWallet(int wallet) {
            this.wallet = wallet;
        }

        public List<TeacherListBean> getTeacher_list() {
            return teacher_list;
        }

        public void setTeacher_list(List<TeacherListBean> teacher_list) {
            this.teacher_list = teacher_list;
        }

        public List<SubjectListBean> getSubject_list() {
            return subject_list;
        }

        public void setSubject_list(List<SubjectListBean> subject_list) {
            this.subject_list = subject_list;
        }

        public List<DemoVideoListBean> getDemo_video_list() {
            return demo_video_list;
        }

        public void setDemo_video_list(List<DemoVideoListBean> demo_video_list) {
            this.demo_video_list = demo_video_list;
        }

        public List<SubscriptionBean> getSubscription() {
            return subscription;
        }

        public void setSubscription(List<SubscriptionBean> subscription) {
            this.subscription = subscription;
        }

        public List<FavouriteVideosBean> getFavourite_videos() {
            return favourite_videos;
        }

        public void setFavourite_videos(List<FavouriteVideosBean> favourite_videos) {
            this.favourite_videos = favourite_videos;
        }

        public static class TeacherListBean {
            /**
             * teacher_id : MRT001
             * teacher_name : Chhavi Gupta
             * subject_id : MRS005
             * teacher_subject : Biology
             * teacher_image : https://mrb-data.s3.ap-south-1.amazonaws.com/teacher_images/1572588980092
             * description : Gold Medallist, PHD
             * created_timestamp : 1575376215
             * updated_timestamp : 1575376215
             * delete_flag : false
             */

            private String teacher_id;
            private String teacher_name;
            private String subject_id;
            private String teacher_subject;
            private String teacher_image;
            private String description;
            private String created_timestamp;
            private String updated_timestamp;
            private boolean delete_flag;

            public String getTeacher_id() {
                return teacher_id;
            }

            public void setTeacher_id(String teacher_id) {
                this.teacher_id = teacher_id;
            }

            public String getTeacher_name() {
                return teacher_name;
            }

            public void setTeacher_name(String teacher_name) {
                this.teacher_name = teacher_name;
            }

            public String getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(String subject_id) {
                this.subject_id = subject_id;
            }

            public String getTeacher_subject() {
                return teacher_subject;
            }

            public void setTeacher_subject(String teacher_subject) {
                this.teacher_subject = teacher_subject;
            }

            public String getTeacher_image() {
                return teacher_image;
            }

            public void setTeacher_image(String teacher_image) {
                this.teacher_image = teacher_image;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getUpdated_timestamp() {
                return updated_timestamp;
            }

            public void setUpdated_timestamp(String updated_timestamp) {
                this.updated_timestamp = updated_timestamp;
            }

            public boolean isDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(boolean delete_flag) {
                this.delete_flag = delete_flag;
            }
        }

        public static class SubjectListBean implements Parcelable {
            public static final Parcelable.Creator<SubjectListBean> CREATOR = new Parcelable.Creator<SubjectListBean>() {
                @Override
                public SubjectListBean createFromParcel(Parcel source) {
                    return new SubjectListBean(source);
                }

                @Override
                public SubjectListBean[] newArray(int size) {
                    return new SubjectListBean[size];
                }
            };
            private String class_id;
            private String subject_name;
            private String medium;
            private String color_code;
            private String icons;
            private String created_timestamp;
            private String updated_timestamp;
            /**
             * subject_id : MRS001
             * class_id : 1
             * subject_name : Mathematics
             * medium : Hindi
             * color_code : #00A1FF
             * icons : https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/maths.png
             * created_timestamp : 1575375559
             * updated_timestamp : 1575375559
             * delete_flag : false
             */

            private String subject_id;

            public String getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(String subject_id) {
                this.subject_id = subject_id;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getSubject_name() {
                return subject_name;
            }

            public void setSubject_name(String subject_name) {
                this.subject_name = subject_name;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getColor_code() {
                return color_code;
            }

            public void setColor_code(String color_code) {
                this.color_code = color_code;
            }

            public String getIcons() {
                return icons;
            }

            public void setIcons(String icons) {
                this.icons = icons;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getUpdated_timestamp() {
                return updated_timestamp;
            }

            public void setUpdated_timestamp(String updated_timestamp) {
                this.updated_timestamp = updated_timestamp;
            }

            public boolean isDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(boolean delete_flag) {
                this.delete_flag = delete_flag;
            }

            private boolean delete_flag;

            public SubjectListBean() {
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.subject_id);
                dest.writeString(this.class_id);
                dest.writeString(this.subject_name);
                dest.writeString(this.medium);
                dest.writeString(this.color_code);
                dest.writeString(this.icons);
                dest.writeString(this.created_timestamp);
                dest.writeString(this.updated_timestamp);
                dest.writeByte(this.delete_flag ? (byte) 1 : (byte) 0);
            }

            protected SubjectListBean(Parcel in) {
                this.subject_id = in.readString();
                this.class_id = in.readString();
                this.subject_name = in.readString();
                this.medium = in.readString();
                this.color_code = in.readString();
                this.icons = in.readString();
                this.created_timestamp = in.readString();
                this.updated_timestamp = in.readString();
                this.delete_flag = in.readByte() != 0;
            }

            @Override
            public int describeContents() {
                return 0;
            }
        }

        public static class DemoVideoListBean implements Parcelable {
            public static final Creator<DemoVideoListBean> CREATOR = new Creator<DemoVideoListBean>() {
                @Override
                public DemoVideoListBean createFromParcel(Parcel source) {
                    return new DemoVideoListBean(source);
                }

                @Override
                public DemoVideoListBean[] newArray(int size) {
                    return new DemoVideoListBean[size];
                }
            };
            private String chapter_id;
            private String video_name;
            private String Video_url;
            private String video_notes_url;
            private int video_like;
            private String thumbnail;
            /**
             * video_id : MRV001
             * chapter_id : MRC001
             * video_name : Quadratic Equations(Introduction)
             * Video_url : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Quadratic+Equations+Introduction.mp4
             * video_notes_url : https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Quadratic+Equations+(Introduction).pdf
             * video_like : 20
             * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/ezgif-4-6001e08ecd3b.jpg
             * isdemovideo : true
             * description : demo description Quadratic Equations(Introduction)
             * created_timestamp : 1575435367
             * updated_timestamp : 1575435367
             * delete_flag : false
             * isLiked : false
             * isFavourited : false
             */

            private String video_id;
            private String description;
            private String created_timestamp;
            private String updated_timestamp;
            private boolean delete_flag;
            private boolean isLiked;
            private boolean isFavourited;

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public String getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(String chapter_id) {
                this.chapter_id = chapter_id;
            }

            public String getVideo_name() {
                return video_name;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            public String getVideo_url() {
                return Video_url;
            }

            public void setVideo_url(String Video_url) {
                this.Video_url = Video_url;
            }

            public String getVideo_notes_url() {
                return video_notes_url;
            }

            public void setVideo_notes_url(String video_notes_url) {
                this.video_notes_url = video_notes_url;
            }

            public int getVideo_like() {
                return video_like;
            }

            public void setVideo_like(int video_like) {
                this.video_like = video_like;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            private boolean isdemovideo;

            public DemoVideoListBean() {
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getUpdated_timestamp() {
                return updated_timestamp;
            }

            public void setUpdated_timestamp(String updated_timestamp) {
                this.updated_timestamp = updated_timestamp;
            }

            protected DemoVideoListBean(Parcel in) {
                this.video_id = in.readString();
                this.chapter_id = in.readString();
                this.video_name = in.readString();
                this.Video_url = in.readString();
                this.video_notes_url = in.readString();
                this.video_like = in.readInt();
                this.thumbnail = in.readString();
                this.isdemovideo = in.readByte() != 0;
                this.description = in.readString();
                this.created_timestamp = in.readString();
                this.updated_timestamp = in.readString();
                this.delete_flag = in.readByte() != 0;
                this.isLiked = in.readByte() != 0;
                this.isFavourited = in.readByte() != 0;
            }

            public boolean isIsdemovideo() {
                return isdemovideo;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public boolean isIsFavourited() {
                return isFavourited;
            }

            public void setIsFavourited(boolean isFavourited) {
                this.isFavourited = isFavourited;
            }

            public void setIsdemovideo(boolean isdemovideo) {
                this.isdemovideo = isdemovideo;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public boolean isDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(boolean delete_flag) {
                this.delete_flag = delete_flag;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.video_id);
                dest.writeString(this.chapter_id);
                dest.writeString(this.video_name);
                dest.writeString(this.Video_url);
                dest.writeString(this.video_notes_url);
                dest.writeInt(this.video_like);
                dest.writeString(this.thumbnail);
                dest.writeByte(this.isdemovideo ? (byte) 1 : (byte) 0);
                dest.writeString(this.description);
                dest.writeString(this.created_timestamp);
                dest.writeString(this.updated_timestamp);
                dest.writeByte(this.delete_flag ? (byte) 1 : (byte) 0);
                dest.writeByte(this.isLiked ? (byte) 1 : (byte) 0);
                dest.writeByte(this.isFavourited ? (byte) 1 : (byte) 0);
            }
        }

        public static class SubscriptionBean {
            /**
             * subscription_id : MRS001
             * class_id : 1
             * amount : 700
             * expiry_date : 1585567982
             * banner_image : https://mrb-data.s3.ap-south-1.amazonaws.com/subscription_image/premium_pack.png
             * description : valid for 31/11/2019
             * created_timestamp : 1575376043
             * updated_timestamp : 1575376043
             * delete_flag : false
             */

            private String subscription_id;
            private String class_id;
            private int amount;
            private String expiry_date;
            private String banner_image;
            private String description;
            private String created_timestamp;
            private String updated_timestamp;
            private boolean delete_flag;

            public String getSubscription_id() {
                return subscription_id;
            }

            public void setSubscription_id(String subscription_id) {
                this.subscription_id = subscription_id;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getExpiry_date() {
                return expiry_date;
            }

            public void setExpiry_date(String expiry_date) {
                this.expiry_date = expiry_date;
            }

            public String getBanner_image() {
                return banner_image;
            }

            public void setBanner_image(String banner_image) {
                this.banner_image = banner_image;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getUpdated_timestamp() {
                return updated_timestamp;
            }

            public void setUpdated_timestamp(String updated_timestamp) {
                this.updated_timestamp = updated_timestamp;
            }

            public boolean isDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(boolean delete_flag) {
                this.delete_flag = delete_flag;
            }
        }

        public static class FavouriteVideosBean implements Parcelable {
            public static final Parcelable.Creator<FavouriteVideosBean> CREATOR = new Parcelable.Creator<FavouriteVideosBean>() {
                @Override
                public FavouriteVideosBean createFromParcel(Parcel source) {
                    return new FavouriteVideosBean(source);
                }

                @Override
                public FavouriteVideosBean[] newArray(int size) {
                    return new FavouriteVideosBean[size];
                }
            };
            private String chapter_id;
            private String title;
            private String Video_url;
            private String video_notes_url;
            private int video_like;
            private String thumbnail;
            private FavouriteVideosBeanVideo video;

            public FavouriteVideosBeanVideo getVideo() {
                return video;
            }

            public void setVideo(FavouriteVideosBeanVideo video) {
                this.video = video;
            }

            /**
             * video_id : MRV006
             * chapter_id : MRC002
             * video_name : Introduction
             * Video_url : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4
             * video_notes_url : https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf
             * video_like : 101
             * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png
             * isdemovideo : 1
             * description : demo description
             * created_timestamp : 1575435564
             * updated_timestamp : 1575435564
             * delete_flag : false
             * user_name : Rohit Kumar
             */

            private String video_id;
            private String description;
            private String created_timestamp;
            private String updated_timestamp;
            private boolean delete_flag;
            private int isdemovideo;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            private int user_id;

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public String getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(String chapter_id) {
                this.chapter_id = chapter_id;
            }

            public String getVideo_name() {
                return title;
            }

            public void setVideo_name(String video_name) {
                this.title = video_name;
            }

            public String getVideo_url() {
                return Video_url;
            }

            public void setVideo_url(String Video_url) {
                this.Video_url = Video_url;
            }

            public String getVideo_notes_url() {
                return video_notes_url;
            }

            public void setVideo_notes_url(String video_notes_url) {
                this.video_notes_url = video_notes_url;
            }

            public int getVideo_like() {
                return video_like;
            }

            public void setVideo_like(int video_like) {
                this.video_like = video_like;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
            private String user_name;

            public FavouriteVideosBean() {
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_timestamp() {
                return created_timestamp;
            }

            public void setCreated_timestamp(String created_timestamp) {
                this.created_timestamp = created_timestamp;
            }

            public String getUpdated_timestamp() {
                return updated_timestamp;
            }

            public void setUpdated_timestamp(String updated_timestamp) {
                this.updated_timestamp = updated_timestamp;
            }

            public boolean isDelete_flag() {
                return delete_flag;
            }

            public void setDelete_flag(boolean delete_flag) {
                this.delete_flag = delete_flag;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            protected FavouriteVideosBean(Parcel in) {
                this.video_id = in.readString();
                this.chapter_id = in.readString();
                this.title = in.readString();
                this.Video_url = in.readString();
                this.video_notes_url = in.readString();
                this.video_like = in.readInt();
                this.thumbnail = in.readString();
                this.isdemovideo = in.readInt();
                this.description = in.readString();
                this.created_timestamp = in.readString();
                this.updated_timestamp = in.readString();
                this.delete_flag = in.readByte() != 0;
                this.user_name = in.readString();
                this.user_id=in.readInt();
                this.video=in.readParcelable(FavouriteVideosBeanVideo.class.getClassLoader());

            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.video_id);
                dest.writeString(this.chapter_id);
                dest.writeString(this.title);
                dest.writeString(this.Video_url);
                dest.writeString(this.video_notes_url);
                dest.writeInt(this.video_like);
                dest.writeString(this.thumbnail);
                dest.writeInt(this.isdemovideo);
                dest.writeString(this.description);
                dest.writeString(this.created_timestamp);
                dest.writeString(this.updated_timestamp);
                dest.writeByte(this.delete_flag ? (byte) 1 : (byte) 0);
                dest.writeString(this.user_name);
                dest.writeInt(this.user_id);
                dest.writeParcelable(this.video,flags);
            }

            public int getIsdemovideo() {
                return isdemovideo;
            }

            public void setIsdemovideo(int isdemovideo) {
                this.isdemovideo = isdemovideo;
            }

            @Override
            public int describeContents() {
                return 0;
            }
        }
        public static class FavouriteVideosBeanVideo implements Parcelable {
            public static final Parcelable.Creator<FavouriteVideosBeanVideo> CREATOR = new Parcelable.Creator<FavouriteVideosBeanVideo>() {
                @Override
                public FavouriteVideosBeanVideo createFromParcel(Parcel source) {
                    return new FavouriteVideosBeanVideo(source);
                }

                @Override
                public FavouriteVideosBeanVideo[] newArray(int size) {
                    return new FavouriteVideosBeanVideo[size];
                }
            };



            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public int getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(int topic_id) {
                this.topic_id = topic_id;
            }

            public int getTeacher_id() {
                return teacher_id;
            }

            public void setTeacher_id(int teacher_id) {
                this.teacher_id = teacher_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }

            public String getDocument_url() {
                return document_url;
            }

            public void setDocument_url(String document_url) {
                this.document_url = document_url;
            }

            public String getVideo_description() {
                return video_description;
            }

            public void setVideo_description(String video_description) {
                this.video_description = video_description;
            }

            public String getDocument_description() {
                return document_description;
            }

            public void setDocument_description(String document_description) {
                this.document_description = document_description;
            }

            private  int id;
private String video_id;
private  int topic_id;
private  int teacher_id;
private String title;
private String type;
private String video_url;
private String document_url;
private String video_description;
private String document_description;
private String thumbnail;

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            /**
             * video_id : MRV006
             * chapter_id : MRC002
             * video_name : Introduction
             * Video_url : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4
             * video_notes_url : https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf
             * video_like : 101
             * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png
             * isdemovideo : 1
             * description : demo description
             * created_timestamp : 1575435564
             * updated_timestamp : 1575435564
             * delete_flag : false
             * user_name : Rohit Kumar
             */





            protected FavouriteVideosBeanVideo(Parcel in) {
                this.id = in.readInt();
                this.video_id = in.readString();
                this.topic_id = in.readInt();
                this.teacher_id = in.readInt();
                this.title = in.readString();
                this.type = in.readString();
                this.video_url = in.readString();
                this.document_url = in.readString();
                this.video_description = in.readString();
                this.document_description = in.readString();
                this.thumbnail = in.readString();

            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.video_id);
                dest.writeInt(this.topic_id);
                dest.writeInt(this.teacher_id);
                dest.writeString(this.title);
                dest.writeString(this.type);
                dest.writeString(this.video_url);
                dest.writeString(this.document_url);
                dest.writeString(this.video_description);
                dest.writeString(this.document_description);
                dest.writeString(this.thumbnail);

            }



            @Override
            public int describeContents() {
                return 0;
            }
        }
    }



}
