package com.zhangzj.resume.service;

import com.zhangzj.resume.entity.Admin;

public interface AdminService {
  public Admin login(Admin admin);
  public void updateAdmin(Admin admin, String password);
  public Admin findAdminById(Admin admin);
}
