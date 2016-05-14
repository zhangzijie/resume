package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.CompanyDao;
import com.zhangzj.resume.entity.Company;

public class CompanyDaoImpl extends BaseDao<Company> implements CompanyDao {

  @Override
  public void addCompany(Company company) {
    this.save(company);
  }

  @Override
  public void updateCompany(Company company) {
    this.update(company);
  }

  @Override
  public void deleteCompany(Company company) {
    this.delete(company);
  }
  
  @Override
  public Company findCompanyByID(Company company) {
    return this.findById(Company.class, company.getId());
  }

  @Override
  public Company findCompanyByName(Company company) {
    List<Company> list = this.findByProperty(Company.class, "username", company.getUsername());
    if (list.size() == 1) {
      return list.get(0);
    } else {
      System.err.println("can not find Company by username, cos no result.");
      return null;
    }
  }

  @Override
  public List<Company> findAll() {
    return this.findAll(Company.class);
  }
  
}
