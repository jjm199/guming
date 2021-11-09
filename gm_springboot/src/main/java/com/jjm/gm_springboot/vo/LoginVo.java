package com.jjm.gm_springboot.vo;

import lombok.Data;

/**
 * @author: jjm
 * @description: 登录表单实体类
 * @date: 2021/11/5
 */
@Data
public class LoginVo {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

}
