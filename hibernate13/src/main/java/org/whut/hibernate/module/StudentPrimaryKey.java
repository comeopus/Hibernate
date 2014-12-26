package org.whut.hibernate.module;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public class StudentPrimaryKey implements Serializable{

    private String cardId;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPrimaryKey that = (StudentPrimaryKey) o;

        if (!cardId.equals(that.cardId)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
