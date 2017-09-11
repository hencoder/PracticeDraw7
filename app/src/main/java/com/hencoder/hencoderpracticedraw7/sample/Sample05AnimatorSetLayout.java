package com.hencoder.hencoderpracticedraw7.sample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Sample05AnimatorSetLayout extends RelativeLayout {
    View view;
    Button animateBt;

    public Sample05AnimatorSetLayout(Context context) {
        super(context);
    }

    public Sample05AnimatorSetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample05AnimatorSetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setTranslationX(-200f);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "translationX", -200, 200);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotation", 0, 1080);
                animator3.setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator1).before(animator2); // 先执行 1 再执行 2
                animatorSet.playTogether(animator2, animator3); // 2 和 3 同时开始

                animatorSet.start();
            }
        });
    }
}
