package com.murder.mystery.service.server.netty.module.player.handler;

import com.murder.mystery.service.server.annotion.SocketCommand;
import com.murder.mystery.service.server.annotion.SocketModule;
import com.murder.mystery.service.server.netty.model.Request;
import com.murder.mystery.service.server.netty.session.Session;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * Created by yuehui on 2018/6/19
 */
@SocketModule(module = 1)
public interface PlayerHandler {

    @SocketCommand(cmd = 1)
    public TextWebSocketFrame login(Session session, Request request);
}
