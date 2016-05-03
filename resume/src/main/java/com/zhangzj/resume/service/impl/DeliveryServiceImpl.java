package com.zhangzj.resume.service.impl;

import java.util.List;

import com.zhangzj.resume.dao.DeliveryDao;
import com.zhangzj.resume.entity.Company;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Delivery;
import com.zhangzj.resume.service.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {
  private DeliveryDao deliveryDao;
  
  @Override
  public void addDelivery(Delivery delivery) {
    deliveryDao.addDelivery(delivery);
  }

  @Override
  public void updateDelivery(Delivery delivery) {
    deliveryDao.updateDelivery(delivery);
  }

  @Override
  public void deleteDelivery(Delivery delivery) {
    deliveryDao.deleteDelivery(delivery);
  }

  @Override
  public Delivery findDeliveryById(Delivery delivery) {
    return deliveryDao.findDeliveryById(delivery);
  }

  @Override
  public List<Delivery> findDeliveryByProperty(String key, String value) {
    return deliveryDao.findDeliveryByProperty(key, value);
  }

  @Override
  public List<Delivery> findByJobseeker(Jobseeker jobseeker) {
    return deliveryDao.findDeliveryByPropertyOrderBy("jobseekerid", jobseeker.getId(), "id", "desc");
  }

  @Override
  public List<Delivery> findByCompany(Company company) {
    return deliveryDao.findDeliveryByPropertyOrderBy("companyid", company.getId(), "id", "desc");
  }

  public DeliveryDao getDeliveryDao() {
    return deliveryDao;
  }

  public void setDeliveryDao(DeliveryDao deliveryDao) {
    this.deliveryDao = deliveryDao;
  }

}
