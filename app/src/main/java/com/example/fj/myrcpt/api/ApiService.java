package com.example.fj.myrcpt.api;

import com.example.fj.myrcpt.bean.ArticalBean;
import com.example.fj.myrcpt.bean.IconBean;
import com.example.fj.myrcpt.bean.MainActivityBean;
import com.example.fj.myrcpt.bean.NewsListBean;
import com.example.fj.myrcpt.bean.NewsListTitleBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 860617010 on 2017/6/6.
 */

public interface ApiService {
    String HTTP_HOST = "http://123.232.109.129/";//实际IP
//    String HTTP_HOST = "http://172.29.140.141:8080/";//栾
//    String HTTP_HOST = "http://103.239.152.67:6090/";
//    String HTTP_HOST = "http://172.29.140.127:8080/";//薛红霞
    String BASE_URL = HTTP_HOST + "RCPT/";
    String IMAGE_BASE = HTTP_HOST + "images/";

    @GET("indexapp/indexnews.app")
    Observable<MainActivityBean> getHomeInstitutionList();

    @GET("personRegapp/goRegistration.app")
    Observable<ArticalBean> registerClause();

    /**
     * 修改个人头像
     *
     * @param photo
     * @param userId
     * @return
     */
    @POST("personalInfoapp/updateUserPicture.app")
    @Multipart
    Observable<IconBean> uploadAvatar(@Part MultipartBody.Part photo, @Part("userId") RequestBody userId);

    /**
     * 新闻列表
     *
     * @param category
     * @return
     */
    @GET("newsapp/newslist.app")
    Observable<NewsListBean> newsList(@Query("category") String category, @Query("pageNum") int page);

    /**
     * 新闻类型
     *
     * @return
     */
    @GET("newsapp/newstype.app")
    Observable<NewsListTitleBean> newsType();
}
