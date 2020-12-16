独立完成用户登录功能

流程:
1.用户访问登录页面:login.html
2.在页面输入用户名和密码后点击登录按钮提交表单
3.服务端处理登录并响应登录页面(成功或失败)


实现:
1:在web/myweb下准备对应的页面:
   1.1:login.html登录页面，页面中form表单action的值是:"./loginUser"
   1.2:login_success.html登录成功提示页面，居中一行字:登录成功，欢迎回来
   1.3:login_fail.html登录失败提示页面，居中一行字:登录失败，用户名或密码错误
2:定义处理登录的业务类:com.webserver.servlet.LoginServlet
  并定义service方法完成登录逻辑
3:在ClientHandler处理请求环节再添加一个分支判断请求的路径是否为登录，如果是则进行登录处理