<%--
  Created by IntelliJ IDEA.
  User: GeniusV
  Date: 3/20/18
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        Info
                    </th>
                    <th>
                        Price
                    </th>
                    <th>
                        Number
                    </th>
                    <th>
                        Total
                    </th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>
                        Coat
                    </td>
                    <td>
                        100
                    </td>
                    <td class="item1">
                        <button v-on:click="counter += 1">+</button>
                        {{ counter }}
                        <button v-on:click="down">-</button>
                    </td>
                    <td>
                        Call in to confirm
                    </td>
                </tr>
                <tr>
                    <td>
                        Coat
                    </td>
                    <td>
                        100
                    </td>
                    <td class="item1">
                        <button v-on:click="counter += 1">+</button>
                        {{ counter }}
                        <button v-on:click="down">-</button>
                    </td>
                    <td>
                        Call in to
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
<script>

    $(document).ready(function () {
        $('.item1').each(function (index,item) {
            console.log(index, item)
            new Vue({
                el: item,
                data: function () {
                    return {
                        counter: 0
                    }
                },
                methods: {
                    down: function () {
                        if (this.counter > 0) {
                            return this.counter -= 1
                        } else {
                            counter = 0;
                            return this.counter
                        }
                    }
                }
            });
        })
    })

</script>
</body>
</html>
