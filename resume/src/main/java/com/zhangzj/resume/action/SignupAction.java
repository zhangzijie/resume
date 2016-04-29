package com.zhangzj.resume.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;

@SuppressWarnings("serial")
public class SignupAction extends ActionSupport {
  private String username;
  private String password;
  private String role;
  
  public String signup() {
    try{
      //TODO 
      String role = "";
      if ("jobseeker".equals(role)) {
        Jobseeker jobseeker = new Jobseeker();
        //TODO
        jobseeker.setUsername(role);
        
      } else if ("company".equals(role)){
        Company company = new Company();
        //TODO
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      return ERROR;
    }
    return SUCCESS;
  }
  
}
