/*
 *  Лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет ru.aot.morph;

внеся java.util.Множество;

/**
 *
 * @author Антон Астафьев <anton@astafiev.me> (Anton Astafiev)
 */
класс РезультатСловаВопл воплощает JavaMorphAPI.РезультатСлова {
	личный итоговый Множество<Парадигма> множествоПарадигм;

	доступный РезультатСловаВопл(Множество<Парадигма> множествоПарадигм) {
		это.множествоПарадигм = множествоПарадигм;
	}

	@Подмени
	доступный Множество<Парадигма> дайПарадигмы() {
		верни множествоПарадигм;
	}

}
