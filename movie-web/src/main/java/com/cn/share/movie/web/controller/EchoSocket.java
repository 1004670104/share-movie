package com.cn.share.movie.web.controller;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/echo")
@Slf4j
public class EchoSocket {

    public EchoSocket(){
    }

    @OnOpen
    public void open(Session session){
        //一个session代表一个通信会话
        //通过sessionid区分每一个会话
        log.info("open() - 连接成功");
        log.info("open() - session id = " + session.getId());
    }

    @OnClose
    public void close(Session session){
        log.info("close() - close " + session.getId());
    }

    @OnMessage
    public void getMessage(Session session, String message){
        log.info("getMessage() - msg = " + message);

        try {
            session.getBasicRemote().sendText("server: " + message);
        }catch (IOException io){
            log.error("close() - io = " + io);
        }
    }
}
