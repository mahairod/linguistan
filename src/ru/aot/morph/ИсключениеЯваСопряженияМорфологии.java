/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2016 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 * 
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет ru.aot.morph;

/**
 *
 * @author Антон Александрович Астафьев <anton@astafiev.me>
 */
доступный класс ИсключениеЯваСопряженияМорфологии расширяет RuntimeException {

	личный статичный итоговый ширцел serialVersionUID = 6844719078250020184L;

	доступный ИсключениеЯваСопряженияМорфологии() {
		super();
	}

	доступный ИсключениеЯваСопряженияМорфологии(Строка сообщение, Throwable причина) {
		super(сообщение, причина);
	}

	доступный ИсключениеЯваСопряженияМорфологии(Строка сообщение) {
		super(сообщение);
	}

	доступный ИсключениеЯваСопряженияМорфологии(Throwable причина) {
		super(причина);
	}

}
