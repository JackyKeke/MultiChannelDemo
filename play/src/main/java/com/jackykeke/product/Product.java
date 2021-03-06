package com.jackykeke.product;


import com.jackykeke.base.BaseProductInfo;

public class Product implements BaseProductInfo {

    private String STORE_URL = "www.googleplay.com/11111";

    private String USER_POLICY = "www.googleplay.com/user_policy";

    private String PRIVACY_POLICY = "www.googleplay.com/privacy_policy";

    private String ADVERTISE_ID = "www.googleplay.com/advertise_id";

    private String APP_SHARE_URL = "www.googleplay.com/app_share_url";

    private static Product product;


    private Product() {
    }

    public static Product getInstance() {
        if (null == product) {
            product = new Product();
        }
        return product;
    }

    @Override
    public String getStoreUrl() {
        return STORE_URL;
    }

    @Override
    public String getUserPolicy() {
        return USER_POLICY;
    }

    @Override
    public String getPrivacyPolicy() {
        return PRIVACY_POLICY;
    }

    @Override
    public String getAdvertiseId() {
        return ADVERTISE_ID;
    }

    @Override
    public String getAppShareUrl() {
        return APP_SHARE_URL;
    }
}
