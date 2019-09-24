package com.test.demo1.controller;


import com.test.demo1.entity.Msg;
import com.test.demo1.service.impl.MsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgServiceImpl msgService;

    //发送消息
    @PostMapping("/send")
    public Msg sendMsg(@RequestParam("title") String title,
                        @RequestParam("content") String content,
                        @RequestParam(value = "img",required = false) MultipartFile img){
        Msg msg = new Msg();
        msg.setTitle(title);
        msg.setContent(content);
        if (img != null){
            msg.setImg("123");
        }
        msg.setUserId(123);
        msg.setUsername("123");
        Msg msg1 = msgService.sendMsg(msg);
        return msg1;
    }

    //TODO
    //审批消息
    @GetMapping("/approve")
    public void approveMsg(@RequestParam("id") Integer msgId){
        Msg msg = msgService.getOneMsg(msgId);
        msgService.approveMsg(msg);
    }

    //更新消息
    @PostMapping("/update")
    public Msg updateMsg(@RequestParam("id") Integer msgId,
                         @RequestParam(value = "title",required = false) String title,
                         @RequestParam(value = "content",required = false) String content,
                         @RequestParam(value = "img",required = false) MultipartFile img){
        Msg msg = msgService.getOneMsg(msgId);
        if (msg == null){
            //throw new
        }
        if (title != null || title.isEmpty()){
            msg.setTitle(title);
        }
        if (content != null || content.isEmpty()){
            msg.setContent(content);
        }
        if (img != null){
            msg.setImg("123");
        }

        return msgService.updateMsg(msg);
    }
}
