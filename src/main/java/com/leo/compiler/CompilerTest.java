package com.leo.compiler;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;

/**
 * Java编译器API，可以通过此API来动态编译Java代码
 * Created on 2017/2/28 上午10:25
 * leo linxiaotao1993@vip.qq.com
 */
public class CompilerTest {

    static final String JAVA_SOURCE = "public class Main{ public void main(){ System.out.println(\"Hello World\");}}";

    //通过JavaCompiler动态编译Java源代码，生成class文件，并使用ClassLoader去加载，通过反射调用方法。
    //正确输出为:
    //编译成功
    //Hello World
    public static void main(String[] args) throws IOException {
        //获取系统Java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获取标准Java文件管理器
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        //设置编译成功的class文件输出路径(这里为项目根目录下的"target/classes")
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File("target/classes")));
        StringSourceJavaObject sourceJavaObject = new CompilerTest.StringSourceJavaObject("Main", JAVA_SOURCE);
        Iterable fileObjects = Arrays.asList(sourceJavaObject);
        //编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);
        //编译结果
        boolean result = task.call();
        if (result) {
            System.out.println("编译成功");
            //通过ClassLoader加载生成类
            try {
                //这里获取的classLoader为AppClassLoader
                ClassLoader classLoader = CompilerTest.class.getClassLoader();
                //默认的ClassLoader的加载用户class路径为:"target/classes"
                Class clazz = classLoader.loadClass("Main");
                //通过反射调用main方法
                Object instance = clazz.newInstance();
                Method method = clazz.getDeclaredMethod("main");
                method.invoke(instance, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class StringSourceJavaObject extends SimpleJavaFileObject {
        private String mContent;

        public StringSourceJavaObject(String name, String content) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            mContent = content;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return mContent;
        }
    }
}
