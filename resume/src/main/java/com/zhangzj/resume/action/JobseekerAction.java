package com.zhangzj.resume.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.service.JobseekerService;
import com.zhangzj.resume.util.Page;

@SuppressWarnings("serial")
public class JobseekerAction extends ActionSupport {
  private JobseekerService jobseekerService;
  private int id;
  private String username;
  private String password;
  private String fullname;
  private String phone;
  private String email;
  private String pagenum;
  
  public String editJobseeker() {
    try {
      if (null != ActionContext.getContext().getApplication().get("jobseeker")) {
        return "editJobseeker";
      } else if (null != ActionContext.getContext().getApplication().get("admin")) {
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setId(this.getId());
        jobseeker = jobseekerService.findJobseekerById(jobseeker);
        ServletActionContext.getRequest().setAttribute("jobseekeritem", jobseeker);
        return "adminEditJobseeker";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "编辑求职者信息失败");
        return INPUT;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "编辑求职者信息失败");
      return ERROR;
    }
  }
  
  public String updateJobseeker() {
    try {
      if (null != ActionContext.getContext().getApplication().get("jobseeker")) {
        Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
        jobseeker.setPhone(this.getPhone());
        jobseeker.setEmail(this.getEmail());
        jobseekerService.updateJobseeker(jobseeker, this.getPassword());
        return SUCCESS;
      } else if (null != ActionContext.getContext().getApplication().get("admin")) {
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setId(id);
        jobseeker = jobseekerService.findJobseekerById(jobseeker);
        jobseeker.setFullname(this.getFullname());
        jobseeker.setPhone(this.getPhone());
        jobseeker.setEmail(this.getEmail());
        jobseekerService.updateJobseeker(jobseeker, this.getPassword());
        return "listJobseeker";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "保存求职者信息失败");
        return INPUT;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存求职者信息失败");
      return ERROR;
    }
  }
  
  @SuppressWarnings("unchecked")
  public String listJobseeker() {
    try {
      if (null == this.getPagenum() || "".equals(this.getPagenum())) {
        List<Jobseeker> jobseekerList= jobseekerService.findAll();
        Page page = new Page(1,jobseekerList.size());
        ActionContext.getContext().getSession().put("jobseekerList", jobseekerList);
        ServletActionContext.getRequest().setAttribute("page", page);
      } else {
        Page page = new Page(Integer.parseInt(this.getPagenum()), ((List<Jobseeker>)ActionContext.getContext().getSession().get("jobseekerList")).size());
        ServletActionContext.getRequest().setAttribute("page", page);
      }
      return "adminSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看求职者列表失败");
      return "adminError";
    }
  }
  
  public String searchJobseeker() {
    try {
      if (null == this.getUsername() || "".equals(this.getUsername())) {
        List<Jobseeker> jobseekerList= jobseekerService.findAll();
        Page page = new Page(1,jobseekerList.size());
        ActionContext.getContext().getSession().put("jobseekerList", jobseekerList);
        ServletActionContext.getRequest().setAttribute("page", page);
      } else {
        Jobseeker jobseeker = new Jobseeker();
        jobseeker.setUsername(this.getUsername());
        jobseeker = jobseekerService.findJobseekerByName(jobseeker);
        List<Jobseeker> jobseekerList = new ArrayList<Jobseeker>();
        jobseekerList.add(jobseeker);
        Page page = new Page(1,jobseekerList.size());
        ActionContext.getContext().getSession().put("jobseekerList", jobseekerList);
        ServletActionContext.getRequest().setAttribute("page", page);
      }
      return "adminSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "搜索求职者失败");
      return "adminError";
    }
  }
  
  public String deleteJobseeker() {
    try {
      Jobseeker jobseeker = new Jobseeker();
      jobseeker.setId(this.getId());
      jobseeker = jobseekerService.findJobseekerById(jobseeker);
      jobseekerService.deleteJobseeker(jobseeker);
      return "listJobseeker";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "删除求职者失败");
      return "adminError";
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

  public String getPagenum() {
    return pagenum;
  }

  public void setPagenum(String pagenum) {
    this.pagenum = pagenum;
  }
  
}
