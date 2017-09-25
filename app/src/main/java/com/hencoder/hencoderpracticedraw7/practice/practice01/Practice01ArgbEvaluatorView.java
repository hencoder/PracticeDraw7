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

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Camera camera;
    private Matrix matrix;
    private int color = 0xffff0000;
    private float angle;
    private float wave;
    Bitmap bitmap;
    float[] dst;
    float[] src;
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        angle = 0;
        wave = 0;
        camera = new Camera();
        matrix = new Matrix();

                   // 左下

    }

    public Practice01ArgbEvaluatorView(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        src = {0, 0,                                    // 左上
//                bitmap.getWidth(), 0,                          // 右上
//                bitmap.getWidth(), bitmap.getHeight(),        // 右下
//                0, bitmap.getHeight()};                        // 左下
//
//        dst = {0, 0,                                    // 左上
//                bitmap.getWidth(), 400,                        // 右上
//                bitmap.getWidth(), bitmap.getHeight() - 200,  // 右下
//                0, bitmap.getHeight()};
    }

    public Practice01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float bitmapWidth = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        float x = centerX - bitmapWidth / 2;
        float y = centerY - bitmapHeight / 2;


        canvas.save();
        canvas.clipRect(x, y, centerX, (0.5f * bitmapHeight + centerY));
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        matrix.reset();
        camera.rotateY(angle);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.postTranslate(centerX, centerY);
        matrix.preTranslate(-centerX, -centerY);
        canvas.concat(matrix);
        canvas.clipRect(centerX, (centerY - 0.5f * bitmapHeight), (centerX + 0.5f * bitmapWidth), (0.5f * bitmapHeight + centerY));
        canvas.drawBitmap(bitmap, x, y, paint);
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
