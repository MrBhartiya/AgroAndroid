package com.mrbhartiya.education.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SearchModel implements Parcelable {

    public static final Parcelable.Creator<SearchModel> CREATOR = new Parcelable.Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel source) {
            return new SearchModel(source);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };
    /**
     * status : true
     * message : Get successfully searching result...
     * data : [{"video_id":"MRV001","chapter_id":"MRC001","video_name":"Quadratic Equations(Introduction)","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Quadratic+Equations+Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Quadratic+Equations+(Introduction).pdf","video_like":19,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/ezgif-4-6001e08ecd3b.jpg","isdemovideo":1,"description":"demo description Quadratic Equations(Introduction)","created_timestamp":"2019-11-02T12:05:32.000Z","updated_timestamp":"2019-11-02T12:05:32.000Z","delete_flag":false,"isLiked":true,"isFavourited":true},{"video_id":"MRV002","chapter_id":"MRC001","video_name":"Quadratic Equations(Numericals-Part 1)","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2+Quadratic+Equations+Numericals-+Part+1.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2+Quadratic+Equations+(Numericals-+Part+1).pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description Quadratic Equations(Numericals-Part 1)","created_timestamp":"2019-11-02T12:11:05.000Z","updated_timestamp":"2019-11-02T12:11:05.000Z","delete_flag":false,"isLiked":true,"isFavourited":false},{"video_id":"MRV003","chapter_id":"MRC001","video_name":"Quadratic Equations(Numericals-Part 2)","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/3+Quadratic+Equations+Numericals-+Part+2.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2+Solution+of+Quadratic+Equations+by+Factorisation+Numericals+Part+2.pdf","video_like":107,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-02T12:11:14.000Z","updated_timestamp":"2019-11-02T12:11:14.000Z","delete_flag":false,"isLiked":true,"isFavourited":false},{"video_id":"MRV004","chapter_id":"MRC001","video_name":"Solution of Quadratic Equations by factorisation Numericals Part 1","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Solution+Of+Quadratic+Equations+By+Factorisation+Numericals+Part+1.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Solution+of+Quadratic+Equations+by+Factorisation+Numericals+Part+1.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-02T12:17:21.000Z","updated_timestamp":"2019-11-02T12:17:21.000Z","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV005","chapter_id":"MRC001","video_name":"Solution of Quadratic Equations by Factorisation Numericals Part 2","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2+Solution+Of+Quadratic+Equations+By+Factorisation+Numericals+Part+2.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2+Solution+of+Quadratic+Equations+by+Factorisation+Numericals+Part+2.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-02T12:19:12.000Z","updated_timestamp":"2019-11-02T12:19:12.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV006","chapter_id":"MRC002","video_name":"Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"2019-11-02T12:25:20.000Z","updated_timestamp":"2019-11-02T12:25:20.000Z","delete_flag":false,"isLiked":false,"isFavourited":true},{"video_id":"MRV007","chapter_id":"MRC002","video_name":"Nutrition in Green Plant","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2.Nutrition+In+Green+Plant.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2.Nutrition+in+Green+Plant.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"2019-11-02T12:25:20.000Z","updated_timestamp":"2019-11-02T12:25:20.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV009","chapter_id":"MRC003","video_name":"Introduction Of Control And Coordination","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction+Of+Control+And+Coordination.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction+Of+Control+And+Coordination.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-02T12:28:29.000Z","updated_timestamp":"2019-11-02T12:28:29.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV010","chapter_id":"MRC003","video_name":"Transmission Of Impulses","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2.Transmission+Of+Impulses.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2.Transmission+Of+Impulses.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-02T12:28:31.000Z","updated_timestamp":"2019-11-02T12:28:31.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV011","chapter_id":"MRC004","video_name":"1 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/01+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/01+madam+rides+the+bus.pdf","video_like":201,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:46:05.000Z","updated_timestamp":"2019-11-04T04:46:05.000Z","delete_flag":false,"isLiked":true,"isFavourited":true},{"video_id":"MRV012","chapter_id":"MRC004","video_name":"2 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/02+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/02+madam+rides+the+bus.pdf","video_like":200,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:17.000Z","updated_timestamp":"2019-11-04T04:49:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV013","chapter_id":"MRC004","video_name":"3 Madam Rides the bus","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/03+Madam+Rides+The+Bus.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/03+madam+rides+the+bus.pdf","video_like":101,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:49:19.000Z","updated_timestamp":"2019-11-04T04:49:19.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV014","chapter_id":"MRC005","video_name":"The tale of curstard the dragon","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/The+Tale+Of+Custard+The+Dragon.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/the+tale+of+custard+the+dragon.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T04:50:38.000Z","updated_timestamp":"2019-11-04T04:50:38.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV016","chapter_id":"MRC007","video_name":"Introduction Of Reproduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.+Introduction+Of+Reproduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.+Introduction+of+Reproduction.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T05:22:52.000Z","updated_timestamp":"2019-11-04T05:22:52.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV017","chapter_id":"MRC007","video_name":"Types Of A sexual Reproduction Part-1","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.1+Types+Of+Asesxual+Reproduction+Part-1.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.1+Types+of+asesxual+reproduction+part-1.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"2019-11-04T05:22:52.000Z","updated_timestamp":"2019-11-04T05:22:52.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV018","chapter_id":"MRC007","video_name":"Types Of A sexual Reproduction Spore Formation Part-2","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/3.+Types+Of+Asexual+Reproduction+Spore+Formation-+Part-2.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/3.+Types+of+asexual+reproduction+Spore+formation-+part-2.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/thumbnail2.jpg","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T05:22:54.000Z","updated_timestamp":"2019-11-04T05:22:54.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV019","chapter_id":"MRC008","video_name":"Pollination Introduction","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/10.+Pollination-Introduction.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/10.+Pollination-Introduction.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T05:27:04.000Z","updated_timestamp":"2019-11-04T05:27:04.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV021","chapter_id":"MRC009","video_name":"Introduction And Nomenclature","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.Introduction+And+Nomenclature.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.Introduction+and+Nomenclature.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T05:37:17.000Z","updated_timestamp":"2019-11-04T05:37:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV022","chapter_id":"MRC009","video_name":"Structure Of Carbonyl Group","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/2.Structure+Of+Carbonyl+Group.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/2.Structure+of+Carbonyl+Group.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":0,"description":"demo description","created_timestamp":"2019-11-04T05:37:17.000Z","updated_timestamp":"2019-11-04T05:37:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":false},{"video_id":"MRV024","chapter_id":"MRC010","video_name":"General Introduction And Electronic structure","Video_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1.+General+Introduction+And+Electronic+Structure.mp4","video_notes_url":"https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1.+General+introduction+and+electronic+structure.pdf","video_like":100,"thumbnail":"https://mrb-data.s3.ap-south-1.amazonaws.com/videos/list_video_thumbnail.png","isdemovideo":1,"description":"demo description","created_timestamp":"2019-11-04T05:37:17.000Z","updated_timestamp":"2019-11-04T05:37:17.000Z","delete_flag":false,"isLiked":false,"isFavourited":false}]
     */

    private boolean status;
    private String message;
    private List<DataBean> data;

    public SearchModel() {
    }

    protected SearchModel(Parcel in) {
        this.status = in.readByte() != 0;
        this.message = in.readString();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeString(this.message);
        dest.writeList(this.data);
    }

    public static class DataBean implements Parcelable {
        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
        /**
         * video_id : MRV001
         * chapter_id : MRC001
         * video_name : Quadratic Equations(Introduction)
         * Video_url : https://mrb-data.s3.ap-south-1.amazonaws.com/videos/1+Quadratic+Equations+Introduction.mp4
         * video_notes_url : https://mrb-data.s3.ap-south-1.amazonaws.com/notes/1+Quadratic+Equations+(Introduction).pdf
         * video_like : 19
         * thumbnail : https://mrb-data.s3.ap-south-1.amazonaws.com/video_thumbnail/ezgif-4-6001e08ecd3b.jpg
         * isdemovideo : 1
         * description : demo description Quadratic Equations(Introduction)
         * created_timestamp : 2019-11-02T12:05:32.000Z
         * updated_timestamp : 2019-11-02T12:05:32.000Z
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

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.video_id = in.readString();
            this.chapter_id = in.readString();
            this.video_name = in.readString();
            this.Video_url = in.readString();
            this.video_notes_url = in.readString();
            this.video_like = in.readInt();
            this.thumbnail = in.readString();
            this.isdemovideo = in.readInt();
            this.description = in.readString();
            this.created_timestamp = in.readString();
            this.updated_timestamp = in.readString();
            this.delete_flag = in.readByte() != 0;
            this.isLiked = in.readByte() != 0;
            this.isFavourited = in.readByte() != 0;
        }

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

        @Override
        public int describeContents() {
            return 0;
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
            dest.writeInt(this.isdemovideo);
            dest.writeString(this.description);
            dest.writeString(this.created_timestamp);
            dest.writeString(this.updated_timestamp);
            dest.writeByte(this.delete_flag ? (byte) 1 : (byte) 0);
            dest.writeByte(this.isLiked ? (byte) 1 : (byte) 0);
            dest.writeByte(this.isFavourited ? (byte) 1 : (byte) 0);
        }
    }
}
