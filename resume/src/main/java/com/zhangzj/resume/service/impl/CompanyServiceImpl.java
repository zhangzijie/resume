package com.zhangzj.resume.service.impl;

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

  public CompanyDao getCompanyDao() {
    return companyDao;
  }

  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

}
