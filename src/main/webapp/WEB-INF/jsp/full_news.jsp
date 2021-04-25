<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.List, by.jd2.p1.task1.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            background-image: linear-gradient(to top, #dfe9f3 0%, white 100%);
        }

        .header {
            min-height: 220px;
            border: 2px double black;
        }
        .header_form{
            border: 2px double black;
            height: 220px;
            width: 250px;
            float: right;
            padding-left: 10px;
        }
        .header_title{
            text-align: center;
            vertical-align: center;
            font-size: 26px;
            border: 2px double black;
            height: 220px;
        }
        .footer {
            min-height: 50px;
            border: 2px double black;
        }

        .content-wrap {
        	padding: 10px;
        	padding-left: 40px;
        	padding-right: 40px;
        	overflow: auto;
            border: 2px double black;
            height: 100%;
        }
        .clear {
            clear: both;
            background-color: darkcyan;
        }
    </style>
</head>
<body>
<div style="border: 4px double black; height: 100vh; display: flex; flex-direction: column; justify-content: space-between;">
    <div class="header">
        <div class="header_form">   
             
         	<c:if test="${sessionScope.auth != null}">
        		<p>Привет 
        			<c:if test="${sessionScope.role eq 'admin'}">
        				администратор
        			</c:if>
        			<c:if test="${sessionScope.role eq 'user'}">
        				пользователь
        			</c:if>
        		<c:out value="${sessionScope.auth}"/></p>
        		
        		
        		<a href="Controller?command=logout">Выйти</a>
				<br />
				<a href="Controller?command=gotoedituser">Редактирование профиля</a>  
        	</c:if>
        	
			<c:if test="${sessionScope.auth == null}">
				<p>Авторизация</p>
				
				<c:if test="${param.message eq 'emptyLogin'}">
					заполните поле с логином
				</c:if>
				<c:if test="${param.message eq 'emptyPassword'}">
					заполните поле с паролем
				</c:if>				
				<c:if test="${param.message eq 'logination error'}">
					неверные логин и пароль					
				</c:if>		
				<c:if test="${param.message eq 'error message'}">
					непредвиденная ошибка - попробуйте зайти позже				
				</c:if>	
			</c:if>							
				
				<%
				String message = (String) request.getParameter("message");
				if (message != null) {
					out.write(message);
				}
				%>




        
            
        </div>
        <div class="header_title">РИА НОВОСТИ</div>
        <!--    <div class="clear"></div>-->

    </div>
		<div class="content-wrap">
			<h2>${requestScope.newsone.title}</h2> <br />
			<p>${requestScope.newsone.content}</p> <br />
			<p style="float: left; width: 50%; margin-top: 0px;">${requestScope.newsone.date}</p>
			<p style="text-align: right; float: left; width: 50%; margin-top: 0px;">
				<c:if test="${sessionScope.auth != null}">
					<c:if test="${sessionScope.role eq 'admin'}">
						<a href="Controller?command=gotoeditfullnews&id=<c:out	value="${requestScope.newsone.id}" />&action=edit">   редактировать новость </a>
						<a href="Controller?command=gotodeletenews&id=<c:out	value="${requestScope.newsone.id}" />">   удалить новость </a>
					</c:if>
				</c:if>
				<a href="Controller?command=gotoindexpage">   назад</a>
			</p>
			<p style="clear: left"></p>

		</div>
		<div class="footer"></div>
</div>
</body>
</html>