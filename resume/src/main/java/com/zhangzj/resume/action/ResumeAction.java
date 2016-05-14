package com.zhangzj.resume.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangzj.resume.entity.Jobseeker;
import com.zhangzj.resume.entity.Resume;
import com.zhangzj.resume.service.ResumeService;
import com.zhangzj.resume.util.FileUpload;

@SuppressWarnings("serial")
public class ResumeAction extends ActionSupport {
  private ResumeService resumeService;
  private int id;
  private String resumename;
  private String fullname;
  private String sex;
  private String birthday;
  private String idnumber;
  private String phone;
  private String email;
  private String workyear;
  private String city;
  private String jobintension;
  private String studystartdate;
  private String studyenddate;
  private String school;
  private String major;
  private String degree;
  private String workstartdate;
  private String workenddate;
  private String company;
  private String jobname;
  private String workdesc;
  private String skill;
  private String englishlevel;
  private String otherlang;
  private String certificate;
  private String awards;
  private String evaluation;
  private File photo;
  private String photoFileName;
  private String photoContentType;
  private File resumedoc;
  private String resumedocFileName;
  private String resumedocContentType;
  
  public String addResume() {
    try {
      ActionContext.getContext().getSession().put("addflag", "true");
      return "editResume";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "创建简历失败");
      return ERROR;
    }
  }
  
  public String editResume() {
    try {
      Resume resume = new Resume();
      resume.setId(this.getId());
      resume = resumeService.findResumeById(resume);
      ServletActionContext.getRequest().setAttribute("resume", resume);
      ActionContext.getContext().getSession().put("addflag", "false");
      return "editResume";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "编辑简历失败");
      return ERROR;
    }
  }
  
  public String viewResume() {
    try {
      Resume resume = new Resume();
      if(null != ServletActionContext.getRequest().getAttribute("resumeid")) {
        resume.setId((int) ServletActionContext.getRequest().getAttribute("resumeid"));
      } else {
        resume.setId(this.getId());
      }
      resume = resumeService.findResumeById(resume);
      ServletActionContext.getRequest().setAttribute("resume", resume);
      return "viewResume";
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "查看简历失败");
      return ERROR;
    }
  }
  
  public String updateResume() {
    try {
      if (null != ActionContext.getContext().getSession().get("addflag") && "true".equals((String)ActionContext.getContext().getSession().get("addflag"))) {
        Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
        Resume resume = new Resume();
        resume.setJobseeker(jobseeker);
        resume.setResumename(this.getResumename());
        resume.setFullname(this.getFullname());
        resume.setSex(this.getSex());
        resume.setBirthday(this.getBirthday());
        resume.setIdnumber(this.getIdnumber());
        resume.setPhone(this.getPhone());
        resume.setEmail(this.getEmail());
        resume.setWorkyear(this.getWorkyear());
        resume.setCity(this.getCity());
        resume.setJobintension(this.getJobintension());
        resume.setStudystartdate(this.getStudystartdate());
        resume.setStudyenddate(this.getStudyenddate());
        resume.setSchool(this.getSchool());
        resume.setMajor(this.getMajor());
        resume.setDegree(this.getDegree());
        resume.setWorkstartdate(this.getWorkstartdate());
        resume.setWorkenddate(this.getWorkenddate());
        resume.setCompany(this.getCompany());
        resume.setJobname(this.getJobname());
        resume.setWorkdesc(this.getWorkdesc());
        resume.setSkill(this.getSkill());
        resume.setEnglishlevel(this.getEnglishlevel());
        resume.setOtherlang(this.getOtherlang());
        resume.setCertificate(this.getCertificate());
        resume.setAwards(this.getAwards());
        resume.setEvaluation(this.getEvaluation());
        if(null != this.getPhoto() && this.getPhoto().exists()) {
          resume.setPhoto(FileUpload.Upload(this.getPhoto(), this.getPhotoFileName()));
        }
        if(null != this.getResumedoc() && this.getResumedoc().exists()) {
          resume.setResumedoc(FileUpload.Upload(this.getResumedoc(), this.getResumedocFileName()));
        }
        resumeService.addResume(resume);
        
        ActionContext.getContext().getSession().remove("addflag");
      } else if(null != ActionContext.getContext().getSession().get("addflag") && "false".equals((String)ActionContext.getContext().getSession().get("addflag"))) {
        Resume resume = new Resume();
        resume.setId(this.getId());
        resume = resumeService.findResumeById(resume);
        resume.setResumename(this.getResumename());
        resume.setFullname(this.getFullname());
        resume.setSex(this.getSex());
        resume.setBirthday(this.getBirthday());
        resume.setIdnumber(this.getIdnumber());
        resume.setPhone(this.getPhone());
        resume.setEmail(this.getEmail());
        resume.setWorkyear(this.getWorkyear());
        resume.setCity(this.getCity());
        resume.setJobintension(this.getJobintension());
        resume.setStudystartdate(this.getStudystartdate());
        resume.setStudyenddate(this.getStudyenddate());
        resume.setSchool(this.getSchool());
        resume.setMajor(this.getMajor());
        resume.setDegree(this.getDegree());
        resume.setWorkstartdate(this.getWorkstartdate());
        resume.setWorkenddate(this.getWorkenddate());
        resume.setCompany(this.getCompany());
        resume.setJobname(this.getJobname());
        resume.setWorkdesc(this.getWorkdesc());
        resume.setSkill(this.getSkill());
        resume.setEnglishlevel(this.getEnglishlevel());
        resume.setOtherlang(this.getOtherlang());
        resume.setCertificate(this.getCertificate());
        resume.setAwards(this.getAwards());
        resume.setEvaluation(this.getEvaluation());
        if(null != this.getPhoto() && this.getPhoto().exists()) {
          resume.setPhoto(FileUpload.Upload(this.getPhoto(), this.getPhotoFileName()));
        }
        if(null != this.getResumedoc() && this.getResumedoc().exists()) {
          resume.setResumedoc(FileUpload.Upload(this.getResumedoc(), this.getResumedocFileName()));
        }
        resumeService.updateResume(resume);
      } else {
        ServletActionContext.getRequest().setAttribute("msg", "保存简历失败");
      }
      Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
      ActionContext.getContext().getSession().put("resumeList", resumeService.findResumeByJobseeker(jobseeker));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "保存简历失败");
      return ERROR;
    }
  }

  public String deleteResume() {
    try {
      Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
      Resume resume = new Resume();
      resume.setId(this.getId());
      resumeService.deleteResume(resume);
      ActionContext.getContext().getSession().put("resumeList", resumeService.findResumeByJobseeker(jobseeker));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "删除简历失败");
      return ERROR;
    }
  }
  
  public String listResume() {
    try {
      Jobseeker jobseeker = (Jobseeker) ActionContext.getContext().getApplication().get("jobseeker");
      ActionContext.getContext().getSession().put("resumeList", resumeService.findResumeByJobseeker(jobseeker));
      return SUCCESS;
    } catch (Exception ex) {
      ex.printStackTrace();
      ServletActionContext.getRequest().setAttribute("msg", "列出简历失败");
      return ERROR;
    }
  }

  public ResumeService getResumeService() {
    return resumeService;
  }

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getResumename() {
    return resumename;
  }

  public void setResumename(String resumename) {
    this.resumename = resumename;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getIdnumber() {
    return idnumber;
  }

  public void setIdnumber(String idnumber) {
    this.idnumber = idnumber;
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

  public String getWorkyear() {
    return workyear;
  }

  public void setWorkyear(String workyear) {
    this.workyear = workyear;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getJobintension() {
    return jobintension;
  }

  public void setJobintension(String jobintension) {
    this.jobintension = jobintension;
  }

  public String getStudystartdate() {
    return studystartdate;
  }

  public void setStudystartdate(String studystartdate) {
    this.studystartdate = studystartdate;
  }

  public String getStudyenddate() {
    return studyenddate;
  }

  public void setStudyenddate(String studyenddate) {
    this.studyenddate = studyenddate;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getWorkstartdate() {
    return workstartdate;
  }

  public void setWorkstartdate(String workstartdate) {
    this.workstartdate = workstartdate;
  }

  public String getWorkenddate() {
    return workenddate;
  }

  public void setWorkenddate(String workenddate) {
    this.workenddate = workenddate;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname;
  }

  public String getWorkdesc() {
    return workdesc;
  }

  public void setWorkdesc(String workdesc) {
    this.workdesc = workdesc;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  public String getEnglishlevel() {
    return englishlevel;
  }

  public void setEnglishlevel(String englishlevel) {
    this.englishlevel = englishlevel;
  }

  public String getOtherlang() {
    return otherlang;
  }

  public void setOtherlang(String otherlang) {
    this.otherlang = otherlang;
  }

  public String getCertificate() {
    return certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
  }

  public File getPhoto() {
    return photo;
  }

  public void setPhoto(File photo) {
    this.photo = photo;
  }

  public String getPhotoFileName() {
    return photoFileName;
  }

  public void setPhotoFileName(String photoFileName) {
    this.photoFileName = photoFileName;
  }

  public File getResumedoc() {
    return resumedoc;
  }

  public void setResumedoc(File resumedoc) {
    this.resumedoc = resumedoc;
  }

  public String getResumedocFileName() {
    return resumedocFileName;
  }

  public void setResumedocFileName(String resumedocFileName) {
    this.resumedocFileName = resumedocFileName;
  }

  public String getPhotoContentType() {
    return photoContentType;
  }

  public void setPhotoContentType(String photoContentType) {
    this.photoContentType = photoContentType;
  }

  public String getResumedocContentType() {
    return resumedocContentType;
  }

  public void setResumedocContentType(String resumedocContentType) {
    this.resumedocContentType = resumedocContentType;
  }
  
}
