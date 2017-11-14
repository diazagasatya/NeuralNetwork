<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="friend_finder.css">
</head>
<body>
	<div class="header">
      <div class="header-logo">Find  Friend</div>
      <div class="header-list">
        <ul>
          <li>Find Friends!</li>
          <li>Account Setting</li>
          <li>Log Out</li>
        </ul>
      </div>
    </div>
    
    <%
    		if(session.getAttribute("username") == null) {
    			response.sendRedirect("login.jsp");
    		}
    %>

    <div class="main">
      <div class="copy-container">
        <h2>Welcome! ${username}</h2>
      </div>   
    </div>

    <div class="footer">
      <div class="footer-logo">Find a Friend</div>
      <div class="footer-list">
        <ul>
          <li>Find Friends!</li>
          <li>Account Setting</li>
          <li>Log Out</li>
        </ul>
      </div>
    </div>
</body>
</html>