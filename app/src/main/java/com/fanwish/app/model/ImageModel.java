package com.fanwish.app.model;

/**
 * Created by mdfaroque on 7/5/15.
 */
public class ImageModel {
    private String url;

    public ImageModel(String url){
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
