package org.whut.hibernate.module;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-22
 * Time: 上午9:52
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    private Long id;
    private String name;
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
