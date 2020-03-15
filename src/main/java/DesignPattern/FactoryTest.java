package DesignPattern;



/**
 * @author ����ģʽ
 *
 */
//����������
public class FactoryTest {
public static void main(String[] args){
/*     HumanFactory factory = new HumanFactory();
 Human male = factory.createMale();*/
 Human male=HumanFactory.createFemale();
   male.eat();
   male.sleep();
   male.beat();
}
}
//���߹�ͬ�Ľӿ�
interface Human{
 public void eat();
 public void sleep();
 public void beat();
}

//����ʵ���� Male
class Male implements Human{
 public void eat(){
     System.out.println("Male can eat."); 
 }
 public void sleep(){
     System.out.println("Male can sleep.");
 }
 public void beat(){
     System.out.println("Male can beat.");
 }
} 
//����ʵ���� Female
class Female implements Human{
 public void eat(){
     System.out.println("Female can eat."); 
 }
 public void sleep(){
     System.out.println("Female can sleep.");
 }
 public void beat(){
     System.out.println("Female can beat.");
 }
} 

//������ͨ������
/**
 * @author ����ģʽ��Factory Pattern��������͸���������һ��������������������У�����ͨ����һ������������������Ķ��󡣹���ģʽ���ݲ�ͬ�Ĳ�����ʵ�ֲ�ͬ�ķ��䷽���ʹ�������
 *�ڹ���ģʽ�У������ڴ�������ʱ����Կͻ��˱�¶�����߼���������ͨ��ʹ��һ����ͬ�Ľӿ���ָ���´����Ķ���
 *��ͨ����ģʽ��������ݲ�������������ȷ��������
 *����ģʽ��Ϊ����ͨ����ģʽ�������������ģʽ����̬��������ģʽ
 */
/*class HumanFactory{
 public Human createHuman(String gender){
     if( gender.equals("male") ){
        return new Male();
     }else if( gender.equals("female")){
        return new Female();
     }else {
         System.out.println("��������ȷ�����ͣ�");
         return null;
     }
 }
}*/

/*//�����������
//Ϊ�����ͨ����ģʽ�����ݲ����������⣬���Դ����������������
 class HumanFactory{
 public Male createMale() {
     return new Male();
 }
 public Female createFemale() {
     return new Female();
 }
}*/
//�����������
//��̬��������������ʱ���봴��ʵ��
class HumanFactory{
  public static Male createMale() {
      return new Male();
  }
  public static Female createFemale() {
      return new Female();
  }
}



/*�ܽ᣺���ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ��
����ͨ����������ģʽ���д����������ϵ�����ģʽ�У���һ�����������ַ�������
������ȷ�������󣬵���������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£�
���ǻ�ѡ�õ����֡�����̬��������ģʽ

*�ٸ�ʵ��
*�� Java �����档���ݲ�ͬ�Ĳ�����getInstance() �����᷵�ز�ͬ�� Calendar ����
*java.util.Calendar - getInstance()
java.util.Calendar - getInstance(TimeZone zone)
java.util.Calendar - getInstance(Locale aLocale)
java.util.Calendar - getInstance(TimeZone zone, Locale aLocale)
java.text.NumberFormat - getInstance()
java.text.NumberFormat - getInstance(Locale inLocale)
*
*/
