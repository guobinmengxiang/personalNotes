package DesignPattern;



/**
 * @author 工厂模式
 *
 */
//工厂测试类
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
//二者共同的接口
interface Human{
 public void eat();
 public void sleep();
 public void beat();
}

//创建实现类 Male
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
//创建实现类 Female
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

//创建普通工厂类
/**
 * @author 工厂模式（Factory Pattern）的意义就跟它的名字一样，在面向对象程序设计中，工厂通常是一个用来创建其他对象的对象。工厂模式根据不同的参数来实现不同的分配方案和创建对象。
 *在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象
 *普通工厂模式，如果传递参数有误，则不能正确创建对象
 *工厂模式分为：普通工厂模式、多个工厂方法模式、静态工厂方法模式
 */
/*class HumanFactory{
 public Human createHuman(String gender){
     if( gender.equals("male") ){
        return new Male();
     }else if( gender.equals("female")){
        return new Female();
     }else {
         System.out.println("请输入正确的类型！");
         return null;
     }
 }
}*/

/*//多个工厂方法
//为解决普通工厂模式，传递参数有误问题，索性创建多个工厂方法；
 class HumanFactory{
 public Male createMale() {
     return new Male();
 }
 public Female createFemale() {
     return new Female();
 }
}*/
//多个工厂方法
//静态工厂方法，调用时无须创建实例
class HumanFactory{
  public static Male createMale() {
      return new Male();
  }
  public static Female createFemale() {
      return new Female();
  }
}



/*总结：凡是出现了大量的产品需要创建，并且具有共同的接口时，
可以通过工厂方法模式进行创建。在以上的三种模式中，第一种如果传入的字符串有误，
不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，
我们会选用第三种——静态工厂方法模式

*举个实例
*在 Java 库里面。根据不同的参数，getInstance() 方法会返回不同的 Calendar 对象。
*java.util.Calendar - getInstance()
java.util.Calendar - getInstance(TimeZone zone)
java.util.Calendar - getInstance(Locale aLocale)
java.util.Calendar - getInstance(TimeZone zone, Locale aLocale)
java.text.NumberFormat - getInstance()
java.text.NumberFormat - getInstance(Locale inLocale)
*
*/
