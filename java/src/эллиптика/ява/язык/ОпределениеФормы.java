/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.язык;

внеся java.util.Коллекция;
внеся java.util.Множество;
внеся org.elliptica.ling.Граммема;
внеся org.elliptica.ling.ОтклонениеМорфологии;
внеся org.elliptica.ling.Парадигма;
внеся эллиптика.ява.синтаксис.структ.ГруппаСтруктуры;



/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
класс ОпределениеФормы воплощает ДелегатЛингвистикиВопл.Операция<Коллекция<Граммема>> {

	@Подмени
	доступный Коллекция<Граммема> дляСлова(Парадигма парадигма, Строка вход) кидает ОтклонениеМорфологии {
		верни парадигма.дайГраммемы();
	}

	@Подмени
	доступный Коллекция<Граммема> дляФразы(ГруппаСтруктуры группаСтруктуры, Строка вход) {
		верни группаСтруктуры.дайГраммемы();
	}

	@Подмени
	доступный Коллекция<Граммема> дляСбоя(Строка вход) {
		кинь новый NullPointerException();
	}

	@Подмени
	доступный цел рейтинг(Парадигма парадигма) {
		цел рейтинг = ДелегатЛингвистикиВопл.Операция.поверх.рейтинг(парадигма) * 100;
		Множество<Граммема> граммемы = парадигма.дайГраммемы();
		выбери (парадигма.дайЧастьРечи()) {
			случай прилагательное:
			случай причастие:
			случай местоименное_прилагательное:
				рейтинг += граммемы.содержит(Граммема.мужской) ? 0 : 10;
			случай существительное:
			случай местоименное_существительное:
				рейтинг += граммемы.содержит(Граммема.именительный) ? 0 : 6;
				рейтинг += граммемы.содержит(Граммема.единственное) ? 0 : 3;
		}
		верни рейтинг;
	}

}
