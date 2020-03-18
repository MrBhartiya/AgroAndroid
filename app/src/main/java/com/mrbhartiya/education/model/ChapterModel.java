package com.mrbhartiya.education.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ChapterModel {


    /**
     * status : true
     * message : chpater list
     * data : [{"chapter_id":"MRC001","subject_id":"MRS001","chapter_name":"Quadratic Equations","thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/list_video_thumbnail.png","chapter_description":"demo description data","created_timestamp":"2019-11-02T08:51:15.000Z","updated_timestamp":"2019-11-02T08:51:15.000Z","delete_flag":false}]
     */

    private boolean status;
    private String message;
    //private List<DataBean> data;
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
         * chapter_id : MRC001
         * subject_id : MRS001
         * chapter_name : Quadratic Equations
         * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/list_video_thumbnail.png
         * chapter_description : demo description data
         * created_timestamp : 2019-11-02T08:51:15.000Z
         * updated_timestamp : 2019-11-02T08:51:15.000Z
         * delete_flag : false
         *//*"id": 10,
                "subject_id": "0ENfwP",
                "class_id": 4,
                "teacher_id": 1,
                "subject_name": "GK",
                "description": "erftgyhu",
                "icons": "/storage/subject/1584472471user.jpg",
                "color_code": "#c65c39",
                "created_at": "2020-03-17 19:14:31",
                "updated_at": "2020-03-17 19:20:28",*/
private  int id;
        private String chapter_id;
        private String subject_id;
        private String color_code;

        public String getColor_code() {
            return color_code;
        }

        public void setColor_code(String color_code) {
            this.color_code = color_code;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getSubject_name() {
            return subject_name;
        }

        public void setSubject_name(String subject_name) {
            this.subject_name = subject_name;
        }

        public String getIcons() {
            return icons;
        }

        public void setIcons(String icons) {
            this.icons = icons;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private int  class_id;
        private String subject_name;
        private String icons;
        private String description;
        private String created_timestamp;
        private String updated_timestamp;
        private boolean delete_flag;
        private List<ChapterListBean> chapter;

        public List<ChapterListBean> getChapterListBeans() {
            return chapter;
        }

        public void setChapterListBeans(List<ChapterListBean> chapterListBeans) {
            this.chapter = chapterListBeans;
        }

        public String getChapter_id() {
            return chapter_id;
        }

        public void setChapter_id(String chapter_id) {
            this.chapter_id = chapter_id;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getChapter_name() {
            return subject_name;
        }

        public void setChapter_name(String chapter_name) {
            this.subject_name = chapter_name;
        }

        public String getThumbnail() {
            return icons;
        }

        public void setThumbnail(String thumbnail) {
            this.icons = thumbnail;
        }

        public String getChapter_description() {
            return description;
        }

        public void setChapter_description(String chapter_description) {
            this.description = chapter_description;
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

        public static class ChapterListBean implements Parcelable {
            public static final Parcelable.Creator<ChapterListBean> CREATOR = new Parcelable.Creator<ChapterListBean>() {
                @Override
                public ChapterListBean createFromParcel(Parcel source) {
                    return new ChapterListBean(source);
                }

                @Override
                public ChapterListBean[] newArray(int size) {
                    return new ChapterListBean[size];
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
            private String chapter_id;
            private int id;
            private int subject_id;
            private String chapter_name;
            private String thumbnail;
            private String description;

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

            protected ChapterListBean(Parcel in) {

                this.chapter_id = in.readString();

                this.thumbnail = in.readString();

                this.description = in.readString();

                this.user_name = in.readString();
                this.chapter_name = in.readString();
                this.user_id=in.readInt();
                this.id=in.readInt();
                this.subject_id=in.readInt();

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
               }

               @Override
            public int describeContents() {
                return 0;
            }
        }
    }
}
