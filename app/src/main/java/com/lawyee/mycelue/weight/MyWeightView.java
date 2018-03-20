package com.lawyee.mycelue.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.weight
 * @Description: 提供一写插件来帮助自定义
 * @author: YFL
 * @date: 2018/3/19 11:08
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyWeightView extends View {
    public MyWeightView(Context context) {
        super(context);
        init(context);
    }



    public MyWeightView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public MyWeightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }
    private void init(Context context) {
        ViewConfiguration cfg = ViewConfiguration.get(context);
        int slop = cfg.getScaledTouchSlop();
        Log.e("yfl", "init: "+slop );
        int timeout = ViewConfiguration.getDoubleTapTimeout();
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout();
        Log.e("yfl", "双或者点击 " +timeout+
        "\n按住转换长按所需时间"+longPressTimeout
        +"\n重复按钮时间"+keyRepeatTimeout);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }
}
