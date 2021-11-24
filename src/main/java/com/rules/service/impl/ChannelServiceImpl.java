package com.rules.service.impl;

import com.alibaba.fastjson.JSON;
import com.rules.service.ChannelService;

public class ChannelServiceImpl implements ChannelService {
    @Override
    public void send(Object object) {
        System.out.println("channel service send:" + JSON.toJSONString(object));
    }
}
