package org.whut.struts2.ognl;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-18
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class Dog {

    private String name;
    private String[] friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }
}
