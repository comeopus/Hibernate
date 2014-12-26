package org.whut.hibernate.module;

import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */
public class Student {

    private String id;
    private String name;
    private String cardId;
    private int age;
    //通过时间戳来实现乐观锁
    private Date lastDate;

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    //    private int version;
//
//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
