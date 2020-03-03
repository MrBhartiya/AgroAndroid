package com.mrbhartiya.education.model;

import java.util.List;

public class ChapterModel {


    /**
     * status : true
     * message : chpater list
     * data : [{"chapter_id":"MRC001","subject_id":"MRS001","chapter_name":"Quadratic Equations","thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/subject_icons/list_video_thumbnail.png","chapter_description":"demo description data","created_timestamp":"2019-11-02T08:51:15.000Z","updated_timestamp":"2019-11-02T08:51:15.000Z","delete_flag":false}]
     */

    private boolean status;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
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
         */

        private String chapter_id;
        private String subject_id;
        private String chapter_name;
        private String thumbnail;
        private String description;
        private String created_timestamp;
        private String updated_timestamp;
        private boolean delete_flag;

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
            return chapter_name;
        }

        public void setChapter_name(String chapter_name) {
            this.chapter_name = chapter_name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
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
    }
}
