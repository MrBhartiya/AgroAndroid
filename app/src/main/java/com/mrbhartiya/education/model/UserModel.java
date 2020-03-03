package com.mrbhartiya.education.model;

public class UserModel {


    /**
     * status_code : 200
     * status : true
     * message : true
     * data : {"id":18,"name":"Surbhi","email":"asd@gmail.com","mobile_no":"7014349426","role":"NA","status":0,"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDFhMGNjNmQ3NjY0ZGI1ZDIyNjBmMjViMTY3NmM5MmQ2NTZlYjFmZDc4ZTE0MDRjYTM5M2JmZWJlZGU0NmIyM2UxZTUxMmVmNGM5NDA3NGEiLCJpYXQiOjE1ODA4ODY3OTksIm5iZiI6MTU4MDg4Njc5OSwiZXhwIjoxNjEyNTA5MTk5LCJzdWIiOiIxOCIsInNjb3BlcyI6W119.W-XLzvC2R7evRJpfDsKcyqoyiZ5HqeiAkPStmc92Z2TaVIE5WUyUSGvHWjSq_UxYFPUgPYu2hVzYCyuua8kX1O8PoK9gdKWB76hwaR2lYzICDsgBRlyVDaxk_x2qqcrrT_yv4HYeQFATx4TvGQvzx9xj3cc_CcMipqX5P0QTjnwxFCN7FAKYhTnPl-FsKvcc8qo0tbQrWTJ6dKpPHvLeV-UW2nvrpnlb0uQDS1d1ib7RSWGChMynlORYzHW8UYRWM5zUR90IjV0PG_ovsTcXXDv3OOnK3jNG19FVWP7HgFgfMboadfIIKTGYHsaiXnq2nEtYPz1zau98eAZbU37y210hHc3jeHDrykNJy-emS1IRy5lI0m3T37rRdYQWVbsNYVCv1MOLjky_lEmJi4W9jvkweBwPJYVNqAD3XffRT3JKv3LyU0-DsmQ2J8NK_ds6Y-9h4k1ujsjeWXK_XG04zPNntjuxSjREe647IzD_vf958J6NPeFmAAYvt6gHXw_GND00wfefnPJdTOvdueD-599RLSHWu7B5elyowRLP5vjZHgqReY3oFnWHXnqVXYo4qqxAnxiCnlGftAA3sCMawouX-RolG0DSiBeuAFW8lGdClQrSHVH5-h07qUCKv8DsCdT7U-sTZYI_Ce8vDpV8bFodiERSyUiIVjcDbl4H_G0","user_class":"10","city":"udpr","state":"raj","gender":"female","dob":"1993-11-17","referral_code":"HlUn5P","isVideo_purchase":false,"bucket_url":"http://mrb-data.s3.ap-south-1.amazonaws.com/","profile_image":"http://ec2-13-232-236-23.ap-south-1.compute.amazonaws.com../storage/app/icon/profile.png","device_id":"tyftyft","fcm_token":"tyftyfty","created":1580657825000,"updated":1580657825000}
     */

    private int status_code;
    private boolean status;
    private String message;
    private DataBean data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 18
         * name : Surbhi
         * email : asd@gmail.com
         * mobile_no : 7014349426
         * role : NA
         * status : 0
         * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDFhMGNjNmQ3NjY0ZGI1ZDIyNjBmMjViMTY3NmM5MmQ2NTZlYjFmZDc4ZTE0MDRjYTM5M2JmZWJlZGU0NmIyM2UxZTUxMmVmNGM5NDA3NGEiLCJpYXQiOjE1ODA4ODY3OTksIm5iZiI6MTU4MDg4Njc5OSwiZXhwIjoxNjEyNTA5MTk5LCJzdWIiOiIxOCIsInNjb3BlcyI6W119.W-XLzvC2R7evRJpfDsKcyqoyiZ5HqeiAkPStmc92Z2TaVIE5WUyUSGvHWjSq_UxYFPUgPYu2hVzYCyuua8kX1O8PoK9gdKWB76hwaR2lYzICDsgBRlyVDaxk_x2qqcrrT_yv4HYeQFATx4TvGQvzx9xj3cc_CcMipqX5P0QTjnwxFCN7FAKYhTnPl-FsKvcc8qo0tbQrWTJ6dKpPHvLeV-UW2nvrpnlb0uQDS1d1ib7RSWGChMynlORYzHW8UYRWM5zUR90IjV0PG_ovsTcXXDv3OOnK3jNG19FVWP7HgFgfMboadfIIKTGYHsaiXnq2nEtYPz1zau98eAZbU37y210hHc3jeHDrykNJy-emS1IRy5lI0m3T37rRdYQWVbsNYVCv1MOLjky_lEmJi4W9jvkweBwPJYVNqAD3XffRT3JKv3LyU0-DsmQ2J8NK_ds6Y-9h4k1ujsjeWXK_XG04zPNntjuxSjREe647IzD_vf958J6NPeFmAAYvt6gHXw_GND00wfefnPJdTOvdueD-599RLSHWu7B5elyowRLP5vjZHgqReY3oFnWHXnqVXYo4qqxAnxiCnlGftAA3sCMawouX-RolG0DSiBeuAFW8lGdClQrSHVH5-h07qUCKv8DsCdT7U-sTZYI_Ce8vDpV8bFodiERSyUiIVjcDbl4H_G0
         * user_class : 10
         * city : udpr
         * state : raj
         * gender : female
         * dob : 1993-11-17
         * referral_code : HlUn5P
         * isVideo_purchase : false
         * bucket_url : http://mrb-data.s3.ap-south-1.amazonaws.com/
         * profile_image : http://ec2-13-232-236-23.ap-south-1.compute.amazonaws.com../storage/app/icon/profile.png
         * device_id : tyftyft
         * fcm_token : tyftyfty
         * created : 1580657825000
         * updated : 1580657825000
         */

        private int id;
        private String name;
        private String email;
        private String mobile_no;
        private String role;
        private int status;
        private String access_token;
        private String user_class;
        private String city;
        private String state;
        private String gender;
        private String dob;
        private String referral_code;
        private boolean isVideo_purchase;
        private String bucket_url;
        private String profile_image;
        private String device_id;
        private String fcm_token;
        private long created;
        private long updated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile_no() {
            return mobile_no;
        }

        public void setMobile_no(String mobile_no) {
            this.mobile_no = mobile_no;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getUser_class() {
            return user_class;
        }

        public void setUser_class(String user_class) {
            this.user_class = user_class;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getReferral_code() {
            return referral_code;
        }

        public void setReferral_code(String referral_code) {
            this.referral_code = referral_code;
        }

        public boolean isIsVideo_purchase() {
            return isVideo_purchase;
        }

        public void setIsVideo_purchase(boolean isVideo_purchase) {
            this.isVideo_purchase = isVideo_purchase;
        }

        public String getBucket_url() {
            return bucket_url;
        }

        public void setBucket_url(String bucket_url) {
            this.bucket_url = bucket_url;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public String getFcm_token() {
            return fcm_token;
        }

        public void setFcm_token(String fcm_token) {
            this.fcm_token = fcm_token;
        }

        public long getCreated() {
            return created;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }
    }
}
