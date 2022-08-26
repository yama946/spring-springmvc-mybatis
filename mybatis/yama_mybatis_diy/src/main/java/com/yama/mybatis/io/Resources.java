package com.yama.mybatis.io;

import java.io.InputStream;

/**
*
*@autor yama946
*@company www.baidu.com
 *使用类加载器读取配置文件的类
*/
public class Resources {
    /**
     * 根据传入的参数获取一个字节输入流
     * @param pathname
     * @return
     */
    public static InputStream getResourceAsStream(String pathname){
        return Resources.class.getClassLoader().getResourceAsStream(pathname);
    }
}
