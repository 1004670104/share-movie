package com.cn.share.movie.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@ServerEndpoint("/chat")
@Slf4j
public class ChatSocketController {

    //定义一个全局变量集合sockets,用户存放每个登录用户的通信管道
    private static Set<ChatSocketController> socket = new HashSet<>();
    //定义一个全局变量Session,用于存放登录用户
    private Session session;

    /**
     *@OnOpen注解
     *注解下的方法会在连接建立时运行
     */
    @OnOpen
    public void open(Session session){
        this.session = session;
        socket.add(this);
    }

    /**
     *@OnMessage注解
     *注解下的方法会在前台传来消息时触发
     */
    @OnMessage
    public void getmessage(Session session, String message){
        broadcaet(socket, message);
    }

    /**
     *@OnClose注解
     *注解下的方法会在连接关闭时运行
     */
    @OnClose
    public void close(Session session){
        socket.remove(this);
        log.info("close() - " + session.getId() + " logout! ");
    }

    public void broadcaet(Set<ChatSocketController> socket, String msg){
        for (ChatSocketController c : socket) {
            try {
                c.session.getBasicRemote().sendText(msg);
            }catch (IOException io){
                log.error("broadcaet() - io = " + io);
            }
        }
    }
}
