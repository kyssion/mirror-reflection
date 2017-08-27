package a_java基础知识点;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;

public class f_网络 {
	public static void main(String[] args) {
		
	}
	//ip地址获取类
	public void method() throws UnknownHostException{
		InetAddress[] address =InetAddress.getAllByName("www.baidu.com");
		InetAddress.getLocalHost();
		InetAddress.getByAddress(new byte[100]);//获得ip地址的字节数组 有很多 get类型的参数
		address[1].isMulticastAddress();//判断是否是多播地址  有很多is类型的参数
	}
	//java get方法发送请求
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	//java post方法发送请求
	public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
}
//这两个实现 tcp/ip协议-----判断断开的方法很简单只要然向其中写数据就行了如果不能写就表示断开
class MySocket2 extends Thread {//客户端
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Socket socket = new Socket("127.0.0.1", 8090);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			String string = "1233211234567";
			outputStream.write(string.getBytes());
			socket.shutdownOutput();//关闭socke 对应的输入流
			this.sleep(1000);
			byte[] bs = new byte[100];
			while (inputStream.read(bs)!=-1) {//流如果输出流被打开 就会被一直有数据输入  
				String string2 = new String(bs);
				System.out.println(string2);
			}
			System.out.println("客戶端 關閉");
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MySeverSocjet extends Thread {//服务器端
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			ServerSocket serverSocket = new ServerSocket(8090);
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			System.out.println("this is server");
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("hahahhahah".getBytes());
			socket.shutdownOutput();//自动在输入流的后面加上数据结束标志 从而使 read ==-1可以使用  否则 java read方法 会认为 数据没有读完从而导致  输入流一只等待
			byte[] bs = new byte[100];
			while (inputStream.read(bs) != -1) {
				String string = new String(bs);
				System.out.println(string);
			}
			System.out.println("服務端關閉");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//UDP编程
class MyUDP extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			DatagramSocket datagramSocket = new  DatagramSocket(7777);//声明一个类注册的端口
			byte[] bs= "ssssssss".getBytes();
			//打包数据
			DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length, new InetSocketAddress("127.0.0.1", 8000));
			//发送
			datagramSocket.send(datagramPacket);
			datagramSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MyUDP2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			DatagramSocket datagramSocket = new DatagramSocket(8000);
			byte[] bs= new byte[1000];
			//打包数据
			DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length);
			try {
				datagramSocket.receive(datagramPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] da= datagramPacket.getData();
			System.out.println(new String(da));
			datagramSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class mysocket extends Socket{
	//将此套接字连接到服务器。
	public void connect(SocketAddress endpoint) throws IOException {super.connect(endpoint);}
	//将此套接字连接到服务器。并制定超时时间
	public void connect(SocketAddress endpoint, int timeout) throws IOException {super.connect(endpoint, timeout);}
	//将套接字绑定到本地地址。
	public void bind(SocketAddress bindpoint) throws IOException {super.bind(bindpoint);}
	//返回套接字连接的地址。
	public InetAddress getInetAddress() {return super.getInetAddress();}
	//获取套接字绑定的本地地址。
	public InetAddress getLocalAddress() {return super.getLocalAddress();}
	//返回此套接字连接到的远程端口。
	public int getPort() {return super.getPort();}
	//返回此套接字绑定到的本地端口。
	public int getLocalPort() {return super.getLocalPort();}
	//返回此套接字连接的端点的地址，如果未连接则返回 null。
	public SocketAddress getRemoteSocketAddress() {return super.getRemoteSocketAddress();}
	//返回此套接字绑定的端点的地址，如果尚未绑定则返回 null。
	public SocketAddress getLocalSocketAddress() {return super.getLocalSocketAddress();}
	//返回与此数据报套接字关联的唯一 SocketChannel 对象（如果有）。
	public SocketChannel getChannel() {return super.getChannel();}
	public InputStream getInputStream() throws IOException {return super.getInputStream();}
	public OutputStream getOutputStream() throws IOException {return super.getOutputStream();}
	
	//启用/禁用 TCP_NODELAY（启用/禁用 Nagle 算法）。
	public void setTcpNoDelay(boolean on) throws SocketException {super.setTcpNoDelay(on);}
	//启用/禁用 TCP_NODELAY（启用/禁用 Nagle 算法）。
	public boolean getTcpNoDelay() throws SocketException {return super.getTcpNoDelay();}
	//启用/禁用具有指定逗留时间（以秒为单位）的 SO_LINGER。
	public void setSoLinger(boolean on, int linger) throws SocketException {super.setSoLinger(on, linger);}
	public int getSoLinger() throws SocketException {return super.getSoLinger();}
	//在套接字上发送一个紧急数据字节。
	public void sendUrgentData(int data) throws IOException {super.sendUrgentData(data);}
	//启用/禁用 OOBINLINE（TCP 紧急数据的接收者） 默认情况下，此选项是禁用的，即在套接字上接收的 TCP 紧急数据被静默丢弃。
	public void setOOBInline(boolean on) throws SocketException {super.setOOBInline(on);}
	public boolean getOOBInline() throws SocketException {return super.getOOBInline();}
	//启用/禁用带有指定超时值的 SO_TIMEOUT，以毫秒为单位。
	public synchronized void setSoTimeout(int timeout) throws SocketException {super.setSoTimeout(timeout);}
	public synchronized int getSoTimeout() throws SocketException {return super.getSoTimeout();}
	//获取此 Socket 的 SO_SNDBUF 选项的值，该值是平台在 Socket 上输出时使用的缓冲区大小。
	public synchronized void setSendBufferSize(int size) throws SocketException {super.setSendBufferSize(size);}
	public synchronized int getSendBufferSize() throws SocketException {return super.getSendBufferSize();}
	//将此 Socket 的 SO_RCVBUF 选项设置为指定的值。
	public synchronized void setReceiveBufferSize(int size) throws SocketException {super.setReceiveBufferSize(size);}
	public synchronized int getReceiveBufferSize() throws SocketException {return super.getReceiveBufferSize();}
	//启用/禁用 SO_KEEPALIVE。
	public void setKeepAlive(boolean on) throws SocketException {super.setKeepAlive(on);}
	public boolean getKeepAlive() throws SocketException {return super.getKeepAlive();}
	//为从此 Socket 上发送的包在 IP 头中设置流量类别 (traffic class) 或服务类型八位组 (type-of-service octet)。
	public void setTrafficClass(int tc) throws SocketException {super.setTrafficClass(tc);}
	public int getTrafficClass() throws SocketException {return super.getTrafficClass();}
	//启用/禁用 SO_REUSEADDR 套接字选项。
	public void setReuseAddress(boolean on) throws SocketException {super.setReuseAddress(on);}
	public boolean getReuseAddress() throws SocketException {return super.getReuseAddress();}
	
	public synchronized void close() throws IOException {super.close();}
	public void shutdownInput() throws IOException {super.shutdownInput();}
	public void shutdownOutput() throws IOException {super.shutdownOutput();}
	public String toString() {return super.toString();}
	//值判断类型
	public boolean isConnected() {return super.isConnected();}
	
	public boolean isBound() {return super.isBound();}
	
	public boolean isClosed() {return super.isClosed();}
	
	public boolean isInputShutdown() {return super.isInputShutdown();}
	
	public boolean isOutputShutdown() {return super.isOutputShutdown();}
	
	public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {super.setPerformancePreferences(connectionTime, latency, bandwidth);}
}
