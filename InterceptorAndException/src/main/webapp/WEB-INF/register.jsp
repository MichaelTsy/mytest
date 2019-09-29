<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>人人网注册页面</title>
</head>
<body background="pic/brackground.jpg">

<form action="${pageContext.request.contextPath}/register" enctype="multipart/form-data" method="post">
    <table>
        <tr><strong>免费注册开通人人网账号</strong></tr>
        <tr>
            <td>免费注册邮箱：</td>
            <td >
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>你还可以使用账号注册或者手机号注册</td>
        </tr>
        <tr>
            <td>创建密码：</td>
            <td >

                <input type="password" name="password">

            </td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td >

                <input type="text" name="realName">

            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td >

                <input type="radio" name="gender" value="male" >Male
                <input type="radio" name="gender" value="female">Female

            </td>
        </tr>
        <tr>
            <td>输入生日：格式为yyyy-MM-dd</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>我现在:</td>
            <td>

                <select name="nowDo">
                    <option value ="上学">上学</option>
                    <option value="工作">工作</option>
                    <option value="退休了">退休了</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>我的爱好:</td>
            <td>
                <input type="checkbox" name="hobbies" value="唱">唱
                <input type="checkbox" name="hobbies" value="跳">跳
                <input type="checkbox" name="hobbies" value="rap">rap
                <input type="checkbox" name="hobbies" value="篮球">篮球
            </td>
        </tr>
        <tr>
            <td></td>
            <td><img src="pic/verycode.gif"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td >

                <input type="text" name="验证码">

            </td>
        </tr>
        <tr>
            <td>上传头像</td>
            <td>
                <input type="file"  name="headpic"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="image" value="image"  src="pic/btn_reg.gif"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
