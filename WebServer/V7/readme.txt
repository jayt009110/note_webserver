在页面上显示一张图片
实现：
1.准备一张图片存入到webapps/myweb中
2.在webapps/myweb/index.html中使用<img>标签将图片显示出来


请求页面后发现图片无法正常显示,这是因为我们的服务端目前只接受依次请求后就停止了.但是浏览器在得到页面
后发现页面上需要一些图片，而此时它会自动发起另一个请求来下载图片，这就导致无法下载而显示不成功

改进：
将WebServer的start中接受请求的操作改为循环即可.由于我们已经实现了"一问一答",因此可以重复接受客户端的
多次连接了

当我们可以重复接受多次请求时，会时不时的在HttpRequst的解析请求行方法parseRequestLine中出现数组下标
越界异常，这是由于空请求引起的

HTTP协议中对此的说明为:为了保证服务器的健壮性，应当忽略客户端空的请求(客户端建立TCP连接后只发送了CRLF
并没有阿松标准的HTTP请求内容，之后便与服务器断开连接了)
因此，我们可以在解析请求行方法中发现读取回来的字符串是空字符串时对外抛出一个空请求异常给ClientHandler
使得其忽略后续的处理请求和响应客户端的工作而直接与客户端断开连接达到忽略本次请求的目的

实现：
1.在com.webserver.http包下新建一个类:EmptyRequestException,表示空指针请求异常
2.在HttpRequest的解析请求行方法parseRequestLine汇总，当读取第一行字符串时发现是空字符串时，则对外抛出
空请求异常给HttpRequest的构造方法
3.在HttpRequest的构造方法上继续声明空请求异常的抛出，这样如果出现空请求就可以抛出给ClientHandler了
4.在ClientHandler中单独添加一个catch捕获空请求异常，但是不需要做任何处理，目的只是为了忽略后续处理
请求和响应客户端的操作