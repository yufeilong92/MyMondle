package com.lawyee.myapplication.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.myapplication.listView
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/20 10:01
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CounteView extends View implements View.OnClickListener {

    private Rect rect;
    private Paint paint;
    private int cout;

    public CounteView(Context context) {
        super(context);
        init();
    }


    public CounteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CounteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        rect = new Rect();
        setOnClickListener(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0,getWidth(),getHeight(), paint);
        paint.setColor(Color.YELLOW);
        paint.setTextSize(35);
        String value = String.valueOf(cout);
        paint.getTextBounds(value,0,value.length(),rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText(value,getWidth()/2-width/2,getHeight()/2-
        height/2,paint);
    }

    @Override
    public void onClick(View v) {
       cout++;
       invalidate();
    }
}
