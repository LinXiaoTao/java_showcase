package com.leo.timing;


import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

/**
 * Created on 2017/3/1 下午5:33
 * leo linxiaotao1993@vip.qq.com
 */
public class TimingMethodVisitor extends AdviceAdapter {

    private boolean mIsVisit = false;
    private String mMethodName;

    TimingMethodVisitor(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
        super(i, methodVisitor, i1, s, s1);
        mMethodName = s;
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
//        System.out.println("method enter isVisit: " + mIsVisit);
        if (mIsVisit){
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/leo/timing/CalculateUtil", "setStartTime", "(J)V", false);
        }
    }

    @Override
    protected void onMethodExit(int i) {
        super.onMethodExit(i);
//        System.out.println("method exit isVisit: " + mIsVisit);
        if (mIsVisit){
            mv.visitLdcInsn(mMethodName);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/leo/timing/CalculateUtil", "run", "(Ljava/lang/String;J)V", false);        }
    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {
//        System.out.println("method annotation: " + s);
        mIsVisit = Type.getDescriptor(Timing.class).equals(s);
        return super.visitAnnotation(s, b);
    }


}
