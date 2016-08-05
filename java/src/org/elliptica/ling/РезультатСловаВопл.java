/*
 *  Лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет org.elliptica.ling;

внеся java.util.Множество;

/**
 *
 * @author Антон Александрович Астафьев {@literal <anton@astafiev.me>} (Anton Astafiev)
 */
класс РезультатСловаВопл воплощает РезультатСлова {
	личный итоговый Множество<Парадигма> множествоПарадигм;

	доступный РезультатСловаВопл(Множество<Парадигма> множествоПарадигм) {
		это.множествоПарадигм = множествоПарадигм;
	}

	@Подмени
	доступный Множество<Парадигма> дайПарадигмы() {
		верни множествоПарадигм;
	}

}
