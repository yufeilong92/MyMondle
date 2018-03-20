package com.lawyee.mycelue.pain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
 * @date: 2018/3/16 9:47
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyView extends View {
    private float start=0;
    private float end=0;

    private Paint mPaint;
    private Paint mPaint1;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(Color.RED);//画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔样式
        mPaint.setTextSize(20);//字体大小
        mPaint.setStrokeWidth(3);//画笔宽度
        mPaint1 = new Paint();
        mPaint1.setAntiAlias(true);//抗锯齿
        mPaint1.setColor(Color.DKGRAY);//画笔颜色
        mPaint1.setStyle(Paint.Style.FILL);//画笔样式
        mPaint1.setTextSize(20);//字体大小
        mPaint1.setStrokeWidth(3);//画笔宽度


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        //画圆
//        canvas.drawCircle(200,200,50,mPaint);
        //画矩形
//        canvas.drawRect(20,20,220,220,mPaint);
       //画画弧形
        if (end>360){
            Log.e("yfl", "已经最大了" );
            end=360;
        }
// 绘制圆
                canvas.drawArc(new RectF(20f,20f,220f,220f),start,end,true,mPaint);
//        canvas.drawArc(new RectF(20f,20f,220f,220f),20,40,true,mPaint1);
     //绘制多边形
//        path(canvas);
//       drawText(canvas);

//       drawA(canvas);
    }

    private void drawA(Canvas canvas) {
        canvas.translate(canvas.getWidth()/2, 200); //将位置移动画纸的坐标点:150,150
        canvas.drawCircle(0, 0, 100, mPaint); //画圆圈

        //使用path绘制路径文字
        canvas.save();
        canvas.translate(-75, -75);
        Path path = new Path();
        path.addArc(new RectF(0,0,150,150), -180, 180);
        Paint citePaint = new Paint(mPaint);
        citePaint.setTextSize(14);
        citePaint.setStrokeWidth(1);
        canvas.drawTextOnPath("绘制表盘~", path, 28, 0, citePaint);
        canvas.restore();

        Paint tmpPaint = new Paint(mPaint); //小刻度画笔对象
        tmpPaint.setStrokeWidth(1);

        float  y=100;
        int count = 60; //总刻度数

        for(int i=0 ; i <count ; i++){
            if(i%5 == 0){
                canvas.drawLine(0f, y, 0, y+12f, mPaint);
                canvas.drawText(String.valueOf(i/5+1), -4f, y+25f, tmpPaint);

            }else{
                canvas.drawLine(0f, y, 0f, y +5f, tmpPaint);
            }
            canvas.rotate(360/count,0f,0f); //旋转画纸
        }

        //绘制指针
        tmpPaint.setColor(Color.GRAY);
        tmpPaint.setStrokeWidth(4);
        canvas.drawCircle(0, 0, 7, tmpPaint);
        tmpPaint.setStyle(Paint.Style.FILL);
        tmpPaint.setColor(Color.YELLOW);
        canvas.drawCircle(0, 0, 5, tmpPaint);
        canvas.drawLine(0, 10, 0, -65, mPaint);
    }

    private void drawText(Canvas canvas) {
        canvas.drawText("sbnasdads",10,200,mPaint);

    }

    private void path(Canvas canvas) {
        Path path = new Path();
        path.moveTo(10,50);
        path.lineTo(50,50);
        path.lineTo(70,8);
        path.lineTo(90,50);
        path.lineTo(130,50);
        path.lineTo(90,80);
        path.lineTo(130,120);
        path.lineTo(70,90);
        path.lineTo(50,120);
        path.lineTo(50,80);
        path.lineTo(10,50);
        path.close();
        canvas.drawPath(path,mPaint);


    }

    public void setArc(float start,float end){
        this.start=start;
        this.end=end;
//        postInvalidate();
     invalidate();
    }

}
