package com.doandkeep.devjourney.main.weibo.timeline;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseFragment;
import com.doandkeep.devjourney.bean.weibo.Timeline;
import com.doandkeep.devjourney.main.weibo.Constants;
import com.doandkeep.devjourney.main.weibo.timeline.adapter.TimelineStatusAdapter;
import com.doandkeep.devjourney.retrofit.ServiceGenerator;
import com.doandkeep.devjourney.retrofit.service.WeiboService;
import com.doandkeep.devjourney.third.weibo.AccessTokenKeeper;
import com.doandkeep.devjourney.util.DebugLog;

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

    @BindView(R.id.timeline_rv)
    RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private TimelineStatusAdapter mAdapter;

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

        mAdapter = new TimelineStatusAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        WeiboService weiboService = ServiceGenerator.createService(WeiboService.class);

        Call<Timeline> call;
        switch (mType) {
            case Constants.TYPE_TIMELINE_PUBLIC:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken());
                break;
            case Constants.TYPE_TIMELINE_FRIEND:
                call = weiboService.timelineForFriend(AccessTokenKeeper.readAccessToken(getContext()).getToken());
                break;
            case Constants.TYPE_TIMELINE_MINE:
                call = weiboService.timelineForMine(AccessTokenKeeper.readAccessToken(getContext()).getToken());
                break;
            default:
                call = weiboService.timelineForPublic(AccessTokenKeeper.readAccessToken(getContext()).getToken());
                break;
        }

        call.enqueue(new Callback<Timeline>() {
            @Override
            public void onResponse(Call<Timeline> call, Response<Timeline> response) {
                if (response.isSuccessful()) {
                    mAdapter.setData(response.body().getStatuses());
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

}
