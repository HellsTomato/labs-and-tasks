public class Cylinder extends GeometricFigure {

    private double radius;
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super("Цилиндр");
        this.radius = radius;
        this.height = height;
    }

    @Override
    protected void calculateArea() {
        setArea(2 * Math.PI * radius * (radius + height));
    }

    @Override
    protected void calculateVolume() {
        setVolume(Math.PI * radius * radius * height);
    }

    @Override
    protected void displayData() {
        System.out.println("Радиус: " + radius);
        System.out.println("Высота: " + height);}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
