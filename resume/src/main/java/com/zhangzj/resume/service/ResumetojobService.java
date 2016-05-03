package com.zhangzj.resume.service;

import java.util.List;

import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resumetojob;

public interface ResumetojobService {
  public void addResumetojob(Resumetojob resumetojob);
  public void updateResumetojob(Resumetojob resumetojob);
  public void deleteResumetojob(Resumetojob resumetojob);
  public Resumetojob findResumetojobById(Resumetojob resumetojob);
  public List<Resumetojob> findResumetojobByProperty(String key, String value);
  public List<Resumetojob> findByJobseeker(Jobseeker jobseeker);
  public List<Resumetojob> findByCompany(Company company);
}
