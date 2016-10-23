package com.demo.marquee.widget;


import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

public class MarqueeHolder extends RecyclerView.ViewHolder {

    public MarqueeHolder(View itemView) {
        super(itemView);
    }

    public TextView getMarquee(int viewId) {
        return (TextView) itemView.findViewById(viewId);
    }

    public MarqueeHolder setText(int viewId, SpannableStringBuilder text) {
        TextView view = getMarquee(viewId);
        view.setText(text);
        return this;
    }
}