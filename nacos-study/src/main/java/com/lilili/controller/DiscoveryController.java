package com.lilili.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/8
 **/
@Controller
@RequestMapping("discovery")
public class DiscoveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryController.class);
    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        LOGGER.debug("serviceName: {}", serviceName);
        List<Instance> allInstances = namingService.getAllInstances(serviceName);
        LOGGER.debug("allInstances: {}", allInstances);
        return allInstances;
    }
}
