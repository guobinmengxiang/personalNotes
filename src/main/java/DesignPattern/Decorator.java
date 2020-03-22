package DesignPattern;

/**
 * @author װ����ģʽ
 *��̬�ذ�ְ�𸽼ӵ����ж�����ȥ��ʵ�ֹ�����չ���������ԣ�ʹ��װ����ģʽ�ṩ�˱ȼ̳и����е��ԵĽ��������
 *��վ�����Ͽ��羰�� ���羰������¥�Ͽ��㡣 ����װ������Ĵ��ӣ� ��װ���˱��˵��Ρ�
 *˳����һ�³����࣬ǰ������˵���ԣ��������߳�����ͽӿ���ɶ�����ҵ�ʱҲ���ˣ�ɶ�ǳ����ࣻ
 *abstract�����࣬��ʹ������Ϊһ�������࣬����ཫ�������ɶ���ʵ������������Ϊ����������������ͣ�
 *Ҳ���Ǳ���ʱ���ͣ������������һ��İ��Ʒ����Ҫ����̳в��������еĳ��󷽷���
 *abstract���η�������ʹ���������ɳ��󷽷���Ҳ����ֻ�����������壩��û��ʵ�֣�
 *ʵ�ֲ�����"��"���档��Ҫ����̳�ʵ�֣����ǣ�
 */
public class Decorator {
	 public static void main(String[] args) {
	        Girl g1 = new AmericanGirl();
	        System.out.println(g1.getDescription());

	        GoldenHair g2 = new GoldenHair(g1);
	        System.out.println(g2.getDescription());

	        Tall g3 = new Tall(g2);
	        System.out.println(g3.getDescription());

	        // ��Ҳ����һ����λ
	         Girl g = new Tall(new GoldenHair(new AmericanGirl()));
	    }
}
//����girl
abstract class Girl {
    String description = "no particular";

    public String getDescription(){
        return description;
    }
}
//����Ů��
class AmericanGirl extends Girl {
 public AmericanGirl() {
     description = "+AmericanGirl";
 }
}

//��������
class ChineseGirl extends Girl {
 public ChineseGirl() {
     description = "+ChineseGirl";
 }
}

//װ����
abstract class GirlDecorator extends Girl {
 public abstract String getDescription();
}
//����������Ů��ʾ��
//������Ů�����Ͻ�
class GoldenHair extends GirlDecorator {

 private Girl girl;

 public GoldenHair(Girl g) {
     girl = g;
 }

 @Override
 public String getDescription() {
     return girl.getDescription() + "+with golden hair";
 }

}

//������ĸߴ������
class Tall extends GirlDecorator {

 private Girl girl;

 public Tall(Girl g) {
     girl = g;
 }

 @Override
 public String getDescription() {
     return girl.getDescription() + "+is very tall";
 }

}

/*������Ҫ��̬�ظ�һ��������ӹ��ܣ�ʵ�ֹ�����չ��ʱ�򣬾Ϳ���ʹ��װ����ģʽ��
 * Java IO ������һ�������װ����ģʽӦ�ã� BufferedReader װ���� InputStreamReader
 * BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 * InputStreamReader(InputStream in) - InputSteamReader ��ȡ bytes �ֽ����ݣ�Ȼ��ת���� characters �� �����
 *BufferedReader(Reader in) - �� characters �� �ж�ȡ���ݲ����档
 */

//װ���ߺ�������
/*������ְ��������Ҳ������ת��ʱ�����µ�ְ�𣬵�����ҪĿ�Ĳ����ڴˣ���װ����ģʽ��ҪĿ�ģ����Ǹ���װ����������ְ���õġ�
����ԭ�ӿڣ�������ģʽ�����½ӿ�������ԭ�ӿڣ�ԭ�ӿڶ���ϵͳ��˵�ǲ��ɼ�����˵�����õģ���װ����ģʽԭ�ⲻ����ʹ��ԭ�ӿڣ�ϵͳ��װ�εĶ���Ҳͨ��ԭ�ӿ������ʹ�á�
����������Ķ�����������֪���������ߵ���ϸ����ģ������Ǹ�����Ǹ��ӿڣ�����װ����ֻ֪����ӿ���ʲô��������������ͣ��ǻ��໹�����������ֻࣩ���������ڼ��֪����*/
