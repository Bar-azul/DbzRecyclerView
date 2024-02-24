package com.example.recyclerveiw1;

public class dbz_Model {

    String dbz_names;
    String dbz_races;
    String dbz_power;
    String description;
    int image;


    public dbz_Model(String dbz_names,String dbz_races, String dbz_power, int image,String dbz_Description) {
        this.dbz_names = dbz_names;
        this.dbz_races = dbz_races;
        this.dbz_power = dbz_power;
        this.image = image;
        this.description= dbz_Description;
    }

    public String getDescription() {
        return description;
    }

    public String getDbz_names() {
        return dbz_names;
    }

    public String getDbz_races() {
        return dbz_races;
    }

    public String getDbz_power() {
        return dbz_power;
    }

    public int getImage() {
        return image;
    }
}
