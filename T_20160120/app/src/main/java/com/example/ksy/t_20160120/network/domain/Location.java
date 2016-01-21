package com.example.ksy.t_20160120.network.domain;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class Location {
    private Long id;
    private String title;
    /**
     * 시작시간 second 단위
     */
    private int startTime;
    /**
     * 종료시간 second 단위
     */
    private int endTime;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
