package com.mrbhartiya.education.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AssessmentModel {

    /**
     * status : true
     * message : Get successfully assessment...
     * data : [{"assessment_id":"MRA001","video_id":"MRV001","question":"Is x²+6x-4= 0 a quadratic equation?","total_option":2,"options":[{"option":"yes"},{"option":"no"}],"correct_answer":"no","created_timestamp":"2019-11-16T13:09:36.000Z","updated_timestamp":"2019-11-16T13:09:36.000Z","delete_flag":false},{"assessment_id":"MRA002","video_id":"MRV001","question":"The product  of two consecutive positive integers is 306. From the quadratic equation to find the integers, if x denotes the smaller integer.","total_option":4,"options":[{"option":"x²+x-306=0"},{"option":"x²-45x+324=0"},{"option":"x²+11x-1452=0"},{"option":"x²+5x-1800=0"}],"correct_answer":"x²+5x-1800=0","created_timestamp":"2019-11-16T13:13:57.000Z","updated_timestamp":"2019-11-16T13:13:57.000Z","delete_flag":false}]
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

    public static class DataBean implements Parcelable {
        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
        private String video_id;
        private String question;
        /**
         * assessment_id : MRA001
         * video_id : MRV001
         * question : Is x²+6x-4= 0 a quadratic equation?
         * total_option : 2
         * options : [{"option":"yes"},{"option":"no"}]
         * correct_answer : no
         * created_timestamp : 2019-11-16T13:09:36.000Z
         * updated_timestamp : 2019-11-16T13:09:36.000Z
         * delete_flag : false
         */

        private String assessment_id;
        private int total_option;
        private String created_timestamp;
        private String updated_timestamp;
        private boolean delete_flag;
        private String correct_answer;

        public String getAssessment_id() {
            return assessment_id;
        }

        public void setAssessment_id(String assessment_id) {
            this.assessment_id = assessment_id;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        private List<OptionsBean> options;

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.assessment_id = in.readString();
            this.video_id = in.readString();
            this.question = in.readString();
            this.total_option = in.readInt();
            this.correct_answer = in.readString();
            this.created_timestamp = in.readString();
            this.updated_timestamp = in.readString();
            this.delete_flag = in.readByte() != 0;
            this.options = new ArrayList<OptionsBean>();
            in.readList(this.options, OptionsBean.class.getClassLoader());
        }

        public int getTotal_option() {
            return total_option;
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

        public void setTotal_option(int total_option) {
            this.total_option = total_option;
        }

        public String getCorrect_answer() {
            return correct_answer;
        }

        public void setCorrect_answer(String correct_answer) {
            this.correct_answer = correct_answer;
        }

        public List<OptionsBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionsBean> options) {
            this.options = options;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.assessment_id);
            dest.writeString(this.video_id);
            dest.writeString(this.question);
            dest.writeInt(this.total_option);
            dest.writeString(this.correct_answer);
            dest.writeString(this.created_timestamp);
            dest.writeString(this.updated_timestamp);
            dest.writeByte(this.delete_flag ? (byte) 1 : (byte) 0);
            dest.writeList(this.options);
        }

        public static class OptionsBean implements Parcelable {
            public static final Creator<OptionsBean> CREATOR = new Creator<OptionsBean>() {
                @Override
                public OptionsBean createFromParcel(Parcel source) {
                    return new OptionsBean(source);
                }

                @Override
                public OptionsBean[] newArray(int size) {
                    return new OptionsBean[size];
                }
            };
            /**
             * option : yes
             */

            private String option;

            public OptionsBean() {
            }

            protected OptionsBean(Parcel in) {
                this.option = in.readString();
            }

            public String getOption() {
                return option;
            }

            public void setOption(String option) {
                this.option = option;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.option);
            }
        }
    }
}
