package com.jjm.gm_springboot.service.impl;

import com.jjm.gm_springboot.entity.GmUsers;
import com.jjm.gm_springboot.mapper.GmUsersMapper;
import com.jjm.gm_springboot.service.GmUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjm
 * @since 2021-11-04
 */
@Service
public class GmUsersServiceImpl extends ServiceImpl<GmUsersMapper, GmUsers> implements GmUsersService {

}
