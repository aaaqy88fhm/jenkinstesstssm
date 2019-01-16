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
    <title>新闻列表</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
</head>
<body>
    <center>
    <h1>新闻列表</h1>
    <input type="button" value="添加" onclick="add()">
    <hr/>
    <table border="1">
        <tr align="center">
            <td>标题</td>
            <td>内容</td>
            <td>点击量</td>
            <td>类型</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${newsList}" var="news">
        <tr align="center">
            <td>${news.TITLE}</td>
            <td>${news.CONTENT}</td>
            <td>${news.CLICKNUM}</td>
            <td>${news.TYPENAME}</td>
            <td>
                <input type="button" value="编辑" onclick="edit(${news.NEWSID})">&nbsp;&nbsp;
                <input type="button" value="删除" onclick="del(${news.NEWSID})">
            </td>
        </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="5" align="center"> ${pageString}</td>
        </tr>
    </table>
    </center>
    <script type="text/javascript">
        function edit(newsid){
            location.href="toUpdate.do?newsid="+newsid;
        }
        function del(newsid){
            if(confirm("你确定删除吗？")){
                location.href="delete.do?newsid="+newsid;
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
