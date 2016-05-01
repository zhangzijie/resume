package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Resume;

public interface ResumeDao {
  public void addResume(Resume resume);
  public void updateResume(Resume resume);
  public void deleteResume(Resume resume);
  public Resume findResumeById(Resume resume);
  public List<Resume> findAll();
}
