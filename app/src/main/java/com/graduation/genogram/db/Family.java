package com.graduation.genogram.db;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class Family extends LitePalSupport {
    private String name;
    private int id;
    private String spouse;
    private int databaseId;
    private int father;
    //=======

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getFather() {
        return father;
    }
}
