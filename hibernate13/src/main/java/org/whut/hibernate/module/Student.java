package org.whut.hibernate.module;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
public class Student {

    private StudentPrimaryKey studentPrimaryKey;
    private int age;

    public StudentPrimaryKey getStudentPrimaryKey() {
        return studentPrimaryKey;
    }

    public void setStudentPrimaryKey(StudentPrimaryKey studentPrimaryKey) {
        this.studentPrimaryKey = studentPrimaryKey;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
