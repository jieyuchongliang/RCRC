package com.example.fj.myrcpt;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.example.fj.myrcpt.api.ApiService;
import com.example.fj.myrcpt.bean.MainActivityBean;
import com.squareup.picasso.Picasso;

/**
 * Created by 860617010 on 2017/6/8.
 */
public class NetworkImageHolderView implements Holder<MainActivityBean.DataBean.PicBean> {

    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, MainActivityBean.DataBean.PicBean data) {
        Picasso.with(context).load(ApiService.IMAGE_BASE + data.getFilePath()).error(R.drawable.ic_oooo).into(imageView);
    }


}
