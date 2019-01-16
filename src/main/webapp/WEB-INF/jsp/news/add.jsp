<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/19
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻添加</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //使用AJAX方法调用  后台得到数据
            $.get(
                "/newsType/list.do",//请求地址
                function(data){//回调函数
                    //alert(data); //如果是字符串  可以使用eval  JSON.stringify
                    var tempStr="";
                    //判断是否为空
                    if(data!=''){
                        $("#type").empty(); //清空所有子元素
                        for(var i=0;i<data.length;i++){
                            tempStr +="<option value='"+data[i].TYPEID+"'>"+data[i].TYPENAME+"</option>";
                        }
                        $("#type").append(tempStr);
                    }
                },
                "json" //定义返回值格式
            );
        })
    </script>
</head>
<body>
    <center>
    <form action="/news/add.do" method="post">
        <table border="1">
            <tr align="center">
                <td>标题</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr align="center">
                <td>内容</td>
                <td><input type="text" name="content"></td>
            </tr>
            <tr align="center">
                <td>点击量</td>
                <td><input type="text" name="clicknum"></td>
            </tr>
            <tr align="center">
                <td>类型</td>
                <td><select id="type" name="typeid"></select>  </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="添加">
                </td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>
