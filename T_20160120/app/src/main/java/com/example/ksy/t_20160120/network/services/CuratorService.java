package com.example.ksy.t_20160120.network.services;

import com.example.ksy.t_20160120.network.domain.Page;
import com.example.ksy.t_20160120.network.domain.Video;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ksy on 2016-01-08.
 */
public interface CuratorService {

    /**
     * 사용자별 큐레이터의 영상 목록
     *
     * @param callback
     */
    @GET("/api/curator/video")
    void getCuratorListByUser(Callback<Page<Video>> callback);


}
