<%--
  Created by IntelliJ IDEA.
  User: avrabie
  Date: 12/2/2016
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int i=15; %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>ReALLy?</h1>

  <%
    response.getWriter().println("Your IP address is " + request.getRemoteAddr());
    out.println("surprisingly, it works!");
  %>
   <h3> The i is <%=i%></h3>

  <h4>Is this persistent?</h4>
  <form method="get" action="index.jsp">
    ID: <input type="text" name="id"> <br/>
    FirstName <input type="text" name="firstName"> <br/>
    LastName <input type="text" name="lastName"> <br/>
    Salary <input type="text" name="salary"> <br/>
    <input type="submit" value="Submit Me">
  </form>

  <br/>
  FirstName: <%= request.getParameter("firstName")%>
  LastName:  <%= request.getParameter("lastName")%>

  </body>
</html>
