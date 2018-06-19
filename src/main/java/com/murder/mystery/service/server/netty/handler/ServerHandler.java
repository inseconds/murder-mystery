package com.murder.mystery.service.server.netty.handler;

import com.alibaba.fastjson.JSONObject;
import com.murder.mystery.service.server.core.model.Request;
import com.murder.mystery.service.server.core.model.Response;
import com.murder.mystery.service.server.core.model.ResultCode;
import com.murder.mystery.service.server.domain.Player;
import com.murder.mystery.service.server.netty.scanner.Invoker;
import com.murder.mystery.service.server.netty.scanner.InvokerHoler;
import com.murder.mystery.service.server.netty.session.Session;
import com.murder.mystery.service.server.netty.session.SessionImpl;
import com.murder.mystery.service.server.netty.session.SessionManager;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by yuehui on 2018/6/19
 */
@Component
@Qualifier("serverHandler")
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame request) throws Exception {

        handlerMessage(new SessionImpl(ctx.channel()), request);
    }

    private void handlerMessage(Session session, TextWebSocketFrame msg){
        Request request = JSONObject.parseObject(msg.text(), Request.class);
        Response response = new Response(request);

        System.out.println("module:"+request.getModule() + "   " + "cmd：" + request.getCmd());

        //获取命令执行器
        Invoker invoker = InvokerHoler.getInvoker(request.getModule(), request.getCmd());
        if(invoker != null){
            try {
                Object result = invoker.invoke(session, request);
                session.write(result);
            } catch (Exception e){
                response.setModule(request.getModule());
                response.setCmd(request.getCmd());
                response.setStateCode(ResultCode.UNKOWN_EXCEPTION);
                session.write(new TextWebSocketFrame(JSONObject.toJSONString(response)));
            }
//            try {
//                Result<?> result = null;
//                //假如是玩家模块传入channel参数，否则传入playerId参数
//                if(request.getModule() == ModuleId.PLAYER){
//                    result = (Result<?>)invoker.invoke(session, request.getData());
//                }else{
//                    Object attachment = session.getAttachment();
//                    if(attachment != null){
//                        Player player = (Player) attachment;
//                        result = (Result<?>)invoker.invoke(player.getPlayerId(), request.getData());
//                    }else{
//                        //会话未登录拒绝请求
//                        response.setStateCode(ResultCode.LOGIN_PLEASE);
//                        session.write(response);
//                        return;
//                    }
//                }
//
//                //判断请求是否成功
//                if(result.getResultCode() == ResultCode.SUCCESS){
//                    //回写数据
//                    Object object = result.getContent();
//                    if(object != null){
//                        if(object instanceof Serializer){
//                            Serializer content = (Serializer)object;
//                            response.setData(content.getBytes());
//                        }else if(object instanceof GeneratedMessage){
//                            GeneratedMessage content = (GeneratedMessage)object;
//                            response.setData(content.toByteArray());
//                        }else{
//                            System.out.println(String.format("不可识别传输对象:%s", object));
//                        }
//                    }
//                    session.write(response);
//                }else{
//                    //返回错误码
//                    response.setStateCode(result.getResultCode());
//                    session.write(response);
//                    return;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                //系统未知异常
//                response.setStateCode(ResultCode.UNKOWN_EXCEPTION);
//                session.write(response);
//            }
        }else{
            //未找到执行者
            response.setStateCode(ResultCode.NO_INVOKER);
            session.write(response);
            return;
        }
    }

    /**
     * 断线移除会话
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Session session = new SessionImpl(ctx.channel());
        Object object = session.getAttachment();
        if(object != null){
            Player player = (Player)object;
            SessionManager.removeSession(player.getPlayerId());
        }
    }
}
