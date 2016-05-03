package com.zhangzj.resume.service;

import java.util.List;

import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Delivery;

public interface DeliveryService {
  public void addDelivery(Delivery delivery);
  public void updateDelivery(Delivery delivery);
  public void deleteDelivery(Delivery delivery);
  public Delivery findDeliveryById(Delivery delivery);
  public List<Delivery> findDeliveryByProperty(String key, String value);
  public List<Delivery> findByJobseeker(Jobseeker jobseeker);
  public List<Delivery> findByCompany(Company company);
}
