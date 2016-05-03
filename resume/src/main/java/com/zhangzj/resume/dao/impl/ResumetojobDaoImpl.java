package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.ResumetojobDao;
import com.zhangzj.resume.entity.Resumetojob;

public class ResumetojobDaoImpl extends BaseDao<Resumetojob> implements ResumetojobDao {

  @Override
  public void addResumetojob(Resumetojob resumetojob) {
    this.save(resumetojob);
  }

  @Override
  public void updateResumetojob(Resumetojob resumetojob) {
    this.update(resumetojob);

  }

  @Override
  public void deleteResumetojob(Resumetojob resumetojob) {
    this.delete(resumetojob);
  }

  @Override
  public Resumetojob findResumetojobById(Resumetojob resumetojob) {
    return this.findById(Resumetojob.class, resumetojob.getId());
  }

  @Override
  public List<Resumetojob> findResumetojobByProperty(String key, Object value) {
    return this.findByProperty(Resumetojob.class, key, value);
  }

}
