package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Jobseeker;

public interface JobseekerDao {
  public void addJobseeker(Jobseeker jobseeker);
  public void updateJobseeker(Jobseeker jobseeker);
  public void deleteJobseeker(Jobseeker jobseeker);
  public Jobseeker findJobseekerByID(Jobseeker jobseeker);
  public Jobseeker findJobseekerByName(Jobseeker jobseeker);
  public List<Jobseeker> findAll();
}
