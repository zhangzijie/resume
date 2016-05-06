<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看职位</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/company/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/company/viewJob.css" rel="stylesheet">
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
                    <li><a href="listDelivery.action">收查简历</a></li>
                    <li><a href="editCompany.action">修改公司信息</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="#jobinfo"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin: 0 5px;"></span>职位信息</a></li>
                    <li><a href="#description"><span class="glyphicon glyphicon-book" aria-hidden="true" style="margin: 0 5px;"></span>职位描述</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <div class="job-header row">
                    <div class="col-sm-6 col-md-6">
                        <h3>${job.jobname}</h3>
                        <h4>${job.companyname}</h4>
                    </div>
                </div>
                <div class="job-main">
                    <a name="jobinfo"></a>
                    <div class="job-baseinfo row">
                        <ul class="col-sm-4 col-md-4">
                            <li>职位月薪：<span class="salary">${job.salary}</span></li>
                            <li>发布日期：${job.credate}</li>
                            <li>工作经验：${job.workyear}</li>
                        </ul>
                        <ul class="col-sm-4 col-md-4">
                            <li>招聘人数：${job.number}</li>
                            <li>工作地点：${job.address}</li>
                            <li>学历要求：${job.degree}</li>
                        </ul>
                    </div>
                    <a name="description"></a>
                    <div class="job-description row">
                        <ul class="col-sm-12 col-md-12">
                            <li class="sub-title">岗位职责:</li>
                            <li id="responsibility">${job.responsibility}</li>
                            <li class="sub-title">岗位要求:</li>
                            <li id="requirement">${job.requirement}</li>
                            <li class="sub-title">职能类别:</li>
                            <li>${job.category}</li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script>
    $(function(){
        var element;
        var str;
        
        element = $('#responsibility');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);
        
        element = $('#requirement');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);

    });
</script>

<c:if test="${not empty msg}">
<div class="modal fade" id="msgDialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"><span class="label label-warning" style="margin-right:10px;">警告</span>失败信息</h4>
            </div>
            <div class="modal-body">
                <p>${msg}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
<script>
  $(function(){
    $('#msgDialog').modal('show');
  });
</script>
</c:if>

</body>
</html>