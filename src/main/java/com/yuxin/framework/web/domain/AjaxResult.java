package com.yuxin.framework.web.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AjaxResult {

    private boolean success;

    private String msg;

    private Object data;

    private AjaxResult() {
    }

    private AjaxResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    private AjaxResult(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxResult success() {
        return new AjaxResult(true, "success");
    }

    public static AjaxResult success(String msg) {
        return new AjaxResult(true, msg);
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(true, msg, data);
    }

    public static AjaxResult fail() {
        return new AjaxResult(false, "fail");
    }

    public static AjaxResult fail(String msg) {
        return new AjaxResult(false, msg);
    }

}
