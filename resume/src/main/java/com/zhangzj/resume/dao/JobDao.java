package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;

public interface JobDao {
  public void addJob(Job job);
  public void updateJob(Job job);
  public void deleteJob(Job job);
  public Job findJobById(Job job);
  public List<Job> findJobByCompany(Company company);
  public List<Job> findAll();
}
