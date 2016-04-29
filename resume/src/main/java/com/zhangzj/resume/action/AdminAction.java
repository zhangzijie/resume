package com.zhangzj.resume.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.dao.AdminDao;
import com.zhangzj.resume.entity.Admin;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {
  private AdminDao adminDao;
  private String username;
  private String password;
  
  public String addAdmin() {
    try{
      Admin admin = new Admin();
      admin.setUsername(this.getUsername());
      admin.setPassword(this.getPassword());
      adminDao.addAdmin(admin);
    } catch (Exception ex) {
      ex.printStackTrace();
      return ERROR;
    }
    return SUCCESS;
  }
  
  public String deleteAdmin() {
    try{
      Admin admin = new Admin();
      admin.setUsername(this.getUsername());
      admin.setPassword(this.getPassword());
      adminDao.deleteAdmin(admin);
    } catch (Exception ex) {
      ex.printStackTrace();
      return ERROR;
    }
    return SUCCESS;
  }
  

  public AdminDao getAdminDao() {
    return adminDao;
  }

  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
