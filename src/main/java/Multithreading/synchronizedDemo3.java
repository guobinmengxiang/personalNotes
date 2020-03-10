package Multithreading;
/**
 * @author ���ݵ����
 *
 */
public class synchronizedDemo3{
    public static void main(String[] args){
    	
    	 try{
             Account account = new Account();
             Thread a = new MyThread3(account);
             a.start();
             Thread.sleep(1000);
             account.getAccount();
         }catch(InterruptedException e){
             e.printStackTrace();
         }
     } 
}



class Account{
    public String username = "zhangguobin";
    public String password = "123456";
    synchronized public void setAccount(String username,String password){
        try{
            this.username = username;
            Thread.sleep(1000);
            this.password = password;
            Thread.sleep(1000);
            System.out.println("set end,username:"+username+",password:"+password);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * ֻ��set�ϼ�����get�ϲ��ӣ��ᵼ������Ĳ���
     * �������������get��Ҳ���� synchronized
     */
    synchronized   public void getAccount(){
        System.out.println("get end,username:"+username+",password:"+password);
    }
}

class MyThread3 extends Thread{
    private Account account;
    public MyThread3(Account account){
        super();
        this.account = account;
    }
    @Override
    public void run(){
        super.run();
        account.setAccount("username2", "password2");
    }
}
