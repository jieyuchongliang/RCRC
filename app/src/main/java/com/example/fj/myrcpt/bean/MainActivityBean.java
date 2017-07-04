package com.example.fj.myrcpt.bean;

import java.util.List;

/**
 * Created by 860617010 on 2017/6/6.
 */

public class MainActivityBean {


    /**
     * result : true
     * msg : 培训机构+公告+图片
     * data : {"institutionList":[{"institutionId":"1a20b51fe5189658","areaVal":"济南市","institutionPicture":"uploadFiles/institutionShowImg/d59e41a0b58049c7828e14852748d81f.jpg","cityVal":"济南市","institutionName":"蜀汉","contact":"诸葛孔明qqqqqqqqqqqqqqqq","logo":"uploadFiles/registerImg/5d5c27bab9384f9da96376a34094a853.jpg","tel":"0531-6660211","industry":"07","industryValue":"通信/电信运营/移动增值","introduction":"丧脊之犬，狺狺狂吠。mmp","provinceVal":"山东省"},{"institutionId":"b2ce49e4a541068d","areaVal":"济南市","institutionPicture":"uploadFiles/institutionShowImg/ef38f355f032431394fc9bc5ac153c2c.jpg","cityVal":"济南市","institutionName":"培训机构qw","contact":"深度","logo":"uploadFiles/companyLogo/e6d5689b23a5457cb26fd18c6020ccf4.jpg","tel":"15569691212","industry":"01,03","industryValue":"计算机软件,IT服务（系统/数据/维护）","introduction":"金额您上YY","provinceVal":"山东省"},{"institutionId":"9581145d8034b13c","areaVal":"济南市","cityVal":"济南市","institutionName":"测试用","contact":"sdf","logo":"uploadFiles/companyLogo/65e98ebec4124a3091c0fdf0ba9bab3a.jpg","tel":"15563896363","provinceVal":"山东省"},{"institutionId":"69ae8193249f8ff7","areaVal":"济南市","cityVal":"济南市","institutionName":"北大青鸟科技教育有限公司","contact":"sadfc","logo":"uploadFiles/companyLogo/935f52880bda4654aec61bace7fcf53b.jpg","tel":"13468228244","industry":"03","industryValue":"IT服务（系统/数据/维护）","introduction":"一二三四五六七八提一下搜索咯LOL那咯可以移民","provinceVal":"山东省"},{"institutionId":"8205edfb1ac05fbb","areaVal":"济南市","cityVal":"济南市","institutionName":"浪潮优派科技教育有限公司","contact":"sdcdc","logo":"uploadFiles/companyLogo/c490582338114ed6947a1f91f287ad46.jpg","tel":"15563636595","provinceVal":"山东省"},{"institutionId":"0533fd4667146563","areaVal":"常州市","cityVal":"常州市","institutionName":"李的培训","contact":"","logo":"","tel":"0531-87441258","industry":"12","industryValue":"会计/审计","introduction":"       培训公司与培训中心\r\n培训中心是一个单一方向的培训机构，例如电脑培训中心就是培训电脑的，不可以超出经营的范围，驾驶的培训中心也是只可以学车，不可以提供其他的培训项目，而培训公司则可以根据其营业执照的许可范围例如管理人员培训，可向管理人员提供必要的培训，所以不同点是培训中心是单一经营项目，而培训公司是只对提供对象有划分并不对培训项目有限制。\r\n培训公司与培训学校\r\n培训学校更多是以学历教育为目的，所以一个培训学校的好坏看考取学历的比例、就业的比例，而培训公司是以单纯的顾客满意为目的，只要客户觉得值得、认可就可以了。\r\n培训学校与培训中心\r\n这两者之间的差别非常明显,培训学校是以学历为目的的，而培训中心则以考试通过或者达标为目的,一个注重的是文凭，一个注重的是证书。","provinceVal":"江苏省"}],"pic":[{"filePath":"uploadFiles/organizationImg/7f8c744addaf4bbd926a52397dff46e7.jpg","picId":73},{"filePath":"uploadFiles/organizationImg/d40d82e5882e4d24b3a4513284d958a1.jpg","picId":72},{"filePath":"uploadFiles/organizationImg/e7b1e706933248e7a1701317a26b44dd.jpg","picId":71}],"notice":[{"newsId":247,"title":"1测试新闻"},{"newsId":246,"title":"1测试新闻"},{"newsId":245,"title":"1"},{"newsId":243,"title":"后台测试审ff批"},{"newsId":209,"title":"新闻新规"}]}
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
        private List<InstitutionListBean> institutionList;
        private List<PicBean> pic;
        private List<NoticeBean> notice;

        public List<InstitutionListBean> getInstitutionList() {
            return institutionList;
        }

        public void setInstitutionList(List<InstitutionListBean> institutionList) {
            this.institutionList = institutionList;
        }

        public List<PicBean> getPic() {
            return pic;
        }

        public void setPic(List<PicBean> pic) {
            this.pic = pic;
        }

        public List<NoticeBean> getNotice() {
            return notice;
        }

        public void setNotice(List<NoticeBean> notice) {
            this.notice = notice;
        }

        public static class InstitutionListBean {
            /**
             * institutionId : 1a20b51fe5189658
             * areaVal : 济南市
             * institutionPicture : uploadFiles/institutionShowImg/d59e41a0b58049c7828e14852748d81f.jpg
             * cityVal : 济南市
             * institutionName : 蜀汉
             * contact : 诸葛孔明qqqqqqqqqqqqqqqq
             * logo : uploadFiles/registerImg/5d5c27bab9384f9da96376a34094a853.jpg
             * tel : 0531-6660211
             * industry : 07
             * industryValue : 通信/电信运营/移动增值
             * introduction : 丧脊之犬，狺狺狂吠。mmp
             * provinceVal : 山东省
             */

            private String institutionId;
            private String areaVal;
            private String institutionPicture;
            private String cityVal;
            private String institutionName;
            private String contact;
            private String logo;
            private String tel;
            private String industry;
            private String industryValue;
            private String introduction;
            private String provinceVal;

            public String getInstitutionId() {
                return institutionId;
            }

            public void setInstitutionId(String institutionId) {
                this.institutionId = institutionId;
            }

            public String getAreaVal() {
                return areaVal;
            }

            public void setAreaVal(String areaVal) {
                this.areaVal = areaVal;
            }

            public String getInstitutionPicture() {
                return institutionPicture;
            }

            public void setInstitutionPicture(String institutionPicture) {
                this.institutionPicture = institutionPicture;
            }

            public String getCityVal() {
                return cityVal;
            }

            public void setCityVal(String cityVal) {
                this.cityVal = cityVal;
            }

            public String getInstitutionName() {
                return institutionName;
            }

            public void setInstitutionName(String institutionName) {
                this.institutionName = institutionName;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getIndustryValue() {
                return industryValue;
            }

            public void setIndustryValue(String industryValue) {
                this.industryValue = industryValue;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getProvinceVal() {
                return provinceVal;
            }

            public void setProvinceVal(String provinceVal) {
                this.provinceVal = provinceVal;
            }
        }

        public static class PicBean {
            /**
             * filePath : uploadFiles/organizationImg/7f8c744addaf4bbd926a52397dff46e7.jpg
             * picId : 73
             */

            private String filePath;
            private int picId;

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }
        }

        public static class NoticeBean {
            /**
             * newsId : 247
             * title : 1测试新闻
             */

            private int newsId;
            private String title;

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
        }
    }
}
