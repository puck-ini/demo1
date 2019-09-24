package com.test.demo1.service;

import com.test.demo1.entity.Msg;

import java.util.List;

public interface MsgService {

    Msg sendMsg(Msg msg);

    Msg updateMsg(Msg msg);

    Msg approveMsg(Msg msg);

    Boolean deleteMsg(Integer msgId);

    List<Msg> getAllMsg();

    Msg getOneMsg(Integer id);//消息id 用户id

    List<Msg> getUserMsg(Integer id);

    List<Msg> getMsg(String str);//内容 标题 用户名字



}
