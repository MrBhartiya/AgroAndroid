package com.mrbhartiya.education.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TopicModel {


    /**
     * status : true
     * message : video list
     * data : [{"video_id":"MRV011","chapter_id":"MRC004","video_name":"1 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/01+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/01+madam+rides+the+bus.pdf","video_like":201,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:46:05.000Z","updated_timestamp":"2019-11-04T04:46:05.000Z","delete_flag":false,"isLiked":true,"isFavourited":true},{"video_id":"MRV012","chapter_id":"MRC004","video_name":"2 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/02+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/02+madam+rides+the+bus.pdf","video_like":200,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:17.000Z","updated_timestamp":"2019-11-04T04:49:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV013","chapter_id":"MRC004","video_name":"3 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/03+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/03+madam+rides+the+bus.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:19.000Z","updated_timestamp":"2019-11-04T04:49:19.000Z","delete_flag":false,"isLiked":false,"isFavourited":false}]
     */

    private boolean status;
    private String message;
    private  DataBean data;

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
         * video_id : MRV011
         * chapter_id : MRC004
         * video_name : 1 Madam Rides the bus
         * Video_url : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/01+Madam+Rides+The+Bus.mp4
         * video_notes_url : https://mrb-data.s3.ap-south-1.amazonaws.com/notes/01+madam+rides+the+bus.pdf
         * video_like : 201
         * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png
         * isdemovideo : 0
         * description : demo description
         * created_timestamp : 2019-11-04T04:46:05.000Z
         * updated_timestamp : 2019-11-04T04:46:05.000Z
         * delete_flag : false
         * isLiked : true
         * isFavourited : true
         */
/*  "id": 8,
          "chapter_id": "jVOuvA",
          "subject_id": 10,
          "chapter_name": "Current",
          "thumbnail": "/storage/chapter/1584472500user.jpg",
          "description": "edrftgyh",
          "created_at": "2020-03-17 19:15:00",
          "updated_at": "2020-03-17 19:15:00",*/

private  int id;
private  String chapter_id;
private  int subject_id;
        private  String chapter_name;
        private  String thumbnail;
        private  String description;

        public List<TopicListBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicListBean> topic) {
            this.topic = topic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(int subject_id) {
            this.subject_id = subject_id;
        }

        public String getChapter_name() {
            return chapter_name;
        }

        public void setChapter_name(String chapter_name) {
            this.chapter_name = chapter_name;
        }

        public boolean isLiked() {
            return isLiked;
        }

        public void setLiked(boolean liked) {
            isLiked = liked;
        }

        public boolean isFavourited() {
            return isFavourited;
        }

        public void setFavourited(boolean favourited) {
            isFavourited = favourited;
        }
        private List<TopicListBean> topic;

        private String video_id;

        private String video_name;
        private String Video_url;
        private String video_notes_url;
        private int video_like;

        private int isdemovideo;

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

        public int getIsdemovideo() {
            return isdemovideo;
        }

        public void setIsdemovideo(int isdemovideo) {
            this.isdemovideo = isdemovideo;
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

        public static class TopicListBean implements Parcelable {
            public static final Parcelable.Creator<TopicListBean> CREATOR = new Parcelable.Creator<TopicListBean>() {
                @Override
                public TopicListBean createFromParcel(Parcel source) {
                    return new TopicListBean(source);
                }

                @Override
                public TopicListBean[] newArray(int size) {
                    return new TopicListBean[size];
                }
            };

            /* "id": 8,
                     "chapter_id": "jVOuvA",
                     "subject_id": 10,
                     "chapter_name": "Current",
                     "thumbnail": "/storage/chapter/1584472500user.jpg",
                     "description": "edrftgyh",
                     "created_at": "2020-03-17 19:15:00",
                     "updated_at": "2020-03-17 19:15:00"*/
            private  int id;
            private  String chapter_id;
            private  int subject_id;
            private  String chapter_name;
            private  String thumbnail;
            private  String description;
            private String video_id;

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
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

            public void setVideo_url(String video_url) {
                Video_url = video_url;
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

            public int getIsdemovideo() {
                return isdemovideo;
            }

            public void setIsdemovideo(int isdemovideo) {
                this.isdemovideo = isdemovideo;
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

            public boolean isLiked() {
                return isLiked;
            }

            public void setLiked(boolean liked) {
                isLiked = liked;
            }

            public boolean isFavourited() {
                return isFavourited;
            }

            public void setFavourited(boolean favourited) {
                isFavourited = favourited;
            }

            private String video_name;
            private String Video_url;
            private String video_notes_url;
            private int video_like;

            private int isdemovideo;

            private String created_timestamp;
            private String updated_timestamp;
            private boolean delete_flag;
            private boolean isLiked;
            private boolean isFavourited;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(int subject_id) {
                this.subject_id = subject_id;
            }

            public String getChapter_name() {
                return chapter_name;
            }

            public void setChapter_name(String chapter_name) {
                this.chapter_name = chapter_name;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            private int user_id;



            public String getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(String chapter_id) {
                this.chapter_id = chapter_id;
            }



            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
            private String user_name;



            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }


            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            protected TopicListBean(Parcel in) {

                this.chapter_id = in.readString();

                this.thumbnail = in.readString();

                this.description = in.readString();

                this.user_name = in.readString();
                this.chapter_name = in.readString();
                this.user_id=in.readInt();
                this.id=in.readInt();
                this.subject_id=in.readInt();
                this.video_id = in.readString();

                this.video_name = in.readString();
                this.Video_url = in.readString();
                this.video_notes_url = in.readString();
                this.video_like = in.readInt();

                this.isdemovideo = in.readInt();

                this.created_timestamp = in.readString();
                this.updated_timestamp = in.readString();


            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {

                dest.writeString(this.chapter_id);

                dest.writeString(this.thumbnail);

                dest.writeString(this.description);
                dest.writeString(this.user_name);
                dest.writeString(this.chapter_name);
                dest.writeInt(this.user_id);
                dest.writeInt(this.id);
                dest.writeInt(this.subject_id);
                dest.writeString(this.video_id );

                dest.writeString(this.video_name );
                dest.writeString(this.Video_url);
                dest.writeString(this.video_notes_url );
                dest.writeInt(this.video_like );

                dest.writeInt( this.isdemovideo );

                dest.writeString(this.created_timestamp );
                dest.writeString(this.updated_timestamp );
            }

            @Override
            public int describeContents() {
                return 0;
            }
        }

    }
}
