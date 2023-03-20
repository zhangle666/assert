package com.virtue.service.impl;

import com.virtue.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String mailUsername;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private TemplateEngine templateEngine;


    /**
     * 激活账号发送
     * @param activationUrl 激活人的url
     * @param email 收件人邮箱
     */
    @Override
    public void sedMailForActivationAccount(String  activationUrl, String email){
        //设置邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            //设置邮件主题
            message.setSubject("欢迎你注册-个人账户激活");
            //设置邮件发送者
            message.setFrom(mailUsername);
            //设置邮件的接收人
            message.setTo(email);
            //设置发送日期
            message.setSentDate(new Date());
            //设置上下文对象
            Context context = new Context();
            context.setVariable("activationUrl",activationUrl);
            String text=templateEngine.process("activation-account.html",context);
            //邮件发送
            message.setText(text,true);
        } catch (MessagingException e) {
            System.out.println("不自在");
        }
        try {
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            System.out.println("错误错误错误");
        }

    }
}
