package com.hencoder.hencoderpracticedraw7.sample.sample03;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Sample03OfObjectLayout extends RelativeLayout {
    Sample03OfObjectView view;
    Button animateBt;

    public Sample03OfObjectLayout(Context context) {
        super(context);
    }

    public Sample03OfObjectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Sample03OfObjectView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofObject(view, "position",
                        new PointFEvaluator(), new PointF(0, 0), new PointF(1, 1));
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(1000);
                animator.start();
            }
        });
    }

    private class PointFEvaluator implements TypeEvaluator<PointF> {
        PointF newPoint = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (fraction * (endValue.x - startValue.x));
            float y = startValue.y + (fraction * (endValue.y - startValue.y));

            newPoint.set(x, y);

            return newPoint;
        }
    }
}
