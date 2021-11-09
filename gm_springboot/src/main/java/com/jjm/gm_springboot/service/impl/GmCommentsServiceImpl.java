package com.jjm.gm_springboot.service.impl;

import com.jjm.gm_springboot.entity.GmComments;
import com.jjm.gm_springboot.mapper.GmCommentsMapper;
import com.jjm.gm_springboot.service.GmCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蒋金铭
 * @since 2021-11-04
 */
@Service
public class GmCommentsServiceImpl extends ServiceImpl<GmCommentsMapper, GmComments> implements GmCommentsService {

}
