package com.zhangzj.resume.service;

import java.util.List;

import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resume;

public interface ResumeService {
  public void addResume(Resume resume);
  public void updateResume(Resume resume);
  public void deleteResume(Resume resume);
  public Resume findResumeById(Resume resume);
  public List<Resume> findResumeByJobseeker(Jobseeker jobseeker);
  public List<Resume> findAll();
}
