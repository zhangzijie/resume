package com.zhangzj.resume.entity;

public class Resumetojob {
  private int id;
  private int jobseekerid;
  private int companyid;
  private String resumename;
  private String jobname;
  private String jobseekername;
  private String companyname;
  private Resume resume;
  private Job job;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getJobseekerid() {
    return jobseekerid;
  }

  public void setJobseekerid(int jobseekerid) {
    this.jobseekerid = jobseekerid;
  }

  public int getCompanyid() {
    return companyid;
  }

  public void setCompanyid(int companyid) {
    this.companyid = companyid;
  }

  public String getResumename() {
    return resumename;
  }

  public void setResumename(String resumename) {
    this.resumename = resumename;
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname;
  }

  public String getJobseekername() {
    return jobseekername;
  }

  public void setJobseekername(String jobseekername) {
    this.jobseekername = jobseekername;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public Resume getResume() {
    return resume;
  }

  public void setResume(Resume resume) {
    this.resume = resume;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }
  
}
