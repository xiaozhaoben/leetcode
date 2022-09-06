package designPattern.BridgePattern;

/**
 * 优点
 * 1、分离抽象接口及其实现部分。提高了比继承更好的解决方案。
 * 2、桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。
 * 3、实现细节对客户透明，可以对用户隐藏实现细节。
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}