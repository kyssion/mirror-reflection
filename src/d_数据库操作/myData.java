package d_数据库操作;
import java.sql.*;
import java.util.Properties;

import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
public class myData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql", "root","14159265jkl");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
		ResultSet resultSet =preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
}
class MySqlAll{
	public void one() throws Exception{
		//Java 数据库使用方法 -  其实是Java标准中存在相关的接口来调用 数据库厂商提供的数据库驱动类
		//1. 加载jdbc数据库连接 - 加载类的时候会调用jdbc中的静态代码块实现一些初始化的方法比如将driver 注册到jdbc中
		Class.forName("com.mysql.jdbc.Driver");//方法1
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());//方法2进行注册
		//2. 进行数据库url绑
		String url="jdbc:mysql://127.0.0.1:3306/student";//直接进行url绑定
		url+="?useServerPrepStmts=false&cachePrepStmts=true&rewriteBatchedStatements=true";
		//第一个参数是关掉预处理-预处理的过程首先java程序将需要的过程是先将带有占位符（即”?”）的sql模板发送至mysql服务器，由服务器对此无参数的sql进行编译后，将编译结果缓存，然后直接执行带有真实参数的sql。
		//-useServerPrepStmts=true，ConneciontImpl在prepareStatement时会产生一个ServerPreparedStatement.在这个ServerPreparedStatement对象构造时首先会把当前SQL语句发送给MySQL进行预编译，然后将返回的结果缓存起来，其中包含预编译的名称（我们可以看成是当前SQL语句编译后的函数名），签名（参数列表），然后执行的时候就会直接把参数传给这个函数请求MySQL执行这个函数。否则返回的是客户端预编译语句，它仅做参数化工作
		//第二个参数使用预编译缓存这样就能让jdbc驱动使用相通的select语句的预编译结果而不是使用同一个connect获得的结果--使用cachePrepStmts=true，这个选项可以让JVM端缓存每个SQL语句的预编译结果，说白了就是以SQL语句为key, 将预编译结果缓存起来，下次遇到相同的SQL语句时作为key去get一下看看有没有这个SQL语句的预编译结果，有就直接合出来用
		//首先对于打开预编译的URL//获取数据库连接之后，本质是获取预编译语句pstmt = conn.prepareStatement(sql)时会向MySQL服务端发送一个RPC，发送一个预编译的SQL模板（驱动会拼接mysql预编译语句prepare s1 from 'select * fromuser where id = ?'），然会MySQL服务端会编译好收到的SQL模板，再会为
		//此预编译模板语句分配一个serverStatementId发送给JDBC驱动，这样以后PreparedStatement就会持有当前预编译语句的服务端的serverStatementId,并且会把此 PreparedStatement缓存在当前数据库连接中，以后对于相同SQL模板的操作pstmt.executeUpdate()，都用相同的PreparedStatement，执行SQL时
		//只需要发送serverStatementId和参数，节省一次SQL编译, 直接执行。并且对于每一个连接(驱动端及Mysql服务端)都有自己的preparecache,具体的源码实现是在com.mysql.jdbc.ServerPreparedStatement中实现。
		
		//?忽略掉ssl警告
		url+="?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		//connect 是数据库连接参数里面储存了相关数据库连接的信息
		Connection connection = DriverManager.getConnection(url, "root","14159265jkl");
		connection.getClientInfo();
		connection.getClientInfo("root");//获得数据连接中的指定参数比如上面的
		connection.setClientInfo(new Properties());
		connection.setClientInfo("","");//加入属性值
		connection.isReadOnly();//
		connection.isClosed();//判断对象是否关闭了
		connection.setReadOnly(true);//设置数据库只读提示
		DatabaseMetaData data=connection.getMetaData();//获得数据库的整体信息
		
		
		Properties info=new Properties();
		info.put( "user", "username" );
		info.put( "password", "password" );
		Connection connection2 = DriverManager.getConnection(url, info);//使用配置类进行绑定
		//3.关闭数据库
		connection.close();
		
