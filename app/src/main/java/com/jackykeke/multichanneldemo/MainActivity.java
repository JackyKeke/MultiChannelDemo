package com.jackykeke.multichanneldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jackykeke.base.BaseModuleApp;


public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BuildConfig


//        Log.e(TAG, )
        ((TextView) findViewById(R.id.tv_store_url)).setText(String.format("渠道下载位置  %s", BaseModuleApp.productInfo.getStoreUrl()));
        ((TextView) findViewById(R.id.tv_user_policy)).setText(String.format("用户协议  %s", BaseModuleApp.productInfo.getUserPolicy()));
        ((TextView) findViewById(R.id.tv_privacy_policy)).setText(String.format("隐私政策  %s", BaseModuleApp.productInfo.getPrivacyPolicy()));
        ((TextView) findViewById(R.id.tv_advertise_id)).setText(String.format("广告id  %s", BaseModuleApp.productInfo.getAdvertiseId()));
        ((TextView) findViewById(R.id.tv_app_share_url)).setText(String.format("分享网站  %s", BaseModuleApp.productInfo.getAppShareUrl()));


        ((TextView) findViewById(R.id.tv_other)).setText(String.format("域名：   %s\n渠道号：    %s", BuildConfig.app_server, getResources().getString(R.string.app_channel)));


    }

    public void different_layout(View view) {



    }


    public void debugging_page(View view) {


    }


}