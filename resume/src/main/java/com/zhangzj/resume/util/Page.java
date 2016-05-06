package com.zhangzj.resume.util;

public class Page {
  private int pageNum;
  private int pageSize = 10;
  private int total;
  private int maxPage;
  private int firstResult;
  private int lastResult;
  
  public Page(int pageNum, int total) {
    this.setPageNum(pageNum);
    this.setTotal(total);
    this.setFirstResult(this.getPageNum()*this.getPageSize()-this.getPageSize()+1);
    this.setLastResult(this.getFirstResult()+this.getPageSize()-1);
    this.setMaxPage((new Double(Math.ceil((double)this.getTotal()/(double)this.getPageSize()))).intValue());
  }
  
  public Page(int pageNum, int total, int pageSize) {
    this.setPageNum(pageNum);
    this.setTotal(total);
    this.setPageSize(pageSize);
    this.setFirstResult(this.getPageNum()*this.getPageSize()-this.getPageSize()+1);
    this.setLastResult(this.getFirstResult()+this.getPageSize()-1);
    this.setMaxPage((new Double(Math.ceil((double)this.getTotal()/(double)this.getPageSize()))).intValue());
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getMaxPage() {
    return maxPage;
  }

  public void setMaxPage(int maxPage) {
    this.maxPage = maxPage;
  }

  public int getFirstResult() {
    return firstResult;
  }

  public void setFirstResult(int firstResult) {
    this.firstResult = firstResult;
  }

  public int getLastResult() {
    return lastResult;
  }

  public void setLastResult(int lastResult) {
    this.lastResult = lastResult;
  }

}
