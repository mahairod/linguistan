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

внеся java.io.IOException;
внеся java.net.InetAddress;
внеся java.net.InetSocketAddress;
внеся java.util.logging.Level;
внеся эллиптика.ява.Целое;
внеся эллиптика.ява.сеть.ППГТСервер;
внеся эллиптика.ява.утилиты.журналирование.Журналарь;
внеся эллиптика.ява.утилиты.журналирование.Уровень;


/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
доступный класс Сервер {
	личный статичный итоговый Журналарь ЖУРНАЛ = Журналарь.дайЖурналарь(Сервер.класс.дайИмя());

	доступный статичный тщетный main(Строка[] args) {
		попробуй {
			запуск(args);
		} ловя (Exception ex) {
			ЖУРНАЛ.запись(Уровень.ОШИБКА, ничто, ex);
		}
		
	}

	личный статичный тщетный запуск(Строка[] args) кидает IOException {
		цел порт;
		попробуй {
			порт = Целое.разборЦел(args[0]);
		} ловя (Exception откл) {
			порт = 7070;
		}
		ППГТСервер сервер = ППГТСервер.создай();
		сервер.прикрепи(новый InetSocketAddress(InetAddress.getLoopbackAddress(), порт), 20);
		сервер.создайКонтекст("/линг", новый СервисЛингвистики());
		сервер.создайКонтекст("/управление", новый СервисУправления(сервер));
		сервер.запуск();
	}
}
