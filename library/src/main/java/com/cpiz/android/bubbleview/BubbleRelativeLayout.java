package com.cpiz.android.bubbleview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import lombok.experimental.Delegate;

/**
 * 气泡样式的RelativeLayout布局
 * 支持自定义气泡样式
 *
 * Created by caijw on 2016/5/26.
 * https://github.com/cpiz/BubbleView
 */
@SuppressWarnings("unused")
public class BubbleRelativeLayout extends RelativeLayout implements BubbleStyle, BubbleCallback {
    @Delegate(types = BubbleStyle.class)
    private BubbleImpl mBubbleImpl = new BubbleImpl();

    public BubbleRelativeLayout(Context context) {
        super(context);
        init(context, null);
    }

    public BubbleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BubbleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BubbleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mBubbleImpl.init(this, context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mBubbleImpl.updateDrawable(right - left, bottom - top, true);
    }

    @Override
    public void setSuperPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
    }

    @Override
    public int getSuperPaddingLeft() {
        return super.getPaddingLeft();
    }

    @Override
    public int getSuperPaddingTop() {
        return super.getPaddingTop();
    }

    @Override
    public int getSuperPaddingRight() {
        return super.getPaddingRight();
    }

    @Override
    public int getSuperPaddingBottom() {
        return super.getPaddingBottom();
    }
}
