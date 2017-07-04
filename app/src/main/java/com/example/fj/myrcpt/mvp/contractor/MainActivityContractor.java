package com.example.fj.myrcpt.mvp.contractor;

import android.content.Context;

import com.example.fj.myrcpt.bean.MainActivityBean;

/**
 * Created by 860617010 on 2017/6/8.
 */

public interface MainActivityContractor {
    interface View{
        void bindDataToConvenientBanner(MainActivityBean mainActivityBean);

        void showArtical(String content);
    }

    interface Presenter{
        void loadData();
        void loadRegisterArticle();

        void obtainPermission(Context context);

    }
}
