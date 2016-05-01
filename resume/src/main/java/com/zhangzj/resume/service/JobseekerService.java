package com.zhangzj.resume.service;

import com.zhangzj.resume.entity.Jobseeker;

public interface JobseekerService {
  public void signup(Jobseeker jobseeker);
  public Jobseeker login(Jobseeker jobseeker);
}
