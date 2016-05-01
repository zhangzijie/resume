<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	   pageEncoding="UTF-8"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>简历管理</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/resumeList.css" rel="stylesheet">
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
                <li><a href="${pageContext.request.contextPath}">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="content">
        <div class="row">
            <div class="col-sm-3 col-md-2">
                <ul class="nav nav-sidebar" style="margin-top: 20px;">
                    <li class="active"><a href="#">简历管理</a></li>
                    <li><a href="#">职位搜索</a></li>
                    <li><a href="#">最新招聘</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="${pageContext.request.contextPath}/addResume.action"><span class="glyphicon glyphicon-file" aria-hidden="true" style="margin: 0 5px;"></span>增加简历</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <h3 class="sub-header">我的简历</h3>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>简历名称</th>
                            <th>修改</th>
                            <th>预览</th>
                            <th>复制</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>XXX个人简历</td>
                            <td><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="margin-left: 5px;"></span></td>
                            <td><span class="glyphicon glyphicon-eye-open" aria-hidden="true" style="margin-left: 5px;"></span></td>
                            <td><span class="glyphicon glyphicon-paste" aria-hidden="true" style="margin-left: 5px;"></span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/jobseeker/resumeList.js"></script>

</body>
</html>