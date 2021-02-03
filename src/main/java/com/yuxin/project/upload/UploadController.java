package com.yuxin.project.upload;

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
@RequestMapping("/upload")
public class UploadController extends BaseController {

    @GetMapping("")
    public String index() {
        return "upload";
    }

    @PostMapping("/doUpload")
    @ResponseBody
    public AjaxResult upload(MultipartFile[] files) {
        boolean upload = FTPUtils.upload(files, "/soda");
        if (upload) return success();
        return fail();
    }

}
