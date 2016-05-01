package com.zhangzj.resume.service.impl;

import com.zhangzj.resume.dao.JobseekerDao;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.service.JobseekerService;
import com.zhangzj.resume.util.MakeMD5;

public class JobseekerServiceImpl implements JobseekerService {
  private JobseekerDao jobseekerDao;
  
  @Override
  public void signup(Jobseeker jobseeker) {
    jobseeker.setPassword(MakeMD5.makeMD5(jobseeker.getPassword()));
    jobseekerDao.addJobseeker(jobseeker);
  }

  @Override
  public Jobseeker login(Jobseeker jobseeker) {
    String password = MakeMD5.makeMD5(jobseeker.getPassword());
    jobseeker = jobseekerDao.findJobseekerByName(jobseeker);
    if (jobseeker.getPassword().equals(password)) {
      return jobseeker;
    } else {
      return null;
    }
  }

  public JobseekerDao getJobseekerDao() {
    return jobseekerDao;
  }

  public void setJobseekerDao(JobseekerDao jobseekerDao) {
    this.jobseekerDao = jobseekerDao;
  }

}
