package com.example.fj.myrcpt.mvp.module;

import android.content.Context;

import com.example.fj.myrcpt.bean.ArticalBean;
import com.example.fj.myrcpt.bean.MainActivityBean;
import com.example.fj.myrcpt.api.OnDataCallBack;
import com.example.fj.myrcpt.api.RetrofitManager;

import rx.Subscriber;

/**
 * Created by 860617010 on 2017/6/8.
 */

public class MainActivityModule {
    public void getData(Context context, final OnDataCallBack<MainActivityBean> callBack) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().getHomeInstitutionList(), new Subscriber<MainActivityBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainActivityBean mainActivityBean) {
                if (mainActivityBean.isResult()) {
                    callBack.onSuccess(mainActivityBean);
                } else {
                    callBack.onError(new Exception());
                }
            }
        });
    }

    private static final String TAG = "MainActivityModule";

    public void loadArticalData(final OnDataCallBack<ArticalBean> callBack) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().registerClause(), new Subscriber<ArticalBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e);
            }

            @Override
            public void onNext(ArticalBean articalBean) {
                callBack.onSuccess(articalBean);
            }
        });
    }
}
