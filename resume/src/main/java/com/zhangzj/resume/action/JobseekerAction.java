package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.service.JobseekerService;

@SuppressWarnings("serial")
public class JobseekerAction extends ActionSupport {
  private JobseekerService jobseekerService;
  private int id;
  private String username;
  private String password;
  private String fullname;
  private String phone;
  private String email;
  
  public String editJobseeker() {
    return "editJobseeker";
  }
  
  public String updateJobseeker() {
    try {
      Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
      jobseeker.setPhone(this.getPhone());
      jobseeker.setEmail(this.getEmail());
      jobseekerService.updateJobseeker(jobseeker, this.getPassword());
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存个人信息失败");
      return ERROR;
    }
  }

  public JobseekerService getJobseekerService() {
    return jobseekerService;
  }

  public void setJobseekerService(JobseekerService jobseekerService) {
    this.jobseekerService = jobseekerService;
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

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
}
