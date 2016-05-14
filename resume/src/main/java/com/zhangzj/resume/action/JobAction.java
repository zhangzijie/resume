package com.zhangzj.resume.action;

import java.util.List;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.service.JobService;
import com.zhangzj.resume.util.GetNowDate;
import com.zhangzj.resume.util.Page;

@SuppressWarnings("serial")
public class JobAction extends ActionSupport {
  private JobService jobService;
  private int id;
  private String companyid;
  private String jobseekerid;
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
  private String companyname;
  private String pagenum;
  private Company company;
  
  public String addJob() {
    try {
      ActionContext.getContext().getSession().put("addflag", "true");
      return "editJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "创建职位失败");
      return ERROR;
    }
  }
  
  public String editJob() {
    try {
      Job job = new Job();
      job.setId(this.getId());
      job = jobService.findJobById(job);
      ServletActionContext.getRequest().setAttribute("job", job);
      ActionContext.getContext().getSession().put("addflag", "false");
      return "editJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "编辑职位失败");
      return ERROR;
    }
  }
  
  public String viewJob() {
    try {
      Job job = new Job();
      job.setId(this.getId());
      job = jobService.findJobById(job);
      //ActionContext.getContext().getSession().put("job", job);
      ServletActionContext.getRequest().setAttribute("job", job);
      if (null != ActionContext.getContext().getApplication().get("company")) {
        return "companyViewJob";
      } else if(null != ActionContext.getContext().getApplication().get("jobseeker")) {
        return "jobseekerViewJob";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "查看职位失败");
        return ERROR;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看职位失败");
      return ERROR;
    }
  }
  
  public String updateJob() {
    try {
      if (null != ActionContext.getContext().getSession().get("addflag") && "true".equals((String)ActionContext.getContext().getSession().get("addflag"))) {
        Company company = (Company) ActionContext.getContext().getApplication().get("company");
        Job job = new Job();
        job.setCompanyname(company.getCompanyname());
        job.setCompany(company);
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
        jobService.addJob(job);
        ActionContext.getContext().getSession().remove("addflag");
      } else if (null != ActionContext.getContext().getSession().get("addflag") && "false".equals((String)ActionContext.getContext().getSession().get("addflag"))) {
        Job job = new Job();
        job.setId(this.getId());
        job = jobService.findJobById(job);
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
        ActionContext.getContext().getSession().remove("addflag");
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "保存职位失败");
      }
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
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
  
  public String latestJob() {
    try {
      List<Job> jobList = jobService.findLatest();
      ActionContext.getContext().getSession().put("jobList",jobList);
      if (null != ActionContext.getContext().getApplication().get("company")) {
        return "companyLatestJob";
      } else if(null != ActionContext.getContext().getApplication().get("jobseeker")) {
        return "jobseekerLatestJob";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "查看最新职位失败");
        return ERROR;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看最新职位失败");
      return ERROR;
    }
  }
  
  @SuppressWarnings("unchecked")
  public String searchJob() {
    try {
      if (null == this.getPagenum() || "".equals(this.getPagenum())) {
        Properties prop = new Properties();
        prop.setProperty("jobname", this.getJobname());
        prop.setProperty("companyname", this.getCompanyname());
        prop.setProperty("address", this.getAddress());
        List<Job> jobList = jobService.findJobByProperties(prop);
        ActionContext.getContext().getSession().put("jobList", jobList);
        Page page = new Page(1,jobList.size());
        ServletActionContext.getRequest().setAttribute("page", page);
      } else {
        Page page = new Page(Integer.parseInt(this.getPagenum()), ((List<Job>)ActionContext.getContext().getSession().get("jobList")).size());
        ServletActionContext.getRequest().setAttribute("page", page);
      }
      this.setPagenum(null);
      return "searchJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "搜索职位失败");
      return "jobseekerError";
    }
  }
  
  public String searchpageJob() {
    try {
      ActionContext.getContext().getSession().remove("jobList");
      return "searchJob";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "跳转搜索职位页面失败");
      return "jobseekerError";
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

  public String getJobseekerid() {
    return jobseekerid;
  }

  public void setJobseekerid(String jobseekerid) {
    this.jobseekerid = jobseekerid;
  }

  public String getCompanyid() {
    return companyid;
  }

  public void setCompanyid(String companyid) {
    this.companyid = companyid;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getPagenum() {
    return pagenum;
  }

  public void setPagenum(String pagenum) {
    this.pagenum = pagenum;
  }

  
}
