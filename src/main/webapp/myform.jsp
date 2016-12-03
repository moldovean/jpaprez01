<%--
  Created by IntelliJ IDEA.
  User: avrabie
  Date: 12/2/2016
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Our Form</title>
  </head>
  <body>
  <h1>ReALLy?</h1>

  <%
    response.getWriter().println("Your IP address is " + request.getRemoteAddr());
    out.println("surprisingly, it works!");
  %>

  <br/>
  Hello, <%= request.getParameter("firstName")%> <%= request.getParameter("lastName")%> <br/>
  please enter the form below: <br/>

  <form method="get" action="myform.jsp">
    ID: <input type="text" name="id"> <br/>
    FirstName <input type="text" name="firstName"> <br/>
    LastName <input type="text" name="lastName"> <br/>
    Salary <input type="text" name="salary"> <br/>
    <input type="submit" value="Submit Me">
  </form>

  <br/>
  FirstName: ${firstName}
  LastName:  ${lastName}

  </body>
</html>
