package org.whut.hibernate.module;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-22
 * Time: 下午7:02
 * To change this template use File | Settings | File Templates.
 */
public class Category {

    private Long id;
    private String name;
    private Category parentCategory;
    private Set<Category> childCategory;

    public Category(String name, Category parentCategory, Set<Category> childCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.childCategory = childCategory;
    }

    public Category() {
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<Category> childCategory) {
        this.childCategory = childCategory;
    }
}
