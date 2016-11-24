package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import com.doandkeep.devjourney.base.presentation.LoadDataView;
import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieEntity;

import java.util.List;

/**
 * Created by zhangtao on 2016/11/23.
 */

public interface DoubanMovieListView extends LoadDataView {
    void renderMovie(List<DoubanMovieEntity> movieList);
}
