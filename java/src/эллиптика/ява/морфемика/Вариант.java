/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.морфемика;

внеся java.util.Список;
внеся java.util.Collections;
внеся java.util.Массивы;
внеся эллиптика.ява.морфемика.ячейки.MorphemDescr;


/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
доступный класс Вариант {

	доступный Вариант(MorphemDescr morphemDescr, Список<Вариант> дети) {
		это.morphemDescr = morphemDescr;
		это.дети = дети;
	}

	доступный Вариант(MorphemDescr morphemDescr, Строка остаток) {
		это.morphemDescr = morphemDescr;
		это.остаток = остаток;
	}

	@Override
	доступный Строка toString() {
		если (дети == ничто) {
			верни "Вариант{" + "morphemDescr=" + morphemDescr + ", остаток=" + остаток + '}';
		} иначе {
			верни "Вариант{" + "morphemDescr=" + morphemDescr + ", дети=" + Массивы.toString(
					дети.поток().map(в -> в.morphemDescr).toArray()
					) + '}';
		}
	}

	доступный MorphemDescr getMorphemDescr() {
		верни morphemDescr;
	}

	доступный Список<Вариант> getДети() {
		верни дети;
	}

	доступный Строка getОстаток() {
		верни остаток;
	}

	личный MorphemDescr morphemDescr;
	личный Список<Вариант> дети;
	личный Строка остаток;
}
