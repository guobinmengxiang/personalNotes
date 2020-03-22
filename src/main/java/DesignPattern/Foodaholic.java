package DesignPattern;



/**
 * @author ���󹤳�
 *��������ģʽ����Ե��� һ����Ʒ�ȼ��ṹ ��������һ������ģʽ���ӣ��ϵ�����Ů
 *���󹤳�ģʽ����� �����Ʒ�ȼ��ṹ��������������˸�ʳ��and �;ߣ�ʳ����ƻ�����;��е����������ô����˼�����˸��㼶�ṹ
 *��ʵ�ҵ�����Ҳ�е��ң����������
 */
public class Foodaholic {

 public void eat(KitchenFactory k) {
    System.out.println("A foodaholic is eating "+ k.getFood().getFoodName()
           + " with " + k.getTableWare().getToolName() );
 }

 public static void main(String[] args) {
    Foodaholic fh = new Foodaholic();
    KitchenFactory kf = new AKitchen();
    fh.eat(kf);
 }
}
//����ʳ��
interface Food {
 public String getFoodName();
}

//����;�
interface TableWare {
 public String getToolName();
}

//���󹤳�
interface KitchenFactory {
 public Food getFood();
 public TableWare getTableWare();
}

//����ʳ�� Apple �Ķ�������
class Apple implements Food{
 public String getFoodName() {
     return "apple";
 }
}

//����;� Knife �Ķ�������
class Knife implements TableWare {
 public String getToolName() {
     return "knife";
 }
}

//�Ծ��幤�� AKitchen Ϊ��
class AKitchen implements KitchenFactory {

 public Food getFood() {
    return new Apple();
 }

 public TableWare getTableWare() {
    return new Knife();
 }
}

/*���󹤳�ģʽ�ر��ʺ���������һ�ֲ�Ʒ�ṹ��
��Ʒ��Ϊ����ϵ�У���ÿ��ϵ���У���Ʒ�Ĳ��ֶ������Ƶģ�
��һ��ϵ����ĳ��λ�õĲ�Ʒ������һ��ϵ����һ����һ����Ӧ�Ĳ�Ʒ��
�����Ĳ�Ʒ�ṹ�Ǵ��ڵģ�
�⼸��ϵ����ͬһλ�õĲ�Ʒ�����ǻ����
����������Բ�ͬ�ͻ��Ľ��������ÿ���ͻ���ֻѡ����һ��*/
