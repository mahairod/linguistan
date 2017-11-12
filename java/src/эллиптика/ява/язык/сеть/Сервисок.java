/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.язык.сеть;

внеся java.net.HttpURLConnection;
внеся эллиптика.ява.сеть.РазменППСТ;
внеся эллиптика.ява.язык.Система;

/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
доступный сопряжение Сервисок {
	цел УСПЕХ = HttpURLConnection.HTTP_OK;

	цел обработай(Строка запрос, StringBuilder вывод) кидает Exception;
	запасной тщетный послеДействие(РазменППСТ размен){
	};

	запасной цел обработай(РазменППСТ размен, StringBuilder вывод) кидает Exception {
		Строка запрос = размен.дайУРРЗапроса().дайЗапрос();
		Система.вывод.печатайстр("Запрос: " + запрос);
		верни обработай(запрос, вывод);
	}
}
