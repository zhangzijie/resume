package com.zhangzj.resume.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.service.CompanyService;
import com.zhangzj.resume.service.JobseekerService;

@SuppressWarnings("serial")
public class SignupAction extends ActionSupport {
  private JobseekerService jobseekerService;
  private CompanyService companyService;
  private String username;
  private String password;
  private String role;
  private String fullname;
  private String phonej;
  private String emailj;
  private String companyname;
  private String linkman;
  private String phonec;
  private String emailc;
  private String address;
  
  public String signup() {
    try{
      String role = this.getRole();
      ActionContext.getContext().getApplication().remove("company");
      ActionContext.getContext().getApplication().remove("jobseeker");
      if ("jobseeker".equals(role)) {
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUsername(this.getUsername());
        jobseeker.setPassword(this.getPassword());
        jobseeker.setFullname(this.getFullname());
        jobseeker.setPhone(this.getPhonej());
        jobseeker.setEmail(this.getEmailj());
        jobseekerService.signup(jobseeker);
        ActionContext.getContext().getApplication().put("jobseeker", jobseeker);
        return "jobseeker";
      } else if ("company".equals(role)){
        Company company = new Company();
        company.setUsername(this.getUsername());
        company.setPassword(this.getPassword());
        company.setCompanyname(this.getCompanyname());
        company.setLinkman(this.getLinkman());
        company.setPhone(this.getPhonec());
        company.setEmail(this.getEmailc());
        company.setAddress(this.getAddress());
        companyService.signup(company);
        ActionContext.getContext().getApplication().put("company", company);
        return "company";
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

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPhonej() {
    return phonej;
  }

  public void setPhonej(String phonej) {
    this.phonej = phonej;
  }

  public String getEmailj() {
    return emailj;
  }

  public void setEmailj(String emailj) {
    this.emailj = emailj;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getLinkman() {
    return linkman;
  }

  public void setLinkman(String linkman) {
    this.linkman = linkman;
  }

  public String getPhonec() {
    return phonec;
  }

  public void setPhonec(String phonec) {
    this.phonec = phonec;
  }

  public String getEmailc() {
    return emailc;
  }

  public void setEmailc(String emailc) {
    this.emailc = emailc;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
