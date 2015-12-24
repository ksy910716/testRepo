package com.example.ksy.test2.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ksy.test2.R;
import com.example.ksy.test2.model.Video;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by ksy on 2015-12-23.
 */
public class MainAdapter extends RecyclerView.Adapter {

    private List<Object> items;
    private Context context;


    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }



    public MainAdapter(Context context, List<Object> videos) {
        this(context, videos, false);
    }

    public MainAdapter(Context context, List<Object> videos, boolean isChannelMain) {
        this.context = context;
        this.items = videos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item_fragment, parent, false);
        return new NormalVideoHolder(itemView, viewType);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NormalVideoHolder videoHolder = (NormalVideoHolder) holder;
        Video video = (Video) items.get(position);
        Glide.with(context).load(video.getThumbnailUrl())
                .placeholder(R.drawable.pre_video_loading)
                .into(videoHolder.videoImg);
        videoHolder.videoDesc.setText(video.getSimpleDescription());
        videoHolder.videoLikedCnt.setText(NumberFormat.getInstance().format(video.getLikedCount()).toString());
        videoHolder.videoPlayCnt.setText(NumberFormat.getInstance().format(video.getPlayedCount()).toString());
        videoHolder.videoTitle.setText(video.getTitle());
        videoHolder.setVideo(video);
    }

    public final class NormalVideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView videoImg;
        TextView videoTitle;
        TextView videoDesc;
        TextView videoPlayCnt;
        TextView videoLikedCnt;

        private Video video;


        public NormalVideoHolder(View itemView, int viewType) {
            super(itemView);
            videoImg = (ImageView) itemView.findViewById(R.id.video_img);
            videoTitle = (TextView) itemView.findViewById(R.id.video_title);
            videoDesc = (TextView) itemView.findViewById(R.id.video_desc);
            videoPlayCnt = (TextView) itemView.findViewById(R.id.video_playedCnt);
            videoLikedCnt = (TextView) itemView.findViewById(R.id.video_likedCnt);
            //itemView.setOnClickListener(this);
        }

        public Video getVideo() {
            return video;
        }

        public void setVideo(Video video) {
            this.video = video;
        }

        @Override
        public void onClick(View v) {
           // Intent videoDetailIntent = new Intent(context, VideoDetailActivity.class);
           // videoDetailIntent.putExtra("videoId", video.getId());
           // videoDetailIntent.putExtra("videoType", video.getVideoType());
           // context.startActivity(videoDetailIntent);
        }
    }

}
