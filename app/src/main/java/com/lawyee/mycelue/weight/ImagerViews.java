package com.lawyee.mycelue.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lawyee.mycelue.R;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.weight
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/19 15:41
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ImagerViews extends View {

    public ImagerViews(Context context) {
        super(context);
    }

    public ImagerViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImagerViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.e);
        int i = bitmap.getWidth() / 2;
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(shader);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,paint);

    }
}
