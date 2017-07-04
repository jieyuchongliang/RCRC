package com.example.fj.myrcpt.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 860617010 on 2017/6/12.
 */

public class NewsListBean implements Serializable{

    /**
     * result : true
     * msg : 最新关注首页——平台新闻
     * data : {"getlistNews":[{"newsId":219,"title":"测试时四十撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法","category":"通知公告","news_thumbnail":"uploadFiles/registerImg/e77f4dd5910145ecbf8932aa24584e0d.jpg","updateTimeStamp":"2017-05-03","newsSources":"撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法阿斯大法阿"},{"newsId":211,"title":"关于转发邀请组织企业参加2017年中国服务外包（美国）品牌展的函","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-05-02","newsSources":"济南市服务外包公共信息服务平台"},{"newsId":208,"title":"山东省商务厅关于开展省级服务外包人才培训机构评估认定工作的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-03-27","newsSources":"济南市服务外包协会"},{"newsId":185,"title":"关于服务贸易重点企业和年度人物 推选活动的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":183,"title":"5.14会议通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":182,"title":"关于开展2016中国服务外包领军及成长型企业、在华全球服务供应商筛选工作的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":181,"title":"关于组织参加济南市2016年度中央服务外包资金申报政策宣讲会的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":180,"title":"关于组织参加商务部国际贸易经济合作研究院自贸区背景下服务外包创新发展实务操作研修","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":179,"title":"山东省商务厅关于认定山东省服务贸易特色服务出口基地的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"}],"totalPage":"1","isNext":false}
     */

    private boolean result;
    private String msg;
    private DataBean data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * getlistNews : [{"newsId":219,"title":"测试时四十撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法","category":"通知公告","news_thumbnail":"uploadFiles/registerImg/e77f4dd5910145ecbf8932aa24584e0d.jpg","updateTimeStamp":"2017-05-03","newsSources":"撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法阿斯大法阿"},{"newsId":211,"title":"关于转发邀请组织企业参加2017年中国服务外包（美国）品牌展的函","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-05-02","newsSources":"济南市服务外包公共信息服务平台"},{"newsId":208,"title":"山东省商务厅关于开展省级服务外包人才培训机构评估认定工作的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-03-27","newsSources":"济南市服务外包协会"},{"newsId":185,"title":"关于服务贸易重点企业和年度人物 推选活动的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":183,"title":"5.14会议通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":182,"title":"关于开展2016中国服务外包领军及成长型企业、在华全球服务供应商筛选工作的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":181,"title":"关于组织参加济南市2016年度中央服务外包资金申报政策宣讲会的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":180,"title":"关于组织参加商务部国际贸易经济合作研究院自贸区背景下服务外包创新发展实务操作研修","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"},{"newsId":179,"title":"山东省商务厅关于认定山东省服务贸易特色服务出口基地的通知","category":"通知公告","news_thumbnail":"","updateTimeStamp":"2017-02-21","newsSources":"无"}]
         * totalPage : 1
         * isNext : false
         */

        private String totalPage;
        private boolean isNext;
        private List<GetlistNewsBean> getlistNews;

        public String getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(String totalPage) {
            this.totalPage = totalPage;
        }

        public boolean isIsNext() {
            return isNext;
        }

        public void setIsNext(boolean isNext) {
            this.isNext = isNext;
        }

        public List<GetlistNewsBean> getGetlistNews() {
            return getlistNews;
        }

        public void setGetlistNews(List<GetlistNewsBean> getlistNews) {
            this.getlistNews = getlistNews;
        }

        public static class GetlistNewsBean {
            /**
             * newsId : 219
             * title : 测试时四十撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法
             * category : 通知公告
             * news_thumbnail : uploadFiles/registerImg/e77f4dd5910145ecbf8932aa24584e0d.jpg
             * updateTimeStamp : 2017-05-03
             * newsSources : 撒旦发阿斯大法阿斯大法撒旦发撒旦发撒旦发撒旦发阿斯大法阿斯大法阿斯大法阿斯大法阿
             */

            private int newsId;
            private String title;
            private String category;
            private String news_thumbnail;
            private String updateTimeStamp;
            private String newsSources;

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getNews_thumbnail() {
                return news_thumbnail;
            }

            public void setNews_thumbnail(String news_thumbnail) {
                this.news_thumbnail = news_thumbnail;
            }

            public String getUpdateTimeStamp() {
                return updateTimeStamp;
            }

            public void setUpdateTimeStamp(String updateTimeStamp) {
                this.updateTimeStamp = updateTimeStamp;
            }

            public String getNewsSources() {
                return newsSources;
            }

            public void setNewsSources(String newsSources) {
                this.newsSources = newsSources;
            }
        }
    }
}
