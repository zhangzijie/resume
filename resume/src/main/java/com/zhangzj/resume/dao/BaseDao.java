package com.zhangzj.resume.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao<T, ID extends Serializable> extends HibernateDaoSupport {
  /**
   * 获取所有实体集合
   * @param entityClass
   * @return
   */
  public List<T> findAll(Class<T> entityClass) {
    try {
      return (List<T>) this.getHibernateTemplate().find("from" + entityClass.getName());
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 查找指定ID实体类对象
   * @param entityClass
   * @param id
   * @return
   */
  public T findById(Class<T> entityClass, ID id) {
    try {
      return this.getHibernateTemplate().get(entityClass, id);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 查找指定HQL，并返回集合
   * @param hql
   * @param values
   * @return
   */
  public List<Object> find(String hql, Object... values) {
    try {
      return (List<Object>) this.getHibernateTemplate().find(hql, values);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 保存指定实体
   * @param entity
   */
  public void save(T entity) {
    try {
      this.getHibernateTemplate().save(entity);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 删除指定实体
   * @param entity
   */
  public void delete(T entity) {
    try {
      this.getHibernateTemplate().delete(entity);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 更新或保存指定实体
   * @param entity
   */
  public void saveOrUpdate(T entity) {
    try {
      this.getHibernateTemplate().saveOrUpdate(entity);
    } catch (RuntimeException e) {
      throw e;
    }
  }
}
