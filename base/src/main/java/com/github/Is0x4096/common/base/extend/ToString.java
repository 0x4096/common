package com.github.Is0x4096.common.base.extend;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * 重写 toString 方法, 其他类继承此类即可 默认使用 fastjson 若使用 Jackson 可通过
 * System.setProperty("com.github.0x4096.json.serialize", "Jackson") 配置
 *
 * @author 0x4096.peng@gmail.com
 * @date 2021/7/24
 */
@Slf4j
public class ToString {

    private static ObjectMapper DEFAULT_MAPPER;
    private static boolean isJackson;

    static {
        String prop = System.getProperty("com.github.0x4096.json.serialize", "fastjson");
        if ("Jackson".equalsIgnoreCase(prop)) {
            isJackson = true;
            DEFAULT_MAPPER = new ObjectMapper();
            DEFAULT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            DEFAULT_MAPPER.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
            DEFAULT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            DEFAULT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            DEFAULT_MAPPER.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
            DEFAULT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            DEFAULT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            log.info("com.github.Is0x4096.common.base.extend.ToString 使用 Jackson 序列化");
        } else {
            log.info("com.github.Is0x4096.common.base.extend.ToString 使用 fastjson 序列化");
        }
    }

    @Override
    public String toString() {
        if (isJackson) {
            return jackSon(this, DEFAULT_MAPPER);
        } else {
            return fastjson(this);
        }
    }


    private static String fastjson(Object obj) {
        return JSON.toJSONString(obj);
    }

    private static String jackSon(Object t, ObjectMapper objectMapper) {
        if (t == null || objectMapper == null) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            log.error("json转换异常", e);
            return null;
        }
    }

}
