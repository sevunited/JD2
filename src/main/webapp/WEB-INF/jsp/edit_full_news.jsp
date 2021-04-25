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
			<c:if test="${param.action eq 'edit'}">
				<h2>Редактирование новости</h2>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="saveeditfullnews" />
					<input type="hidden" name="action" value="edit" />
					<input type="hidden" name="id" value="${requestScope.newsone.id}" />
					<p>Дата:</p>
					<textarea rows="1" cols="10" name="date" disabled>${requestScope.newsone.date}</textarea><br /><br />
					<p>Название:</p>
					<textarea rows="5" cols="100" name="title">${requestScope.newsone.title}</textarea><br /><br />
					<p>Краткое описание:</p>
					<textarea rows="10" cols="100" name="brief">${requestScope.newsone.brief}</textarea><br /><br />
					<p>Полное описание:</p>
					<textarea rows="20" cols="100" name="content">${requestScope.newsone.content}</textarea><br />
					<input style="margin-top: 5px;" type="submit" value="Сохранить" />
					<span>
						<a href="Controller?command=gotoonefullnews&id=<c:out value="${requestScope.newsone.id}" />">НАЗАД</a>
					</span>
					<span>
						<c:if test="${sessionScope.role eq 'admin'}">
							<a href="Controller?command=gotodeletenews&id=<c:out value="${requestScope.newsone.id}" />">удалить новость</a>
						</c:if>
					</span><br />					
				</form>
			</c:if>
			<c:if test="${param.action eq 'add'}">
				<h2>Добавление новости</h2>
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="saveaddnews" />
					<input type="hidden" name="action" value="add" />
					<p>Название:</p>
					<textarea rows="5" cols="100" name="title" ></textarea><br /><br />
					<p>Краткое описание:</p>
					<textarea rows="10" cols="100" name="brief"></textarea><br /><br />
					<p>Полное описание:</p>
					<textarea rows="20" cols="100" name="content"></textarea><br />
					<input style="margin-top: 5px;" type="submit" value="Сохранить" />
					<span>
						<a href="Controller?command=gotoindexpage">НАЗАД</a>
					</span>					
				</form>
			</c:if>			
			
			
			
			
			
			
		</div>
		<div class="footer"></div>
</div>
</body>
</html>