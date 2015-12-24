package com.example.ksy.test2.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ksy.test2.R;
import com.example.ksy.test2.adapter.MainAdapter;
import com.example.ksy.test2.model.Video;
import com.example.ksy.test2.service.VideoService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ksy on 2015-12-23.
 */
public class MainFragment extends Fragment{
    RecyclerView mainVideoList;
    MainAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_main, container, false);
        mainVideoList = (RecyclerView) view.findViewById(R.id.lst_main_videos);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        mainVideoList.setLayoutManager(layoutManager);

        VideoService channelService = instance().create(VideoService.class);

        channelService.listVideo(
                new Callback<List<Video>>() {
                    @Override
                    public void success(List<Video> videos, Response response) {
                        if (videos != null) {
                            List<Object> objects = new ArrayList<Object>(videos);
                            adapter = new MainAdapter(getActivity(), objects);
                            mainVideoList.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                    }
                }
        );

        return view;
    }


    public retrofit.RestAdapter instance(){
        retrofit.RestAdapter instance = new retrofit.RestAdapter.Builder()
                .setEndpoint("http://api.videoceans.com")
                .build();
        return instance;
    }
}
