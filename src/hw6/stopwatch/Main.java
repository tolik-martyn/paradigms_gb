package hw6.stopwatch;

public class Main {
    public static void main(String[] args) {

        Stopwatch stopwatch = new Stopwatch();

        System.out.println("Время в миллисекундах перед командой \"start\": " + stopwatch.getTimeElapsed());

        // Секундомер начал отсчет времени
        stopwatch.start();

        try {
            Thread.sleep(5000); // 5000 миллисекунд
        } catch (InterruptedException e) {
            System.err.println("Ошибка при выполнении программы");
        }

        System.out.println("Время в миллисекундах перед командой \"pause\": " + stopwatch.getTimeElapsed());

        // Секундомер приостановлен
        stopwatch.pause();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Ошибка при выполнении программы");
        }
        System.out.println("Время в миллисекундах перед командой \"resume\": " + stopwatch.getTimeElapsed());

        // Секундомер возобновил отсчет времени
        stopwatch.resume();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Ошибка при выполнении программы");
        }

        System.out.println("Время в миллисекундах перед командой \"stop\": " + stopwatch.getTimeElapsed());

        // Секундомер остановлен
        stopwatch.stop();

        System.out.println("Время в миллисекундах после команды \"stop\": " + stopwatch.getTimeElapsed());
    }
}