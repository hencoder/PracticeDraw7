package com.hencoder.hencoderpracticedraw7.sample.sample03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw7.Utils;

public class Sample03OfObjectView extends View {
    public static final float RADIUS = Utils.dpToPixel(20);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    PointF position = new PointF();

    public Sample03OfObjectView(Context context) {
        super(context);
    }

    public Sample03OfObjectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03OfObjectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#009688"));
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF position) {
        if (position != null) {
            this.position.set(position);
            invalidate();
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float innerPaddingLeft = RADIUS * 1;
        float innterPaddingRight = RADIUS * 1;
        float innterPaddingTop = RADIUS * 1;
        float innterPaddingBottom = RADIUS * 3;
        float width = getWidth() - innerPaddingLeft - innterPaddingRight - RADIUS * 2;
        float height = getHeight() - innterPaddingTop - innterPaddingBottom - RADIUS * 2;

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innterPaddingTop + RADIUS + height * position.y, RADIUS, paint);
    }
}
