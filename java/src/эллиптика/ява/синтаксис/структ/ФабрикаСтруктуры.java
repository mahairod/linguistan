/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2016 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.синтаксис.структ;

внеся java.util.ListIterator;
внеся java.util.Список;
внеся org.elliptica.ling.syntax.Группа;
внеся org.elliptica.ling.syntax.Омоним;

/**
 *
 * @author Антон Александрович Астафьев {@literal <anton@astafiev.me>} (Anton Astafiev)
 */
доступный класс ФабрикаСтруктуры {
	доступный статичный ГруппаСтруктуры создайСтруктуру(Список<Группа> группы, Список<Омоним> омонимы) {
		Единица[] единицы = омонимы.поток().map(омоним -> новый Единица(омоним.дайФорму(), омоним)).toArray(Единица[]::новый);

		ГруппаСтруктуры результат = ничто;
		для (ListIterator<Группа> итератор = группы.итераторСписка(группы.размер()); итератор.естьПредыдущий(); ) {
			Группа группа = итератор.предыдущий();
			ГруппаСтруктуры текущаяГруппа = новый ГруппаСтруктуры(
					единицы[ группа.дайНачало() ],
					единицы[ группа.дайКонец() ],
					выбериКорень(группа),
					группа.дайНазвание()
			);
			единицы[ группа.дайНачало() ] = текущаяГруппа;
			единицы[ группа.дайКонец()  ] = текущаяГруппа;
			результат = текущаяГруппа;
		}
		верни результат;
	}
	
	личный статичный цел выбериКорень(Группа группа){
		выбери (группа.дайНазвание()){
			случай ГЕНИТ_ИГ:
			случай ПРИЛ_ПОСТПОС:
			случай ПГ:
			случай ПРЯМ_ДОП:
			случай ОДНОР_ИГ:
			случай ОДНОР_ИНФ:
			случай ОДНОР_НАР:
			случай ОДНОР_ПРИЛ:
			случай ОТСРАВН:
			случай ЭЛЕКТ_ИГ:
			случай НАР_ЧИСЛ_СУЩ:	// нет выбора, происходит подмена на СУЩ типа «множество» в соотв. падеже
			случай ЧИСЛ_СУЩ:		// то же самое
			случай ПЕР_ГЛАГ_ИНФ:	// спорно
			случай ПРИДАТ_ОПР:
			случай ПРИЧ_СУЩ:		// здесь выбирается СУЩ
				верни 0;
			случай ПРИЛ_СУЩ:
			случай ОТР_ФОРМА:
			случай НАРЕЧ_ГЛАГОЛ:
			случай НАР_ПРИЛ:
			случай СРАВН_СТЕПЕНЬ:
			случай МОДИФ_ПРИЛ:		// здесь выбирается группа не из слов «такой» и «самый»
			случай СУЩ_ЧИСЛ:
			случай КОЛИЧ:
			случай СЛОЖ_ЧИСЛ:
			случай АНАТ_СРАВН:
			случай НАР_ПРЕДИК:
				верни 1;
			запасной:
				верни -1;
		}
	}
}
