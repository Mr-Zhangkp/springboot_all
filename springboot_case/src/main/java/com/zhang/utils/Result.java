package com.zhang.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
public class Result implements Serializable {

    /**
     * 响应状态
     */
    private Boolean status;
    /**
     * 异常信息
     */
    private String msg;
    /**
     * 正常结果
     */
    private Object data;

    /**
     * 正常的返回
     * @param data
     * @return result
     */
    public static Result ok(Object data){
        Result result = new Result();
        result.setStatus(true);
        result.setData(data);

        return result;
    }

    /**
     * 异常的返回
     * @param msg
     * @return result
     */
    public static Result error(String msg){
        Result result = new Result();
        result.setStatus(false);
        result.setMsg(msg);

        return result;
    }





    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
