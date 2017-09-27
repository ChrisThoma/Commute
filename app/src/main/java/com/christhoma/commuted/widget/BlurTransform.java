package com.christhoma.commuted.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

import com.squareup.picasso.Transformation;

import java.lang.ref.WeakReference;


public class BlurTransform implements Transformation {

    private final WeakReference<Context> contextReference;

    BlurTransform(Context context) {
        super();
        contextReference = new WeakReference<>(context);
    }

    @Override
    public Bitmap transform(Bitmap source) {
        final RenderScript rs = RenderScript.create(contextReference.get());

        // Create another source that will hold the results of the filter.
        final Bitmap blurredBitmap = source.copy(source.getConfig(), true);

        // Allocate memory for Renderscript to work with
        final Allocation input = Allocation.createFromBitmap(rs, source, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SHARED);
        final Allocation output = Allocation.createTyped(rs, input.getType());

        // Load up an instance of the specific script that we want to use.
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setInput(input);

        // Set the blur radius
        script.setRadius(25);

        // Start the ScriptIntrinisicBlur
        script.forEach(output);

        // Copy the output to the blurred source
        output.copyTo(blurredBitmap);

        // We have created a new copy, recycle the source bitmap.
        source.recycle();

        return blurredBitmap;
    }

    @Override
    public String key() {
        return "blur";
    }

}
