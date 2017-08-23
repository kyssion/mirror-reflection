package javaEE.g_tomcat8_websocket;

import java.util.List;


import javax.websocket.EndpointConfig;
import javax.websocket.Extension;
import javax.websocket.HandshakeResponse;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
//注意websocket需要当需要使用本地回环的时候使用loaclhost而不要使用127.0.0.1----这个方法跑出电脑本地的环境导致相关的防火墙可能会挡住这个方法
//启用websocket 用@ServerEndpoint或被注释为或@ClientEndpoint将被称为注释的端点的类。---后者不支持路径就是表示路径的请求
//当没有一个词访问就会创建一个断点类就是websocket
@ServerEndpoint(value = "/Mywebsocket")
public class Mywebsocket {
	//使用这中方法之后会将这个类编程一个接收端类  这个类用来管理每一个session(使用session)
	@OnOpen//当客户端连接进来的时候出发这个方法
	public void open(Session session,EndpointConfig endpointConfig){
//		该方法只能采用以下参数：
//		可选Session参数
//		可选EndpointConfig参数
//		零到n使用注释注释的String PathParam参数。
	}
	@OnClose//当客户端退出时触发这个方法
	public void close(javax.websocket.Session session, javax.websocket.CloseReason closeReason){
		//session变量是全局的---当一个用户进行注册的时候都将获得一个session
//		该方法只能采用以下参数：
//
//		可选Session参数
//		可选CloseReason参数
//		零到n使用注释注释的String PathParam 参数。---讲CloseReason中的参数尽心解析在发送
	}
	@OnMessage//大客户端通信的时候出发这个方法---参数可以使用字符串或者当使用输入流的时候使用bytebuffer-或者使byte[]
	//返回值表示给服务器返回的信息可以为空
	public void inmessage(String message,Session session){
//		完全是以下任何一种选择
//		如果方法正在处理短信：
//			String 接收整个消息
//			Java原语或类相当于接收整个消息转换为该类型
//			字符串和布尔对以部分方式接收消息
//			Reader 接收整个消息作为阻塞流
//			端点具有文本解码器（Decoder.Text或 Decoder.TextStream）的任何对象参数。
//		如果该方法正在处理二进制消息：
//			byte []或ByteBuffer接收整个消息
//			byte []和boolean对，或者是ByteBuffer布尔对，以便部分地接收消息
//			InputStream 接收整个消息作为阻塞流
//			端点具有二进制解码器（Decoder.Binary或 Decoder.BinaryStream）的任何对象参数。
//		如果方法是处理乒乓消息：---心跳处理消息
//			PongMessage 处理乒乓消息
		//获取信息发送----异步请求方法使用---返回一个消息处理方法使用这个方法将会导致返回一个处理流-- 处理流可以使用send和set方法进行相关的处理       
		session.getAsyncRemote();
		session.getBasicRemote();
	}
	@OnError//当客户端出现错误的时候出发这个方法
	public void inerror(javax.websocket.Session session, java.lang.Throwable e){
		//返回session的值和异常e
	}
}
//自定义服务器的端点链接设置---可以用来预处理 ServerEndpointConfig 获得session 头信息等
class my extends  ServerEndpointConfig.Configurator{

	@Override
	public String getNegotiatedSubprotocol(List<String> supported, List<String> requested) {
		// TODO Auto-generated method stub
		return super.getNegotiatedSubprotocol(supported, requested);
	}

	@Override
	public List<Extension> getNegotiatedExtensions(List<Extension> installed, List<Extension> requested) {
		// TODO Auto-generated method stub
		return super.getNegotiatedExtensions(installed, requested);
	}

	@Override
	public boolean checkOrigin(String originHeaderValue) {
		// TODO Auto-generated method stub
		return super.checkOrigin(originHeaderValue);
	}
	//用来为自定义的断点协议进行相关的修改----serverEndpintConfig用来将相关的属性值存在
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		// TODO Auto-generated method stub
		super.modifyHandshake(sec, request, response);
	}
	//每当新客户端连接到此配置器配置的逻辑端点时，容器就会调用此方法。反射出端点类
	@Override
	public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
		// TODO Auto-generated method stub
		return super.getEndpointInstance(clazz);
	}
	
}