<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>收查简历</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/company/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/company/contentHeight.css" rel="stylesheet">
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
                    <li><a href="listJob.action">职位管理</a></li>
                    <li class="active"><a href="listDelivery.action">收查简历</a></li>
                    <li><a href="editCompany.action">修改公司信息</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="addJob.action"><span class="glyphicon glyphicon-file" aria-hidden="true" style="margin: 0 5px;"></span>增加职位</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <h3 class="sub-header">我收到的投递简历</h3>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>应聘职位</th>
                            <th>申请人</th>
                            <th>申请简历</th>
                            <th>申请时间</th>
                            <th>回绝该申请</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${null == deliveryList[0]}">
                            <tr>
                                <td></td>
                                <td>还没有收到任何简历！</td>
                            </tr>
                        </c:if>
                        <c:if test="${not empty deliveryList && not empty page}">
                            <c:forEach var="deliveryitem" items="${deliveryList}" varStatus="status" begin="${page.firstResult}" end="${page.lastResult}">
                                <tr <c:if test="${deliveryitem.state eq '待查看'}">style="font-weight:bold;"</c:if> >
                                    <td><a href="viewJob.action?id=${deliveryitem.job.id}" target="_blank">${deliveryitem.jobname}</a></td>
                                    <td>${deliveryitem.jobseekername}</td>
                                    <td><a href="viewDelivery.action?id=${deliveryitem.id}" target="_blank">${deliveryitem.resumename}</a></td>
                                    <td>${deliveryitem.credate}</td>
                                    <td><a href="#" id="refuseDelivery.action?id=${deliveryitem.id}" class="deleteButton" data-toggle="modal" data-target="#deleteDialog"><span class="glyphicon glyphicon-remove" aria-hidden="true" style="margin-left: 5px;"></span></a></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                    <c:if test="${not empty deliveryList && not empty page}">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <c:forEach var="s" begin="0" end="${page.maxPage-1}" varStatus="status">
                               <c:if test="${status.index+1 == page.pageNum}">
                               <li class="active"><a href="listDelivery.action?pagenum=${status.index+1}">${status.index+1}</a></li>
                               </c:if>
                               <c:if test="${status.index+1 ne page.pageNum}">
                               <li><a href="listDelivery.action?pagenum=${status.index+1}">${status.index+1}</a></li>
                               </c:if>
                            </c:forEach>
                            <li>
                              <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteDialog" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确定回绝</h4>
            </div>
            <div class="modal-body">
                <p>确定回绝这个申请？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a type="button" class="btn btn-danger" id="confirmdelete">确定</a>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script>
    $(function(){
        $('.deleteButton').click(function(){
            /*$(this).attr('id') 根据id判断刚点击的是哪个按钮*/
            var deleteaction = $(this).attr('id');
            $('#confirmdelete').attr('href',deleteaction);
        });
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