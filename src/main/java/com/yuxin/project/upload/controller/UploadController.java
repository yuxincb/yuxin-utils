package com.yuxin.project.upload.controller;

import com.yuxin.framework.web.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public AjaxResult upload(MultipartFile[] files) {
        return null;
    }

}
