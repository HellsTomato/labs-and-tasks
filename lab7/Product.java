public class Product {
    private String name; // имя товара
    private int weight; // вес товара

    // конструктор для создания нового товара
    public Product(String name, int weight) {
        this.name = name; // инициализация имя
        this.weight = weight; // инициализация веса
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

