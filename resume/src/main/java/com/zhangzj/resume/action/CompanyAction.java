package com.zhangzj.resume.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.service.CompanyService;
import com.zhangzj.resume.util.Page;

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
  private String pagenum;
  
  public String editCompany() {
    try {
      if (null != ActionContext.getContext().getApplication().get("company")) {
        return "editCompany";
      } else if (null != ActionContext.getContext().getApplication().get("admin")) {
        Company company = new Company();
        company.setId(this.getId());
        company = companyService.findCompanyById(company);
        ServletActionContext.getRequest().setAttribute("companyitem", company);
        return "adminEditCompany";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "编辑求职者信息失败");
        return INPUT;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "编辑求职者信息失败");
      return ERROR;
    }
  }
  
  public String updateCompany() {
    try {
      if (null != ActionContext.getContext().getApplication().get("company")) {
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
      } else if (null != ActionContext.getContext().getApplication().get("admin")) {
        Company company = new Company();
        company.setId(id);
        company = companyService.findCompanyById(company);
        company.setCompanyname(this.getCompanyname());
        company.setLinkman(this.getLinkman());
        company.setPhone(this.getPhone());
        company.setEmail(this.getEmail());
        company.setAddress(this.getAddress());
        company.setDescription(this.getDescription());
        company.setWelfare(this.getWelfare());
        companyService.updateCompany(company, this.getPassword());
        return "listCompany";
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "保存求职者信息失败");
        return INPUT;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存求职者信息失败");
      return ERROR;
    }
  }
  
  @SuppressWarnings("unchecked")
  public String listCompany() {
    try {
      if (null == this.getPagenum() || "".equals(this.getPagenum())) {
        List<Company> companyList= companyService.findAll();
        Page page = new Page(1,companyList.size());
        ActionContext.getContext().getSession().put("companyList", companyList);
        ServletActionContext.getRequest().setAttribute("page", page);
      } else {
        Page page = new Page(Integer.parseInt(this.getPagenum()), ((List<Company>)ActionContext.getContext().getSession().get("companyList")).size());
        ServletActionContext.getRequest().setAttribute("page", page);
      }
      return "adminSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看求职者列表失败");
      return "adminError";
    }
  }
  
  public String searchCompany() {
    try {
      if (null == this.getUsername() || "".equals(this.getUsername())) {
        List<Company> companyList= companyService.findAll();
        Page page = new Page(1,companyList.size());
        ActionContext.getContext().getSession().put("companyList", companyList);
        ServletActionContext.getRequest().setAttribute("page", page);
      } else {
        Company company = new Company();
        company.setUsername(this.getUsername());
        company = companyService.findCompanyByName(company);
        List<Company> companyList = new ArrayList<Company>();
        companyList.add(company);
        Page page = new Page(1,companyList.size());
        ActionContext.getContext().getSession().put("companyList", companyList);
        ServletActionContext.getRequest().setAttribute("page", page);
      }
      return "adminSuccess";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "搜索求职者失败");
      return "adminError";
    }
  }
  
  public String deleteCompany() {
    try {
      Company company = new Company();
      company.setId(this.getId());
      company = companyService.findCompanyById(company);
      companyService.deleteCompany(company);
      return "listCompany";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "删除求职者失败");
      return "adminError";
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

  public String getPagenum() {
    return pagenum;
  }

  public void setPagenum(String pagenum) {
    this.pagenum = pagenum;
  }
  
}
