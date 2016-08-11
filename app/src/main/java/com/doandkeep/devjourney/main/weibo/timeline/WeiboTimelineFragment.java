package com.doandkeep.devjourney.main.weibo.timeline;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseFragment;
import com.doandkeep.devjourney.bean.weibo.Timeline;
import com.doandkeep.devjourney.main.weibo.Constants;
import com.doandkeep.devjourney.main.weibo.timeline.adapter.TimelineAdapter;
import com.doandkeep.devjourney.retrofit.ServiceGenerator;
import com.doandkeep.devjourney.retrofit.service.WeiboService;
import com.doandkeep.devjourney.third.weibo.AccessTokenKeeper;
import com.doandkeep.devjourney.util.DebugLog;
import com.doandkeep.devjourney.view.cyclerview.DividerItemDecoration;
import com.doandkeep.devjourney.view.cyclerview.EndlessRecyclerViewScrollListener;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhangtao on 16/8/3.
 */
public class WeiboTimelineFragment extends BaseFragment {

    private static final String TAG = WeiboTimelineFragment.class.getCanonicalName();

    private static final String ARG_TIMELINE_TYPE = "ARG_TIMELINE_TYPE";
    private static final int COUNT_PER_REQ = 20;

    @BindView(R.id.timeline_srl)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.timeline_rv)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private TimelineAdapter mAdapter;

    private int mType;

    public static WeiboTimelineFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(ARG_TIMELINE_TYPE, type);
        WeiboTimelineFragment fragment = new WeiboTimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getInt(ARG_TIMELINE_TYPE);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_weibo_timeline;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                loadMoreTimelines(page + 1);
            }
        });

        mAdapter = new TimelineAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST);
        itemDecoration.setDivider(getContext().getResources().getDrawable(R.drawable.divider_weibo_timeline));
        mRecyclerView.addItemDecoration(itemDecoration);

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadInitalTimelines();
            }
        });

        loadInitalTimelines();
    }

    private void loadInitalTimelines() {
        WeiboService weiboService = ServiceGenerator.createService(WeiboService.class);

        Call<Timeline> call;
        switch (mType) {
            case Constants.TYPE_TIMELINE_PUBLIC:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, 1);
                break;
            case Constants.TYPE_TIMELINE_FRIEND:
                call = weiboService.timelineForFriend(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, 1);
                break;
            case Constants.TYPE_TIMELINE_MINE:
                call = weiboService.timelineForMine(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, 1);
                break;
            default:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, 1);
                break;
        }

        call.enqueue(new Callback<Timeline>() {
            @Override
            public void onResponse(Call<Timeline> call, Response<Timeline> response) {
                onLoadedComplete();
                if (response.isSuccessful()) {
                    mAdapter.setData(response.body().getStatuses());
                } else {
                    DebugLog.i(TAG, "request if failed");
                }
            }

            @Override
            public void onFailure(Call<Timeline> call, Throwable t) {
                onLoadedComplete();
                DebugLog.i(TAG, "error:" + t.getMessage());
            }
        });
    }

    private void loadMoreTimelines(int page) {
        DebugLog.i(TAG, "loadMore_page:" + page);

        WeiboService weiboService = ServiceGenerator.createService(WeiboService.class);

        Call<Timeline> call;
        switch (mType) {
            case Constants.TYPE_TIMELINE_PUBLIC:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, page);
                break;
            case Constants.TYPE_TIMELINE_FRIEND:
                call = weiboService.timelineForFriend(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, page);
                break;
            case Constants.TYPE_TIMELINE_MINE:
                call = weiboService.timelineForMine(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, page);
                break;
            default:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken(), COUNT_PER_REQ, page);
                break;
        }

        call.enqueue(new Callback<Timeline>() {
            @Override
            public void onResponse(Call<Timeline> call, Response<Timeline> response) {
                if (response.isSuccessful()) {
                    mAdapter.addData(response.body().getStatuses());
                } else {
                    DebugLog.i(TAG, "request if failed");
                }
            }

            @Override
            public void onFailure(Call<Timeline> call, Throwable t) {
                DebugLog.i(TAG, "error:" + t.getMessage());
            }
        });
    }

    private void onLoadedComplete() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}
