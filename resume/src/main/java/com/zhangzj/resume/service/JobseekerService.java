package com.zhangzj.resume.service;

import java.util.List;

import com.zhangzj.resume.entity.Jobseeker;

public interface JobseekerService {
  public void signup(Jobseeker jobseeker);
  public Jobseeker login(Jobseeker jobseeker);
  public void updateJobseeker(Jobseeker jobseeker, String password);
  public List<Jobseeker> findAll();
  public Jobseeker findJobseekerByName(Jobseeker jobseeker);
  public void deleteJobseeker(Jobseeker jobseeker);
  public Jobseeker findJobseekerById(Jobseeker jobseeker);
}
