package com.yuxin.project.upload.controller;

import com.yuxin.common.utils.FTPUtils;
import com.yuxin.framework.web.controller.BaseController;
import com.yuxin.framework.web.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class UploadController extends BaseController {

    @GetMapping("/1")
    public String page() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload(MultipartFile[] files) {
        boolean upload = FTPUtils.upload(files, "/soda");
        if (upload) return success();
        return fail();
    }

}
