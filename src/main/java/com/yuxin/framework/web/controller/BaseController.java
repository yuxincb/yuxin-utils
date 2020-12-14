package com.yuxin.framework.web.controller;

import com.yuxin.framework.web.domain.AjaxResult;

public class BaseController {

    public AjaxResult success() {
        return AjaxResult.success();
    }

    public AjaxResult success(String msg) {
        return AjaxResult.success(msg);
    }

    public AjaxResult success(String msg, Object data) {
        return AjaxResult.success(msg, data);
    }

    public AjaxResult fail() {
        return AjaxResult.fail();
    }

    public AjaxResult fail(String msg) {
        return AjaxResult.fail(msg);
    }

}
