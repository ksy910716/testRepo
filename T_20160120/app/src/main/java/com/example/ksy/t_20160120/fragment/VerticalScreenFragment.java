package com.example.ksy.t_20160120.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ksy.t_20160120.R;
import com.example.ksy.t_20160120.activity.LockScreenActivity;
import com.example.ksy.t_20160120.network.RestAdapter;
import com.example.ksy.t_20160120.network.domain.Page;
import com.example.ksy.t_20160120.network.domain.Video;
import com.example.ksy.t_20160120.network.services.CuratorService;


import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
/**
 * Created by Prograper on 2016-01-06.
 */
public class VerticalScreenFragment extends Fragment {

    private int mPageNumber;
    private CuratorService curatorService;
    private List<Video> videoList = null;
    ImageView lockScreenImg;
    Video video;

    public Video getVideo(){
        return video;
    }

    public static VerticalScreenFragment create(int pageNumber) {
        VerticalScreenFragment fragment = new VerticalScreenFragment();
        Bundle args = new Bundle();
        args.putInt("page", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fm_lockscreen, container, false);
        lockScreenImg = (ImageView) rootView.findViewById(R.id.img_viewpager_childimage);
        curatorService = RestAdapter.getInstance(getActivity()).create(CuratorService.class);
        if(videoList == null) getCuratorListByUser();
        return rootView;
    }

    public void getCuratorListByUser(){
        curatorService.getCuratorListByUser(new Callback<Page<Video>>() {
            @Override
            public void success(Page<Video> videos, retrofit.client.Response response) {
                videoList = new ArrayList<Video>(videos.getContent());
                video = videoList.get(mPageNumber);
                Glide.with(getContext()).load(video.getThumbnailUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(lockScreenImg);
                ((LockScreenActivity) getActivity()).setVideoList(videoList);
            }
            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}
