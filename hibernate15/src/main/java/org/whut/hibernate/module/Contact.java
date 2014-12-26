package org.whut.hibernate.module;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
public class Contact {

    private String student_id;
    private String method;
    private String address;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
