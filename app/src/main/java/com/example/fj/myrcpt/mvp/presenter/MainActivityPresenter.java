package com.example.fj.myrcpt.mvp.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.fj.myrcpt.MyApplication;
import com.example.fj.myrcpt.api.OnDataCallBack;
import com.example.fj.myrcpt.bean.ArticalBean;
import com.example.fj.myrcpt.bean.MainActivityBean;
import com.example.fj.myrcpt.mvp.contractor.MainActivityContractor;
import com.example.fj.myrcpt.mvp.module.MainActivityModule;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;


/**
 * Created by 860617010 on 2017/6/8.
 */

public class MainActivityPresenter implements MainActivityContractor.Presenter {


    private MainActivityModule mainActivityModule;
    private MainActivityContractor.View view;

    public MainActivityPresenter(MainActivityContractor.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        mainActivityModule = new MainActivityModule();
        mainActivityModule.getData(MyApplication.getContext(), new OnDataCallBack<MainActivityBean>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(MainActivityBean data) {
                view.bindDataToConvenientBanner(data);
            }
        });
    }

    @Override
    public void loadRegisterArticle() {
        mainActivityModule.loadArticalData(new OnDataCallBack<ArticalBean>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(ArticalBean data) {
                view.showArtical(data.getData().getContent());
            }
        });
    }

    @Override
    public void obtainPermission(final Context context) {
        RxPermissions rxPermissions = new RxPermissions((Activity) context);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            Toast.makeText(context, "权限申请通过", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "权限没有通过", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }




}
