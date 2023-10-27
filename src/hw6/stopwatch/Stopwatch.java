package hw6.stopwatch;

/**
 * Класс Stopwatch представляет секундомер с возможностью запуска, паузы,
 * возобновления и остановки отсчета времени.
 */
public class Stopwatch {
    private long startTime;  // Время начала отсчета
    private long pausedTime;  // Время, которое прошло в паузе
    private boolean isRunning;  // Флаг, указывающий на текущее состояние секундомера

    /**
     * Запускает секундомер. Если секундомер уже запущен, метод ничего не делает.
     */
    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis() - pausedTime;
            isRunning = true;
        }
    }

    /**
     * Приостанавливает секундомер. Если секундомер не был запущен, метод ничего не делает.
     */
    public void pause() {
        if (isRunning) {
            isRunning = false;
            pausedTime = System.currentTimeMillis() - startTime;
        }
    }

    /**
     * Возобновляет отсчет времени после паузы. Если секундомер не был приостановлен,
     * метод ничего не делает.
     */
    public void resume() {
        if (!isRunning) {
            startTime = System.currentTimeMillis() - pausedTime;
            isRunning = true;
        }
    }

    /**
     * Останавливает секундомер и сбрасывает все записанные временные значения.
     */
    public void stop() {
        if (isRunning) {
            isRunning = false;
            pausedTime = 0;
        }
    }

    /**
     * Возвращает прошедшее время в миллисекундах. Если секундомер запущен, возвращает
     * текущее прошедшее время, включая время в паузе. Если секундомер приостановлен,
     * возвращает время, которое было заморожено при паузе.
     *
     * @return Прошедшее время в миллисекундах.
     */
    public long getTimeElapsed() {
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return pausedTime;
        }
    }
}