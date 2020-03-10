package Multithreading;

/**
 * @author 队列
 * 先进先出，
 *
 */
public class queue {

	public static void main(String[] args) {
        MyQueue<Character> queue = new MyQueue<Character>(4);

        //判断
        System.out.println("队列是否为空：" + queue.isNull());

        //入队 A,B,C
        queue.push('A');
        queue.push('B');
        queue.push('C');

        System.out.println("队列是否为满：" + queue.isFull());

        //出队
        Character data = queue.pop();
        System.out.println("出队："+data);
    }
}
class MyQueue<T>{
    private T[] datas;//使用数组作为队列的容器
    private int maxSize;//队列的容量
    private int front;//头指针
    private int rear;//尾指针

    //初始化队列
    public MyQueue(int maxSize){
        if(maxSize < 1){
            maxSize = 1;
        }
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.datas = (T[])new Object[this.maxSize];
    }

    //两个状态：队空&队满
    public boolean isNull(){
        if(this.front == this.rear)
            return true;
        else
            return false;
    }

    public boolean isFull(){
        if((rear+1) % this.maxSize == front)
            return true;
        else
            return false;
    }

    //初始化队列
    public void initQueue(){
        this.front = 0;
    }

    //两个操作：进队&出队
    public boolean push(T data){
        if(isFull())
            return false;//队满则无法进队
        else{
            datas[rear] = data;//进队
            rear = (rear+1) % maxSize;//队尾指针+1.
            return true;
        }
    }
    public T pop(){
        if(isNull())
            return null;//对空无法出队
        else{
            T popData = datas[front++];//出队
            front = (front+1) % maxSize;//队头指针+1
            return popData;
        }
    }

    //get()
    public T[] getDatas() {
        return datas;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }
}
