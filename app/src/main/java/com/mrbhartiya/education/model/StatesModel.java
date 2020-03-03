package com.mrbhartiya.education.model;

import java.util.List;

public class StatesModel {

    /**
     * status_code : 200
     * status : true
     * message : state class list
     * data : {"state":[{"id":5,"name":"Andaman & Nicobar Islands"},{"id":6,"name":"Andhra Pradesh"},{"id":7,"name":"Arunachal Pradesh"},{"id":8,"name":"Assam"},{"id":9,"name":"Bihar"},{"id":51,"name":"Chandigarh"},{"id":10,"name":"Chhattisgarh"},{"id":11,"name":"Dadra & Nagar Haveli"},{"id":12,"name":"Daman & Diu"},{"id":13,"name":"Delhi"},{"id":14,"name":"Goa"},{"id":15,"name":"Gujarat"},{"id":19,"name":"Haryana"},{"id":20,"name":"Himachal Pradesh"},{"id":21,"name":"Jammu & Kashmir"},{"id":22,"name":"Jharkhand"},{"id":23,"name":"Karnataka"},{"id":24,"name":"Kerala"},{"id":25,"name":"Lakshadweep"},{"id":26,"name":"Madhya Pradesh"},{"id":4,"name":"Maharashtra"},{"id":28,"name":"Manipur"},{"id":29,"name":"Meghalaya"},{"id":30,"name":"Mizoram"},{"id":31,"name":"Nagaland"},{"id":32,"name":"Orissa"},{"id":33,"name":"Pondicherry"},{"id":34,"name":"Punjab"},{"id":35,"name":"Rajasthan"},{"id":37,"name":"Sikkim"},{"id":39,"name":"Tamil Nadu"},{"id":50,"name":"Telangana"},{"id":40,"name":"Tripura"},{"id":41,"name":"Uttar Pradesh"},{"id":48,"name":"Uttarakhand"},{"id":38,"name":"West Bengal"}],"user_class":[{"id":2,"class_id":"yThsv8","class_name":"10","description":"10th","created_at":"2020-02-08 18:41:36","updated_at":"2020-02-08 18:41:36"},{"id":3,"class_id":"2s7pwo","class_name":"11","description":"11th","created_at":"2020-02-09 19:59:43","updated_at":"2020-02-09 19:59:43"},{"id":4,"class_id":"qJTL6K","class_name":"12","description":"12th","created_at":"2020-02-09 20:00:02","updated_at":"2020-02-09 20:00:02"}]}
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
        private List<StateBean> state;
        private List<UserClassBean> user_class;

        public List<StateBean> getState() {
            return state;
        }

        public void setState(List<StateBean> state) {
            this.state = state;
        }

        public List<UserClassBean> getUser_class() {
            return user_class;
        }

        public void setUser_class(List<UserClassBean> user_class) {
            this.user_class = user_class;
        }

        public static class StateBean {
            /**
             * id : 5
             * name : Andaman & Nicobar Islands
             */

            private int id;
            private String name;

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
        }

        public static class UserClassBean {
            /**
             * id : 2
             * class_id : yThsv8
             * class_name : 10
             * description : 10th
             * created_at : 2020-02-08 18:41:36
             * updated_at : 2020-02-08 18:41:36
             */

            private int id;
            private String class_id;
            private String class_name;
            private String description;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
