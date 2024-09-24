public class Main {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(5.0);
        sphere.calculateArea();
        sphere.calculateVolume();
        sphere.display();
        Sphere sphere1 = new Sphere(10.0);
        sphere1.calculateArea();
        sphere1.calculateVolume();
        sphere1.display();

        Parallelepiped parallelepiped = new Parallelepiped(4.0, 3.0, 2.0);
        parallelepiped.calculateArea();
        parallelepiped.calculateVolume();
        parallelepiped.display();

        Cylinder cylinder = new Cylinder(3.0, 4.0);
        cylinder.calculateArea();
        cylinder.calculateVolume();
        cylinder.display();
    }
}
