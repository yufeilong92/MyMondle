package com.lawyee.mycelue.weight;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.weight
 * @Description: 处理一写手势
 * @author: YFL
 * @date: 2018/3/19 11:29
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class GestureDetectorView implements GestureDetector.OnGestureListener {
    public  String TAG = "GestureDetectorView.class";
    /**
     *触摸屏幕均会调用的方法
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        Log.e(TAG, "onDown: 触摸屏幕均会调用的方法");
        return false;
    }
    //手指在屏幕上按下,且未移动和松开时调用该方法
    @Override
    public void onShowPress(MotionEvent e) {
        Log.e(TAG, "onShowPress: 手指在屏幕上按下,且未移动和松开时调用该方法" );
    }
    //轻击屏幕时调用该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.e(TAG, "onSingleTapUp:轻击屏幕时调用该方法 " );
        return false;
        
    }
    //手指在屏幕上滚动时会调用该方法
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.e(TAG, "onScroll: 手指在屏幕上滚动时会调用该方法" );
        return false;
    }

    //手指长按屏幕时均会调用该方法
    @Override
    public void onLongPress(MotionEvent e) {
        Log.e(TAG, "onLongPress:手指长按屏幕时均会调用该方法 " );
    }
    //手指在屏幕上拖动时会调用该方法
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.e(TAG, "onFling:手指在屏幕上拖动时会调用该方法 " );
        return false;
    }

}
