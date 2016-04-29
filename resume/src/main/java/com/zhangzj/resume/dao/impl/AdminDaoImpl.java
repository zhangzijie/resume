package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.AdminDao;
import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.entity.Admin;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

  public void addAdmin(Admin admin) {
    this.save(admin);
  }

  public void deleteAdmin(Admin admin) {
    
    List<Admin> list = this.findByProperty(Admin.class, "username", admin.getUsername());
    if (list.size() == 1) {
      this.delete(list.get(0));
    }
  }
}
