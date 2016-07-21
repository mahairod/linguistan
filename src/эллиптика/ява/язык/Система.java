/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2016 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 * 
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.язык;

внеся java.io.InputStream;
внеся статичный java.lang.System.*;
внеся эллиптика.ява.ввыв.ПотокПечати;
внеся эллиптика.ява.ввыв.ПотокПечатиДелегирующий;

/**
 *
 * @author Антон Александрович Астафьев <anton@astafiev.me>
 */
доступный класс Система {
	доступный статичный Строка дайСвойство(Строка ключ) {
		верни getProperty(ключ);
	}

	доступный статичный Строка дайСвойство(Строка ключ, Строка запасное) {
		верни getProperty(ключ, запасное);
	}

	доступный статичный Строка задайСвойство(Строка ключ, Строка значение) {
		верни setProperty(ключ, значение);
	}

	доступный статичный Строка очистиСвойство(Строка ключ) {
		верни clearProperty(ключ);
	}

	доступный статичный ширцел текущееВремяМс() {
		верни currentTimeMillis();
	}

	доступный статичный ширцел наноВремя() {
		верни nanoTime();
	}

    доступный статичный тщетный загрузи(Строка имяФайла) {
		load(имяФайла);
    }

    доступный итоговый статичный InputStream ввод = System.in;

	доступный итоговый статичный ПотокПечати вывод = новый ПотокПечатиДелегирующий(System.out);

	доступный итоговый статичный ПотокПечати ошибки = новый ПотокПечатиДелегирующий(System.err);
}
