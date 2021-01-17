package com.yuxin.project.redirect;

import com.yuxin.common.algorithm.UrlShortner;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 模拟通过短链接重定向到原链接
 */
@Log4j2
@Controller
@RequestMapping("/tiny")
public class RedirectController {

    @RequestMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer url = request.getRequestURL();
        // 获取url前半段，例：http://192.168.0.222
        String shortUrl = url.substring(0, url.indexOf("/", 8));
        log.info(shortUrl);
        int id = UrlShortner.code2id(code);
        // 根据id查找原链接逻辑
        log.info(id);
        response.sendRedirect("http://localhost/file/1");

    }

}
