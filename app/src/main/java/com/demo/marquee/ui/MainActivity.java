package com.demo.marquee.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.marquee.R;
import com.demo.marquee.presenter.MainPresenter;
import com.demo.marquee.util.ToastUtil;
import com.demo.marquee.widget.MarqueeClickListener;
import com.demo.marquee.widget.MarqueeView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
        mainPresenter.initMarquee();
    }

    @Override
    public void showToast(String stockCode) {
        ToastUtil.showShort(stockCode);
    }
}
