package com.hacker.framework.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public class Md5Util {

    /**
     * 计算字符串的MD5
     * @param content
     * @return
     */
    public static String getMd5(String content){
        return DigestUtils.md5Hex(StringUtils.trimAllWhitespace(content));
    }
}
