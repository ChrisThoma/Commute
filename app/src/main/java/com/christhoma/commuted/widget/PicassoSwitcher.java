package com.christhoma.commuted.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class PicassoSwitcher extends ImageSwitcher {

    Picasso picasso;
    Transformation blurTransformation;

    public PicassoSwitcher(Context context) {
        this(context, null);
    }

    public PicassoSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        picasso = Picasso.with(context);
        blurTransformation = new BlurTransform(context);
    }

    @Override
    public void setImageResource(int resid) {
        ImageView imageView = (ImageView) getNextView();
        picasso.load(resid).fit().transform(blurTransformation).into(imageView);
        showNext();
    }
}
