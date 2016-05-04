package com.zhangzj.resume.service;

import com.zhangzj.resume.entity.Company;

public interface CompanyService {
  public void signup(Company company);
  public Company login(Company company);
  public void updateCompany(Company company, String password);
}
