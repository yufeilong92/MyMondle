package com.lawyee.mycelue.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.Canvas
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/16 13:49
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyViewCanvas extends View {

    private Paint paint;

    public MyViewCanvas(Context context) {
        super(context);
        init();

    }

    public MyViewCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyViewCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取高-测量规则的模式和大
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        //        获取宽-测量规则模式和大小
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int mWith = 400;
        int mHeight = 400;
        int getwidth = getLayoutParams().width;
        int getheight = getLayoutParams().height;
        if (getwidth == ViewGroup.LayoutParams.WRAP_CONTENT &&
                getheight == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWith, mHeight);
        } else if (getwidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWith, heightsize);
        }else if (getheight==ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(widthsize,mHeight);
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
//        translat(canvas);

        Rect rect = new Rect(50, 50, 80, 80);
        canvas.translate(150, 150);
        canvas.drawCircle(40, 40, 8, paint);
        for (int i = 0; i < 36; i++) {
            canvas.rotate(45, 40, 40);
            canvas.drawRect(rect, paint);
        }
    }

    private void translat(Canvas canvas) {
        for (int i = 0; i < 10; i++) {
            canvas.drawCircle(10, 10, 10, paint);
            canvas.translate(30, 30);
        }
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
    }
}
