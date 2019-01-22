package cn.swiftpass.wftpay;

import com.yqjr.pay.bean.WXPayBean;

public class BaseBean {

    /**
     * state : 1
     * msg : 支付成功
     * body : {"packagevalue":"Sign=WXPay","orderNo":"538113601292002","appid":"wx03f981b2fbb7dbca","sign":"0830D2B93E5ADE298F9D92F43B261966","partnerid":"1502762471","prepayid":"wx28134641574838100c8703fe3144712587","noncestr":"o2aoXmTz55jAMHqy","timestamp":1538113601}
     */

    private String state;
    private String msg;
    private WXPayBean body;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public WXPayBean getBody() {
        return body;
    }

    public void setBody(WXPayBean body) {
        this.body = body;
    }

}
