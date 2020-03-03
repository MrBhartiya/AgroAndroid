package com.mrbhartiya.education.model;

import java.util.List;

public class TopicModel {


    /**
     * status : true
     * message : video list
     * data : [{"video_id":"MRV011","chapter_id":"MRC004","video_name":"1 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/01+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/01+madam+rides+the+bus.pdf","video_like":201,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:46:05.000Z","updated_timestamp":"2019-11-04T04:46:05.000Z","delete_flag":false,"isLiked":true,"isFavourited":true},{"video_id":"MRV012","chapter_id":"MRC004","video_name":"2 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/02+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/02+madam+rides+the+bus.pdf","video_like":200,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:17.000Z","updated_timestamp":"2019-11-04T04:49:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV013","chapter_id":"MRC004","video_name":"3 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/03+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/03+madam+rides+the+bus.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:19.000Z","updated_timestamp":"2019-11-04T04:49:19.000Z","delete_flag":false,"isLiked":false,"isFavourited":false}]
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

        private String video_id;
        private String chapter_id;
        private String video_name;
        private String Video_url;
        private String video_notes_url;
        private int video_like;
        private String thumbnail;
        private int isdemovideo;
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
    }
}
