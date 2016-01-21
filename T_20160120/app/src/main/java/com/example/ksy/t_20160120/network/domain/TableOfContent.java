package com.example.ksy.t_20160120.network.domain;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class TableOfContent {
    private long id;

    /**
     * 제목
     */
    private String title;
    /**
     * 시작시간 second 단위
     */
    private int startTime;

    /**
     * 종료시간 second 단위
     */
    private int endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
