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
внеся java.util.МножествоСвёрток;
внеся org.elliptica.ling.Morph;
внеся org.elliptica.ling.Граммема;
внеся org.elliptica.ling.ОтклонениеМорфологии;
внеся org.elliptica.ling.Парадигма;
внеся org.elliptica.ling.ФормаСлова;
внеся org.elliptica.ling.ЧастьРечи;
внеся эллиптика.ява.синтаксис.структ.ГруппаСтруктуры;



/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
класс ПодборФормы воплощает ДелегатЛингвистикиВопл.Операция<Строка> {

	доступный ПодборФормы(ДелегатЛингвистикиВопл.ЦелевыеФормы формы, ЧастьРечи частьРечи) {
		это.формы = формы;
		это.частьРечи = частьРечи;
	}
	защищённый итоговый ДелегатЛингвистикиВопл.ЦелевыеФормы формы;
	личный итоговый ЧастьРечи частьРечи;

	@Подмени
	доступный цел рейтинг(Парадигма парадигма) {
		верни парадигма.дайЧастьРечи() == частьРечи ? 0 : 1;
	}

	@Подмени
	доступный Строка дляФразы(ГруппаСтруктуры группаСтруктуры, Строка вход) {
		если (группаСтруктуры == ничто) {
			верни вход;
		}
		Коллекция<Граммема> граммемы = формы.дляФразы(группаСтруктуры.дайГраммемы());
		группаСтруктуры.смениФорму(граммемы);
		Строка выход = группаСтруктуры.дайФразу();
		если (Character.isUpperCase(вход.символВ(0))) {
			выход = " " + выход;
		}
		символ[] символы = выход.кМассивуСимволов();
		цел й = 0;
		для (цел и = 0; и < символы.length; и++, й++) {
			если (символы[и] == ' ') {
				если (и + 1 < символы.length) {
					и++;
					символы[й] = Character.toUpperCase(символы[и]);
				}
			} иначе {
				символы[й] = символы[и];
			}
		}
		верни новый Строка(символы, 0, й);
	}

	@Подмени
	доступный Строка дляСбоя(Строка вход) {
		верни вход;
	}

	@Подмени
	доступный Строка дляСлова(Парадигма парадигма, Строка вход) кидает ОтклонениеМорфологии {
		ФормаСлова фс = Morph.найдиФорму(парадигма.дайБазовуюФорму(), парадигма.дайЧастьРечи(), новый МножествоСвёрток<Граммема>(формы.дляФразы(парадигма.дайГраммемы())));
		если (фс == ничто) {
			верни вход;
		}
		Строка выход = фс.дайСлово().вНижнемРегистре();
		если (Character.isUpperCase(вход.символВ(0))) {
			выход = Character.toUpperCase(выход.символВ(0)) + выход.подстрока(1);
		}
		верни выход;
	}

}
