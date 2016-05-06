package com.zhangzj.resume.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpload {
  public static String Upload(File file , String fileName) throws Exception {
    if (null != file) {
      String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
      String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
      String uuid = UUID.randomUUID().toString().replace("-", "");
      String destFileName = uuid + "." + fileEnd;
      File destFile = new File(new File(uploadPath), destFileName);
      if (!destFile.getParentFile().exists()) {
        destFile.getParentFile().mkdirs();
      }
      FileUtils.copyFile(file, destFile);
      return "/upload/" + destFileName;
    } else {
      throw new Exception("can not upload file, cos file is null");
    }
  }
}
