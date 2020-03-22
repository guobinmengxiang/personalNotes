package DesignPattern;

/**
 * @author 装饰者模式
 *动态地把职责附加到已有对象上去，实现功能扩展。这种特性，使得装饰者模式提供了比继承更具有弹性的解决方案。
 *你站在桥上看风景， 看风景的人在楼上看你。 明月装饰了你的窗子， 你装饰了别人的梦。
 *顺便聊一下抽象类，前天三弟说面试，问面试者抽象类和接口有啥区别，我当时也蒙了，啥是抽象类；
 *abstract修饰类，会使这个类成为一个抽象类，这个类将不能生成对象实例，但可以做为对象变量声明的类型，
 *也就是编译时类型，抽象类就像当于一类的半成品，需要子类继承并覆盖其中的抽象方法。
 *abstract修饰方法，会使这个方法变成抽象方法，也就是只有声明（定义）而没有实现，
 *实现部分以"；"代替。需要子类继承实现（覆盖）
 */
public class Decorator {
	 public static void main(String[] args) {
	        Girl g1 = new AmericanGirl();
	        System.out.println(g1.getDescription());

	        GoldenHair g2 = new GoldenHair(g1);
	        System.out.println(g2.getDescription());

	        Tall g3 = new Tall(g2);
	        System.out.println(g3.getDescription());

	        // 你也可以一步到位
	         Girl g = new Tall(new GoldenHair(new AmericanGirl()));
	    }
}
//抽象girl
abstract class Girl {
    String description = "no particular";

    public String getDescription(){
        return description;
    }
}
//美国女孩
class AmericanGirl extends Girl {
 public AmericanGirl() {
     description = "+AmericanGirl";
 }
}

//国产妹子
class ChineseGirl extends Girl {
 public ChineseGirl() {
     description = "+ChineseGirl";
 }
}

//装饰者
abstract class GirlDecorator extends Girl {
 public abstract String getDescription();
}
//下面以美国女孩示例
//给美国女孩加上金发
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

//加上身材高大的特性
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

/*当你需要动态地给一个对象添加功能，实现功能扩展的时候，就可以使用装饰者模式。
 * Java IO 类中有一个经典的装饰者模式应用， BufferedReader 装饰了 InputStreamReader
 * BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 * InputStreamReader(InputStream in) - InputSteamReader 读取 bytes 字节内容，然后转换成 characters 流 输出。
 *BufferedReader(Reader in) - 从 characters 流 中读取内容并缓存。
 */

//装饰者和适配器
/*关于新职责：适配器也可以在转换时增加新的职责，但其主要目的并不在此；而装饰者模式主要目的，就是给被装饰者增加新职责用的。
关于原接口：适配器模式是用新接口来调用原接口，原接口对新系统来说是不可见或者说不可用的；而装饰者模式原封不动的使用原接口，系统对装饰的对象也通过原接口来完成使用。
关于其包裹的对象：适配器是知道被适配者的详细情况的（就是那个类或那个接口）；而装饰者只知道其接口是什么，至于其具体类型（是基类还是其他派生类）只有在运行期间才知道。*/
