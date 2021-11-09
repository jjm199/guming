package com.jjm.gm_springboot.utils;

import lombok.Data;

@Data
public class ResultData {

    private String code;

    private String msg;

    private Object data;

    public static ResultData success(Object data) {
        return resultData(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg(), data);
    }

    public static ResultData success() {
        return resultData(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg(), null);
    }

    public static ResultData success(Object data, String msg) {
        return resultData(ResponseCode.SUCCESS.val(), msg, data);
    }

    public static ResultData error(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ResultData error(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ResultData resultData(String code, String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
}
