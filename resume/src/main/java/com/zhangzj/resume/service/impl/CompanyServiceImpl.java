package com.zhangzj.resume.service.impl;

import java.util.List;

import com.zhangzj.resume.dao.CompanyDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.service.CompanyService;
import com.zhangzj.resume.util.MakeMD5;

public class CompanyServiceImpl implements CompanyService {
  private CompanyDao companyDao;
  
  @Override
  public void signup(Company company) {
    company.setPassword(MakeMD5.makeMD5(company.getPassword()));
    companyDao.addCompany(company);
  }

  @Override
  public Company login(Company company) {
    String password = MakeMD5.makeMD5(company.getPassword());
    company = companyDao.findCompanyByName(company);
    if (company.getPassword().equals(password)) {
      return company;
    } else {
      return null;
    }
  }
  
  @Override
  public void updateCompany(Company company, String password) {
    if(null == password || "".equals(password)) {
      companyDao.updateCompany(company);
    } else {
      company.setPassword(MakeMD5.makeMD5(password));
      companyDao.updateCompany(company);
    }
  }

  @Override
  public List<Company> findAll() {
    return companyDao.findAll();
  }

  @Override
  public Company findCompanyByName(Company company) {
    return companyDao.findCompanyByName(company);
  }

  @Override
  public void deleteCompany(Company company) {
    companyDao.deleteCompany(company);
  }

  @Override
  public Company findCompanyById(Company company) {
    return companyDao.findCompanyByID(company);
  }

  public CompanyDao getCompanyDao() {
    return companyDao;
  }

  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

}
