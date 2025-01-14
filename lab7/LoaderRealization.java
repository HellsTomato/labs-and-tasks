import java.util.concurrent.atomic.AtomicInteger;

public class LoaderRealization implements Loader {
    private static final int MAX_WEIGHT = 150; // Максимальный вес для одного грузчика
    private AtomicInteger currentWeight; // Текущий вес товаров у грузчика
    private String name; // Имя грузчика

    // конструктор для создания Грузчика
    public LoaderRealization(String name) {
        this.name = name;
        this.currentWeight = new AtomicInteger(0); // Изначально грузчик ничего не несет
    }

    // Метод, выполняемый в потоке
    @Override
    public void run() {
        // Выводим сообщение, что грузчик начал работать
        System.out.println(name + " начал работать");

        // Пока текущий вес грузчика меньше 150 кг
        while (currentWeight.get() < MAX_WEIGHT) {
            // Создаем новый товар с весом 50 кг
            Product product = new Product("Товар " + (currentWeight.get() + 1), 50); // Каждый товар весит 50 кг
            loadProduct(product); // Загружаем товар

            try {
                Thread.sleep(1000); // Задержка в 1 секунду, для переноса товара :)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // когда превысил свой лимит
        System.out.println(name + " завершил работу с максимальным весом: " + currentWeight.get() + " кг");
    }

    // Метод для переноса товара
    @Override
    public void loadProduct(Product product) {
        // Если грузчик может еще нести товар, добавляем его вес
        if (currentWeight.get() + product.getWeight() <= MAX_WEIGHT) {
            // Если может, добавляем вес товара
            currentWeight.addAndGet(product.getWeight());
            System.out.println(name + " перенес товар: " + product.getName() + " (Вес: " + product.getWeight() + " кг)");
        } else {
            System.out.println(name + " не может перенести товар: " + product.getName() + " (Превышен вес)");
        }
    }
}

