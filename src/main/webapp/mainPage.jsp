<%@ page import="com.hjc.entity.Good" %>
<%@ page import="com.hjc.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="utf-8" %>
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
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        div {
            background: white;
        }

        body {
            text-align: center;
            background: #e571b8
        }

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

            <%
                if (session.getAttribute("user") != null) {
                    User user = (User) session.getAttribute("user");
            %>
            <p>welcome <%= user.getUseName()%>
            </p>
            <a href="/logout">
                <button type="button" class="btn btn-default">Logout</button>
            </a>
            <a href="/userInfo.jsp">
                <button type="button" class="btn btn-default">Profile Setting</button>
            </a>
            <%} else { %>
            <a href="./signin.jsp">登录</a>|
            <a href="./signup.jsp">注册</a><br/>
            <a href="./cart.jsp">
                <img alt="" src="./image/cart.png">
            </a>
            <%}%>
        </div>
    </div>

    <div id="nav" class="row">
        <div id="navRight" class="col-lg-4">
            <ul class="nav nav-tabs" id="cate-nav">
                <li><a href="${pageContext.request.contextPath}/">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/?category=1">食品</a></li>
                <li><a href="${pageContext.request.contextPath}/?category=2">家电</a></li>
                <li><a href="${pageContext.request.contextPath}/?category=3">书籍</a></li>
            </ul>
        </div>
    </div>
    <div id="main" class="clearfix">
        <%
            List<Good> goodList = (List<Good>) request.getAttribute("goodList");
            for (Good good : goodList) {

        %>
        <div style="float: left; padding: 30px; border: red solid 1px; width: 300px; height: 50%">
            <table>
                <tr>
                    <td colspan="2"><img src="<%=good.getImgPath()%>" alt=""></td>
                </tr>
                <tr>
                    <td colspan="2"><%=good.getInfo()%>
                    </td>
                </tr>
                <tr>
                    <td><%=good.getPrice()%>RMB</td>
                    <td><a type="button" class="btn btn-primary">Buy</a></td>
                </tr>
            </table>
        </div>
        <%}%>
    </div>

    <div class="clearfix row center-block" style="width: 50%">
        <ul class="pager">
            <li id="previous" class="previous"><a>&larr; Older</a></li>
            <li id="next" class="next"><a>Newer &rarr;</a></li>
        </ul>
    </div>
</div>
<script>

    var getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };

    var page = getUrlParam("page");
    var cate = getUrlParam("category");

    $(document).ready(function () {
        var children = $("#cate-nav").children();
        if (cate == null || cate < 1 || cate > 3) {
            $(children[0]).addClass('active');
            cate = 0;
        }else {
            $(children[cate]).addClass('active');
        }

        //set page
        if (page === null) {
            page = 0
        }else{
            page = parseInt(page)
        }

        $('#previous').click(function () {
            if (page - 1 >= 0) {
                page--;
            }
            window.location.href = "/?category=" + cate + '&page=' + page;
        });

        $('#next').click(function () {
            page++;
            window.location.href = "/?category=" + cate + '&page=' + page;
        })

    });
</script>
</body>
</html>
