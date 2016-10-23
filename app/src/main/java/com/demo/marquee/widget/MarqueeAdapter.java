package com.demo.marquee.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.marquee.model.MaqueeModel;

import java.util.List;

/**
 * 跑马灯适配器
 */
public class MarqueeAdapter extends RecyclerView.Adapter<MarqueeHolder> {

    private int layoutId;
    private List<MaqueeModel> list;
    private MarqueeCallBack recyclerCallBack;

    public MarqueeAdapter(final List<MaqueeModel> list, final int layoutId,
                          final MarqueeCallBack recyclerCallBack) {
        this.list = list;
        this.layoutId = layoutId;
        this.recyclerCallBack = recyclerCallBack;
    }

    @Override
    public MarqueeHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new MarqueeHolder(LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MarqueeHolder viewHolder, int position) {
        recyclerCallBack.onBindViewHolder(position, viewHolder, list.get(position % list.size()));
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return Integer.MAX_VALUE;
    }
}