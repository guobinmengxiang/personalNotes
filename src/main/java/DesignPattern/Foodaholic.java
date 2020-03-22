package DesignPattern;



/**
 * @author 抽象工厂
 *工厂方法模式：针对的是 一个产品等级结构 ，比如上一个工厂模式例子，上帝造男女
 *抽象工厂模式：针对 多个产品等级结构，这个例子是造了个食物and 餐具，食物有苹果，餐具有刀，大概是这么个意思，多了个层级结构
 *其实我倒现在也有点乱，后续整理吧
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
//抽象食物
interface Food {
 public String getFoodName();
}

//抽象餐具
interface TableWare {
 public String getToolName();
}

//抽象工厂
interface KitchenFactory {
 public Food getFood();
 public TableWare getTableWare();
}

//具体食物 Apple 的定义如下
class Apple implements Food{
 public String getFoodName() {
     return "apple";
 }
}

//具体餐具 Knife 的定义如下
class Knife implements TableWare {
 public String getToolName() {
     return "knife";
 }
}

//以具体工厂 AKitchen 为例
class AKitchen implements KitchenFactory {

 public Food getFood() {
    return new Apple();
 }

 public TableWare getTableWare() {
    return new Knife();
 }
}

/*抽象工厂模式特别适合于这样的一种产品结构：
产品分为几个系列，在每个系列中，产品的布局都是类似的，
在一个系列中某个位置的产品，在另一个系列中一定有一个对应的产品。
这样的产品结构是存在的，
这几个系列中同一位置的产品可能是互斥的
，它们是针对不同客户的解决方案，每个客户都只选择其一。*/
