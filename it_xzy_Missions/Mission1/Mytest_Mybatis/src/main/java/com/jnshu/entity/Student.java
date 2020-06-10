package com.jnshu.entity;


/**
 * 类名采用UpperCamelCase风格
 * @author 王振宇
 * 2020.6.10
 *
 * POJO类属性必须使用包装数据类型
 * POJO类必须写toString方法，在方法抛出异常时，可以直接调用POJO的toString()方法打印其属性，便于排查问题
 */
public  class Student {
    /**
     * 不以 _ $ 开始和结束
     * 局部变量采用lowerCamelCase风格
     */
    private Integer idInMysql;
    private String nameInMysql;
    private String schoolInMysql;
    private String onlineOrUnInMysql;
    private Integer numberInMysql;
    private String cityInMysql;

    public Integer getIdInMysql() {
        return idInMysql;
    }
    // setter方法中，参数名称与类成员变量名称一致
    public void setIdInMysql(Integer idInMysql) {
        this.idInMysql = idInMysql;
    }

    public String getNameInMysql() {
        return nameInMysql;
    }

    public void setNameInMysql(String nameInMysql) {
        this.nameInMysql = nameInMysql;
    }

    public String getSchoolInMysql() {
        return schoolInMysql;
    }

    public void setSchoolInMysql(String schoolInMysql) {
        this.schoolInMysql = schoolInMysql;
    }

    public String getOnlineOrUnInMysql() {
        return onlineOrUnInMysql;
    }

    public void setOnlineOrUnInMysql(String onlineOrUnInMysql) {
        this.onlineOrUnInMysql = onlineOrUnInMysql;
    }

    public Integer getNumberInMysql() {
        return numberInMysql;
    }

    public void setNumberInMysql(Integer numberInMysql) {
        this.numberInMysql = numberInMysql;
    }

    public String getCityInMysql() {
        return cityInMysql;
    }

    public void setCityInMysql(String cityInMysql) {
        this.cityInMysql = cityInMysql;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idInMysql=" + idInMysql +
                ", nameInMysql='" + nameInMysql + '\'' +
                ", schoolInMysql='" + schoolInMysql + '\'' +
                ", onlineOrUnInMysql='" + onlineOrUnInMysql + '\'' +
                ", numberInMysql=" + numberInMysql +
                ", cityInMysql='" + cityInMysql + '\'' +
                '}';
    }
}


