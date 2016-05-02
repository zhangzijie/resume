package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.service.JobService;
import com.zhangzj.resume.util.GetNowDate;

@SuppressWarnings("serial")
public class JobAction extends ActionSupport {
  private JobService jobService;
  private int id;
  private String jobname;
  private String credate;
  private String salary;
  private String number;
  private String address;
  private String workyear;
  private String degree;
  private String responsibility;
  private String requirement;
  private String category;
  private Company company;
  
  public String addJob() {
    try {
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
      Job job = new Job();
      job.setCompanyname(company.getCompanyname());
      job.setCompany(company);
      jobService.addJob(job);
      ActionContext.getContext().getSession().put("job", job);
      return "editJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "创建职位失败");
      return ERROR;
    }
  }
  
  public String editJob() {
    try {
      //Company company = (Company) ActionContext.getContext().getApplication().get("company");
      Job job = new Job();
      job.setId(this.getId());
      job = jobService.findJobById(job);
      ActionContext.getContext().getSession().put("job", job);
      return "editJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "编辑职位失败");
      return ERROR;
    }
  }
  
  public String viewJob() {
    try {
      //Company company = (Company) ActionContext.getContext().getApplication().get("company");
      Job job = new Job();
      job.setId(this.getId());
      job = jobService.findJobById(job);
      ActionContext.getContext().getSession().put("job", job);
      return "viewJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看职位失败");
      return ERROR;
    }
  }
  
  public String updateJob() {
    Job job = (Job) ActionContext.getContext().getSession().get("job");
    try {
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
      job.setJobname(this.getJobname());
      job.setCredate(GetNowDate.getNowDateStr());
      job.setSalary(this.getSalary());
      job.setNumber(this.getNumber());
      job.setAddress(this.getAddress());
      job.setWorkyear(this.getWorkyear());
      job.setDegree(this.getDegree());
      job.setResponsibility(this.getResponsibility());
      job.setRequirement(this.getRequirement());
      job.setCategory(this.getCategory());
      jobService.updateJob(job);
      ActionContext.getContext().getSession().put("jobList", jobService.findJobByCompany(company));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存职位失败");
      return ERROR;
    }
  }
  
  public String deleteJob() {
    try {
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
      Job job = new Job();
      job.setId(this.getId());
      jobService.deleteJob(job);
      ActionContext.getContext().getSession().put("jobList", jobService.findJobByCompany(company));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "删除职位失败");
      return ERROR;
    }
  }
  
  public String listJob() {
    try {
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
      ActionContext.getContext().getSession().put("jobList", jobService.findJobByCompany(company));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "列出职位失败");
      return ERROR;
    }
  }

  public JobService getJobService() {
    return jobService;
  }

  public void setJobService(JobService jobService) {
    this.jobService = jobService;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname;
  }

  public String getCredate() {
    return credate;
  }

  public void setCredate(String credate) {
    this.credate = credate;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getWorkyear() {
    return workyear;
  }

  public void setWorkyear(String workyear) {
    this.workyear = workyear;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getResponsibility() {
    return responsibility;
  }

  public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
  }

  public String getRequirement() {
    return requirement;
  }

  public void setRequirement(String requirement) {
    this.requirement = requirement;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
  
}
