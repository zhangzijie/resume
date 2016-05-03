package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resume;
import com.zhangzj.resume.entity.Resumetojob;
import com.zhangzj.resume.service.JobService;
import com.zhangzj.resume.service.ResumeService;
import com.zhangzj.resume.service.ResumetojobService;

@SuppressWarnings("serial")
public class DeliveryAction extends ActionSupport {
  private ResumetojobService resumetojobService;
  private ResumeService resumeService;
  private JobService jobService;
  private int id;
  private String resumeid;
  private String jobid;
  
  public String addDelivery() {
    try {
      Resumetojob resumetojob = new Resumetojob();
      Resume resume = new Resume();
      resume.setId(Integer.parseInt(this.getResumeid()));
      resume = resumeService.findResumeById(resume);
      Job job = new Job();
      job.setId(Integer.parseInt(this.getJobid()));
      job = jobService.findJobById(job);
      
      resumetojob.setResume(resume);
      resumetojob.setJob(job);
      resumetojob.setJobseekerid(resume.getJobseeker().getId());
      resumetojob.setCompanyid(job.getCompany().getId());
      resumetojob.setResumename(resume.getResumename());
      resumetojob.setJobname(job.getJobname());
      resumetojob.setJobseekername(resume.getJobseeker().getFullname());
      resumetojob.setCompanyname(job.getCompanyname());
      resumetojobService.addResumetojob(resumetojob);
      //获取该求职者的投递列表
      ActionContext.getContext().getSession().put("deliveryList", resumetojobService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("jobseeker")));
      return "jobseekerSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "创建职位失败");
      return ERROR;
    }
  }

  public ResumetojobService getResumetojobService() {
    return resumetojobService;
  }

  public void setResumetojobService(ResumetojobService resumetojobService) {
    this.resumetojobService = resumetojobService;
  }

  public String getResumeid() {
    return resumeid;
  }

  public void setResumeid(String resumeid) {
    this.resumeid = resumeid;
  }

  public String getJobid() {
    return jobid;
  }

  public void setJobid(String jobid) {
    this.jobid = jobid;
  }

  public ResumeService getResumeService() {
    return resumeService;
  }

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
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
  
}
