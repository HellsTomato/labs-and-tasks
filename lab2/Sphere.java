public class Sphere extends GeometricFigure {

    private static int spheresCreated = 0; //1

    private double radius;

    public Sphere() {
    }

    public Sphere(double radius) {
        super("Шар");
        this.radius = radius;
        spheresCreated++;
    }

    @Override
    protected void calculateArea() {
        setArea(4 * Math.PI * radius * radius);
    }

    @Override
    protected void calculateVolume() {
        setVolume((4.0 / 3) * Math.PI * radius * radius * radius);
    }

    @Override
    protected void displayData() {
        System.out.println("Радиус: " + radius);
    }

    @Override
    protected void count() {
        System.out.println("Количество созданных шаров: " + spheresCreated);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
