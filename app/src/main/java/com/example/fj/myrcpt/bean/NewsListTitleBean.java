package com.example.fj.myrcpt.bean;

import java.util.List;

/**
 * Created by 860617010 on 2017/6/12.
 */

public class NewsListTitleBean {

    /**
     * result : true
     * msg : 新闻类别
     * data : [{"distinguishId":"0","value":"通知公告"},{"distinguishId":"1","value":"专题聚焦"},{"distinguishId":"2","value":"平台新闻"},{"distinguishId":"3","value":"要闻快递"},{"distinguishId":"4","value":"时时关注"},{"distinguishId":"99","type":"1","value":"企业新闻"}]
     */

    private boolean result;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * distinguishId : 0
         * value : 通知公告
         * type : 1
         */

        private String distinguishId;
        private String value;
        private String type;

        public String getDistinguishId() {
            return distinguishId;
        }

        public void setDistinguishId(String distinguishId) {
            this.distinguishId = distinguishId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
