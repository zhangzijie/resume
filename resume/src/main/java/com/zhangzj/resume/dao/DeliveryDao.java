package com.zhangzj.resume.dao;

import java.util.List;

import com.zhangzj.resume.entity.Delivery;

public interface DeliveryDao {
  public void addDelivery(Delivery delivery);
  public void updateDelivery(Delivery delivery);
  public void deleteDelivery(Delivery delivery);
  public Delivery findDeliveryById(Delivery delivery);
  public List<Delivery> findDeliveryByProperty(String key, Object value);
  public List<Delivery> findDeliveryByPropertyOrderBy(String key, Object value, String orderByProp, String orderByValue);
}
