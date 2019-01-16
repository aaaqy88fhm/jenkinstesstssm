<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/19
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
</head>
<body>
    <center>
    <h1>员工列表</h1>
    <input type="button" value="添加" onclick="add()">
    <hr/>
    <table border="1">
        <tr align="center">
            <td>姓名</td>
            <td>工作</td>
            <td>工资</td>
            <td>奖金</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${empList}" var="emp">
        <tr align="center">
            <td>${emp.ENAME}</td>
            <td>${emp.JOB}</td>
            <td>${emp.SAL}</td>
            <td>${emp.COMM}</td>
            <td>${emp.DNAME}</td>
            <td>
                <input type="button" value="编辑" onclick="edit(${emp.EMPNO})">&nbsp;&nbsp;
                <input type="button" value="删除" onclick="del(${emp.EMPNO})">
            </td>
        </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="6" align="center"> ${pageString}</td>
        </tr>
    </table>
    </center>
    <script type="text/javascript">
        function edit(empno){
            location.href="toUpdate.do?empno="+empno;
        }
        function del(empno){
            if(confirm("你确定删除吗？")){
                location.href="delete.do?empno="+empno;
            }
        }
        function add() {
            location.href="toAdd.do";
        }
        if(${info!=null}&&${pageno==null}){
            alert("${info}");
        }
    </script>

</body>
</html>
