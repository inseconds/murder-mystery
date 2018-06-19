package com.murder.mystery.service.server.netty.module.player.handler.impl;

import com.murder.mystery.service.server.core.model.Request;
import com.murder.mystery.service.server.netty.module.player.handler.PlayerHandler;
import com.murder.mystery.service.server.netty.session.Session;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

/**
 * Created by yuehui on 2018/6/19
 */
@Component
public class PlayerHandlerImpl implements PlayerHandler{

    @Override
    public TextWebSocketFrame login(Session session, Request request) {
        return new TextWebSocketFrame("hello");
    }
}
