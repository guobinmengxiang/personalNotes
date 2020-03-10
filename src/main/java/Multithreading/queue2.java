package Multithreading;

/**
 * @author ����
 * �Ƚ��ȳ���
 *
 */
public class queue2 {

	public static void main(String[] args) {
        MyLinkQueue<Integer> lq = new MyLinkQueue<Integer>();

        System.out.println("�����Ƿ�Ϊ�գ�" + lq.isNull());

        // ���β��� 1��2��3��4
        lq.push(new QNode<Integer>(1));
        lq.push(new QNode<Integer>(2));
        lq.push(new QNode<Integer>(3));
        lq.push(new QNode<Integer>(4));

        // ���γ���
        System.out.println("���γ��ӣ�");
        while (!lq.isNull()) {
            System.out.println(lq.pop().getData());
        }

    }
}


class MyLinkQueue<T> {
    private QNode<T> front;// ��ͷָ��
    private QNode<T> rear;// ��βָ��
    private int maxSize;// Ϊ�˱��ڲ�����ʹ�����������ʾ���ӵ���������

    // ��ʼ��
    public MyLinkQueue() {
        this.front = new QNode<T>();
        this.rear = new QNode<T>();
        this.maxSize = 0;
    }

    // ��ʼ������
    public void initQueue() {
        front.next = null;
        rear.next = null;
        maxSize = 0;
    }

    // �ӿ��ж�
    public boolean isNull() {
        if (front.next == null || rear.next == null)
            return true;
        else
            return false;
    }

    // ����
    public void push(QNode<T> node) {
        if (isNull()) {
            // ��һ��
            front.next = node;
            rear.next = node;
            maxSize++;
        } else {
            node.next = front.next;
            front.next = node;
            maxSize++;
        }
    }

    // ����
    public QNode<T> pop() {
        if (isNull())
            return null;// ��Ϊ��ʱ���޷�����
        else if (maxSize == 1) {
            // ��ֻ��һ��Ԫ��ʱֱ�ӳ�ʼ������
            QNode<T> node = front.next;
            initQueue();
            return node;
        } else {
            // ׼������
            QNode<T> p = front;// ʹ�� p ָ������������
            for (int i = 1; i < maxSize - 1; i++)
                p = p.next;
            // pop
            QNode<T> node = rear.next;
            rear.next = p.next;
            maxSize--;
            return node;
        }
    }

}

// ���ӽ��
class QNode<T> {
    private T data;// ������
    public QNode<T> next;// ָ����

    // ��ʼ�� 1
    public QNode() {
        this.data = null;
        this.next = null;
    }

    // ��ʼ�� 2
    public QNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}