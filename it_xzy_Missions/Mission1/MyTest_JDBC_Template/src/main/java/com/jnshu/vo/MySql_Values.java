package com.jnshu.vo;

public class MySql_Values {
        private int id;
        private String name;
        private String school;
        private String online_un;
        private int number;
        private String city;

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

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getOnline_un() {
            return online_un;
        }

        public void setOnline_un(String online_un) {
            this.online_un = online_un;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String toString(){
            return "MySql_Valuse [id = " + id + ", name = " + name + ", school = " + school + ", online_un = "
                                                + online_un + ", number = " + number + ", city = " + city +"]";
        }

}


