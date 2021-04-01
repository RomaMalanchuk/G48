package models;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Parent {
	protected String name;
	protected static final Logger LOGGER = Logger.getLogger("app");
	

	public Parent(String name) {
		this.name = name;

		try {
			Handler fileHandler = new FileHandler("./logfile.log");
			MyFormatter simple = new MyFormatter(name);
			fileHandler.setFormatter(simple);
			LOGGER.addHandler(fileHandler);

		} catch (IOException e) {
			System.out.printf("Ошибка создания фалйа логов: %s%n", e);
		}
	}

	public void print_name() {
		LOGGER.info(String.format("%s: Выведен текст%n", this.name));
	}

	public void print_list(List<String> list) {
		try {
			for (int i = 0; i < list.size(); i++) {
				try {
					String[] splitted_word = list.get(i).split("");
					for (int x = 0; x < splitted_word.length; x++) {
						LOGGER.fine(splitted_word[x] + " ");
					}
				} catch (NullPointerException e) {
					LOGGER.severe(String.format("Элемент массива %d не определён. "
							+ "Пожалуйста проверте корректность вводимых значений%n", i));
				} catch (Exception e) {
					LOGGER.severe(String
							.format("Произошла неизвесная ошибка в работе с элементом %d. " + "Подробнее: %s%n", i, e));
				}
			}
		} catch (NullPointerException e) {
			LOGGER.severe("Массив не определён. Пожалуйста проверте корректность вводимых значений");
		} catch (Exception e) {
			LOGGER.severe(String
					.format("Произошла неизвесная ошибка. Подробнее: %s%n", e));
		}
	}
}
