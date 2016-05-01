package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.service.CompanyService;
import com.zhangzj.resume.service.JobseekerService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
  private JobseekerService jobseekerService;
  private CompanyService companyService;
  private String username;
  private String password;
  private String role;
  
  public String login(){
    try{
      String role = this.getRole();
      if ("jobseeker".equals(role)) {
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUsername(this.getUsername());
        jobseeker.setPassword(this.getPassword());
        jobseeker = jobseekerService.login(jobseeker);
        if (null != jobseeker) {
          ActionContext.getContext().getApplication().put("jobseeker", jobseeker);
          //ServletActionContext.getRequest().setAttribute("jobseeker", jobseeker);
          return "jobseeker";
        } else {
          return INPUT;
        }
      } else if ("company".equals(role)){
        Company company = new Company();
        company.setUsername(this.getUsername());
        company.setPassword(this.getPassword());
        company = companyService.login(company);
        if (null != company) {
          ActionContext.getContext().getApplication().put("company", company);
          return "company";
        } else {
          return INPUT;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      return INPUT;
    }
    return INPUT;
  }

  public JobseekerService getJobseekerService() {
    return jobseekerService;
  }

  public void setJobseekerService(JobseekerService jobseekerService) {
    this.jobseekerService = jobseekerService;
  }

  public CompanyService getCompanyService() {
    return companyService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
  
}
