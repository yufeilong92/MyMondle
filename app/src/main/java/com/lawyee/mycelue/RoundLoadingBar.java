package com.lawyee.mycelue;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/13 16:33
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class RoundLoadingBar extends View {
    private String TAG = RoundLoadingBar.class.getSimpleName();
    private Context mConText;
    private Paint mPaint;
    //大框的颜色
    private int mFramColor = Color.BLACK;
    //大圆的颜色
    private int mBigCircleColor = Color.BLACK;
    //小圆的颜色
    private int mSmallCircleColor = Color.BLACK;
    //大框的圆角度数
    private int mFrameAngle = 30;
    //大圆的半径
    private int mBigCircleRadius = 200;
    //小圆的半径
    private int mSmallCircleRadiue = 180;

    //大框透明度
    private int mFrameAlpha = 110;
    //小圆透明度
    private int mSmallCircleAlpha = 110;

    private int curValue = 0;

      public RoundLoadingBar(Context context) {
        super(context);
    }

    public RoundLoadingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundLoadingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   private void init(Context context, AttributeSet attrs){
       mConText = context;
       mPaint = new Paint();
       Log.e("zgj", " attrs " + attrs);
       if (attrs != null) {

           TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundLoadingBar);

           mFrameAngle = ta.getDimensionPixelOffset(R.styleable.RoundLoadingBar_frame_angle, mFrameAngle);
           mFramColor = ta.getColor(R.styleable.RoundLoadingBar_frame_color, mFramColor);

           mBigCircleRadius = ta.getDimensionPixelOffset(R.styleable.RoundLoadingBar_bigcircle_radius, mBigCircleRadius);

           mSmallCircleColor = ta.getColor(R.styleable.RoundLoadingBar_smallcircle_color, mSmallCircleColor);
           mSmallCircleRadiue = ta.getDimensionPixelOffset(R.styleable.RoundLoadingBar_smallcircle_radius, mSmallCircleRadiue);

           float alpha = ta.getFloat(R.styleable.RoundLoadingBar_frame_alpha, 0.6f);
           mFrameAlpha = (int) (255 * alpha);
           alpha = ta.getFloat(R.styleable.RoundLoadingBar_smallcircle_alpha, 0.6f);
           mSmallCircleAlpha = (int) (255 * alpha);
       }
       invalidate();
 }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置背景色
        canvas.drawColor(Color.TRANSPARENT);
        if (curValue >= 100) {
            return;
        }
        //画背景半透明的框
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(curValue == 100 ? Color.TRANSPARENT : mBigCircleColor);
        mPaint.setAlpha(mFrameAlpha);
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rectF, mFrameAngle, mFrameAngle, mPaint);
        mPaint.reset();

        //画中心透明的圆
        //使用CLEAR作为PorterDuffXfermode绘制
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        mPaint.setColor(0xFF66AAFF);
        mPaint.setColor(mBigCircleColor);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mBigCircleRadius, mPaint);
        //最后将画笔去除Xfermode
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);

        //根据度数画圆弧
        mPaint.setColor(mSmallCircleColor);
        mPaint.setAlpha(mSmallCircleAlpha);
        @SuppressLint("DrawAllocation")
        RectF rect = new RectF((getWidth() / 2) - mSmallCircleRadiue,
                (getHeight() / 2) - mSmallCircleRadiue,
                (getWidth() / 2) + mSmallCircleRadiue,
                (getHeight() / 2) + mSmallCircleRadiue);
        float angle = (360f / 100f) * (float) curValue;
        Log.d(TAG, " angle " + angle);
        canvas.drawArc(rect, //弧线所使用的矩形区域大小
                -90 + angle,  //开始角度
                360 - angle, //扫过的角度
                true, //是否使用中心
                mPaint);
    }
    public void setValue(int value){
        curValue = value;
        invalidate();
    }
}
