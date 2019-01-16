<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/19
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工更新</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //使用AJAX方法调用  后台得到数据
            $.get(
                "/dept/list.do",//请求地址
                function(data){//回调函数
                    //alert(data); //如果是字符串  可以使用eval  JSON.stringify
                    var tempStr="";
                    //判断是否为空
                    if(data!=''){
                        $("#deptname").empty(); //清空所有子元素
                        for(var i=0;i<data.length;i++){
                            tempStr +="<option value='"+data[i].DEPTNO+"'>"+data[i].DNAME+"</option>";
                        }
                        $("#deptname").append(tempStr);
                    }
                },
                "json" //定义返回值格式
            );
        })
    </script>
</head>
<body>
<center>
<form action="update.do" method="post">
    <table border="1">
        <input type="hidden" name="empno" value="${emp.EMPNO}">
        <tr align="center">
            <td>姓名</td>
            <td><input type="text" name="ename" value="${emp.ENAME}"></td>
        </tr>
        <tr align="center">
            <td>工作</td>
            <td><input type="text" name="job" value="${emp.JOB}"></td>
        </tr>
        <tr align="center">
            <td>工资</td>
            <td><input type="text" name="sal" value="${emp.SAL}"></td>
        </tr>
        <tr align="center">
            <td>奖金</td>
            <td><input type="text" name="comm" value="${emp.COMM}"></td>
        </tr>
        <tr align="center">
            <td>部门</td>
            <td><select id="deptname" name="deptno"></select>  </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</center>
</body>
</html>
