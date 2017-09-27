package com.christhoma.commuted.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoSwitcher extends ImageSwitcher {

    public PicassoSwitcher(Context context) {
        this(context, null);
    }

    public PicassoSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setImageResource(int resid) {
        ImageView imageView = (ImageView) getNextView();
        Picasso.with(getContext()).load(resid).fit().transform(new BlurTransform(getContext())).into(imageView);
        showNext();
    }
}
