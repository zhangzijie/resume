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
    <link href="${pageContext.request.contextPath}/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jobseeker/editResume.css" rel="stylesheet">
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
                    <li><a href="#baseinfo"><span class="glyphicon glyphicon-user" aria-hidden="true" style="margin: 0 5px;"></span>个人信息</a></li>
                    <li><a href="#studyexp"><span class="glyphicon glyphicon-book" aria-hidden="true" style="margin: 0 5px;"></span>教育经历</a></li>
                    <li><a href="#workexp"><span class="glyphicon glyphicon-briefcase" aria-hidden="true" style="margin: 0 5px;"></span>工作/实习经历</a></li>
                    <li><a href="#skillaward"><span class="glyphicon glyphicon-wrench" aria-hidden="true" style="margin: 0 5px;"></span>技能/奖励</a></li>
                    <li><a href="#selfevaluation"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="margin: 0 5px;"></span>自我评价</a></li>
                    <li><a href="#attachment"><span class="glyphicon glyphicon-folder-open" aria-hidden="true" style="margin: 0 5px;"></span>附件</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-md-10">
                <form class="form-horizontal" id="resume-form" action="updateResume" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">简历名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="resumename" name="resumename" required>
                        </div>
                    </div>

                    <legend><a name="baseinfo"></a>个人信息<span style="color: red;">*</span></legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="fullname" name="fullname" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="sex" name="sex" required>
                                <option>请选择</option>
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-5">
                            <input class="form-control" type="text" id="birthday" name="birthday" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="idnumber" name="idnumber" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="phone" name="phone" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电子邮箱</label>
                        <div class="col-sm-5">
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">工作年限</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="workyear" name="workyear" required>
                                <option>请选择</option>
                                <option>在读学生</option>
                                <option>应届毕业生</option>
                                <option>1年</option>
                                <option>2年</option>
                                <option>3-5年</option>
                                <option>5-10年</option>
                                <option>10年以上</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">居住城市</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="city" name="city" required>
                        </div>
                    </div>

                    <legend><a name="studyexp"></a>教育经历</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">开始时间</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="studystartdate" name="studystartdate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">结束时间</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="studyenddate" name="studyenddate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学校</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="school" name="school">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">专业</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="major" name="major">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学历</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="degree" name="degree">
                                <option>请选择</option>
                                <option>高中</option>
                                <option>中专/技校</option>
                                <option>大专</option>
                                <option>本科</option>
                                <option>硕士</option>
                                <option>博士</option>
                            </select>
                        </div>
                    </div>
<!--
                    <div class="form-group">
                        <ul class="list-inline">
                            <li class="col-sm-offset-3">
                                <a class="btn btn-primary" id="submit-studyexp">保存</a>
                                <a class="btn btn-danger" id="delete-studyexp">删除</a>
                                <a class="btn" id="add-studyexp"><span class="glyphicon glyphicon-plus" aria-hidden="true" style="margin-right: 5px;"></span>继续增加</a>
                            </li>
                        </ul>
                    </div>
-->
                    <legend><a name="workexp"></a>工作经历/实习经历</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">开始时间</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="workstartdate" name="workstartdate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">结束时间</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="workenddate" name="workenddate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="company" name="company">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="jobname" name="jobname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">工作描述</label>
                        <div class="col-sm-5">
                            <textarea rows="3" cols="20" class="form-control" id="workdesc" name="workdesc"></textarea>
                        </div>
                    </div>

                    <legend><a name="skillaward"></a>技能/奖励</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">英语等级</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="englishlevel" name="englishlevel">
                                <option>请选择</option>
                                <option>无</option>
                                <option>英语四级</option>
                                <option>英语六级</option>
                                <option>专业四级</option>
                                <option>专业八级</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">其他语言能力</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="otherlang" name="otherlang">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">专业资格证书</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="certificate" name="certificate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">受到奖励</label>
                        <div class="col-sm-5">
                            <textarea rows="3" cols="20" class="form-control" id="awards" name="awards"></textarea>
                        </div>
                    </div>

                    <legend><a name="selfevaluation"></a>自我评价</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">自我评价</label>
                        <div class="col-sm-5">
                            <textarea rows="3" cols="20" class="form-control" id="evaluation" name="evaluation"></textarea>
                        </div>
                    </div>

                    <legend><a name="attachment"></a>附件</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">照片</label>
                        <div class="col-sm-5">
                            <input type="file" id="photo" name="photo">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">简历附件</label>
                        <div class="col-sm-5">
                            <input type="file" id="resumedoc" name="resumedoc">
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
<script src="${pageContext.request.contextPath}/js/jobseeker/editResume.js"></script>

</body>
</html>