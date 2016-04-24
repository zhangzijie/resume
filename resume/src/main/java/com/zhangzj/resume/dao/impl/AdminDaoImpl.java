package com.zhangzj.resume.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.zhangzj.resume.dao.AdminDao;
import com.zhangzj.resume.entity.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

  public void addAdmin(Admin admin) {
    this.getHibernateTemplate().save(admin);
  }

}
