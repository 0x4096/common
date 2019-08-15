package com.x4096.common.utils.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @Author: 0x4096.peng@gmail.com
 * @Project: common-utils
 * @DateTime: 2019/5/5 23:09
 * @Description: Base64 加解密工具类
 */
public class Base64EncryptUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64EncryptUtils.class);

    private Base64EncryptUtils() {
    }

    private static final String DEFAULT_CHARSET = "UTF-8";


    /**
     * base64 加密
     *
     * @param content 待加密内容
     * @return 加密后内容
     */
    public static String encrypt(String content) {
        if (content == null) {
            throw new NullPointerException("加密内容不能为null");
        }
        Base64 base64 = new Base64();
        byte[] textByte = new byte[0];
        try {
            textByte = content.getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的编码集", e);
        }
        return base64.encodeToString(textByte);
    }


    /**
     * base64 解密
     *
     * @param content 待解密内容
     * @return 解密后内容
     */
    public static String decrypt(String content) {
        if (content == null) {
            throw new NullPointerException("解密内容不能为null");
        }
        Base64 base64 = new Base64();
        try {
            return new String(base64.decode(content), DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的编码集", e);
        }
        return null;
    }

}
