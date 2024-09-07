package org.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * SpringLoader 类
 */
public class SpringLoader {
    private static AnnotationConfigApplicationContext  context;// spring上下文

    /**
     * 初始化spring
     */
    public static void Init()  {
        context = new AnnotationConfigApplicationContext();// 创建spring上下文
        context.scan("org.example"); // 指定要扫描的包路径
        context.refresh();// 刷新上下文
    }

    /**
     * 根据类型获取对应的实例
     * @param cls
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> cls){
        return context.getBean(cls);
    }

}