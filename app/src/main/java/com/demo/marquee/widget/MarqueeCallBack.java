package com.demo.marquee.widget;

/** 我的 */
public interface MarqueeCallBack<T> {

	void onBindViewHolder(int position, MarqueeHolder viewHolder, T t);
}