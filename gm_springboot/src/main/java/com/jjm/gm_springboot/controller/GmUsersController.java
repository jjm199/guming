package com.jjm.gm_springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jjm.gm_springboot.entity.GmUsers;
import com.jjm.gm_springboot.service.impl.GmUsersServiceImpl;
import com.jjm.gm_springboot.utils.ResultData;
import com.jjm.gm_springboot.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjm
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/users")
public class GmUsersController {

    @Autowired
    private GmUsersServiceImpl usersService;

    @GetMapping("/login")
    private ResultData loginByName(@RequestParam(required = false) String name) {

        LoginVo userVo = new LoginVo();

        GmUsers userByName = (GmUsers) usersService.getOne(new QueryWrapper<GmUsers>().eq("user_name", name));
        
        userVo.setUserName(userByName.getUserName());
        userVo.setUserPassword(userByName.getUserPassword());
        return ResultData.success();

    }

}

