<%--
  Created by IntelliJ IDEA.
  User: brendawihogora
  Date: 03/03/2024
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.brenda.jsp_crud_example.doa.UserDao"%>
<jsp:useBean id="u" class="com.brenda.jsp_crud_example.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
    int i=UserDao.save(u);
    if(i>0){
        response.sendRedirect("adduser-success.jsp");
    }else{
        response.sendRedirect("adduser-error.jsp");
    }
%>
