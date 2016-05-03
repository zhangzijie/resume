package com.zhangzj.resume.dao.impl;

import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.JobDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Job;

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
    return this.findAll(Job.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Job> findLatest() {
    Criteria criteria = this.getSession().createCriteria(Job.class);
    criteria.addOrder(Order.desc("id"));
    criteria.setFirstResult(0);
    criteria.setMaxResults(20);
    return criteria.list();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public List<Job> findJobByProperties(Properties prop) {
    Criteria criteria = this.getSession().createCriteria(Job.class);
    for(Enumeration e = prop.propertyNames(); e.hasMoreElements();) {
      String key = (String) e.nextElement();
      criteria.add(Restrictions.like(key, "%"+prop.getProperty(key)+"%"));
    }
    return criteria.list();
  }

}
