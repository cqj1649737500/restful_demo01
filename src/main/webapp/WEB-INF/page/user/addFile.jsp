<%--
  Created by IntelliJ IDEA.
  User: cqj
  Date: 2020/7/13
  Time: 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath() %>/res/js/jquery-1.12.4.js" ></script>
    <script type="text/javascript">
        function add() {
            var formData = new FormData($('#fm')[0]);
            $.ajax({
                type: 'post',
                url: '<%=request.getContextPath() %>/users/addUserFile',
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
            }).success(function (data) {
                if (data.code != 200) {
                    alert(data.msg);
                    return;
                }
                    alert(data.msg);
            })
        }

    </script>
</head>
<body>
<form id = "fm" method="post" enctype="multipart/form-data"  >
    头像: <input type="file" name = "file" />
    用户名:<input type="text"  name="userName"   placeholder="输入用户名" /><br>
    密码:<input type="text" name="userPwd" placeholder="输入密码"/><br>
    <input type="button" value="添加" onclick="add()" />

</form>
</body>
</html>
