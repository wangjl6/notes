package com.study.gupao.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.Arrays;

/**
 * 代理对象
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class MyProxy {

    public static Object newInstance(ClassLoader classLoader,Class<?> clazzs,MyInvocationHandler h){
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null,null,null);

//        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
//            JavaFileObject javaFileObject = manager.makeStringSource(fileName, source);
//            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
//            if (task.call()) {
//                results = manager.getClassBytes();
//            }
//        }
        return null;
    }
}
