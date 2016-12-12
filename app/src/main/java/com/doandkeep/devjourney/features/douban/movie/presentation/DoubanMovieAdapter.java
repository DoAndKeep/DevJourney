package com.doandkeep.devjourney.features.douban.movie.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;
import com.doandkeep.devjourney.features.douban.movie.presentation.view.item.DoubanMovieItemView;

import java.util.List;

/**
 * Created by zhangtao on 16/8/5.
 */
public class DoubanMovieAdapter extends RecyclerView.Adapter {

    private List<MovieModel> mMovies;

    public DoubanMovieAdapter(List<MovieModel> movies) {
        this.mMovies = movies;
    }

    public void setData(List<MovieModel> movies) {
        if (this.mMovies != null) {
            this.mMovies.clear();
            this.mMovies.addAll(movies);
        } else {
            this.mMovies = movies;
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieViewHolder viewHolder = new MovieViewHolder(new DoubanMovieItemView(parent.getContext()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolder) holder).mMovieItemView.setData(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public DoubanMovieItemView mMovieItemView;

        public MovieViewHolder(DoubanMovieItemView movieItemView) {
            super(movieItemView);

            this.mMovieItemView = movieItemView;
        }
    }
}
