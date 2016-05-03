package com.zhangzj.resume.service.impl;

import java.util.List;
import java.util.Properties;

import com.zhangzj.resume.dao.JobDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.service.JobService;

public class JobServiceImpl implements JobService {
  private JobDao jobDao;
  
  @Override
  public void addJob(Job job) {
    jobDao.addJob(job);
  }

  @Override
  public void updateJob(Job job) {
    jobDao.updateJob(job);
  }

  @Override
  public void deleteJob(Job job) {
    jobDao.deleteJob(job);
  }

  @Override
  public Job findJobById(Job job) {
    return jobDao.findJobById(job);
  }

  @Override
  public List<Job> findJobByCompany(Company company) {
    return jobDao.findJobByCompany(company);
  }

  @Override
  public List<Job> findAll() {
    return jobDao.findAll();
  }

  @Override
  public List<Job> findLatest() {
    return jobDao.findLatest();
  }

  @Override
  public List<Job> findJobByProperties(Properties prop) {
    return jobDao.findJobByProperties(prop);
  }

  public JobDao getJobDao() {
    return jobDao;
  }

  public void setJobDao(JobDao jobDao) {
    this.jobDao = jobDao;
  }

}
