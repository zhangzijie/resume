package com.zhangzj.resume.dao.impl;

import java.util.List;

import com.zhangzj.resume.dao.BaseDao;
import com.zhangzj.resume.dao.DeliveryDao;
import com.zhangzj.resume.entity.Delivery;

public class DeliveryDaoImpl extends BaseDao<Delivery> implements DeliveryDao {

  @Override
  public void addDelivery(Delivery delivery) {
    this.save(delivery);
  }

  @Override
  public void updateDelivery(Delivery delivery) {
    this.update(delivery);

  }

  @Override
  public void deleteDelivery(Delivery delivery) {
    this.delete(delivery);
  }

  @Override
  public Delivery findDeliveryById(Delivery delivery) {
    return this.findById(Delivery.class, delivery.getId());
  }

  @Override
  public List<Delivery> findDeliveryByProperty(String key, Object value) {
    return this.findByProperty(Delivery.class, key, value);
  }

  @Override
  public List<Delivery> findDeliveryByPropertyOrderBy(String key, Object value,
      String orderByProp, String orderByValue) {
    return this.findByPropertyOrderBy(Delivery.class, key, value, orderByProp, orderByValue);
  }

}