		//4. 事物 
		connection.setAutoCommit(false);//关闭自动提交
		connection.commit();//提交事物
		connection.rollback();//事物回
	}
	public void two(Connection connection) throws Exception{
		//进行数据库交互
		//Statement			使用通用访问数据库。当在运行时使用静态SQL语句。 Statement接口不能接受的参数。
		//PreparedStatement	当计划多次使用SQL语句。 那么可以PreparedStatement接口接收在运行时输入参数。
		//CallableStatement	当要访问数据库中的存储过程中使用。 CallableStatement对象的接口还可以接受运行时输入参数。
	
		//1. statement 对象
		Statement statement = connection.createStatement();
		statement.execute("");//执行任何语句判断是否有result结果集有就返回投入哦否则返回false
		statement.executeUpdate("sdfasfd");//传入sql语句并且返回返回收到影响的行数
		statement.executeQuery("sdf");//传入结果集并且返回resultset结果集对象
		//2. PreparedStatement -- statement升级版可以使用占位符
		String sql = "Update Employees SET age = ? WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(0, "sdf");//表示为第几个参数传入值
		preparedStatement.close();
		//3.用于表示存储过程如orcale数据库---第三种数据库结构
		//4.批量处理---注意不能使用查询语句
		//使用方法不停的向其中进行传递参数预编译的类将会自动进行相关的加入方法
		preparedStatement.setString(0, "sdf");
		preparedStatement.setString(2, "sdf");
		preparedStatement.addBatch();
		preparedStatement.setString(0, "sdf");
		preparedStatement.setString(0, "sdf");
		preparedStatement.addBatch();
		preparedStatement.executeBatch();//提交批量操作
		//注意上面的方法在创建结果集的时候使用create可以指定结果集的类型详情见下面
	}
	public void three(PreparedStatement preparedStatement) throws SQLException{
		//使用结果集
		//1. 声明结果集的类型
		//createStatement(int RSType, int RSConcurrency);
		//prepareStatement(String SQL, int RSType, int RSConcurrency);
		//prepareCall(String sql, int RSType, int RSConcurrency);
		//一.ResultSet的类型：
		//可能的RSType如下，如果不指定ResultSet类型，将自动获得一个是TYPE_FORWARD_ONLY。
		//Type	描述
		//ResultSet.TYPE_FORWARD_ONLY	游标只能向前移动的结果集。
		//ResultSet.TYPE_SCROLL_INSENSITIVE	游标可以向前和向后滚动，结果集不是别人向创建结果集后发生的数据库更改敏感。
		//ResultSet.TYPE_SCROLL_SENSITIVE.	游标可以向前和向后滚动，结果集是别人向创建结果集后发生的数据库更改敏感。
		//二.并发性的ResultSet：
		//可能的RSConcurrency如下，如果不指定任何并发类型，将自动获得一个为CONCUR_READ_ONLY。
		//并发	描述
		//ResultSet.CONCUR_READ_ONLY	创建结果集只读。这是默认的
		//ResultSet.CONCUR_UPDATABLE	创建一个可更新的结果集。
		//到目前为止已写入的例子可以写成如下的初始化一个Statement对象来创建一个只进，只读的ResultSet对象：
		//结果集相关方法----------
		ResultSet resultSet = preparedStatement.executeQuery("asdasd");
		//指定结果集所在的位置
		resultSet.beforeFirst();
		resultSet.afterLast();
		resultSet.first();
		resultSet.last();
		//游标移动方法
		resultSet.absolute(10);//游标定位到指定的位置
		resultSet.relative(-10);//游标向前向后移动指定的行
		resultSet.previous();
		resultSet.next();
		resultSet.getRow();//获得行号
		//获得结果集中的数据
		resultSet.getInt("sdfsdf");
		resultSet.getInt(0);
		//更行数据库中的数据---在可进行更新的结果集中进行的修改
		resultSet.updateInt("s", 0);//-----进行修改---参数有很多updateString  第一个参数列名称 第二个参数 数值
		resultSet.updateRow();//提交updatexx事物
		resultSet.deleteRow();//删除数据库中的当前行---刷新后生效
		resultSet.insertRow();//提交updatexx事物----使用插入方法
		resultSet.refreshRow();//刷新
		resultSet.cancelRowUpdates();//取消
		//
		resultSet.isAfterLast();
		resultSet.isBeforeFirst();
		resultSet.isClosed();
		resultSet.isFirst();
		resultSet.isClosed();
	}
}