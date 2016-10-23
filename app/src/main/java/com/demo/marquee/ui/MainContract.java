package com.demo.marquee.ui;

/**
 * 直播结束
 */
public class MainContract {

    public interface View {

        void showToast(String stockCode);
    }

    public interface Presenter {

        void initMarquee();
    }
}
