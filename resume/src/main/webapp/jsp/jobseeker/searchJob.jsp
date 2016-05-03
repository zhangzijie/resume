<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>职位搜索</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/searchJob.css" rel="stylesheet">
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
            <a class="navbar-brand" href="#" id="showname" style="margin-left: 50px;"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin-right: 5px;"></span>${jobseeker.fullname}，您好！</a>
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
                    <li><a href="listResume.action">简历管理</a></li>
                    <li class="active"><a href="searchJob.action">职位搜索</a></li>
                    <li><a href="latestJob.action">最新招聘</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="addResume.action"><span class="glyphicon glyphicon-file" aria-hidden="true" style="margin: 0 5px;"></span>增加简历</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <h3 class="sub-header">职位搜索</h3>
                <div class="table-responsive">
                    <form class="form-inline" id="search-form" action="searchJob" method="post">
                        <input type="text" class="form-control" name="jobname" placeholder="职位名称" required autofocus>
                        <input type="text" class="form-control" name="companyname" placeholder="公司名称">
                        <input type="text" class="form-control" name="address" placeholder="工作地点">
                        <button id="search-button" class="btn btn-primary" type="submit">搜索</button>
                    </form>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>职位名称</th>
                            <th>公司名称</th>
                            <th>月薪</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${null == jobList[0]}">
                            <tr>
                                <td>没有符合的职位！</td>
                            </tr>
                        </c:if>
                        <c:if test="${null != jobList}">
                            <c:forEach var="jobitem" items="${jobList}" varStatus="status">
                                <tr>
                                    <td><a href="viewJob.action?id=${jobitem.id}" target="_blank">${jobitem.jobname}</a></td>
                                    <td>${jobitem.companyname}</td>
                                    <td>${jobitem.salary}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>