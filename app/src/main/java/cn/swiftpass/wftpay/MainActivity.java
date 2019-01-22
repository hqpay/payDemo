package cn.swiftpass.wftpay;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;


import com.yqjr.pay.PayInit;
import com.yqjr.pay.bean.PayDataBean;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private int payState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cn.swiftpass.wftpay.R.layout.activity_main);
        ButterKnife.bind(this);
    }



    public void pay(View view) {
        PayDataBean payDataBean = new PayDataBean();
        payDataBean.setAppId("wx2a5538052969956e");
        payDataBean.setBusiNo("123451167890");
        payDataBean.setMerCode("201809070005");
        payDataBean.setPayType(1);
        payDataBean.setProductCode("HQ201809240001");
        payDataBean.setProductDesc("SDK商品");
        payDataBean.setOrderNo(System.currentTimeMillis() + System.currentTimeMillis() + "100945");
        payDataBean.setOrderDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        payDataBean.setOrderTime(new SimpleDateFormat("hhmmssSSS").format(new Date()));
        payDataBean.setPayAmount("0.01");
        payDataBean.setPriKey("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJaY61pUoG2FgVu9+nve+xrjm7L8aA9WZ7nF+9/9YEXEvdimmUw92Q1jIhZGT1VGIUOvEzzHlTiiyaRUHNpTRPhweo08RzQ4RDc5HoW7rq2gwHwvkfNTOAA0hjQdnUVo47WNVlFzoKTwaO/NlA266x6xpeC8zEc8bOb2no2LUXhHAgMBAAECgYAKEvCrej3BFc0xdePrpV7mzZL8xiWv4PfPVY8jzK9D+4U3mO1oTDrYymjdVJa5/Zb8EBoZVsCEqV8TvwyvDiLu4UraBP0HXiQVvfkfVqlqZlXCILkBoj287nit0gDHhDAeHi6A/jaehDnCbomGR3WrG9u/73qHFpDtY2yhlvIxAQJBAM3aUfIHBwDG/vQdvzvbvJwl5STn0lSuEIc3Hl8zGJvHAZ7qIw9SeC8Fz0lBvEbIRBs82g2B81P/FJ9vC91iRZUCQQC7SK44Flh6FydU89oh4dQRrMguc80vKNEQ871Lk6m1TwVQuNexaIa/+DoxZ4am00muTT4WYyurOyNfAl33hhdrAkBRc+2w4u72c8c2OP8OZGhBMQ12iPRE5YtMtZai/Mjj+t69TtAIpA1CLf5TcltZdqzcSjvN1Hm/5tL2My5yrwvxAkAKHEhbeslX/fv/mBKElb5vHdbIuzOughOXSLFFbTlSMmvlCbWLPEtZ/bqWhDI+u1VU9ZKOftgSrGSicmxEOpb1AkBLgzoObp9g2Wx4e9yoKweFACbkQZ7pc/O/5WPIj2RqNUcOtga92tw358fYD6YfU2amQTjCaVB4ep433BaNZi5S");
        payDataBean.setIsHybrid(1);
        payDataBean.setPubKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWmOtaVKBthYFbvfp73vsa45uy/GgPVme5xfvf/WBFxL3YpplMPdkNYyIWRk9VRiFDrxM8x5U4osmkVBzaU0T4cHqNPEc0OEQ3OR6Fu66toMB8L5HzUzgANIY0HZ1FaOO1jVZRc6Ck8GjvzZQNuusesaXgvMxHPGzm9p6Ni1F4RwIDAQAB");
        PayInit.setPayData(this,payDataBean);

    }
}
