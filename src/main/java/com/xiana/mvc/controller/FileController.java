package com.xiana.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * <p>包名称: com.xiana.mvc.controller </p>
 * <p>项目名称: java </p>
 * <p>文件名称: null.java </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2022/1/5 上午11:38 </p>
 * <p>公司信息: 全球贸易通公司</p>
 *
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">唐科技</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Controller
public class FileController {
    /**
     * 文件下载
     *
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileDown")
    public ResponseEntity fileDown(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/image/www.pixiv.net-artworks-23887444.jpg");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=" + "www.pixiv.net-artworks-23887444.jpg");
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(bytes, httpHeaders, httpStatus);
    }

    @RequestMapping("/fileUp")
    public String fileUp(MultipartFile photo, HttpSession session) throws IOException {
        String filename = photo.getOriginalFilename();
        //获取文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //获取随机UUID
        String uuid = UUID.randomUUID().toString();
        //拼接最后文件上传路径
        ServletContext servletContext = session.getServletContext();
        String dirPath = servletContext.getRealPath("/photo/") + LocalDate.now();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        photo.transferTo(new File(dirPath + "/" + uuid + suffix));
        return "success";
    }
}