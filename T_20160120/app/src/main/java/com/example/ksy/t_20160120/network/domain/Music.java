package com.example.ksy.t_20160120.network.domain;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class Music {
    private Long id;
    private String title;
    private String singer;

    /**
     * 시작시간 second 단위
     */
    private int startTime;

    /**
     * 종료시간 second 단위
     */
    private int endTime;

    private String url;

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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
