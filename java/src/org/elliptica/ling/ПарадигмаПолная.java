/*
 *  Лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет org.elliptica.ling;

внеся java.util.ПорядковыйСписок;
внеся java.util.Список;
внеся java.util.Множество;

/**
 *
 * @author Антон Александрович Астафьев {@literal <anton@astafiev.me>} (Anton Astafiev)
 */
доступный класс ПарадигмаПолная расширяет БазаПарадигмы {

	доступный ПарадигмаПолная(логическое найдено, ЧастьРечи чречи) {
		поверх(найдено, чречи);
		формыСлова = новый ПорядковыйСписок<>(12);
	}

	@Подмени
	доступный тщетный добавьФорму(ФормаСлова формаСлова) {
		формыСлова.добавь(формаСлова);
	}

	@Подмени
	доступный Список<ФормаСлова> формы() {
		верни формыСлова;
	}

	@Подмени
	доступный Множество<Граммема> дайГраммемы() {
		верни формы().дай(0).дайГраммемы();
	}

	@Подмени
	доступный Строка дайБазовуюФорму() {
		верни формы().дай(0).дайСлово();
	}

	личный итоговый Список<ФормаСлова> формыСлова;

}
