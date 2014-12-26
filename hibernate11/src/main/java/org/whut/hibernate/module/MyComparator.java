package org.whut.hibernate.module;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-24
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class MyComparator implements Comparator<Student> {
    /**
     * 自定义内存比较器    升序就是如下    如果是降序   则在result前面加上负号“-”即可
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == o2){
            return 0;
        }
        int result = o1.getCardId().compareTo(o2.getCardId());
        if(result != 0 ){
            return result;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
