package designPattern.factoryPattern;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        return switch (shapeType) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            case "rectangle" -> new Rectangle();
            default -> null;
        };
    }

}
