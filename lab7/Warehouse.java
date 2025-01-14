import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Warehouse {
    public static void main(String[] args) {
        // Создаем пул потоков для трех грузчиков
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Создаем три грузчика
        Loader loader1 = new LoaderRealization("Грузчик 1");
        Loader loader2 = new LoaderRealization("Грузчик 2");
        Loader loader3 = new LoaderRealization("Грузчик 3");

        // Отправляем грузчиков в пул для выполнения
        executorService.submit(loader1);
        executorService.submit(loader2);
        executorService.submit(loader3);

        // Закрытие пула после выполнения всех задач
        executorService.shutdown();
    }
}

