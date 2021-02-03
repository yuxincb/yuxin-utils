package com.yuxin.project.download;

import com.yuxin.framework.web.controller.BaseController;
import com.yuxin.framework.web.domain.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 文件下载demo
 */
@Controller
@RequestMapping("/download")
public class DownloadController extends BaseController {

    /**
     * 以流的方式下载
     */
    @RequestMapping("/stream")
    @ResponseBody
    public AjaxResult stream(HttpServletResponse response) {
        try {
            String path = "D:\\Pictures\\1.png";
            File file = new File(path);
            String fileName = file.getName();
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] bys = new byte[fis.available()];
            fis.read(bys);
            fis.close();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(bys);
            toClient.flush();
            toClient.close();
            return success("download success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fail("download fail");
    }

    /**
     * 下载本地文件
     */
    @GetMapping("/local")
    public void local(HttpServletResponse response) throws IOException {
        String path = "D:\\Pictures\\1.png";
        File file = new File(path);
        String fileName = file.getName();
        FileInputStream fis = new FileInputStream(path);
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) > 0)
            response.getOutputStream().write(bys, 0, len);
        fis.close();
    }

    /**
     * 下载网络文件
     */
    @RequestMapping("/net")
    @ResponseBody
    public AjaxResult net() {
        try {
            URL url = new URL("http://hb.tztec.com:9999/app/manageres/multi/qrcode/20210119/4030449c6128130b72247b094ddeb72bf241421.png");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\yuxin\\Downloads\\qrcode.png");
            byte[] buffer = new byte[1024];
            int bysSum = 0;
            int bysRead = 0;
            while ((bysRead = is.read(buffer)) != -1) {
                bysSum += bysRead;
                System.out.println(bysSum);
                fos.write(buffer, 0, bysRead);
            }
            return success("download success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fail("download fail");
    }

}




























