package com.leo.instrumentation.agentmain;

import java.io.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * hook ProcessBuilder.start
 * Created on 2017/3/6 下午1:07
 * leo linxiaotao1993@vip.qq.com
 */
public class HookProcessBuilder implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        if (!className.endsWith(ProcessBuilder.class.getName()))
//            return classfileBuffer;
        File file = new File("names");
        String lineSeparator = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction("line.separator"));
        PrintStream printStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists())
                file.createNewFile();
            fileOutputStream = new FileOutputStream(file, true);
            printStream = new PrintStream(fileOutputStream);
            printStream.append(className + lineSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
                if (printStream != null)
                    printStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
