package com.doandkeep.devjourney.features.weibo.timeline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.doandkeep.devjourney.bean.weibo.WeiboTimeline;
import com.doandkeep.devjourney.features.weibo.timeline.view.WeiboTimelineView;

import java.util.List;

/**
 * Created by zhangtao on 16/8/5.
 */
public class TimelineAdapter extends RecyclerView.Adapter {

    private static final String TAG = TimelineAdapter.class.getCanonicalName();

    private List<WeiboTimeline> mTimelines;

    public TimelineAdapter(List<WeiboTimeline> timelines) {
        this.mTimelines = timelines;
    }

    public void setData(List<WeiboTimeline> timelines) {
        if (this.mTimelines != null) {
            this.mTimelines.clear();
            this.mTimelines.addAll(timelines);
        } else {
            this.mTimelines = timelines;
        }
        notifyDataSetChanged();
    }

    public void addData(List<WeiboTimeline> timelines) {
        if (this.mTimelines != null) {
            this.mTimelines.addAll(timelines);
        } else {
            this.mTimelines = timelines;
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TimelineViewHolder viewHolder = new TimelineViewHolder(new WeiboTimelineView(parent.getContext()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TimelineViewHolder) holder).mTimelineView.setData(mTimelines.get(position));
    }

    @Override
    public int getItemCount() {
        return mTimelines == null ? 0 : mTimelines.size();
    }

    public static class TimelineViewHolder extends RecyclerView.ViewHolder {
        public WeiboTimelineView mTimelineView;

        public TimelineViewHolder(WeiboTimelineView timelineView) {
            super(timelineView);

            this.mTimelineView = timelineView;
        }
    }
}
