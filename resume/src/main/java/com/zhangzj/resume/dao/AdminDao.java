package com.zhangzj.resume.dao;

import com.zhangzj.resume.entity.Admin;

public interface AdminDao {
  public void addAdmin(Admin admin);
  public void deleteAdmin(Admin admin);
  public void updateAdmin(Admin admin);
  public Admin findAdminById(Admin admin);
  public Admin findAdminByName(Admin admin);
}
