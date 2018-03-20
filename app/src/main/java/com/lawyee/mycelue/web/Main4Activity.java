package com.lawyee.mycelue.web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.lawyee.mycelue.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: Main4Activity.java
 * @Package com.lawyee.mycelue.web
 * @Description:
 * @author: YFL
 * @date: 2018/3/15 11:32
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/3/15 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Main4Activity extends AppCompatActivity {


    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_refresh)
    Button btnRefresh;
    @BindView(R.id.web_content)
    MyWebView webContent;
    @BindView(R.id.btn_top)
    Button btnTop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        WebSettings settings = webContent.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true);
        btnTop.setVisibility(View.GONE);
        settings.setLoadWithOverviewMode(true);
        webContent.loadUrl("http://www.baidu.com");
        webContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        //设置标题
        webContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tvTitle.setText(title);
            }
        });
        //处理滑动时是否显示置顶按钮
        webContent.setScrollChangedCallback(new MyWebView.OnScrollChangedCallback() {
            @Override
            public void onScroll(int dx, int dy) {
                if (dy > 0) {
                    btnTop.setVisibility(View.VISIBLE);
                } else {
                    btnTop.setVisibility(View.GONE);
                }
            }
        });

    }
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KEYCODE_BACK) && webContent.canGoBack()) {
//            webContent.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onBackPressed() {
        if (webContent.canGoBack()) {
            webContent.goBack();
        } else {
            super.onBackPressed();
        }

    }

    @OnClick({R.id.btn_back, R.id.btn_refresh, R.id.btn_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                if (webContent.canGoBack()) {
                    webContent.goBack();
                } else {
                    super.onBackPressed();
                }
                break;
            case R.id.btn_refresh:
                webContent.reload();
                break;
            case R.id.btn_top://置顶按钮
                webContent.scrollTo(0,0);
                btnTop.setVisibility(View.GONE);
                break;
        }
    }


}
