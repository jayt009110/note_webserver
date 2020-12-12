将doc.canglaoshi.org网站上的学子商场或稻草问答的静态页面下载并复制到webapps项目中，然后尝试访问
其中的页面查看效果

发现页面不能完全显示出来，通过跟踪浏览器与服务端的请求与响应交互可以看出，原因出在服务端发送响应中
的响应头Content-Type的值是固定的text/html,这会导致无论浏览器请求的资源是什么类型的内容，我们统一回复
客户端时告诉它这是一个"页面"，从而浏览器无法正确解释这个资源，出现展示页面不正常的情况

对此,我们要对HttpRespongse发送响应头的工作进行重构，这个过程分为两部分进行
1:虽然当前项目我们需要发送的相应头只有Content-Type和Content-Length.但是实际上服务端给客户端发送的
  响应头还有一些，可以结合请求的处理结果发送对应的其他响应头，因此我们要支持向HttpResponse中设置
  不同的响应头,将来在flush时可以将这些头都发送给客户端，而不是固定的只发上述的两个响应头

2:发送Content-Type的值时要结合客户端实际请求的资源对应的类型来发送，而不能发送固定的text/html.否则
  浏览器可能无法正确理解其请求的资源从而导致显示异常

实现:
一:实现HttpResponse可以根据设置的响应头进行发送
1：在HttpResponse中添加一个属性:private Map<String,String> headers = new HashMap<>();
  用这个Map保存所有要给客户端发送的响应头，其中key是响应头的名字,value为这个响应头的值
2:在sendHeaders方法中改为通过遍历headers将所有响应头发送给客户端
3:添加一个方法putHeader,允许外界设置发送的响应头到HttpResponse中.
  这样一来，在flush之前只要将需要发送的响应头放到headers中,在flush时就可以全部发送过去了