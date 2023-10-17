package hw3.view;

import hw3.model.Table;

/**
 * Интерфейс, представляющий устройство вывода данных.
 */
public interface OutputDevice {

    /**
     * Отображает игровое поле на устройстве вывода.
     *
     * @param table Игровое поле (Table), которое нужно отобразить.
     */
    void showTable(Table table);

    /**
     * Выводит сообщение на устройство вывода.
     *
     * @param message Сообщение для вывода.
     */
    void showMessage(String message);
}