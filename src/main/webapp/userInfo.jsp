<%@ page import="com.geniusver.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: GeniusV
  Date: 5/15/18
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="js/validator.min.js"></script>
</head>
<body>

<a href="/index.jsp" style="display: block;"> <img alt="" src="./image/logo.PNG">
</a>
<div class="container">
    <%
        if (request.getSession().getAttribute("success") != null) {
            request.getSession().removeAttribute("success");
    %>
    <div class="alert alert-success alert-dismissable" style="margin-top: 50px">
        <button type="button" class="close">
            &times;
        </button>
        Update Success !!!!!
    </div>
    <%}%>
    <div class="row clearfix">
        <div class="col-md-6 col-md-offset-3">
            <%
                User user = null;
                if ((user = (User) session.getAttribute("user")) == null) {
                    response.sendRedirect("index.jsp");
                }
                assert user != null;
            %>
            <h2><%=user.getUseName()%>
            </h2>
            <form role="form" action="/update" method="post">
                <div class="form-group">
                    <label for="password">Password</label><input type="password" class="form-control" id="password"
                                                                 name="password"/>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="<%=user.getTel()%>"/>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <div>
                        <input type="email" class="form-control" id="email" data-error="The Email address is not valid."
                               name="email" value="<%=user.getEmail()%>"/>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary center-block">Update</button>
            </form>
        </div>
    </div>
</div>
<script>
    window.setTimeout(function () {
        $('.alert').slideUp("normal");
    }, 2000);

    $(document).ready(function () {
        $('.close').onclick(function (ev) {
            $('.alert').slideUp("normal");
        })
    })
</script>
</body>
</html>
