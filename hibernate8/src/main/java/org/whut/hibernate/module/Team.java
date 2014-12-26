package org.whut.hibernate.module;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 下午7:25
 * To change this template use File | Settings | File Templates.
 */

/**
 * 一个类中有一个Map对象的属性
 * 将有一个配置文件   会生成两张表
 */
public class Team {

    private String id;
    private String teamName;

    private Set students = new HashSet();

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
