public abstract class GeometricFigure{

    private String name;
    private double area;
    private double volume;

    public GeometricFigure() {
    }

    public GeometricFigure(String name) {
        this.name = name;
    }

    protected abstract void calculateArea();
    protected abstract void calculateVolume();
    protected abstract void displayData();

    protected void display() {
        System.out.println("Название: " + name);
        displayData();
        System.out.println("Площадь: " + area);
        System.out.println("Объём: " + volume);
        count();
        System.out.println("==================================================");
    }

    protected void count() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
