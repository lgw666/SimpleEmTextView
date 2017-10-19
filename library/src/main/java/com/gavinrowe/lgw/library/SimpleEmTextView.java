package com.gavinrowe.lgw.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;

/**
 * Author: Luo Guowen
 * Email: luoguowen123@qq.com
 * Time: 2017/10/18
 * 自定义简单强调文字视图
 * 可随时改变内容，字体颜色，字体大小
 */

public class SimpleEmTextView extends android.support.v7.widget.AppCompatTextView {

    /**
     * 视图显示的内容
     */
    private String mContent;

    /**
     * 强调内容
     */
    private String mEmText;

    /**
     * 强调内容的字体颜色、尺寸，风格
     *
     * @see #setEmTextColor(int)
     * @see #setEmTextSize(int)
     */
    private int mEmTextColor, mEmTextSize, mEmTextStyle;

    /**
     * 标志
     * 判断是否能进行自定义绘制，默认为true
     */
    private boolean mCanDraw = true;

    /**
     * 改变字体前景色
     */
    private ForegroundColorSpan mForegroundColorSpan;

    /**
     * 改变字体尺寸
     */
    private AbsoluteSizeSpan mAbsoluteSizeSpan;

    /**
     * 改变字体样式
     */
    private StyleSpan mStyleSpan;

    /**
     * 文字构造器
     */
    private SpannableStringBuilder mBuilder;


    {
        mContent = getText().toString();
        mBuilder = new SpannableStringBuilder(mContent);
    }


    public SimpleEmTextView(Context context) {
        super(context);
    }

    public SimpleEmTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 获取自定义属性
        if (null != attrs) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SimpleEmTextView, 0, 0);
            int num = ta.getIndexCount();
            for (int i = 0; i < num; i++) {
                int attrResId = ta.getIndex(i);
                if (attrResId == R.styleable.SimpleEmTextView_emText) {
                    mEmText = ta.getString(R.styleable.SimpleEmTextView_emText);

                } else if (attrResId == R.styleable.SimpleEmTextView_emTextSize) {
                    mEmTextSize = ta.getInt(R.styleable.SimpleEmTextView_emTextSize, (int) getTextSize());
                    mAbsoluteSizeSpan = new AbsoluteSizeSpan(mEmTextSize, true);

                } else if (attrResId == R.styleable.SimpleEmTextView_emTextColor) {
                    mEmTextColor = ta.getColor(R.styleable.SimpleEmTextView_emTextColor, Color.RED);
                    mForegroundColorSpan = new ForegroundColorSpan(mEmTextColor);

                } else if (attrResId == R.styleable.SimpleEmTextView_emTextStyle) {
                    mEmTextStyle = ta.getInt(R.styleable.SimpleEmTextView_emTextStyle, Typeface.NORMAL);
                    mStyleSpan = new StyleSpan(mEmTextStyle);

                }
            }
            ta.recycle();
        }
    }

    public SimpleEmTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCanDraw && null != mEmText && mContent.contains(mEmText)) {
            mCanDraw = false;
            setTextSpan();
        }
    }

    /**
     * 设置强调文字内容
     *
     * @param text 强调文字内容
     */
    @SuppressWarnings("unused")
    public void setEmText(String text) {
        initTextSpan();
        mCanDraw = true;
        mEmText = text;
        invalidate();
    }

    /**
     * 设置强调文字大小
     *
     * @param size 强调文字大小
     */
    @SuppressWarnings("unused")
    public void setEmTextSize(int size) {
        mCanDraw = true;
        mEmTextSize = size;
        mAbsoluteSizeSpan = new AbsoluteSizeSpan(mEmTextSize, true);
        invalidate();
    }

    /**
     * 设置强调文字颜色
     * 可使用 ContextCompat.getColor(this, R.color.xxx)或者 Color.xxx 或者 十六进制格式颜色
     *
     * @param color 强调文字颜色
     */
    @SuppressWarnings("unused")
    public void setEmTextColor(@ColorInt int color) {
        mCanDraw = true;
        mEmTextColor = color;
        mForegroundColorSpan = new ForegroundColorSpan(mEmTextColor);
        invalidate();
    }

    /**
     * 设置强调文字样式
     *
     * @param style 文字样式
     * @see Typeface#NORMAL
     * @see Typeface#BOLD
     * @see Typeface#ITALIC
     * @see Typeface#BOLD_ITALIC
     */
    @SuppressWarnings("unused")
    public void setEmTextStyle(int style) {
        if (Typeface.NORMAL <= style && Typeface.BOLD_ITALIC >= style) {
            mCanDraw = true;
            mEmTextStyle = style;
            mStyleSpan = new StyleSpan(mEmTextStyle);
            invalidate();
        }
    }

    /**
     * 设置文字
     */
    private void setTextSpan() {
        if (null != mEmText) {
            int start = mContent.indexOf(mEmText);
            int end = start + mEmText.length();
            mBuilder.setSpan(mForegroundColorSpan, start, end, SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
            mBuilder.setSpan(mAbsoluteSizeSpan, start, end, SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
            mBuilder.setSpan(mStyleSpan, start, end, SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
            setText(mBuilder);
        }
    }

    /**
     * 初始化文字
     */
    private void initTextSpan() {
        mBuilder.clearSpans();
    }


}
