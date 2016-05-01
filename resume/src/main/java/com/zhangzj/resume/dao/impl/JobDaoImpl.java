package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.JobDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;
import com.zhangzj.resume.entity.Jobseeker;

public class JobDaoImpl extends BaseDao<Job> implements JobDao {

  @Override
  public void addJob(Job job) {
    this.save(job);
  }

  @Override
  public void updateJob(Job job) {
    this.update(job);
  }

  @Override
  public void deleteJob(Job job) {
    this.delete(job);
  }

  @Override
  public Job findJobById(Job job) {
    return this.findById(Job.class, job.getId());
  }

  @Override
  public List<Job> findJobByCompany(Company company) {
    return this.findByProperty(Job.class, "company", company);
  }

  @Override
  public List<Job> findAll() {
    return this.findAll();
  }

}
