# 职责链模式
将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，
并沿着这条链传递这个请求，直到链上的某个接收对象能够处理它为止。

过滤器(Servlet Filter(实现Filter接口))、拦截器(Spring Interceptor(实现HandlerInterceptor接口))

JDK应用例子 Java Servlet 中的 Filter 就是通过职责链来实现的， 
Spring 中的 interceptor。实际上，拦截器、过滤器这些功能绝大部分都是采用职责链模式来实现的。