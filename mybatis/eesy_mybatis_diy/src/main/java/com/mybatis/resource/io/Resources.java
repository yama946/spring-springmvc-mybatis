package com.mybatis.resource.io;

import java.io.InputStream;
/**
 * 使用类加载器读取配置文件的类
 * @autor yama946
 * @company www.baidu.com
 */
public class Resources {
    /**
     * 传入一个值，通过类加载器，获取一个指定资源的输入流
     * @param
     * @return
     */
    public static InputStream getResourceAsStream(String fileName) {
        return Resources.class.getClassLoader().getResourceAsStream(fileName);
    }
}
