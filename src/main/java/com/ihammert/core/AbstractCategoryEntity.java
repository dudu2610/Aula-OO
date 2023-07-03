package com.ihammert.core;

public abstract class AbstractCategoryEntity {

    private static int globaCategoryId = 0;

    private String categoryName;
    private int categoryId;

    public AbstractCategoryEntity(String categoryName) {
        this.globaCategoryId++;
        this.categoryName = categoryName;
        this.categoryId = this.globaCategoryId;
    }

    public int getId() {
        return this.categoryId;
    }

    public int getTotalCategories() {
        return this.globaCategoryId;
    }

    public void setCategoryName(String newName) {
        this.categoryName = newName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryId(int id){
        this.categoryId = id;
    }
}
