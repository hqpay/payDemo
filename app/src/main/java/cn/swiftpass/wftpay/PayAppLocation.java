package cn.swiftpass.wftpay;

import android.app.Application;

import com.yqjr.pay.PayInit;

public class PayAppLocation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            PayInit.payInit(this,"wx2a5538052969956e");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
