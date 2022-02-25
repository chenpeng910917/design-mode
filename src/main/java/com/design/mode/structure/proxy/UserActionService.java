package com.design.mode.structure.proxy;

/**
 * 用户行为接口
 *
 * @author chenpeng
 */
public interface UserActionService {

    /**
     * 登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户信息
     */
    String login(String name, String password);

    /**
     * 注册
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户信息
     */
    String register(String name, String password);
}
