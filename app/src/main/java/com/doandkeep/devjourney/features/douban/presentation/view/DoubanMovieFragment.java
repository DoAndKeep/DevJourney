package com.doandkeep.devjourney.features.douban.presentation.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseFragment;
import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieListEntity;
import com.doandkeep.devjourney.features.douban.presentation.DoubanMovieAdapter;
import com.doandkeep.devjourney.base.ServiceGenerator;
import com.doandkeep.devjourney.features.douban.data.DoubanService;
import com.doandkeep.devjourney.view.cyclerview.DividerItemDecoration;
import com.doandkeep.devjourney.view.cyclerview.EndlessRecyclerViewScrollListener;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMovieFragment extends BaseFragment {

    private static final String ARG_MOVIE_TYPE = "ARG_MOVIE_TYPE";

    @BindView(R.id.movie_srl)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.movie_rv)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private DoubanMovieAdapter mAdapter;

    private int mType;

    public static DoubanMovieFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(ARG_MOVIE_TYPE, type);
        DoubanMovieFragment fragment = new DoubanMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getInt(ARG_MOVIE_TYPE);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_douban_movie;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {

            }
        });

        mAdapter = new DoubanMovieAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST);
        itemDecoration.setDivider(getContext().getResources().getDrawable(R.drawable.divider_douban_movie));
        mRecyclerView.addItemDecoration(itemDecoration);

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadMovies();
            }
        });

        Snackbar.make(mSwipeRefreshLayout, "欢迎来到Dev Journey!", Snackbar.LENGTH_INDEFINITE)
                .setDuration(5000)
                .setAction("开始旅途", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).show();

        loadMovies();
    }

    private void loadMovies() {
        Timber.i("load movie");
        DoubanService doubanService = ServiceGenerator.createService(DoubanService.class);

        Call<DoubanMovieListEntity> call = doubanService.movieForInTheaters("北京");

        call.enqueue(new Callback<DoubanMovieListEntity>() {
            @Override
            public void onResponse(Call<DoubanMovieListEntity> call, Response<DoubanMovieListEntity> response) {
                onLoadedComplete();
                if (response.isSuccessful()) {
                    mAdapter.setData(response.body().getSubjects());
                } else {
                }
            }

            @Override
            public void onFailure(Call<DoubanMovieListEntity> call, Throwable t) {
                onLoadedComplete();
            }
        });
    }

    private void onLoadedComplete() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}
