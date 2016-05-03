package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Resumetojob;

public interface ResumetojobDao {
  public void addResumetojob(Resumetojob resumetojob);
  public void updateResumetojob(Resumetojob resumetojob);
  public void deleteResumetojob(Resumetojob resumetojob);
  public Resumetojob findResumetojobById(Resumetojob resumetojob);
  public List<Resumetojob> findResumetojobByProperty(String key, Object value);
}
