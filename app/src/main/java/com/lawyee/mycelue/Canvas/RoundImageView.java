package com.lawyee.mycelue.Canvas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.Canvas
 * @Description: 绘画圆角图片
 * @author: YFL
 * @date: 2018/3/16 14:40
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@SuppressLint("AppCompatCustomView")
public class RoundImageView extends ImageView {

    private Paint paint;
    private Bitmap mBitmap;
    private Rect rect;
    private PaintFlagsDrawFilter pdf;
    private Path path;

    public RoundImageView(Context context) {
        super(context);
        init();
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBitmap == null) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        canvas.save();
        canvas.setDrawFilter(pdf);
        int width = getWidth();
        int height = getHeight();
        if (width > height) {
            path.addCircle(width / 2, height / 2,
                    height / 2, Path.Direction.CCW);
        } else {
            path.addCircle(width / 2, height / 2,
                    width / 2, Path.Direction.CCW);
        }
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.drawBitmap(mBitmap, null, rect, paint);
        canvas.restore();

    }

    /**
     * Paint.Style.STROKE 只绘制图形轮廓（描边）
     Paint.Style.FILL 只绘制图形内容
     Paint.Style.FILL_AND_STROKE 既绘制轮廓也绘制内容
     */
    private void init() {
        paint = new Paint();//画笔
        paint.setStyle(Paint.Style.FILL);//正常
        paint.setTextSize(20);
        paint.setAntiAlias(true);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);
        rect = new Rect();
        pdf = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
