package com.lilili.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilili.dao.DemoMapper;
import com.lilili.model.DemoData;
import org.springframework.stereotype.Service;

/**
 * @Author LiYuan
 * @Date 2021/11/8
 **/
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoData> implements DemoService {
}
