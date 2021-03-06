package com.zhangzj.resume.service;

import java.util.List;

import com.zhangzj.resume.entity.Company;

public interface CompanyService {
  public void signup(Company company);
  public Company login(Company company);
  public void updateCompany(Company company, String password);
  public List<Company> findAll();
  public Company findCompanyByName(Company company);
  public void deleteCompany(Company company);
  public Company findCompanyById(Company company);
}
