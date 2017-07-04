package com.example.fj.myrcpt.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fj.myrcpt.LazyLoadFragment;
import com.example.fj.myrcpt.NetworkUtils;
import com.example.fj.myrcpt.R;
import com.example.fj.myrcpt.api.ApiService;
import com.example.fj.myrcpt.api.RetrofitManager;
import com.example.fj.myrcpt.bean.NewsListBean;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import rx.Subscriber;

/**
 * Created by 860617010 on 2017/6/12.
 */

@SuppressLint("ValidFragment")
public class NewsListFragment extends LazyLoadFragment implements SpringView.OnFreshListener {


    private String category;
    private RecyclerView recyclerView;
    private SpringView springView;
    private Context context;
    private List<NewsListBean.DataBean.GetlistNewsBean> getlistNews;
    private TextView springTimeTextView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;

    @SuppressLint("ValidFragment")
    public NewsListFragment(Context context, String category) {
        this.category = category;
        this.context = context;
    }

    @Override
    protected void initView(View view) {
        springView = (SpringView) view.findViewById(R.id.spring_view);
        springView.setHeader(new DefaultHeader(context));
        springView.setFooter(new DefaultFooter(context));
        springTimeTextView = (TextView) springView.getHeaderView().findViewById(R.id.default_header_time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        springTimeTextView.setText(str);
        springView.setListener(this);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        myRecyclerViewAdapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    @Override
    protected int setContentView() {
        return R.layout.news_list_fragment;
    }

    private static final String TAG = "NewsListFragment";
    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    private boolean isRefresh = false;

    @Override
    protected void lazyLoad() {
        Log.i(TAG, "初始化lazyLoad");
        if (getlistNews != null && !isRefresh) {
            return;
        }
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().newsList(category, 1), new Subscriber<NewsListBean>() {

            @Override
            public void onCompleted() {
                isRefresh = false;
            }

            @Override
            public void onError(Throwable e) {
                NetworkUtils.getErrorMsg(e);
            }

            @Override
            public void onNext(NewsListBean newsListBean) {
                if (newsListBean.isResult()) {
                    newsListBeans = newsListBean;
                    springView.onFinishFreshAndLoad();
                    getlistNews = newsListBean.getData().getGetlistNews();
                    myRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "数据异常", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private NewsListBean newsListBeans;
    @Override
    public void onRefresh() {
        getlistNews.clear();
        isRefresh = true;
        lazyLoad();
    }

    @Override
    public void onLoadmore() {
        if (newsListBeans.getData().isIsNext()){
            lazyLoad();
        }else {
            Toast.makeText(context,"已是全部内容",Toast.LENGTH_SHORT).show();
            springView.onFinishFreshAndLoad();
        }
    }


    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.new_list_fragment_item, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (getlistNews != null) {
                holder.textViewTime.setText(getlistNews.get(position).getUpdateTimeStamp());
                holder.textViewDetail.setText(getlistNews.get(position).getTitle());
                if (!TextUtils.isEmpty(getlistNews.get(position).getNews_thumbnail())) {
                    Picasso.with(context).load(ApiService.IMAGE_BASE + getlistNews.get(position).getNews_thumbnail()).error(R.drawable.icok).into(holder.imageView);
                    Log.i(TAG, "onBindViewHolder...: " + ApiService.IMAGE_BASE + getlistNews.get(position).getNews_thumbnail());
                } else {
                    Picasso.with(context).load(R.drawable.ic_oooo).into(holder.imageView);
                }
            }
        }

        @Override
        public int getItemCount() {
            if (getlistNews != null) {
                return getlistNews.size();
            }
            return 0;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView textViewDetail;
            private TextView textViewTime;
            private ImageView imageView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textViewDetail = (TextView) itemView.findViewById(R.id.text_describe);
                textViewTime = (TextView) itemView.findViewById(R.id.text_time);
                imageView = (ImageView) itemView.findViewById(R.id.image_icon);
            }
        }
    }
}
