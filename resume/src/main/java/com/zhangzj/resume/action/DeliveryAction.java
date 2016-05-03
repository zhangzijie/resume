package com.zhangzj.resume.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resume;
import com.zhangzj.resume.entity.Delivery;
import com.zhangzj.resume.service.JobService;
import com.zhangzj.resume.service.ResumeService;
import com.zhangzj.resume.service.DeliveryService;
import com.zhangzj.resume.util.GetNowDate;

@SuppressWarnings("serial")
public class DeliveryAction extends ActionSupport {
  private DeliveryService deliveryService;
  private ResumeService resumeService;
  private JobService jobService;
  private int id;
  private String resumeid;
  private String jobid;
  
  public String addDelivery() {
    try {
      Delivery delivery = new Delivery();
      Resume resume = new Resume();
      resume.setId(Integer.parseInt(this.getResumeid()));
      resume = resumeService.findResumeById(resume);
      Job job = new Job();
      job.setId(Integer.parseInt(this.getJobid()));
      job = jobService.findJobById(job);
      
      delivery.setResume(resume);
      delivery.setJob(job);
      delivery.setJobseekerid(resume.getJobseeker().getId());
      delivery.setCompanyid(job.getCompany().getId());
      delivery.setResumename(resume.getResumename());
      delivery.setJobname(job.getJobname());
      delivery.setJobseekername(resume.getJobseeker().getFullname());
      delivery.setCompanyname(job.getCompanyname());
      delivery.setCredate(GetNowDate.getNowDateStr());
      delivery.setState("待查看");
      deliveryService.addDelivery(delivery);
      //获取该求职者的投递列表
      ActionContext.getContext().getSession().put("deliveryList", deliveryService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("jobseeker")));
      return "jobseekerSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "投递简历失败");
      return "jobseekerError";
    }
  }

  public String listDelivery() {
    try {
      if (null != ActionContext.getContext().getApplication().get("company")) {
        List<Delivery> deliveryList = deliveryService.findByCompany((Company) ActionContext.getContext().getApplication().get("company"));
        for(int i=0; i<deliveryList.size(); i++) {
          Delivery delivery = deliveryList.get(i);
          if(null != delivery.getState()) {
            if ("已回绝".equals(delivery.getState())) {
              deliveryList.remove(i);
            }
          }
        }
        ActionContext.getContext().getSession().put("deliveryList", deliveryList);
        return "companySuccess";
      } else if(null != ActionContext.getContext().getApplication().get("jobseeker")) {
        List<Delivery> deliveryList = deliveryService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("jobseeker"));
        ActionContext.getContext().getSession().put("deliveryList", deliveryList);
        return "jobseekerSuccess";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "查看投递列表失败,请重新登录");
        throw new Exception("cannot get company or jobseeker while listDelivery");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看投递列表失败");
      if (null != ActionContext.getContext().getApplication().get("company")) {
        return "companyError";
      } else if(null != ActionContext.getContext().getApplication().get("jobseeker")) {
        return "jobseekerError";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "查看投递列表失败,请重新登录");
        return ERROR;
      }
    }
  }
  
  public String deleteDelivery() {
    try {
      Delivery delivery = new Delivery();
      delivery.setId(this.getId());
      delivery = deliveryService.findDeliveryById(delivery);
      deliveryService.deleteDelivery(delivery);
      List<Delivery> deliveryList = deliveryService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("jobseeker"));
      ActionContext.getContext().getSession().put("deliveryList", deliveryList);
      return "jobseekerSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "取消投递失败");
      return "jobseekerError";
    }
  }
  
  public String refuseDelivery() {
    try {
      Delivery delivery = new Delivery();
      delivery.setId(this.getId());
      delivery = deliveryService.findDeliveryById(delivery);
      delivery.setState("已回绝");
      deliveryService.updateDelivery(delivery);
      ActionContext.getContext().getSession().put("deliveryList", deliveryService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("company")));
      return "companySuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "回绝简历失败");
      return "companyError";
    }
  }
  
  public String viewDelivery() {
    try {
      Delivery delivery = new Delivery();
      delivery.setId(this.getId());
      delivery = deliveryService.findDeliveryById(delivery);
      delivery.setState("已查看");
      deliveryService.updateDelivery(delivery);
      ActionContext.getContext().getSession().put("deliveryList", deliveryService.findByJobseeker((Jobseeker) ActionContext.getContext().getApplication().get("jobseeker")));
      ServletActionContext.getRequest().setAttribute("resumeid", delivery.getResume().getId());
      return "viewResume";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "更新申请状态失败");
      return "companyError";
    }
  }
  
  public DeliveryService getDeliveryService() {
    return deliveryService;
  }

  public void setDeliveryService(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
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
