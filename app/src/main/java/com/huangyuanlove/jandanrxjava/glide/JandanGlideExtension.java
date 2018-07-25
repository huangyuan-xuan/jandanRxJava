package com.huangyuanlove.jandanrxjava.glide;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.request.RequestOptions.decodeTypeOf;


@GlideExtension
public final class JandanGlideExtension {

    private JandanGlideExtension(){};

    public static final RequestOptions DECODE_TYPE_GIF = decodeTypeOf(GifDrawable.class).lock();


}
