package com.example.ksy.t_20160120.network.domain;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class Channel {
    private Long id;
    private String name;
    private String icon;
    private String description;
    private Long updateTime;
    private String coverImage;

    /**
     * grid의 개수를 맞추기 위해 공백 channel을 넣기위한 필드
     */
    private boolean isEmpty = false;

    public Channel() {

    }

    public Channel(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Channel(Long id, String name, String icon, String coverImage, long updateTime, String description) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.coverImage = coverImage;
        this.updateTime = updateTime;
        this.description = description;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
