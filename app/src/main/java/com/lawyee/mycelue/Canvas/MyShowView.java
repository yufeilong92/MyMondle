package com.lawyee.mycelue.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.Canvas
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/16 14:33
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyShowView extends View {

    private Paint paint;

    public MyShowView(Context context) {
        super(context);
        init();
    }

    public MyShowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyShowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setTextSize(21);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(300,300);
        canvas.clipRect(100,100,300,300);
        canvas.drawColor(Color.WHITE);
        canvas.drawText("sb",110,120,paint);
    }
}
