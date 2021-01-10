package com.wqie.attendance.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailling {
    @Autowired
    JavaMailSender mailSender;

    public Mailling() {
    }

    public void sendSimpleMail(String empno) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("2450182283@qq.com");
            message.setTo("201070292@qq.com");
            message.setSubject("有新的请假信息！！！");
            message.setText("员工" + empno + "申请请假！！！");
            this.mailSender.send(message);
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("发送失败！！！");
        }

    }
}
