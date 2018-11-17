<%@ page language="java" pageEncoding="utf-8"%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>表单</title>
</head>

<body>
  <pre>
    /*
     *  pin yin
     *
     *      ci xiang mu shi zai IDEA mo ren de bian
     *  ma(UTF-8) xia ce shi de.
     *      ru guo ni kan dao le zhong wen luan ma,
     *  shuo ming ni de IDE bian ma bu shi GBK.
     */
  </pre>
  <h1>用户登录</h1>
  <form action="/LoginCL" method="post">
    账号 <input type="text" name="account"/>
    <br>
    密码 <input type="password" name="password"/>
    <br>
    <input type="submit" value="提交" />
  </form>
</body>
</html>
