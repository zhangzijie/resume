<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>求职简历管理系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/index/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
      <div class="center">
        <h1>求职简历管理系统</h1>
        <div class="header">
          <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_signin" href="javascript:void(0);">登录</a>
            <a class="switch_btn" id="switch_signup" href="javascript:void(0);">注册</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 36px; left: 0px;"></div>
          </div>
        </div>
        <form class="form" id="form_login" action="login" method="post">
          <input type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
          <input type="password" class="form-control" name="password" placeholder="密码" required>
          <div class="radiogroup">
            <span><input type="radio" name="role" value="jobseeker">求职者</span>
            <span><input type="radio" name="role" value="company">招聘单位</span>
            <span><input type="radio" name="role" value="admin">管理员</span>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
        <form class="form" id="form_signup" action="signup" method="post" style="display:none;">
          <input type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
          <input type="password" class="form-control" name="password" placeholder="密码" required>
          <div id="jobseeker-info">
            <input type="text" class="form-control" name="fullname" placeholder="真实姓名">
            <input type="text" class="form-control" name="phonej" placeholder="联系电话">
            <input type="email" class="form-control" name="emailj" placeholder="电子邮箱">
          </div>
          <div id="company-info">
            <input type="text" class="form-control" name="companyname" placeholder="公司名">
            <input type="text" class="form-control" name="linkman" placeholder="联系人姓名">
            <input type="text" class="form-control" name="phonec" placeholder="联系电话">
            <input type="email" class="form-control" name="emailc" placeholder="电子邮箱">
            <input type="text" class="form-control" name="address" placeholder="地址">
          </div>
          <div class="radiogroup">
            <span><input type="radio" name="role" value="jobseeker" id="jobseeker-radio" required>求职者</span>
            <span><input type="radio" name="role" value="company" id="company-radio" required>招聘单位</span>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        </form>
      </div>
    </div>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/index/index.js"></script>
    
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