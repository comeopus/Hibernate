package org.whut.hibernate.module;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class Student implements Serializable {

    private String cardId;

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!cardId.equals(student.cardId)) return false;
        if (!name.equals(student.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
