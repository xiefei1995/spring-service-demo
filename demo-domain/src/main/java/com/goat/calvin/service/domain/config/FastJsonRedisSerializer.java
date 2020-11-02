package com.goat.calvin.service.domain.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>对入redis的数据做序列化处理<p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/16 10:56
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz){
        this.clazz = clazz;
    }

    /***
     *
     * @description implements Serializable
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        return t == null ? new byte[0] : JSON.toJSONString(t,new SerializerFeature[]{SerializerFeature.WriteClassName}).getBytes(DEFAULT_CHARSET);
    }

    /**
     *
     * @description implements deSerializable
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(bytes != null && bytes.length > 0){
            String str = new String(bytes,DEFAULT_CHARSET);
            return JSONObject.parseObject(str, this.clazz);
        }
        return  null;
    }
}
