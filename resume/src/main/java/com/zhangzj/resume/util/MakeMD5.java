package com.zhangzj.resume.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MakeMD5 {
  public static String makeMD5(String password) {
    MessageDigest messageDigest;
    try {
      // 生成一个MD5加密计算摘要
      messageDigest = MessageDigest.getInstance("MD5");
      // 计算md5函数
      messageDigest.update(password.getBytes());
      // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
      // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
      String pwd = new BigInteger(1, messageDigest.digest()).toString(16);
      return pwd;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return password;
  }
}
