package com.doandkeep.devjourney.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.doandkeep.devjourney.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by zhangtao on 16/8/10.
 */
public class AdvanceImageView extends ImageView {
    public AdvanceImageView(Context context) {
        super(context);
    }

    public AdvanceImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdvanceImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUrl(String url) {
        Picasso.with(getContext())
                .load(url).fit()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(this);
    }

    public void setUrl(String url, ImageViewSpec spec) {
        RequestCreator creator = Picasso.with(getContext()).load(url);
        if (spec.isCircle) {
            creator.transform(new CropCircleTransformation());
        }
        creator.fit()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(this);
    }


    public static class ImageViewSpec {
        private boolean isCircle;

        public boolean isCircle() {
            return isCircle;
        }

        public void setCircle(boolean circle) {
            isCircle = circle;
        }
    }

}
