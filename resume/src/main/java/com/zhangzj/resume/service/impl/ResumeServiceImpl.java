package com.zhangzj.resume.service.impl;

import java.util.List;

import com.zhangzj.resume.dao.ResumeDao;
import com.zhangzj.resume.entity.Resume;
import com.zhangzj.resume.service.ResumeService;

public class ResumeServiceImpl implements ResumeService {
  private ResumeDao resumeDao;
  
  @Override
  public void addResume(Resume resume) {
    resumeDao.addResume(resume);
  }

  @Override
  public void updateResume(Resume resume) {
    resumeDao.updateResume(resume);
  }

  @Override
  public void deleteResume(Resume resume) {
    resumeDao.deleteResume(resume);
  }

  @Override
  public Resume findResumeById(Resume resume) {
    return resumeDao.findResumeById(resume);
  }

  @Override
  public List<Resume> findAll() {
    return resumeDao.findAll();
  }

  public ResumeDao getResumeDao() {
    return resumeDao;
  }

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

}
