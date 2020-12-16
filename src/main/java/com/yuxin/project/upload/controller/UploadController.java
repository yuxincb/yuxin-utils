package com.yuxin.project.upload.controller;

import com.yuxin.framework.web.controller.BaseController;
import com.yuxin.framework.web.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

    @GetMapping("/1")
    public String page() {
        return "upload";
    }

    @GetMapping("/upload")
    @ResponseBody
    public AjaxResult upload(MultipartFile[] files) {
        return null;
    }

}
