package Multithreading;
/**
 * @author 数据的脏读
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
     * 只在set上加锁，get上不加，会导致脏读的产生
     * 解决方案就是在get上也加上 synchronized
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
