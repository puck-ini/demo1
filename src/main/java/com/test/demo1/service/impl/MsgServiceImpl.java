package com.test.demo1.service.impl;

import com.test.demo1.entity.Msg;
import com.test.demo1.repository.MsgRepository;
import com.test.demo1.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MsgServiceImpl implements MsgService{

    @Autowired
    private MsgRepository msgRepository;

    @Override
    public Msg sendMsg(Msg msg) {
        msg.setCreateTime(new Date());
        msg.setLastModifyTime(new Date());
        msg.setStatus(0);
        return msgRepository.save(msg);
    }

    @Override
    public Msg updateMsg(Msg msg) {
        msg.setLastModifyTime(new Date());
        return msgRepository.save(msg);
    }

    @Override
    public Msg approveMsg(Msg msg) {
        msg.setStatus(1);//TODO
        return msgRepository.save(msg);
    }


    @Override
    public Boolean deleteMsg(Integer msgId) {
        if (msgRepository.getOne(msgId) == null){
            return false;
        }
        msgRepository.deleteById(msgId);
        return true;
    }

    @Override
    public List<Msg> getAllMsg() {
        return msgRepository.findAll();
    }

    @Override
    public Msg getOneMsg(Integer id) {
        return msgRepository.getOne(id);
    }

    @Override
    public List<Msg> getUserMsg(Integer id) {
        return msgRepository.findByUserId(id);
    }

    @Override
    public List<Msg> getMsg(String str) {
        Set<Msg> msgSet = new HashSet<>();
        List<Msg> msgTitleList = msgRepository.findByTitle(str);
        List<Msg> msgContentList = msgRepository.findByContent(str);
        List<Msg> msgUsernameList = msgRepository.findByUsername(str);
        msgSet.addAll(msgTitleList);
        msgSet.addAll(msgContentList);
        msgSet.addAll(msgUsernameList);
        return new ArrayList<>(msgSet);
    }

}
