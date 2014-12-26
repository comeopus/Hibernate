package org.whut.struts2.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-18
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class OgnlTest {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("zhangsan");

        Dog dog = new Dog();
        dog.setName("wangcai");

        Dog dog2 = new Dog();
        dog2.setName("hello");

        person.setDog(dog2);
        OgnlContext context = new OgnlContext();

        context.put("person",person);
        context.put("dog",dog);

        context.setRoot(person);

        Object object = Ognl.parseExpression("#person.dog.name");
        System.out.println(object);

        Object object2 = Ognl.getValue(object,context,context.getRoot());
        System.out.println(object2);

        System.out.println("------------------------");

        Object object3 = Ognl.parseExpression("#person.name");
        System.out.println(object3);

        Object object4 = Ognl.getValue(object3,context,context.getRoot());
        System.out.println(object4);

        System.out.println("------------------------");

        Object object5 = Ognl.parseExpression("#dog.name");
        System.out.println(object5);

        Object object6 = Ognl.getValue(object5,context,context.getRoot());
        System.out.println(object6);

        System.out.println("------------------------");

        Object object7 = Ognl.parseExpression("name.toUpperCase()");
        System.out.println(object7);

        Object object8 = Ognl.getValue(object7,context,context.getRoot());
        System.out.println(object8);

        System.out.println("------------------------");

        Object object9 = Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)");
        System.out.println(object9);

        Object object10 = Ognl.getValue(object9,context,context.getRoot());
        System.out.println(object10);
        System.out.println("------------------------");
        Object object11 = Ognl.parseExpression("@@min(4,10)");  //也可以访问其静态变量   如@@E
        System.out.println(object11);

        Object object12 = Ognl.getValue(object11,context,context.getRoot());
        System.out.println(object12);

        System.out.println("------------------------");

        Object object13 = Ognl.parseExpression("new java.util.LinkedList()");   //ognl生成对象
        System.out.println(object13);

        Object object14 = Ognl.getValue(object13,context,context.getRoot());
        System.out.println(object14);

        System.out.println("------------------------");

        Object object15 = Ognl.getValue("{'aa','bb','cc','dd'}",context,context.getRoot());
        System.out.println(object15);

        System.out.println("------------------------");

        dog.setFriends(new String[]{"aa","bb","cc"});

        Object object16 = Ognl.getValue("#dog.friends[1]",context,context.getRoot());
        System.out.println(object16);

        System.out.println("------------------------");

        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("hello world");

        context.put("list",list);

        Object object17 = Ognl.getValue("#list[0]",context,context.getRoot());
        System.out.println(object17);

        Object object18 = Ognl.getValue("#{'key1':'value1','key2':'value2','key3':'value3','key4':'value4'}['key2']",context,context.getRoot());
        System.out.println(object18);
        System.out.println("------------------------");

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("zhangsan");
        p2.setName("lisi");
        p3.setName("wangwu");

        List persons = new ArrayList();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        context.put("persons",persons);
        //过滤（filtering）,collection.{? expression}
        //不是根元素    因此前面要加#    this表示当前对象    #this.name.length()>4当前对象的名字的长度大于4
        Object object19 = Ognl.getValue("#persons.{? #this.name.length()>4}[0].name",context,context.getRoot());
        System.out.println(object19);
        System.out.println("------------------------");

        //过滤（filtering）,collection.{^ expression} 返回集合的第一个元素   它返回的是一个集合（里面只有一个元素）
        Object object20 = Ognl.getValue("#persons.{^ #this.name.length()>4}[0].name",context,context.getRoot());
        System.out.println(object20);
        System.out.println("------------------------");

        //过滤（filtering）,collection.{$ expression} 返回集合的最后一个元素   它返回的是一个集合（里面只有一个元素）
        Object object21 = Ognl.getValue("#persons.{$ #this.name.length()>4}[0].name",context,context.getRoot());
        System.out.println(object21);
        System.out.println("------------------------");
        //投影（projection）：collection.{expression}
        System.out.println(Ognl.getValue("#persons.{name}",context,context.getRoot()));
        System.out.println("------------------------");
        //如果名字的长度大于5则返回name否则返回hello world

        System.out.println(Ognl.getValue("#persons.{#this.name.length()<=5?'Hello World':#this.name}",context,context.getRoot()));



    }
}
