package com.hencoder.hencoderpracticedraw7.sample.sample06;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Sample06KeyframeLayout extends RelativeLayout {
    Sample06KeyframeView view;
    Button animateBt;

    public Sample06KeyframeLayout(Context context) {
        super(context);
    }

    public Sample06KeyframeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample06KeyframeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Sample06KeyframeView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe keyframe1 = Keyframe.ofFloat(0, 0); // 开始：progress 为 0
                Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100); // 进行到一半是，progres 为 100
                Keyframe keyframe3 = Keyframe.ofFloat(1, 80); // 结束时倒回到 80
                PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);

                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, holder);
                animator.setDuration(2000);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();
            }
        });
    }
}
