<%@ page import="com.hjc.entity.User" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        div {
        /*border: red solid 2px;*/
        background: white;
        }

        /*#head {*/
        /*width: 1000px;*/
        /*height: 150px;*/
        /*}*/

        body {
        text-align: center;
        background: #e571b8
        }

        /*#headleft {*/
        /*width: 30%;*/
        /*float: left;*/
        /*}*/

        /*#headcenter {*/
        /*width: 50%;*/
        /*float: left;*/
        /*position: relative;*/
        /*top: 80px;*/
        /*}*/

        /*#headright {*/
        /*float: right;*/
        /*font-size: 20px;*/
        /*border: red solid 1px;*/
        /*}*/

        /*#nav {*/
        /*width: 1000px;*/
        /*blackgroundcolor: white;*/
        /*height: 50px;*/
        /*}*/

        /*ul {*/
        /*list-style: none;*/
        /*}*/

        /*li {*/
        /*display: inline;*/
        /*width: 100px;*/
        /*line-height: 40px;*/
        /*}*/

        /*#navRight {*/
        /*width: 70%;*/
        /*float: left;*/
        /*}*/


    </style>
</head>
<body>

<div class="container">
    <div id="head" class="row">
        <div id="headleft" class="col-lg-4">
            <img alt="" src="./image/logo.PNG">
        </div>
        <div id="headcenter" class="col-lg-4" style="margin-top: 30px">
            <form action="reserch" method="post">
                <input type="text" id="keyword"/>
                <img alt="" src="./image/searchKey.PNG">
            </form>
        </div>
        <div id="headright" class="col-lg-4" style="margin-top: 30px">

            <%if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");%>
            <p>welcome <%= user.getUseName()%></p>
            <a href="/logout"><button type="button" class="btn btn-default">Logout</button></a>
            <%} else { %>
            <a href="#">登录</a>|
            <a href="./signup.jsp">注册</a><br/>
            <a href="./cart.jsp">
                <img alt="" src="./image/cart.png"  >
            </a>
            <%}%>
        </div>
    </div>

    <div id="nav" class="row">
        <div id="navRight" class="col-lg-4">
            <ul class="nav nav-pills">
                <li><a>首页</a></li>
                <li><a>热卖</a></li>
                <li><a>推荐</a></li>
                <li><a>聚划算</a></li>
            </ul>
        </div>
    </div>
    <div id="main" class="clearfix">
        <% for (int i = 0; i < 5; i++) {
        %>
        <div style="float: left; padding: 30px; border: red solid 1px;">
            <table>
                <tr>
                    <td colspan="2"><img src="./image/clothes/4.jpg" alt=""></td>
                </tr>
                <tr>
                    <td colspan="2">Intrduction</td>
                </tr>
                <tr>
                    <td>900 RMB</td>
                    <td><a type="button" class="btn btn-primary">Buy</a></td>
                </tr>
            </table>
        </div>
        <%}%>
    </div>

    <div class="clearfix row center-block" style="width: 50%">
        <ul class="pager">
            <li class="previous"><a href="#">&larr; Older</a></li>
            <li class="next"><a href="#">Newer &rarr;</a></li>
        </ul>
    </div>
</div>


</body>
</html>
