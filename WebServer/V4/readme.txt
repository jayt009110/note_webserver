本版本完成响应客户端一个页面的操作
通过这个版本我要了解两个知识点
1:html页面的基本组成与语法
2:HTTP协议中的响应
我们只有给浏览器按照HTTP要求发送一个标准的响应，将页面回复给客户端，就可以让他显示出这个页面了

实现：
1:在项目目录下新建一个目录：webapps
  这个目录用于保存当前web容器中部署的所有网络应用(webapp),每个网络应用一个独立的目录放在这里
  目录的名字就是这个网络应用的名字。
  每个网络应用相当于是一个"网站"，包含页面，静态资源，处理业务的代码等
2:新建第一个应用,在webapps下新建一个目录myweb
3:在myweb下新建第一个页面:index.html,作为网络应用的首页

4:在ClientHandler的第三步：响应客户端
  添加发送一个标准的HTTP响应，并将index.html页面内容作为响应正文回复客户端，测试浏览器是否
  可以正确显示出这个页面