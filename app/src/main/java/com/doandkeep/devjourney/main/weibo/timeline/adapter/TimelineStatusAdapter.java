package com.doandkeep.devjourney.main.weibo.timeline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.doandkeep.devjourney.bean.weibo.TimelineStatus;
import com.doandkeep.devjourney.main.weibo.timeline.view.TimelineStatusView;

import java.util.List;

/**
 * Created by zhangtao on 16/8/5.
 */
public class TimelineStatusAdapter extends RecyclerView.Adapter {

    private List<TimelineStatus> mStatuses;

    public TimelineStatusAdapter(List<TimelineStatus> statuses) {
        this.mStatuses = statuses;
    }

    public void setData(List<TimelineStatus> statuses) {
        this.mStatuses = statuses;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TimelineStatusViewHolder viewHolder = new TimelineStatusViewHolder(new TimelineStatusView(parent.getContext()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TimelineStatusViewHolder) holder).mStatusView.setData(mStatuses.get(position));
    }

    @Override
    public int getItemCount() {
        return mStatuses == null ? 0 : mStatuses.size();
    }

    public static class TimelineStatusViewHolder extends RecyclerView.ViewHolder {
        public TimelineStatusView mStatusView;

        public TimelineStatusViewHolder(TimelineStatusView statusView) {
            super(statusView);

            this.mStatusView = statusView;
        }
    }
}
