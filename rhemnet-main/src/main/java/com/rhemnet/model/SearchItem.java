package com.rhemnet.model;

/**
 * Created by user on 14-12-28.
 */
public class SearchItem {
    private String title;
    private String description;


    public SearchItem() {
    }

    public SearchItem( String title, String description) {
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
