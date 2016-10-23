package com.demo.marquee.presenter;

import com.demo.marquee.R;
import com.demo.marquee.model.MaqueeModel;
import com.demo.marquee.ui.MainActivity;
import com.demo.marquee.ui.MainContract;
import com.demo.marquee.widget.MarqueeClickListener;
import com.demo.marquee.widget.MarqueeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalu on 2016/10/21.
 */

public class MainPresenter implements MainContract.Presenter, MarqueeClickListener {

    private MainActivity mainActivity;

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void initMarquee() {
        if (null == mainActivity) return;

        ArrayList<MaqueeModel> marqueeData = new ArrayList();

        marqueeData.add(new Gson().fromJson(mainActivity.getString(R.string.maquee_json1), MaqueeModel.class));
        marqueeData.add(new Gson().fromJson(mainActivity.getString(R.string.maquee_json2), MaqueeModel.class));
        marqueeData.add(new Gson().fromJson(mainActivity.getString(R.string.maquee_json3), MaqueeModel.class));

        ((MarqueeView) mainActivity.findViewById(R.id.mav_live_stock)).setMarqueeAdapter(marqueeData);
        ((MarqueeView) mainActivity.findViewById(R.id.mav_live_stock)).setOnMarqueeClickListener(this);
    }

    @Override
    public void marqueeClickListener(String stockCode) {
        mainActivity.showToast(stockCode);
    }
}
