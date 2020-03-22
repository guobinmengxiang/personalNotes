package DesignPattern;

/**
 * @author 举个例子， 前段时间准备买个剃须刀，我这大胡子很浓密，在网上查了查德国博朗的比较牛逼，
 * 看了看评论，好多人评论上充电器是国产，客服解释德国充电器在中国不能用（网上查了查，插头不一样），所以换了国产，
 * 向他这种其实就是把充电头换了，我们如果不换头，在弄个转接口是不是也可以。
 * 这个转接口也叫作适配器
 *
 */
public class Adaptation {
	 public static void main(String[] args) {
		 EnPluginInterface enPlugin = new EnPlugin();
	        Home home = new Home();
	        PluginAdapter pluginAdapter = new PluginAdapter(enPlugin);
	        home.setPlugin(pluginAdapter);
	        // 会输出 “charge with EnPlugin”
	        home.charge();
	    }
}
//国标插头
 interface CnPluginInterface {
 void chargeWith2Pins();
}
 //英标插头
 interface EnPluginInterface{
	 void chargeWith3Pins();
	 
 }

//实现国标插头的充电方法
 class CnPlugin implements CnPluginInterface {
 public void chargeWith2Pins() {
     System.out.println("charge with CnPlugin");
 }
}
/* 实现英标插口*/
 class EnPlugin implements EnPluginInterface{

	@Override
	public void chargeWith3Pins() {
		System.out.println("charge with EnPlugin");
		
	}
	 
 }

//在国内家中充电
 class Home {
	//国标插头类型变量，拥有国标插头方法
 private CnPluginInterface cnPlugin;

 public Home() {
	 
 }

 public Home(CnPluginInterface cnPlugin) {
     this.cnPlugin = cnPlugin;
 }

 public void setPlugin(CnPluginInterface cnPlugin) {
     this.cnPlugin = cnPlugin;
 }

 // 充电
 public void charge() {
     // 国标充电
     cnPlugin.chargeWith2Pins();
 }
}
 
 
 //适配器
class PluginAdapter implements CnPluginInterface{
    private EnPluginInterface enPlugin;
    public PluginAdapter (EnPluginInterface enPlugin){
    	this.enPlugin=enPlugin;
    }
 // 这是重点，适配器实现了国标的插头，然后重写国标的充电方法，在国标的充电方法中调用英标的充电方法
	public void chargeWith2Pins() {
		enPlugin.chargeWith3Pins();
		
	}
	
}

/*当你想使用一个已有的类，但是这个类的接口跟你的又不一样，不能拿来直接用，
这个时候你就需要一个适配器来帮你了，其主要作用就是在旧的接口、新的接口之间完成适配
  三个特点：
*适配器对象实现原有接口
*适配器对象组合一个实现新接口的对象（这个对象也可以不实现一个接口，只是一个单纯的对象）
*对适配器原有接口方法的调用被委托给新接口的实例的特定方法
*/