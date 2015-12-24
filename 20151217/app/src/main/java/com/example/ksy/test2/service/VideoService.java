package com.example.ksy.test2.service;

import com.example.ksy.test2.model.Video;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ksy on 2015-12-23.
 */
public interface VideoService {

    @GET("/api/video")
    void listVideo(Callback<List<Video>> callback);
}
