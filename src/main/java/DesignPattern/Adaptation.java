package DesignPattern;

/**
 * @author �ٸ����ӣ� ǰ��ʱ��׼��������뵶���������Ӻ�Ũ�ܣ������ϲ��˲�¹����ʵıȽ�ţ�ƣ�
 * ���˿����ۣ��ö��������ϳ�����ǹ������ͷ����͵¹���������й������ã����ϲ��˲飬��ͷ��һ���������Ի��˹�����
 * ����������ʵ���ǰѳ��ͷ���ˣ������������ͷ����Ū��ת�ӿ��ǲ���Ҳ���ԡ�
 * ���ת�ӿ�Ҳ����������
 *
 */
public class Adaptation {
	 public static void main(String[] args) {
		 EnPluginInterface enPlugin = new EnPlugin();
	        Home home = new Home();
	        PluginAdapter pluginAdapter = new PluginAdapter(enPlugin);
	        home.setPlugin(pluginAdapter);
	        // ����� ��charge with EnPlugin��
	        home.charge();
	    }
}
//�����ͷ
 interface CnPluginInterface {
 void chargeWith2Pins();
}
 //Ӣ���ͷ
 interface EnPluginInterface{
	 void chargeWith3Pins();
	 
 }

//ʵ�ֹ����ͷ�ĳ�緽��
 class CnPlugin implements CnPluginInterface {
 public void chargeWith2Pins() {
     System.out.println("charge with CnPlugin");
 }
}
/* ʵ��Ӣ����*/
 class EnPlugin implements EnPluginInterface{

	@Override
	public void chargeWith3Pins() {
		System.out.println("charge with EnPlugin");
		
	}
	 
 }

//�ڹ��ڼ��г��
 class Home {
	//�����ͷ���ͱ�����ӵ�й����ͷ����
 private CnPluginInterface cnPlugin;

 public Home() {
	 
 }

 public Home(CnPluginInterface cnPlugin) {
     this.cnPlugin = cnPlugin;
 }

 public void setPlugin(CnPluginInterface cnPlugin) {
     this.cnPlugin = cnPlugin;
 }

 // ���
 public void charge() {
     // ������
     cnPlugin.chargeWith2Pins();
 }
}
 
 
 //������
class PluginAdapter implements CnPluginInterface{
    private EnPluginInterface enPlugin;
    public PluginAdapter (EnPluginInterface enPlugin){
    	this.enPlugin=enPlugin;
    }
 // �����ص㣬������ʵ���˹���Ĳ�ͷ��Ȼ����д����ĳ�緽�����ڹ���ĳ�緽���е���Ӣ��ĳ�緽��
	public void chargeWith2Pins() {
		enPlugin.chargeWith3Pins();
		
	}
	
}

/*������ʹ��һ�����е��࣬���������Ľӿڸ�����ֲ�һ������������ֱ���ã�
���ʱ�������Ҫһ���������������ˣ�����Ҫ���þ����ھɵĽӿڡ��µĽӿ�֮���������
  �����ص㣺
*����������ʵ��ԭ�нӿ�
*�������������һ��ʵ���½ӿڵĶ����������Ҳ���Բ�ʵ��һ���ӿڣ�ֻ��һ�������Ķ���
*��������ԭ�нӿڷ����ĵ��ñ�ί�и��½ӿڵ�ʵ�����ض�����
*/