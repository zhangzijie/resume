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
    <link href="${pageContext.request.contextPath}/css/jobseeker/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/viewJob.css" rel="stylesheet">
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
                    <li><a href="listDelivery.action">投递记录</a></li>
                    <li class="active"><a href="searchpageJob.action">职位搜索</a></li>
                    <li><a href="latestJob.action">最新招聘</a></li>
                    <li><a href="editJobseeker.action">修改个人信息</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="addResume.action"><span class="glyphicon glyphicon-file" aria-hidden="true" style="margin: 0 5px;"></span>增加简历</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <div class="job-header row">
                    <div class="col-sm-6 col-md-6">
                        <h3>${job.jobname}</h3>
                        <h4>${job.companyname}</h4>
                    </div>
                    <div class="col-sm-4 col-md-4">
                        <a href="#" class="btn btn-warning apply" data-toggle="modal" data-target="#deliverDialog">申请职位</a>
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

<div class="modal fade" id="deliverDialog" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确认投递</h4>
            </div>
            <form action="addDelivery" method="post">
            <div class="modal-body">
                <p>请选择要投递的简历：</p>
                <input type="hidden" name="jobid" value="${job.id}">
                <c:if test="${null != resumeList}">
	                <select class="form-control" name="resumeid" required>
	                <c:forEach var="resumeitem" items="${resumeList}">
	                    <option value="${resumeitem.id}">${resumeitem.resumename}</option>
	                </c:forEach>
	                </select>
                </c:if>
                <c:if test="${null == resumeList || null == resumeList[0]}">
                    <p>你还没有简历，请先创建简历！</p>
                    <script>
                        $(function(){
                        	$('#deliver').css("display","none");
                        });
                    </script>
                </c:if>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" id="deliver">投递</button>
            </div>
            </form>
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
                <h4 class="modal-title" style="color:#dd0000; font-weight:bold;">失败</h4>
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