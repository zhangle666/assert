package com.virtue.model;

import lombok.Data;

/**
 * 用户后端返回给前段的标准类
 */
@Data
public class ReturnParam {
    private Boolean success;    //请求是否成功
    private int  status;          //结果的总条数
    private Object data;         //其他的对象，可以使用Map<String, Object>的格式添加
    private String msg;

    public ReturnParam(Boolean success, int status, Object data, String msg) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public ReturnParam(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ReturnParam(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ReturnParam(Object data) {
        this.data = data;
    }

    public ReturnParam(Boolean success, int status,String msg) {
        this.success = success;
        this.status = status;
        this.msg = msg;
    }

    public ReturnParam(Boolean success) {
        this.success = success;
    }


}
