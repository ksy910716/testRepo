package com.example.ksy.t_20160120.network.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PrographerJ on 2015-07-10.
 */
public class User {

    private String fbId;
    private String fbToken;

    private String kakaoId;
    private String kakaoToken;
    private String email;
    private String name;
    private String profileImage;
    private String token;
    private Long updateTime;
    private long lastStartAppTime;
    private int combo;

    /**
     * 서버에서 데이터를 받아오는 ID List
     */
    private List<Long> favoriteChannels = new ArrayList<>();
    private List<Long> favoriteVideos = new ArrayList<>();
    private List<Long> likeVideos = new ArrayList<>();

    /**
     * 로컬에 저장을 위한 Object 정보
     */
//    private transient List<Video> favoriteVideoObjects = new ArrayList<>();
    //  private transient List<Video> likeVideoObjects = new ArrayList<>();
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Long> getFavoriteChannels() {
        return favoriteChannels;
    }

    public void setFavoriteChannels(List<Long> favoriteChannels) {
        this.favoriteChannels = favoriteChannels;
    }

    public List<Long> getFavoriteVideos() {
        return favoriteVideos;
    }

    public void setFavoriteVideos(List<Long> favoriteVideos) {
        this.favoriteVideos = favoriteVideos;
    }

    public List<Long> getLikeVideos() {
        return likeVideos;
    }

    public void setLikeVideos(List<Long> likeVideos) {
        this.likeVideos = likeVideos;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getKakaoId() {
        return kakaoId;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public String getKakaoToken() {
        return kakaoToken;
    }

    public void setKakaoToken(String kakaoToken) {
        this.kakaoToken = kakaoToken;
    }

    public long getLastStartAppTime() {
        return lastStartAppTime;
    }

    public void setLastStartAppTime(long lastStartAppTime) {
        this.lastStartAppTime = lastStartAppTime;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }
}
