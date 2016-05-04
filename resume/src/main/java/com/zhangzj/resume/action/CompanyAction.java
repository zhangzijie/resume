package com.zhangzj.resume.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.service.CompanyService;

@SuppressWarnings("serial")
public class CompanyAction extends ActionSupport {
  private CompanyService companyService;
  private int id;
  private String username;
  private String password;
  private String companyname;
  private String linkman;
  private String phone;
  private String email;
  private String address;
  private String description;
  private String welfare;
  
  public String editCompany() {
    return "editCompany";
  }
  
  public String updateCompany() {
    try {
      Company company = (Company) ActionContext.getContext().getApplication().get("company");
      company.setCompanyname(this.getCompanyname());
      company.setLinkman(this.getLinkman());
      company.setPhone(this.getPhone());
      company.setEmail(this.getEmail());
      company.setAddress(this.getAddress());
      company.setDescription(this.getDescription());
      company.setWelfare(this.getWelfare());
      companyService.updateCompany(company, this.getPassword());
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存公司信息失败");
      return ERROR;
    }
  }

  public CompanyService getCompanyService() {
    return companyService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public String getLinkman() {
    return linkman;
  }

  public void setLinkman(String linkman) {
    this.linkman = linkman;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getWelfare() {
    return welfare;
  }

  public void setWelfare(String welfare) {
    this.welfare = welfare;
  }
  
}
