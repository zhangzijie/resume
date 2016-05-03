<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编辑职位</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/company/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home" aria-hidden="true" style="margin-right: 5px;"></span>求职简历管理系统</a>
            <a class="navbar-brand" href="#" id="showname" style="margin-left: 50px;"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin-right: 5px;"></span>${company.companyname}，您好！</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">帮助</a></li>
                <li><a href="logout.action">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="content">
        <div class="row">
            <div class="col-sm-3 col-md-2">
                <ul class="nav nav-sidebar" style="margin-top: 20px;">
                    <li class="active"><a href="listJob.action">职位管理</a></li>
                    <li><a href="#">简历搜索</a></li>
                    <li><a href="#">最新简历</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="#jobinfo"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin: 0 5px;"></span>职位信息</a></li>
                    <li><a href="#description"><span class="glyphicon glyphicon-book" aria-hidden="true" style="margin: 0 5px;"></span>职位描述</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <form class="form-horizontal" id="job-form" action="updateJob" method="post">
                    <a name="jobinfo"></a>
                    <legend>职位信息<span style="color: red;">*</span></legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="jobname" name="jobname" value="${job.jobname}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位月薪</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="salary" name="salary" value="${job.salary}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">招聘人数</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="number" name="number" value="${job.number}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">工作地点</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="address" name="address" value="${job.address}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">工作经验</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="workyear" name="workyear" required>
                            <c:if test="${null == job.workyear}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                            </c:if>
                            <c:if test="${null != job.workyear}">
                                <c:if test="${job.workyear eq '请选择'}">
                                <option selected="selected">请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '不限'}">
                                <option>请选择</option>
                                <option selected="selected">不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '1年'}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option selected="selected">1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '2年'}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option selected="selected">2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '3-5年'}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option selected="selected">3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '5-10年'}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option selected="selected">5-10年</option>
                                <option>10年以上</option>
                                </c:if>
                                <c:if test="${job.workyear eq '10年以上'}">
                                <option>请选择</option>
                                <option>不限</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option selected="selected">10年以上</option>
                                </c:if>
                            </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学历要求</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="degree" name="degree" required>
                            <c:if test="${null == job.degree}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                            </c:if>
                            <c:if test="${null != job.degree}">
                                <c:if test="${job.degree eq '请选择'}">
                                <option selected="selected">请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '高中'}">
                                <option>请选择</option>
                                <option selected="selected">高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '中专/技校'}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option selected="selected">中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '大专'}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option selected="selected">大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '本科'}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option selected="selected">本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '硕士'}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option selected="selected">硕士</option>
                                <option>博士</option>
                                </c:if>
                                <c:if test="${job.degree eq '博士'}">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option selected="selected">博士</option>
                                </c:if>
                            </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职能类别</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="category" name="category" value="${job.category}">
                        </div>
                    </div>

                    <a name="description"></a>
                    <legend>职位描述<span style="color: red;">*</span></legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">岗位职责</label>
                        <div class="col-sm-5">
                            <textarea rows="5" cols="30" class="form-control" id="responsibility" name="responsibility">${job.responsibility}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">岗位要求</label>
                        <div class="col-sm-5">
                            <textarea rows="5" cols="30" class="form-control" id="requirement" name="requirement">${job.requirement}</textarea>
                        </div>
                    </div>
                    
                    <div class="form-group" style="padding-top: 15px;">
                        <div class="col-sm-offset-2 col-sm-3">
                            <button type="submit" class="btn btn-primary btn-block" id="submit">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>

</body>
</html>