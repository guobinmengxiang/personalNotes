package Multithreading;

/**
 * @author ����
 * �Ƚ��ȳ���
 *
 */
public class queue {

	public static void main(String[] args) {
        MyQueue<Character> queue = new MyQueue<Character>(4);

        //�ж�
        System.out.println("�����Ƿ�Ϊ�գ�" + queue.isNull());

        //��� A,B,C
        queue.push('A');
        queue.push('B');
        queue.push('C');

        System.out.println("�����Ƿ�Ϊ����" + queue.isFull());

        //����
        Character data = queue.pop();
        System.out.println("���ӣ�"+data);
    }
}
class MyQueue<T>{
    private T[] datas;//ʹ��������Ϊ���е�����
    private int maxSize;//���е�����
    private int front;//ͷָ��
    private int rear;//βָ��

    //��ʼ������
    public MyQueue(int maxSize){
        if(maxSize < 1){
            maxSize = 1;
        }
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.datas = (T[])new Object[this.maxSize];
    }

    //����״̬���ӿ�&����
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

    //��ʼ������
    public void initQueue(){
        this.front = 0;
    }

    //��������������&����
    public boolean push(T data){
        if(isFull())
            return false;//�������޷�����
        else{
            datas[rear] = data;//����
            rear = (rear+1) % maxSize;//��βָ��+1.
            return true;
        }
    }
    public T pop(){
        if(isNull())
            return null;//�Կ��޷�����
        else{
            T popData = datas[front++];//����
            front = (front+1) % maxSize;//��ͷָ��+1
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
