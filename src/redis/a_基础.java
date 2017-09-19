package redis;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;

public class a_基础 {
	public void method() {
		JedisPoolConfig jedisPoolConfig = 
				new JedisPoolConfig();
		//设置最大链接数量
		jedisPoolConfig.setMaxIdle(30);
		//设置最大空闲链接数量
		jedisPoolConfig.setMaxTotal(10);
		//创建数据库链接池
		JedisPool jedisPool =
				new JedisPool(jedisPoolConfig,"127.0.0.1",6375);
		Jedis jedis =jedisPool.getResource();
		jedis.set("name", "13");
		//使用管道技术实现批处理
		Pipeline pipeline = jedis.pipelined();
		pipeline.hget("xxx", "sss");
		//异步提交
		pipeline.sync();
		//异步提交并返回数据
		pipeline.syncAndReturnAll();
		//使用事务
		Transaction transaction = jedis.multi();
		transaction.watch("xxx");//使用乐观锁，，在分布式环境中如果在事物启动之前xxx对象发生了修改将会导致事物取消进行
		transaction.set("sdf", "123");
		transaction.exec();//提交事物
		transaction.discard();//回滚事物
		//分布式模式 
		JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1",1234);
		ArrayList<JedisShardInfo> list= new ArrayList<JedisShardInfo>();
		ShardedJedis shardedJedis= new ShardedJedis(list);
		shardedJedis.set("sdf", "123");
		//分布式数据库链接池----
		ShardedJedisPool shardedJedisPool= new ShardedJedisPool(jedisPoolConfig, list);
		//注意jedis使用后需要关闭
		jedis.close();
	}
	public void redismethod() {
		Jedis jedis = new Jedis();
		//jedis数据进行实例化
		jedis.save();
		//实现jedis 后台数据实例化
		jedis.bgsave();
		
		//key操作
		jedis.exists("xxx");// 查看key是否存在
		jedis.del("xxx");//删除key
		jedis.expire("xx", 333);//设置过期时间
		//jedis.pexpire("xx", 1000);//以毫秒记
		jedis.keys("*");//查找所有给定模式的key
		jedis.persist("xxx");//移除jedis指定键的过期时间
		
		//字符串操作
		// set get mset mget setNX incr dncr incrby dncrby
		
	}
}
