package com.hencoder.hencoderpracticedraw7.practice.practice01;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Practice01ArgbEvaluatorLayout extends RelativeLayout {
    Practice01ArgbEvaluatorView view;
    Button animateBt;

    public Practice01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        view = (Practice01ArgbEvaluatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator=ObjectAnimator.ofFloat(view,"angle",0f,-30f);
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(500);

                ObjectAnimator wave=ObjectAnimator.ofFloat(view,"wave",0f,10f);
                wave.setInterpolator(new LinearInterpolator());
                wave.setDuration(500);

                AnimatorSet animationSet=new AnimatorSet();
                animationSet.playSequentially(animator,wave);
                animationSet.start();
            }
        });
    }
}
