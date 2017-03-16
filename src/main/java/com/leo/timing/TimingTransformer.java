package com.leo.timing;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 统计方法耗时
 * Created on 2017/3/1 下午5:18
 * leo linxiaotao1993@vip.qq.com
 */
public class TimingTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain
            , byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassReader classReader = new ClassReader(classfileBuffer);
        ClassWriter writer = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
        TimingClassVisitor timingClassVisitor = new TimingClassVisitor(Opcodes.ASM5, writer);
        classReader.accept(timingClassVisitor, ClassReader.EXPAND_FRAMES);
        return writer.toByteArray();
    }
}
