package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import redis.clients.jedis.UnifiedJedis;

public class Redis {
    private static Dotenv dotenv = Dotenv.load();
    private static UnifiedJedis jedis = new UnifiedJedis(dotenv.get("REDIS_URL"));

    public static String checkExists(String key){
        String value = jedis.get(key);
        return value;
    }

    public static String setValue(String key,String value){
        String result = jedis.set(key,value);
        return result;
    }

    public static void closeConn(){
        jedis.close();
    }
}
