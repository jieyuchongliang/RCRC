package com.example.fj.myrcpt.mvp.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.fj.myrcpt.R;
import com.example.fj.myrcpt.api.RetrofitManager;
import com.example.fj.myrcpt.bean.NewsListTitleBean;
import com.example.fj.myrcpt.mvp.view.fragment.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class NewsActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //添加到viewpager中的fragment集合
    private List<NewsListFragment> fragmentList;
    //添加到viewpager中的每一个fragment的数据bean的集合
    private List<NewsListTitleBean.DataBean> tabTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        initData();
    }

    private static final String TAG = "NewsActivity";

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        tabTitle = new ArrayList<>();
        RetrofitManager.toSubscribe(RetrofitManager.getApiService().newsType(), new Subscriber<NewsListTitleBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsListTitleBean newsListTitleBean) {
                tabTitle = newsListTitleBean.getData();
                for (int i = 0; i < newsListTitleBean.getData().size(); i++) {
                    fragmentList.add(new NewsListFragment(NewsActivity.this,newsListTitleBean.getData().get(i).getDistinguishId()));
                    initViewPager();
                }
            }
        });
    }

    private void initViewPager() {
        viewPager.setAdapter(new MyViewPagerAdatper(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyViewPagerAdatper extends FragmentPagerAdapter{

        public MyViewPagerAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle.get(position).getValue();
        }
    }
}
