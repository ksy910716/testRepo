package com.example.ksy.t_20160120.network.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class Video {
    private Long id;
    /**
     * 영상 제목
     */
    private String title;

    /**
     * 영상에 대한 설명
     */
    private String description;
    private String simpleDescription;

    private int likedCount;
    private int sharedCount;
    private int favoritedCount;
    private int playedCount;

    private String tags;

    private String videoKey;
    private int videoType;

    private String videoUrl;
    private String thumbnailUrl;
    private String captionUrl;
    private int playTime;

    @JsonIgnore
    private Channel channel;
    private User editor;

    private long totalReward;

    private List<TableOfContent> tableOfContents;

    private List<Location> locations;

    private List<Product> products;

    private List<Music> musics;

    private List<Video> relatedVideo;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getSharedCount() {
        return sharedCount;
    }

    public void setSharedCount(int sharedCount) {
        this.sharedCount = sharedCount;
    }

    public int getFavoritedCount() {
        return favoritedCount;
    }

    public void setFavoritedCount(int favoritedCount) {
        this.favoritedCount = favoritedCount;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getCaptionUrl() {
        return captionUrl;
    }

    public void setCaptionUrl(String captionUrl) {
        this.captionUrl = captionUrl;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getEditor() {
        return editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public List<TableOfContent> getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(List<TableOfContent> tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public List<Video> getRelatedVideo() {
        return relatedVideo;
    }

    public void setRelatedVideo(List<Video> relatedVideo) {
        this.relatedVideo = relatedVideo;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSimpleDescription() {
        return simpleDescription;
    }

    public void setSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }

    public String getVideoKey() {
        return videoKey;
    }

    public void setVideoKey(String videoKey) {
        this.videoKey = videoKey;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public long getTotalReward() {
        return totalReward;
    }

    public void setTotalReward(long totalReward) {
        this.totalReward = totalReward;
    }
}
