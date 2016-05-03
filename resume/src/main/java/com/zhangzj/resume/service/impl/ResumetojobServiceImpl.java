package com.zhangzj.resume.service.impl;

import java.util.List;

import com.zhangzj.resume.dao.ResumetojobDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resumetojob;
import com.zhangzj.resume.service.ResumetojobService;

public class ResumetojobServiceImpl implements ResumetojobService {
  private ResumetojobDao resumetojobDao;
  
  @Override
  public void addResumetojob(Resumetojob resumetojob) {
    resumetojobDao.addResumetojob(resumetojob);
  }

  @Override
  public void updateResumetojob(Resumetojob resumetojob) {
    resumetojobDao.updateResumetojob(resumetojob);
  }

  @Override
  public void deleteResumetojob(Resumetojob resumetojob) {
    resumetojobDao.deleteResumetojob(resumetojob);
  }

  @Override
  public Resumetojob findResumetojobById(Resumetojob resumetojob) {
    return resumetojobDao.findResumetojobById(resumetojob);
  }

  @Override
  public List<Resumetojob> findResumetojobByProperty(String key, String value) {
    return resumetojobDao.findResumetojobByProperty(key, value);
  }

  @Override
  public List<Resumetojob> findByJobseeker(Jobseeker jobseeker) {
    return resumetojobDao.findResumetojobByProperty("jobseekerid", jobseeker.getId());
  }

  @Override
  public List<Resumetojob> findByCompany(Company company) {
    return resumetojobDao.findResumetojobByProperty("companyid", company.getId());
  }

  public ResumetojobDao getResumetojobDao() {
    return resumetojobDao;
  }

  public void setResumetojobDao(ResumetojobDao resumetojobDao) {
    this.resumetojobDao = resumetojobDao;
  }

}
