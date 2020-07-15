<%--
  Created by IntelliJ IDEA.
  User: cqj
  Date: 2020/7/11
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath() %>/res/js/jquery-1.12.4.js" ></script>
    <script type="text/javascript">

        function update() {
            $.ajax(
                {
                    url: "<%=request.getContextPath()%>/users",
                    type: "PUT",
                    dataType: "json",
                    contentType:'application/json;charset=utf-8',
                    data: JSON.stringify({"id":37,"userName" : "aaaaaaaa"}),
                    success: function (result) {
                       console.log(result.data);
                    },
                    error: function () {
                        alert("错误");
                    }
                });
        }


        function addUser() {
            $.ajax(
                {
                    url: "<%=request.getContextPath()%>/users",
                    type: "post",
                    dataType: "json",
                    data: $("#fm").serialize(),
                    success: function (result) {
                        console.log(result.data);
                    },
                    error: function () {
                        alert("错误");
                    }
                });
        }

    </script>
</head>
<body>
    <form id="fm" method="post" >
      姓名:<input type="text" name="userName" />
      密码:<input type="text" name="userPwd" />
      年龄:  <input type="text" name="age" />
        <input  type="button" value="添加" onclick="addUser()" />
        <input  type="button" value="修改" onclick="update()" />
    </form>

</body>
</html>
