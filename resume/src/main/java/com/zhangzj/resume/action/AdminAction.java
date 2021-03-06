package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Admin;
import com.zhangzj.resume.service.AdminService;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {
  private AdminService adminService;
  private int id;
  private String username;
  private String password;
  
  public String updateAdmin() {
    try{
      Admin admin = (Admin) ActionContext.getContext().getApplication().get("admin");
      adminService.updateAdmin(admin, this.getPassword());
    } catch (Exception ex) {
      ServletActionContext.getRequest().setAttribute("msg", "修改管理员信息失败");
      ex.printStackTrace();
      return ERROR;
    }
    return SUCCESS;
  }
  
  public String editAdmin() {
    return "editAdmin";
  }

  public AdminService getAdminService() {
    return adminService;
  }

  public void setAdminService(AdminService adminService) {
    this.adminService = adminService;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
