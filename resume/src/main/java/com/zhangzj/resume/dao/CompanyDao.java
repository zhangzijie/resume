package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Company;

public interface CompanyDao {
  public void addCompany(Company company);
  public void updateCompany(Company company);
  public void deleteCompany(Company company);
  public Company findCompanyByID(Company company);
  public Company findCompanyByName(Company company);
  public List<Company> findAll();
}
