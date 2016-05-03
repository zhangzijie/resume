package com.zhangzj.resume.service;

import java.util.List;
import java.util.Properties;

import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;

public interface JobService {
  public void addJob(Job job);
  public void updateJob(Job job);
  public void deleteJob(Job job);
  public Job findJobById(Job job);
  public List<Job> findJobByCompany(Company company);
  public List<Job> findAll();
  public List<Job> findLatest();
  public List<Job> findJobByProperties(Properties prop);
}
