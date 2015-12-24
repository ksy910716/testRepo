package com.example.ksy.test2.model;

/**
 * Created by ksy on 2015-12-23.
 */
public class Video {
    private Long id;
    private String title;
    private String simpleDescription;
    private String thumbnailUrl;
    private int likedCount;
    private int playedCount;

    public void setSimpleDescription(String simpleDescription){
        this.simpleDescription = simpleDescription;
    }

    public String getSimpleDescription(){
        return this.simpleDescription;
    }

    public void setThumbnailUrl(String thumbName){
        this.thumbnailUrl = thumbName;
    }

    public String getThumbnailUrl(){
        return this.thumbnailUrl;
    }

    public void setId(Long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setLikedCount(int likedCount){
        this.likedCount = likedCount;
    }

    public int getLikedCount(){
        return this.likedCount;
    }

    public void setPlayedCount(int playedCount){
        this.playedCount = playedCount;
    }

    public int getPlayedCount(){
        return this.playedCount;
    }
}
