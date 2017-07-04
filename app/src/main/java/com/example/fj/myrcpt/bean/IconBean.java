package com.example.fj.myrcpt.bean;

/**
 * Created by 860617010 on 2017/6/9.
 */

public class IconBean {

    /**
     * result : true
     * msg : 修改头像成功
     * data : uploadFiles/userPicure/21e12f6a73234fb3b2a16482d4d5a055.jpg
     */

    private boolean result;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
