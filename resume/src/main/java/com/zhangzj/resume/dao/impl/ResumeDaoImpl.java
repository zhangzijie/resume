package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.ResumeDao;
import com.zhangzj.resume.entity.Resume;

public class ResumeDaoImpl extends BaseDao<Resume> implements ResumeDao {

  @Override
  public void addResume(Resume resume) {
    this.save(resume);
  }

  @Override
  public void updateResume(Resume resume) {
    this.update(resume);
  }

  @Override
  public void deleteResume(Resume resume) {
    this.delete(resume);
  }

  @Override
  public Resume findResumeById(Resume resume) {
    return this.findById(Resume.class, resume.getId());
  }

  @Override
  public List<Resume> findAll() {
    return this.findAll(Resume.class);
  }

}
