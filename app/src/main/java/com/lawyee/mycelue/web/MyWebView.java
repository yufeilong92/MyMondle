package com.lawyee.mycelue.web;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.web
 * @Description: webview 滑动显示置顶按钮
 * @author: YFL
 * @date: 2018/3/15 14:56
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyWebView extends WebView {
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollChangedCallback!=null){
            scrollChangedCallback.onScroll(l-oldl,t-oldt);

        }


    }

    public OnScrollChangedCallback scrollChangedCallback;

    public void setScrollChangedCallback(OnScrollChangedCallback scrollChangedCallback) {
        this.scrollChangedCallback = scrollChangedCallback;

    }

    public interface OnScrollChangedCallback{
        public void onScroll(int dx,int dy);
    }
}
