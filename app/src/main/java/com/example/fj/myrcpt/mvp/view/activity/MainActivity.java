package com.example.fj.myrcpt.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.fj.myrcpt.NetworkImageHolderView;
import com.example.fj.myrcpt.R;
import com.example.fj.myrcpt.api.RetrofitManager;
import com.example.fj.myrcpt.bean.IconBean;
import com.example.fj.myrcpt.bean.MainActivityBean;
import com.example.fj.myrcpt.mvp.presenter.MainActivityPresenter;
import com.example.fj.myrcpt.mvp.contractor.MainActivityContractor;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class MainActivity extends AppCompatActivity implements MainActivityContractor.View, OnItemClickListener, View.OnClickListener {
    private ConvenientBanner convenientBanner;
    private List<MainActivityBean.DataBean.PicBean> pic;
    private MainActivityContractor.Presenter mainActivityPresenter;
    private WebView textView;
    private Button buttonPermission;
    private Button btnSendIcon;
    private Button btnNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTarget();
        initData();
    }


    private void initData() {
        mainActivityPresenter.loadData();
    }

    private void initTarget() {
        mainActivityPresenter = new MainActivityPresenter(this);
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenient_banner);
        textView  = (WebView) findViewById(R.id.text_artical);
        buttonPermission = (Button) findViewById(R.id.btn_permission);
        btnSendIcon = (Button) findViewById(R.id.send_icon);
        btnNews = (Button) findViewById(R.id.btn_news);
        btnSendIcon.setOnClickListener(this);
        buttonPermission.setOnClickListener(this);
        btnNews.setOnClickListener(this);
    }

    @Override
    public void bindDataToConvenientBanner(MainActivityBean mainActivityBean) {
        pic = mainActivityBean.getData().getPic();
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        },pic)
                //设置指示器是否可见
                .setPointViewVisible(true)
                //设置自动切换（同时设置了切换时间间隔）
                .startTurning(2000)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_oooo, R.drawable.icok})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置点击监听事件
                .setOnItemClickListener(MainActivity.this)
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);
    }

    @Override
    public void showArtical(String content) {
        textView.loadDataWithBaseURL(null, content, null, "utf-8", null);
    }

    @Override
    public void onItemClick(int position) {
        mainActivityPresenter.loadRegisterArticle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_permission:
                mainActivityPresenter.obtainPermission(this);
                break;
            case R.id.send_icon:
                sendIcon();
                break;
            case R.id.btn_news:
                startActivity(new Intent(this,NewsActivity.class));
                break;
        }
    }

    private void sendIcon() {
//        String filePath = "/storage/emulated/0/apache-tomcat-7.0.65/webapps/examples/servlets/images/code.gif";
        String filePath = "/storage/emulated/0/DCIM/Camera/IMG_20170428_155623.jpg";
//        String filePath = "/storage/emulated/0/apache-tomcat-7.0.65/webapps/examples/servlets/images/code.gif";
//        String filePath = "/data/hw_init/version/region_comm/china/media/Pre-loaded/Pictures/01-01.jpg";
        final File uploadFile = new File(filePath);
        Log.i(TAG, ".......图片大小: " + uploadFile.length());
        if (uploadFile.length() >= 1024 * 1024 * 2) {
            Log.i(TAG, ".......uploadFile.length: " + uploadFile.length());
            pictureCompression(this, uploadFile, new OnCompressListener() {
                @Override
                public void onStart() {
                    Toast.makeText(MainActivity.this,"图片开始压缩...",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(File file) {
                    Toast.makeText(MainActivity.this,"图片压缩完成...",Toast.LENGTH_SHORT).show();
                    uploadUserAvatar(file);
                    Log.i(TAG, ".......file.length: " + file.length());
                    Log.i(TAG, "压缩完成后的file地址: " + file);
                }

                @Override
                public void onError(Throwable e) {
                    Toast.makeText(MainActivity.this,"图片压缩失败...",Toast.LENGTH_SHORT).show();
                    uploadUserAvatar(uploadFile);
                }
            });
        } else {
            uploadUserAvatar(uploadFile);
        }
    }

    private void uploadUserAvatar(File uploadFile) {
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().uploadAvatar
                (getFileBody("userPicture", uploadFile),RequestBody.create(null, "f94696b1abe2dccf")), new Subscriber<IconBean>() {
            @Override
            public void onStart() {
                super.onStart();
                Log.i(TAG, "图片开始上传");
            }

            @Override
            public void onCompleted() {
                Log.i(TAG, "图片上传完成");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(IconBean iconBean) {
                Log.i(TAG,iconBean.getMsg());
                Log.i(TAG,iconBean.getData());
            }
        });
    }

    private static final String TAG = "MainActivity";


    /**
     * 图片压缩处理后进行上传
     *
     * @param file
     * @param listener
     */
    public void pictureCompression(Context context, File file, OnCompressListener listener) {
        Luban.get(context)
                .load(file)                     //传人要压缩的图片
                .putGear(Luban.THIRD_GEAR)//设定压缩档次，默认三挡
                //.setFilename(context.getCacheDir().getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg")//设置上传后的名称
                .setCompressListener(listener).launch();
    }


    /**
     * 单图片上传的Body
     * ----@POST("Api/Hx/AddHx")
     * ----@Multipart
     * Observable<> uploadGroupCreate(@Part MultipartBody.Part photo);
     *
     * @param file
     * @return
     */
    public  MultipartBody.Part getFileBody(String part, File file) {
        Log.d(TAG, "图片大小：" + file.length() + "图片路径：" + file.getPath());
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
        String fileName = file.getName();
        return MultipartBody.Part.createFormData(part, fileName, photoRequestBody);
    }
}
