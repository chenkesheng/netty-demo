# netty-demo
netty源码解析

# 在测试的时候tcp跟http都有component.
只能先进行一个注释。一个个测试。或者你设置order顺序，数字越大优先级越低。
http跟tcp的通信是不一样的.

要进行http通信需要将Decodes ByteBufs into HttpMessages and HttpContents.
意思就是讲byteBufs解码成HttpContents或者HttpMessages。这样才能进行http通信
这只是一种方式。方式有很多种

# 以下是拷贝netty 官方api的原文。
A ChannelHandler that aggregates an HttpMessage and its following HttpContents into a single FullHttpRequest or FullHttpResponse (depending on if it used to handle requests or responses) with no following HttpContents. It is useful when you don't want to take care of HTTP messages whose transfer encoding is 'chunked'. Insert this handler after HttpResponseDecoder in the ChannelPipeline if being used to handle responses, or after HttpRequestDecoder and HttpResponseEncoder in the ChannelPipeline if being used to handle requests.
  ChannelPipeline p = ...;
  ...
  p.addLast("decoder", new HttpRequestDecoder());
  p.addLast("encoder", new HttpResponseEncoder());
  p.addLast("aggregator", new HttpObjectAggregator(1048576));
  ...
  p.addLast("handler", new HttpRequestHandler());
  
  我这里是将tcp转换成FullHttpRequest客户端转换成FullHttpResponse