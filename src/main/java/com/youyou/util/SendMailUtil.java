package com.youyou.util;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * 发送邮箱的工具类
 * <p>
 * Created by 张磊 on 2017/5/8.
 */
public class SendMailUtil {
    /**
     * 配置文件文件位置:classpath路径下的:/JavaMail.properties
     *
     * @param toAddressStr
     * @param subject
     * @param text
     * @throws IOException
     * @throws MessagingException
     */
    public static void sendMail(String toAddressStr, String subject, String text, String propertiesName) throws IOException, MessagingException {
        Properties properties = new Properties();
        properties.load(ClassLoader.class.getResourceAsStream("/" + propertiesName));
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        InternetAddress fromAddress = new InternetAddress(properties.getProperty("fromAddress"));
        InternetAddress toAddress = new InternetAddress(toAddressStr);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
        message.setText(text);
        Transport transport = session.getTransport("smtp");
        transport.connect("17621023548@163.com", properties.getProperty("authorizationPassword"));
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     * 默认值为:
     * JavaMail.properties
     *
     * @param toAddressStr
     * @param subject
     * @param text
     * @throws IOException
     * @throws MessagingException
     */
    public static void sendMail(String toAddressStr, String subject, String text) throws IOException, MessagingException {
        sendMail(toAddressStr, subject, text, "JavaMail.properties");
    }
}
