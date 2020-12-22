package com.yuxin.common.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FTP工具类
 */
@Log4j2
public class FTPUtils {

    private final static String ip;

    private final static int port;

    private final static String username;

    private final static String password;

    private final static String localUrl;

    private FTPUtils() {
    }

    /* 读取配置文件中的值 */
    static {
        ip = PropertiesUtils.getValue("ftp.ip");
        String portStr = PropertiesUtils.getValue("ftp.port");
        port = Integer.parseInt(portStr);
        username = PropertiesUtils.getValue("ftp.username");
        password = PropertiesUtils.getValue("ftp.password");
        localUrl = PropertiesUtils.getValue("ftp.localUrl");
    }

    /**
     * 连接FTP服务器
     *
     * @return FTPClient
     */
    private static FTPClient connect() {
        FTPClient client = null;
        boolean login = false;
        try {
            client = new FTPClient();
            client.setControlEncoding("UTF-8");
            client.connect(ip, port);
            login = client.login(username, password);
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (login) {
            log.info("login ftp server success");
            return client;
        }
        log.warn("login ftp server fail");
        return null;
    }

    /**
     * 多文件上传，把多个文件上传至FTP服务器
     *
     * @param files   上传的文件集合
     * @param ftpPath 希望上传到FTP服务器的路径
     * @return 是否成功上传
     */
    public static boolean upload(MultipartFile[] files, String ftpPath) {
        FTPClient client = null;
        FileInputStream fis = null;
        boolean success = false;
        try {
            client = connect();
            if (client == null) return false;
            client.changeWorkingDirectory("/");
            String[] dirs = ftpPath.split("/");
            for (String dir : dirs) {
                if ("".equals(dir)) continue;
                boolean hasJump = client.changeWorkingDirectory(dir);
                if (!hasJump) {
                    client.makeDirectory(dir);
                    client.changeWorkingDirectory(dir);
                }
            }
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                if (fileName != null && !"".equals(fileName)) {
                    int index = fileName.indexOf(".");
                    String prefix = fileName.substring(0, index);
                    String suffix = fileName.substring(index);
                    String localPath = localUrl + "/" + prefix + System.nanoTime() + suffix;
                    File fileLocal = new File(localPath);
                    if (fileLocal.exists()) {
                        boolean delete = fileLocal.delete();
                        log.info("delete exist file from app server: " + delete);
                    }
                    file.transferTo(fileLocal);
                    log.info(fileName + " has uploaded to app server");
                    fis = new FileInputStream(fileLocal);
                    success = client.storeFile(fileName, fis);
                    log.info(fileName + " has uploaded to ftp server");
                    fis.close();
                    boolean delete = fileLocal.delete();
                    log.info("delete " + fileName + " from app server: " + delete);
                }
            }
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        } finally {
            close(fis);
            disconnect(client);
        }
        return success;
    }

    /**
     * 关闭流
     *
     * @param fis 文件输入流
     */
    private static void close(FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 断开FTP连接
     *
     * @param client FTPClient
     */
    private static void disconnect(FTPClient client) {
        if (client != null) {
            try {
                client.logout();
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
