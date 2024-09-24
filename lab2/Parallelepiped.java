public class Parallelepiped extends GeometricFigure {

    private double length;      //длина
    private double width;       //ширина
    private double height;      //высота

    public Parallelepiped() {
    }

    public Parallelepiped(double length, double width, double height) {
        super("Параллелепипед");
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void calculateArea() {
        setArea(2 * (length * width + length * height + width * height));
    }

    @Override
    protected void calculateVolume() {
        setVolume(length * width * height);
    }

    @Override
    protected void displayData() {
        System.out.println("Длина: " + length);
        System.out.println("Ширина: " + width);
        System.out.println("Высота: " + height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
