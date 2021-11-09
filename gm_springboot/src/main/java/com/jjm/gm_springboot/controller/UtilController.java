package com.jjm.gm_springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jjm.gm_springboot.entity.GmUsers;
import com.jjm.gm_springboot.service.GmUsersService;
import com.jjm.gm_springboot.utils.ResultData;
import com.jjm.gm_springboot.utils.createVerificationCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 玉不啄，不成器；人不学，不知道;志坚者，功名之柱也。
 *
 * @program: bank
 * @description: 验证码
 * @author: 蒋金铭
 * @create: 2021-01-28 16:38
 **/
@RestController
@Slf4j
@RequestMapping("/util")
public class UtilController {
    @Autowired
    private GmUsersService userService;
    static String CODE;

    /**
     * 生成随机验证码图片
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/getCodeImg")
    @ApiOperation(value = "获取验证码图片流")
    public void getIdentifyImage(@RequestParam(required = false) String id, HttpServletResponse response) throws IOException {
        log.info("执行了===>UtilController中的getIdentifyImage方法");
        //设置不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        //指定生成的响应图片
        response.setContentType("image/jpeg");
        createVerificationCode code = new createVerificationCode();
        BufferedImage image = code.getIdentifyImg();
        code.getG().dispose();
        //将图形验证码IO流传输至前端
        ImageIO.write(image, "JPEG", response.getOutputStream());
        CODE = code.getCode();
    }

    @GetMapping("/getCode")
    @ApiOperation(value = "获取验证码")
    public ResultData getCode() {
        return ResultData.success(CODE);
    }

//    @GetMapping("/getRoleId")
//    public ResultData getRoleId(){
//        log.info("执行了===>UtilController中的getRoleId方法");
//        QueryWrapper<GmUsers> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", "jjm");
//        GmUsers user = userService.getOne(wrapper);
//        int roleId =user.getRoleId();
//        String role=String.valueOf(roleId);
//        return new CommonResult<>(200,role);
//    }
}
