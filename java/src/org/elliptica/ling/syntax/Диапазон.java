/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2015 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 * 
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет org.elliptica.ling.syntax;

внеся javax.xml.bind.annotation.XmlElement;
внеся javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Антон Александрович Астафьев {@literal <anton@astafiev.me>} (Anton Astafiev)
 */
@XmlRootElement
доступный класс Диапазон расширяет ОбъектСинт {

	доступный цел дайНачало() {
		верни начало;
	}

	доступный цел дайКонец() {
		верни конец;
	}

	доступный цел дайДлина() {
		верни конец - начало;
	}

	@XmlElement
	доступный цел getНачало() {
		верни начало;
	}

	@XmlElement
	доступный цел getКонец() {
		верни конец;
	}

	доступный тщетный setНачало(цел начало) {
		это.начало = начало;
	}

	доступный тщетный setКонец(цел конец) {
		это.конец = конец;
	}

	личный цел начало;
	личный цел конец;

}
