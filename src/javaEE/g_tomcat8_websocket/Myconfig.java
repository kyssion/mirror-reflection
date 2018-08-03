package javaEE.g_tomcat8_websocket;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class Myconfig extends ServerEndpointConfig.Configurator{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		// TODO Auto-generated method stub
		super.modifyHandshake(sec, request, response);
		request.getHttpSession();
		request.getHeaders();
		request.getHttpSession();//这个可以获得httpsession
		request.getParameterMap();
		request.getQueryString();
		request.getRequestURI();
		request.getUserPrincipal();
		sec.getUserProperties().put("xxx", "sdfsdf");//可以想websocket中添加共享变量
	}
	
}
