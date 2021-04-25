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
        		<p>Привет <c:out value="${sessionScope.auth}"/></p>
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
				
				<%
				String message = (String) request.getParameter("message");
				if (message != null) {
					out.write(message);
				}
				%>		
					
					
					
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="logination" />Логин:<br />
					<input type="text" name="login" value="" /><br />Пароль<br />
					<input type="password" name="password" value="" /><br />
					<input style="margin-top: 5px;" type="submit" value="Войти" /><br />
				</form>
				<a href="Controller?command=registration">Регистрация</a>
			</c:if>




        
            
        </div>
        <div class="header_title">РИА НОВОСТИ</div>
        <!--    <div class="clear"></div>-->

    </div>
		<div class="content-wrap">
		
		<c:if test="${sessionScope.auth == null}">
		
			<form action="Controller" method="post">
            	<input type="hidden" name="command" value="savenewuser" />
            	Логин:<br />
            	<input type="text" name="login" value="" /><br />
           		Пароль:<br />
            	<input type="password" name="password" value="" /><br />
            	Имя:<br />
            	<input type="text" name="name" value="" /><br />
            	Фамилия:<br />
            	<input type="text" name="surname" value="" /><br />
            	E-mail:<br />
            	<input type="text" name="email" value="" /><br />
            	<input type="submit" value="Зарегистрироваться" /><br />
        	</form><br />
		</c:if>
		<c:if test="${sessionScope.auth != null}">
		впвапвапв
		${requestScope.user}
			<form action="Controller" method="post">
            	<input type="hidden" name="command" value="saveedituser" />
            	Логин:<br />
            	<input type="text" name="login" value="${requestScope.user.login}" readonly /><br />
            	Старый пароль:<br />
            	<input type="password" name="passwordOld" value="" /><br />
            	Новый пароль:<br />
            	<input type="password" name="passwordNew" value="" /><br />
            	Имя:<br />
            	<input type="text" name="name" value="${requestScope.user.name}" /><br />
            	Фамилия:<br />
            	<input type="text" name="surname" value="${requestScope.user.surname}" /><br />
            	E-mail:<br />
            	<input type="text" name="email" value="${requestScope.user.email}" /><br />
            	<input type="submit" value="сохранить" /><br />
        	</form><br />
		</c:if>
		
		

			
		</div>
		<div class="footer"></div>
</div>
</body>
</html>