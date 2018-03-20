package com.lawyee.myapplication.weight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lawyee.myapplication.R;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.myapplication.weight
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/20 10:24
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TextViewBar extends FrameLayout {
    private static int BTNBACK = GONE;
    private static int IMGBACK = GONE;
    private static int BTNSETTING = GONE;
    private static int IMGBTNSET = GONE;

    enum Status {
        BTN, BTN_BTN, BTN_BTN_IMG_LEGT, BTN_BTN_IMG_RIGHT, BTN_BTN_IMG_IMG;

        public void setShow(Status status) {
            switch (status) {
                case BTN:
                    BTNBACK =VISIBLE;
                    IMGBACK =GONE;
                    BTNSETTING =GONE;
                    IMGBTNSET =GONE;
                    break;
                case BTN_BTN:
                    BTNBACK =VISIBLE;
                    IMGBACK =GONE;
                    BTNSETTING =VISIBLE;
                    IMGBTNSET =GONE;
                    break;
                case BTN_BTN_IMG_IMG:
                    BTNBACK =VISIBLE;
                    IMGBACK =VISIBLE;
                    BTNSETTING =VISIBLE;
                    IMGBTNSET =VISIBLE;
                    break;
                case BTN_BTN_IMG_LEGT:
                    BTNBACK =VISIBLE;
                    IMGBACK =VISIBLE;
                    BTNSETTING =VISIBLE;
                    IMGBTNSET =GONE;
                    break;
                case BTN_BTN_IMG_RIGHT:
                    BTNBACK =VISIBLE;
                    IMGBACK =GONE;
                    BTNSETTING =VISIBLE;
                    IMGBTNSET =VISIBLE;
                    break;
                default:

                    break;
            }

        }
    }

    private TextView mTvTitle;
    private Button mBtnBack;
    private Button mBtnBack1;
    private CharSequence chs;
    private ViewHolder holder;

    public TextViewBar(@NonNull Context context) {
        super(context);
        init(context);
    }

    public TextViewBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.titlebar, this);
        holder = new ViewHolder(view);

    }


    public void setText(CharSequence chs) {
        holder.mTvTitle.setText(chs);
    }

    /**
     * 设置监听
     *
     * @param l
     */
    public void setBackOnClick(OnClickListener l) {
        holder.mBack.setOnClickListener(l);
    }

    /**
     * 设置文字
     *
     * @param chs
     */
    public void setBackText(CharSequence chs) {
        holder.mBack.setText(chs);
    }

    /**
     * 设置文字
     *
     * @param chs
     */
    public void setSettingText(CharSequence chs) {
        holder.mSetting.setText(chs);
    }

    /**
     * 设置监听
     *
     * @param l
     */
    public void setSetTingClick(OnClickListener l) {
        holder.mSetting.setOnClickListener(l);
    }


    /**
     * 设置icon
     *
     * @param l
     */
    public void setSetTingIcon(int l) {
        holder.mImgSetting.setImageResource(l);

    }

    /**
     * 设置icon
     *
     * @param l
     */
    public void setBackIcon(int l) {
        holder.mImgBack.setImageResource(l);

    }

    public static class ViewHolder {
        public View rootView;
        public Button mBack;
        public ImageButton mImgBack;
        public TextView mTvTitle;
        public Button mSetting;
        public ImageButton mImgSetting;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mBack = (Button) rootView.findViewById(R.id.back);
            this.mImgBack = (ImageButton) rootView.findViewById(R.id.img_back);
            this.mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
            this.mSetting = (Button) rootView.findViewById(R.id.setting);
            this.mImgSetting = (ImageButton) rootView.findViewById(R.id.img_setting);
        }

    }
}
