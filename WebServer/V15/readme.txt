重构HttpResponse的发送响应正文的工作
之前咱们HttpResponse只支持设置一个文件作为响应正文，然后发送时通过读取这个文件的数据作为正文发送给客户端
但是上一个版本中我们在ShowAllUserServlet中实现了动态页面的生成，为了能将这个页面的数据发送给客户端，只能先将
数据写入文件，然后再让HttpResponse从文件中读取数据发送，这白白做了两次IO操作并且还消耗了更多的资源和时间

在HttpResponse中支持直接将一组数据作为正文的方式发送，这样一来所有程序的生成的动态数据可以直接设置到response
中作为正文发送