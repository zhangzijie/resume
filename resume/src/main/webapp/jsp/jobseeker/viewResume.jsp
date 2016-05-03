<!DOCTYPE html><!--[if lte IE 8]>
<html lang="zh-CN" class="lte-ie8">
<![endif]-->
<!--[if gt IE 8]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<meta charset="utf-8">
    <title>查看简历</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jobseeker/viewResume.css">
</head>
<body><!--[if lte IE 8]>
<div class="lte-ie8-comment-wrapper"><p class="lte-ie8-comment">你正在使用 IE8 或更老的古董浏览器，还是快升级或者换浏览器吧~</p></div><![endif]-->
<div class="container">
    <main>
        <header class="row">
            <section class="title">
                <h1>${resume.fullname}</h1>
                <h2>${resume.jobintension}</h2>
            </section>
            <address>
                <ul class="contact">
                    <li class="contact-sex">性别：${resume.sex}</li>
                    <li class="contact-birthday">出生日期：${resume.birthday}</li>
                    <li class="contact-idnumber">身份证号：${resume.idnumber}</li>
                    <li class="contact-phone">手机号码：${resume.phone}</li>
                    <li class="contact-email">电子邮箱：${resume.email}</li>
                    <li class="contact-workyear">工作年限：${resume.workyear}</li>
                    <li class="contact-city">居住城市：${resume.city}</li>
                </ul>
            </address>
        </header>
        <article class="content row">
            <!--
            <div class="column-2 column"></div>
            -->
            <article class="column-8 column center">
                <section class="education">
                    <div class="sec-title-wrapper"><h3 class="sec-title"><span class="sec-title-ch">教育经历</span><span
                            class="sec-title-en">Education</span></h3></div>
                    <div class="timeline-wrapper">
                        <ul class="sec-content timeline">
                            <li class="timeline-item education-undergraduate">
                                <h3 class="timeline-title">
                                    <time class="education-time">${resume.studystartdate} ~ ${resume.studyenddate}</time>
                                </h3>
                                <dl class="education-description timeline-content">
                                    <dt class="education-name">${resume.school}</dt>
                                    <dd class="education-major">专业：${resume.major}</dd>
                                    <dd class="education-major">学历：${resume.degree}</dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </section>

                <section class="experience">
                    <div class="sec-title-wrapper"><h3 class="sec-title"><span class="sec-title-ch">工作/实习经历</span><span
                            class="sec-title-en">Experience</span></h3></div>
                    <div class="timeline-wrapper">
                        <ul class="sec-content timeline">
                            <li class="timeline-item experience-internship">
                                <h3 class="timeline-title"><span class="experience-place">${resume.company}</span>
                                    <time class="experience-time">${resume.workstartdate} ~ ${resume.workenddate}</time>
                                </h3>
                                <dl class="experience-description timeline-content">
                                    <dt class="experience-position">职位：${resume.jobname}</dt>
                                    <dd class="contentarea" id="workdesc">工作描述：${resume.workdesc}</dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </section>

                <section class="skills">
                    <div class="sec-title-wrapper"><h3 class="sec-title"><span class="sec-title-ch">技能/奖励</span><span
                            class="sec-title-en">Skill Awards</span></h3></div>
                    <div class="timeline-wrapper">
                        <ul class="sec-content timeline">
                            <li>
                                <h3 class="timeline-title"></h3>
                                <dl class=" timeline-content">
                                    <dt class="experience-position"></dt>
                                    <dd class="experience-task" id="skill">专业技能：<br/>${resume.skill}</dd>
                                    <dd class="experience-task">英语等级：${resume.englishlevel}</dd>
                                    <dd class="experience-task">其他语言能力：${resume.otherlang}</dd>
                                    <dd class="experience-task">专业资格证书：${resume.certificate}</dd>
                                    <dd class="education-honor" id="awards">受到奖励：<br/>${resume.awards}</dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </section>
                <section class="language">
                    <div class="sec-title-wrapper"><h3 class="sec-title"><span class="sec-title-ch">自我评价</span><span
                            class="sec-title-en">Self-evaluation</span></h3></div>
                    <div class="timeline-wrapper">
                        <ul class="sec-content timeline">
                            <li>
                                <h3 class="timeline-title"></h3>
                                <dl class=" timeline-content">
                                    <dt class="experience-position"></dt>
                                    <dd class="contentarea" id="evaluation">${resume.evaluation}</dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </section>
            </article>
            <div class="column-2 column"></div>
        </article>
    </main>
</div>
<footer>
    <p></p>
</footer>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
    $(function(){
        var element;
        var str;
        
        element = $('#workdesc');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);
        
        element = $('#skill');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);

        element = $('#awards');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);
        
        element = $('#evaluation');
        str =  element.text().replace(/\n/g,'<br/>');
        element.html(str);
    });
</script>
</body>
</html>