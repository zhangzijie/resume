package com.zhangzj.resume.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowDate {
  public static String getNowDateStr() {
    String dateStr;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    dateStr = dateFormat.format(date);
    return dateStr;
  }
}
