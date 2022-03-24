package com.design.pattern.behavior.template.callback;

/**
 * @author chenpeng
 */
public class CallbackDemo {

    public static void main(String[] args) {
        // JDBC回调函数 伪代码 缺少mysql配置信息
//        UserService userService = new UserService();
//        userService.queryUser(1L);

        // 手写回调函数
        DataProcess dataProcess = new DataProcess();
        Object process = dataProcess.process("MYSQL数据");
        System.out.println(process);
    }

}
