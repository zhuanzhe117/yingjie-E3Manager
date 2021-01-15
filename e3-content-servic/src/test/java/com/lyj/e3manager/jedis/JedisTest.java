//package com.lyj.e3manager.jedis;
//
//import org.junit.Test;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class JedisTest {
//    @Test
//    public void testJedis() throws Exception{
//        Jedis jedis = new Jedis("192.168.174.129",6379);
//        jedis.set("test123","my first jedis test");
//        String string = jedis.get("test123");
//        System.out.println(string);
//        jedis.close();
//    }
//
//    @Test
//    public void testJedisPool() throws Exception{
//        JedisPool jedisPool = new JedisPool("192.168.174.129",6379);
//        Jedis jedis = jedisPool.getResource();
//        String string = jedis.get("test123");
//        System.out.println(string);
//        jedis.close();
//        jedisPool.close();
//    }
//    @Test
//    public void testJedisCluster() throws Exception {
//        //创建一个JedisCluster对象。有一个参数nodes是一个set类型。set中包含若干个HostAndPort对象。
//        Set<HostAndPort> nodes = new HashSet<>();
//        nodes.add(new HostAndPort("192.168.174.129", 7001));
//        nodes.add(new HostAndPort("192.168.174.129", 7002));
//        nodes.add(new HostAndPort("192.168.174.129", 7003));
//        nodes.add(new HostAndPort("192.168.174.129", 7004));
//        nodes.add(new HostAndPort("192.168.174.129", 7005));
//        nodes.add(new HostAndPort("192.168.174.129", 7006));
//        JedisCluster jedisCluster = new JedisCluster(nodes);
//        //直接使用JedisCluster对象操作redis。
//        jedisCluster.set("test", "123");
//        String string = jedisCluster.get("test");
//        System.out.println(string);
//        //关闭JedisCluster对象
//        jedisCluster.close();
//    }
//}
