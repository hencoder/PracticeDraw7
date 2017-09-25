package com.hencoder.hencoderpracticedraw7.practice.practice01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw7.R;

public class Practice01ArgbEvaluatorView extends View {

    Paint pointPaint;
    private Matrix mPolyMatrix;
    Bitmap bitmap;
    Camera camera;
    private float[] src = new float[8];
    private float[] dst = new float[8];

    private float wave;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPolyMatrix = new Matrix();
        camera = new Camera();
        wave = 45;
        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth(50);
        pointPaint.setColor(0xffd19165);
        pointPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public Practice01ArgbEvaluatorView(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float bitmapWidth = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();
        float centerX = bitmapWidth / 2;
        float centerY = bitmapHeight / 2;

//        float[] temp = {centerX, centerY,                            // 上中
//                bitmapWidth / 2f + centerX, centerY,         // 右中
//                bitmapWidth / 2f + centerX, bitmapHeight / 2f + centerY,           // 下中
//                centerX, bitmapHeight / 2f + centerY};                                   // 左中
        float[] temp = {0, 0,                                    // 左上
                bitmap.getWidth(), 0,                          // 右上
                bitmap.getWidth(), bitmap.getHeight(),        // 右下
                0, bitmap.getHeight()};

        src = temp.clone();
        dst = temp.clone();
        float r = (float) Math.sqrt((Math.pow(bitmapWidth, 2) + Math.pow(bitmapHeight, 2)));

        canvas.save();
        canvas.translate(300, 100);
        dst[4] = (float) (Math.cos(Math.toRadians(wave)) * r);
        dst[5] = (float) (Math.sin(Math.toRadians(wave)) * r);
//        dst[4] = (float) (Math.cos(Math.toRadians(30)) * r);
//        dst[5] = src[5] - (float) (Math.cos(30) * r);
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, 4);
        canvas.drawBitmap(bitmap, mPolyMatrix, null);
        for (int i = 0; i < 8; i += 2) {
            canvas.drawPoint(dst[i], dst[i + 1], pointPaint);
        }
        canvas.restore();

    }

    public float getWave() {
        return wave;
    }

    public void setWave(float wave) {
        this.wave = wave;
        invalidate();
    }
}
