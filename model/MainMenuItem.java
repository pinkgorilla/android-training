package com.moonlay.android.training.model;

/**
 * Created by Tris Setiawan on 5/8/2017.
 */

public class MainMenuItem {
    public final String id;
    public final String name;
    public final String description;

    public MainMenuItem(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
