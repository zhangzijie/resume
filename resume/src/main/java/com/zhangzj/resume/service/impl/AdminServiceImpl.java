package com.zhangzj.resume.service.impl;

import com.zhangzj.resume.dao.AdminDao;
import com.zhangzj.resume.entity.Admin;
import com.zhangzj.resume.service.AdminService;
import com.zhangzj.resume.util.MakeMD5;

public class AdminServiceImpl implements AdminService {
  private AdminDao adminDao;

  @Override
  public Admin login(Admin admin) {
    String password = MakeMD5.makeMD5(admin.getPassword());
    admin = adminDao.findAdminByName(admin);
    if (admin.getPassword().equals(password)) {
      return admin;
    } else {
      return null;
    }
  }

  @Override
  public void updateAdmin(Admin admin, String password) {
    if(null == password || "".equals(password)) {
      adminDao.updateAdmin(admin);
    } else {
      admin.setPassword(MakeMD5.makeMD5(password));
      adminDao.updateAdmin(admin);
    }
  }

  @Override
  public Admin findAdminById(Admin admin) {
    return adminDao.findAdminById(admin);
  }

  public AdminDao getAdminDao() {
    return adminDao;
  }

  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

}
