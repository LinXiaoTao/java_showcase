package com.leo.timing;


import jdk.internal.org.objectweb.asm.*;

/**
 * Created on 2017/3/1 下午5:39
 * leo linxiaotao1993@vip.qq.com
 */
public class TimingClassVisitor extends ClassVisitor {

    private boolean mIsVisit = false;

    public TimingClassVisitor(int i) {
        super(i);
    }

    public TimingClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {
//        System.out.println("class annotation: " + s);
        mIsVisit = Type.getDescriptor(Timing.class).equals(s);
        return super.visitAnnotation(s, b);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        MethodVisitor methodVisitor = super.visitMethod(i, s, s1, s2, strings);
//        System.out.println("class isVisit: " + mIsVisit);
        if (mIsVisit)
            return new TimingMethodVisitor(Opcodes.ASM5, methodVisitor, i, s, s1);
        else
            return methodVisitor;

    }
}
