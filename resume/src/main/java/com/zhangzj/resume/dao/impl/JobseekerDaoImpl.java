package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.JobseekerDao;
import com.zhangzj.resume.entity.Jobseeker;

public class JobseekerDaoImpl extends BaseDao<Jobseeker> implements JobseekerDao {

  @Override
  public void addJobseeker(Jobseeker jobseeker) {
    this.save(jobseeker);
  }

  @Override
  public void updateJobseeker(Jobseeker jobseeker) {
    this.update(jobseeker);
  }

  @Override
  public void deleteJobseeker(Jobseeker jobseeker) {
    this.delete(this.findJobseekerByName(jobseeker));
  }

  @Override
  public Jobseeker findJobseekerByName(Jobseeker jobseeker) {
    List<Jobseeker> list = this.findByProperty(Jobseeker.class, "username", jobseeker.getUsername());
    if (list.size() == 1) {
      return list.get(0);
    } else {
      try {
        throw new Exception("can not find Jobseeker by username.");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public List<Jobseeker> findAll() {
    return this.findAll(Jobseeker.class);
  }

}
