package com.demo.marquee.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;

import com.demo.marquee.APP;
import com.demo.marquee.R;
import com.demo.marquee.canstant.Constant;
import com.demo.marquee.model.MaqueeModel;
import com.demo.marquee.util.DeviceUtil;

import java.io.File;
import java.util.List;

/**
 * RecyclerView实现跑马灯效果
 */
public class MarqueeView extends RecyclerView implements Handler.Callback {

    private final String TAG = MarqueeView.class.getSimpleName();

    private MarqueeClickListener marqueeClickListener;
    private final Handler marqueeHandler = new Handler(this);
    private final SpannableStringBuilder marqueeSpannable = new SpannableStringBuilder();

    public MarqueeView(Context context) {
        this(context, null, 0);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(lm);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case Constant.HANDLER_WHAT_LIVE_MARQUEE_SCROLL:

                // 自动滚动(100ms)
                scrollBy(5, 5);
                marqueeHandler.sendEmptyMessageDelayed(Constant.HANDLER_WHAT_LIVE_MARQUEE_SCROLL, 100);
                break;
        }
        return false;
    }

    public void setMarqueeAdapter(List<MaqueeModel> marqueeData) {

        marqueeHandler.sendEmptyMessageDelayed(Constant.HANDLER_WHAT_LIVE_MARQUEE_SCROLL, 100);

        setAdapter(new MarqueeAdapter(marqueeData, R.layout.layout_custom_marquee_txt, new MarqueeCallBack<MaqueeModel>() {

            @Override
            public void onBindViewHolder(int position, MarqueeHolder holder, final MaqueeModel stock) {
                String string = stock.getName() + File.separator + stock.getCode() + Constant.N + stock.getPrice() + "  " + stock.getPercent();

                marqueeSpannable.clear();
                marqueeSpannable.clearSpans();
                marqueeSpannable.append(string);

                int xiegang = marqueeSpannable.toString().indexOf(File.separator);
                int huanhang = marqueeSpannable.toString().indexOf(Constant.N);

                // 股票名称
                marqueeSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, xiegang, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                marqueeSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, xiegang, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                marqueeSpannable.setSpan(new AbsoluteSizeSpan(DeviceUtil.dp2px(APP.getInstance().getApplicationContext(), 14)), 0, xiegang, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // 分隔符(颜色透明)
                marqueeSpannable.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), xiegang, xiegang + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // 股票指数
                marqueeSpannable.setSpan(new ForegroundColorSpan(Color.RED), xiegang + 1, huanhang, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                marqueeSpannable.setSpan(new AbsoluteSizeSpan(DeviceUtil.dp2px(APP.getInstance().getApplicationContext(), 16)), xiegang + 1, huanhang, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                // 股票涨跌
                marqueeSpannable.setSpan(new ForegroundColorSpan(Color.GREEN), huanhang, marqueeSpannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                marqueeSpannable.setSpan(new AbsoluteSizeSpan(DeviceUtil.dp2px(APP.getInstance().getApplicationContext(), 12)), huanhang, marqueeSpannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.setText(R.id.text, marqueeSpannable);

                holder.getMarquee(R.id.text).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // 设置点击监听
                        marqueeClickListener.marqueeClickListener(stock.getCode());
                    }
                });
            }
        }));
    }

    /**
     * 设置初始化状态监听
     */
    public void setOnMarqueeClickListener(MarqueeClickListener marqueeClickListener) {
        this.marqueeClickListener = marqueeClickListener;
    }
}