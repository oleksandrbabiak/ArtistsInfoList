package com.example.alex.parallaxeffect.entity;

import java.util.List;

/**
 * Created by Alex on 04.10.2015.
 */
public class PreviewClipItem {
    private String picture;
    private List<Artist> artists;
    private String view_count;
    private String slug;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
