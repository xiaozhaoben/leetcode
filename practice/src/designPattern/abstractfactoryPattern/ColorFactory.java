package designPattern.abstractfactoryPattern;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        if (colorType.equals("red")) {
            return new Red();
        } else if (colorType.equals("green")) {
            return new Green();
        } else if (colorType.equals("blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
