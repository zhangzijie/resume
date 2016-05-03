package com.zhangzj.resume.entity;

import java.util.Set;

public class Job {
  private int id;
  private String jobname;
  private String credate;
  private String salary;
  private String number;
  private String address;
  private String workyear;
  private String degree;
  private String responsibility;
  private String requirement;
  private String category;
  private String companyname;
  private Company company;
  private Set<Resumetojob> resumetojobSet;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname;
  }

  public String getCredate() {
    return credate;
  }

  public void setCredate(String credate) {
    this.credate = credate;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getWorkyear() {
    return workyear;
  }

  public void setWorkyear(String workyear) {
    this.workyear = workyear;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getResponsibility() {
    return responsibility;
  }

  public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
  }

  public String getRequirement() {
    return requirement;
  }

  public void setRequirement(String requirement) {
    this.requirement = requirement;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }

  public Set<Resumetojob> getResumetojobSet() {
    return resumetojobSet;
  }

  public void setResumetojobSet(Set<Resumetojob> resumetojobSet) {
    this.resumetojobSet = resumetojobSet;
  }
  
}
