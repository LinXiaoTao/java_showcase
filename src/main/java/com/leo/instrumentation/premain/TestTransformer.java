package com.leo.instrumentation.premain;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.tree.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 通过继承ClassFileTransformer来实现class类文件的转化处理
 * 这里使用ASM来操作字节码，实现的功能为被代理类方法打印方法。
 * Created on 2017/2/28 下午1:47
 * leo linxiaotao1993@vip.qq.com
 */
public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        if (!className.endsWith("TestAgent"))
            return classfileBuffer;
        //读取一个类，为类访问者(ClassVisitor)提供类解析
        ClassReader classReader = new ClassReader(classfileBuffer);
        //表示类的一个节点
        ClassNode node = new ClassNode();
        //访问这个类，可选的flag参数,表示如何修改这个类的默认行为。eg:SKIP_DEBUG 跳过调试信息等等
        classReader.accept(node, 0);
        for (Object object : node.methods) {
            //表示方法的一个节点
            MethodNode methodNode = (MethodNode) object;
            //<init>是类构造方法
            //<clinit>是类静态代码块
            if ("<init>".endsWith(methodNode.name) || "<clinit>".equals(methodNode.name))
                continue;
            //一个指令节点的双向链表，非线程安全类
            InsnList insnList = methodNode.instructions;
            InsnList list = new InsnList();
            //添加一个变量指令节点(FieldInsnNode)
            //参数说明:
            //opcode:操作码 GETSTATIC表示从常量池中获取一个常量
            //owner:变量类的所有者
            //name:变量名称
            //desc:变量类型描述符
            list.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System",
                    "out", "Ljava/io/PrintStream;"));
            //添加一个LDC指令节点.
            //ldc:表示将一个常量从常量池中推送到堆栈上
            list.add(new LdcInsnNode("Enter method-> " + node.name + "." + methodNode.name));
            //添加一个方法指令节点
            //参数说明:
            //opcode:操作码 INVOKEVIRTUAL表示调用对象的虚拟方法，并将结果推送到堆栈上
            //owner:方法类的所有者
            //name:方法名称
            //desc:方法类型描述符
            list.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));
            //插入自定义的指令
            insnList.insert(list);
            //增加方法的堆栈大小
            methodNode.maxStack += 3;
        }
        //可以从字节码中生成类文件(准确说符合java类文件格式的字节数组)的类访问者(ClassVisitor)
        ClassWriter writer = new ClassWriter(0);
        //让类访问者(ClassVisitor)访问当前类
        node.accept(writer);
        //输出符合java类文件格式的字节数组
        return writer.toByteArray();
    }
}
