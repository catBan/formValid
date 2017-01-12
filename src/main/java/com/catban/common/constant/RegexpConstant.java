package com.catban.common.constant;

/**
 * Created by meitu on 17/1/10.
 */
public interface RegexpConstant {

    /**
     * 手机号码
     */
    String CELL_PHONE = "^1(3[0-9]|4[579]|5[0-35-9]|7[0-9]|8[0-9])\\d{8}$";

    String PWD_STRENGTH = "(((?=.*[A-Z])(?=.*\\\\d))|((?=.*[a-z])(?=.*\\\\d)))(?=.*\\\\W).{6,20}";
}
