package org.whut.hibernate.module;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class Address {

    private String homeAddress;
    private String schoolAddress;

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }
}
