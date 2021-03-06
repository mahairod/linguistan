/*
 *  Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 *  Все права защищены и охраняются законом.
 *  Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 * 
 *   Собственная лицензия Астафьева
 *  Данный программный код является собственностью Астафьева Антона Александровича
 *  и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.морфемика.логика;

внеся java.util.Массивы;
внеся org.elliptica.ling.Граммема;
внеся статичный org.elliptica.ling.Граммема.*;
внеся org.elliptica.ling.ЧастьРечи;
внеся org.hamcrest.BaseMatcher;
внеся org.hamcrest.Description;
внеся org.junit.BeforeClass;
внеся org.junit.Test;
внеся статичный эллиптика.эблок.Поручительство.*;

/**
 *
 * @автор Антон Астафьев
 */
доступный класс РазборTest {

    доступный РазборTest() {
    }

    @BeforeClass
    доступный статичный тщетный setUpClass() {
    }

	@Test
	доступный тщетный testОтглагольноеЛиИмя() {
		System.out.println("отглагольноеЛиИмя");

		Граммема род = женский;
		ширцел маска_граммем = Граммема.маскаГраммем(Массивы.списком(именительный, единственное, род));

		Строка строка = "кора";
		логическое результат = Разбор.отглагольноеЛиИмя(строка, ЧастьРечи.существительное, маска_граммем);
		верноЛожь(результат);

		строка = "трансляция";
		результат = Разбор.отглагольноеЛиИмя(строка, ЧастьРечи.существительное, маска_граммем);
		верноИстина(результат);
	}

	@Test
	доступный тщетный тестСоздать() {
		тестОтглагольноеИмя("создать", "создание");
	}

	@Test
	доступный тщетный тестНести() {
		тестОтглагольноеИмя("нести", "несение");
	}

	@Test
	доступный тщетный тестПринести() {
		тестОтглагольноеИмя("принести", "принесение");
	}

	@Test
	доступный тщетный тестВести() {
		тестОтглагольноеИмя("вести", "ведение");
	}

	@Test
	доступный тщетный тестВезти() {
		тестОтглагольноеИмя("везти", "везение");
	}

	@Test
	доступный тщетный тестПленить() {
		тестОтглагольноеИмя("пленить", "пленение");
	}

	@Test
	доступный тщетный тестПринять() {
		тестОтглагольноеИмя("принять", "принятие");
	}

	@Test
	доступный тщетный тестСиять() {
		тестОтглагольноеИмя("сиять", "сияние");
	}

	@Test
	доступный тщетный тестВосприять() {
		тестОтглагольноеИмя("восприять", "восприятие");
	}

	@Test
	доступный тщетный тестВоспринимать() {
//		тестОтглагольноеИмя("воспринимать", "воспринимание");
	}

	@Test
	доступный тщетный тестПолить() {
		тестОтглагольноеИмя("полить", "полив");
	}

	@Test
	доступный тщетный тестСеять() {
		тестОтглагольноеИмя("сеять", "сев", "сеяние");
	}

	@Test
	доступный тщетный тестНапеть() {
		тестОтглагольноеИмя("напеть", "напев");
	}

	@Test
	доступный тщетный тестПить() {
		тестОтглагольноеИмя("пить", "пиво");
	}

	@Test
	доступный тщетный тестПосадить() {
		тестОтглагольноеИмя("посадить", "посадка");
	}

	@Test
	доступный тщетный тестИзмерить() {
		тестОтглагольноеИмя("измерить", "измерение");
	}

	@Test
	доступный тщетный тестПримерить() {
		тестОтглагольноеИмя("примерить", "примерка");
	}

	@Test
	доступный тщетный тестПримирить() {
		тестОтглагольноеИмя("примирить", "примирение");
	}

	@Test
	доступный тщетный тестКалибровать() {
		тестОтглагольноеИмя("калибровать", "калибровка", "калибрование");
	}

	@Test
	доступный тщетный тестШифровать() {
		тестОтглагольноеИмя("шифровать", "шифровка", "шифрование");
	}

	@Test
	доступный тщетный тестЗимовать() {
		тестОтглагольноеИмя("зимовать", "зимовка");
	}

	@Test
	доступный тщетный тестОстатки() {
		тестОтглагольноеИмя("исправлять", "исправление");
		тестОтглагольноеИмя("зажать", "зажатие");
		тестОтглагольноеИмя("взять", "взятие");
		тестОтглагольноеИмя("искривлять", "искривление");
		тестОтглагольноеИмя("паять", "паяние");
		тестОтглагольноеИмя("огородить", "огорождение");
	}

	@Test
	доступный тщетный тестОтдельный() {
//		тестОтглагольноеИмя("оградить", "ограждение");
//		тестОтглагольноеИмя("нагородить", "нагорождение");
		тестОтглагольноеИмя("уничтожить", "уничтожение");
		тестОтглагольноеИмя("показать", "показ");
		тестОтглагольноеИмя("осмотреть", "осмотр");
		тестОтглагольноеИмя("бить", "биение");
//		тестОтглагольноеИмя("забить", "забить");
	}

	@Test
	доступный тщетный тестКлассифицировать() {
		тестОтглагольноеИмя("классифицировать", "классификация", "классифицирование");
	}

	@Test
	доступный тщетный тестЖестикулировать() {
		тестОтглагольноеИмя("жестикулировать", "жестикуляция");
	}

	тщетный тестОтглагольноеИмя(Строка проба, Строка... ожидаемое) {
		System.out.println("отглагольноеИмя: " + проба);

		Строка строка = проба;
		Строка результат = новый Разбор().отглагольноеИмя(строка);
		если (ожидаемое.length == 1){
			верноРавны(ожидаемое[0], результат);
		} иначе {
			верноЧто(результат, новый BaseMatcher<Строка>() {
				@Подмени
				доступный логическое matches(Object o) {
					верни Массивы.списком(ожидаемое).содержит(o);
				}

				@Подмени
				доступный тщетный describeTo(Description d) {
				}
			});
		}

	}
}