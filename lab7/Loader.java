// интерфейс для грузчика
public interface Loader extends Runnable {
    // метод для переноса товара
    void loadProduct(Product product);
}

