package com.murder.mystery.service.server.netty.strategy;

import com.murder.mystery.service.server.netty.session.Session;

/**
 * Created by yuehui on 2018/6/10
 */
public interface MatchStrategy {

    public Session getAvailableUser();
}
