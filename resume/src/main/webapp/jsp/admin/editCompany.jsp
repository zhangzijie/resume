<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改招聘单位信息</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/admin/style.css" rel="stylesheet">
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
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home" aria-hidden="true" style="margin-right: 5px;"></span>求职招聘系统</a>
            <a class="navbar-brand" href="#" id="showname" style="margin-left: 50px;"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin-right: 5px;"></span>管理员，您好！</a>
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
                    <li><a href="listJobseeker.action">求职者管理</a></li>
                    <li class="active"><a href="listCompany.action">招聘单位管理</a></li>
                    <li><a href="editAdmin.action">修改管理员密码</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="#companyname"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin: 0 5px;"></span>公司信息</a></li>
                    <li><a href="#description"><span class="glyphicon glyphicon-book" aria-hidden="true" style="margin: 0 5px;"></span>公司描述</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <form class="form-horizontal" id="company-form" action="updateCompany" method="post">
                    <h3 class="sub-header">修改招聘单位信息</h3>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control" id="password" name="password" placeholder="不输入不修改">
                        </div>
                    </div>
                    <a name="companyname"></a>
                    <legend>公司信息<span style="color: red;">*</span></legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="companyname" name="companyname" value="${companyitem.companyname}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系人姓名</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="linkman" name="linkman" value="${companyitem.linkman}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="phone" name="phone" value="${companyitem.phone}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电子邮箱</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="email" name="email" value="${companyitem.email}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司地址</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="address" name="address" value="${companyitem.address}" required>
                        </div>
                    </div>
                    
                    <a name="description"></a>
                    <legend>公司描述</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司简介</label>
                        <div class="col-sm-5">
                            <textarea rows="5" cols="30" class="form-control" id="description" name="description">${companyitem.description}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">福利待遇</label>
                        <div class="col-sm-5">
                            <textarea rows="5" cols="30" class="form-control" id="welfare" name="welfare">${companyitem.welfare}</textarea>
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