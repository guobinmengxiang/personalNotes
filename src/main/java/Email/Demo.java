package Email;
import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

public class Demo
{
	public static void main(String[] args) throws MessagingException, IOException
	{
		send();//发送普通邮件
		sendWithFile();//发送带附件的邮件
	}
	/**
	 * 发送普通邮件示例
	 * */
	public static void send() throws MessagingException, IOException
	{
		/**
		 * 得到session
		 * MailUtils.createSession(服务器地址，登录名，授权码)
		 * */
		Session session = MailUtils.createSession("smtp.qq.com","1774427221","授权码");
		/**
		 * 创建mail对象
		 * 发件人,收件人,主题,正文
		 * */
		Mail mail = new Mail("1774427221@qq.com", "zhangguobin@sinosoft.com.cn","主题","<a href='http://www.zhangguobin.com'>这是一封垃圾邮件</a>");
		/**
		 * 调用utils发送邮件
		 * */
		MailUtils.send(session, mail);
	}
	/**
	 * 发送带附件的邮件实例
	 * @throws IOException 
	 * @throws MessagingException 
	 * */
	public static void sendWithFile() throws MessagingException, IOException
	{
		/**
		 * 得到session
		 * */
		Session session = MailUtils.createSession("smtp.qq.com","1774427221","授权码");
		/**
		 * 创建mail对象
		 * 发件人,收件人,主题,正文
		 * */
		Mail mail = new Mail("1774427221@qq.com", "zhangguobin@sinosoft.com.cn","带附件的邮件","<a href='http://www.zhangguobin.com'>带附件</a>");
		/**
		 * 创建Bean类,(一个Bean表示一个附件,可以有多个)
		 * 上传的文件,显示在收件人的文件名称
		 **/
		AttachBean ab1 = new AttachBean(new File("D:\\ceshi\\1.txt"),"fujian");
	//	AttachBean ab2 = new AttachBean(new File("D:\\Demo.xml"),"xml配置文件d.xml");
		/**
		 * 把附件添加到邮件(mail)对象中
		 * */
		mail.addAttach(ab1);
	//	mail.addAttach(ab2);
		/**
		 * 调用utils发送邮件
		 * */
		MailUtils.send(session, mail);
	}
}