package org.whut.struts2.ognl;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-18
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    private String name;
    private Dog dog;

    public String getName() {
        System.out.println("getName invoked!!");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
