package com.zhangzj.resume.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {
  
  public Session getSession() {
    return this.currentSession();
  }
  
  /**
   * 查找指定属性的实体集合
   * @param entityClass
   * @param propertyName
   * @param value
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
    try {
      String queryStr = "from " + entityClass.getName() + " as model where model." + propertyName + "=?";
      return (List<T>) this.getHibernateTemplate().find(queryStr, value);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 获取所有实体集合
   * @param entityClass
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<T> findAll(Class<T> entityClass) {
    try {
      return (List<T>) this.getHibernateTemplate().find("from " + entityClass.getName());
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
  public T findById(Class<T> entityClass, int id) {
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
  @SuppressWarnings("unchecked")
  public List<Object> find(String hql, Object... values) {
    try {
      return (List<Object>) this.getHibernateTemplate().find(hql, values);
    } catch (RuntimeException e) {
      throw e;
    }
  }

  /**
   * 模糊查询指定条件对象集合
   * @param entity
   * @return
   */
  public List<T> findByExample(T entity) {
    try {
      return this.getHibernateTemplate().findByExample(entity);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 模糊查询指定条件对象集合
   * @param criteria
   * @return
   */
  public List<T> findByCriteria(DetachedCriteria criteria){
    try {
      this.getHibernateTemplate().findByCriteria(criteria);
      return null;
    } catch (RuntimeException e) {
      throw e;
    }
  }
  
  /**
   * 模糊查询指定条件对象集合
   * @param criteria
   * @return
   */
  public List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults){
    try {
      this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
      return null;
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
  
  /**
   * 更新指定实体
   * @param entity
   */
  public void update(T entity) {
    try {
      this.getHibernateTemplate().update(entity);
    } catch (RuntimeException e) {
      throw e;
    }
  }
  /**
   * 按照HQL语句查询唯一对象
   * @param hql
   * @return
   */
  public Object findUnique(final String hql) {
    try {
      return this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
        @Override
        public Object doInHibernate(Session session) throws HibernateException {
          Query query = session.createQuery(hql);
          return query.uniqueResult();
        }
      });
    } catch (RuntimeException e) {
      throw e;
    }
  }
}
