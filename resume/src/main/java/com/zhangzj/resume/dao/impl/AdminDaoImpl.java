package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.AdminDao;
import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.entity.Admin;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

  @Override
  public void addAdmin(Admin admin) {
    this.save(admin);
  }

  @Override
  public void deleteAdmin(Admin admin) {
    this.delete(admin);
  }

  @Override
  public void updateAdmin(Admin admin) {
    this.update(admin);
  }

  @Override
  public Admin findAdminById(Admin admin) {
    return this.findById(Admin.class, admin.getId());
  }

  @Override
  public Admin findAdminByName(Admin admin) {
    List<Admin> list = this.findByProperty(Admin.class, "username", admin.getUsername());
    if (list.size() == 1) {
      return list.get(0);
    } else {
      try {
        throw new Exception("can not find Admin by username.");
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
  }
}
