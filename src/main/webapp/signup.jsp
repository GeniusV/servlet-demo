<%--
  Created by IntelliJ IDEA.
  User: GeniusV
  Date: 3/20/18
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="js/validator.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 col-md-offset-3">
            <div style="background-color: #3da6ff; color: white; font-size: 3em">Sign Up</div>
            <form class="form-horizontal" method="post" action="/signup" data-toggle="validator" role="form" style="margin-top: 20px">
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">User Name</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="username" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" class="form-control" id="inputEmail" data-error="The Email address is not valid." name="inputEmail"/>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="inputPassword3" name="inputPassword3"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="passwd-confirm" class="col-sm-3 control-label">Confirm Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="passwd-confirm" data-match="#inputPassword3"
                        data-match-error="Passwords are not match!"/>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-3 control-label">Phone</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="phone" name="phone"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign Up</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
