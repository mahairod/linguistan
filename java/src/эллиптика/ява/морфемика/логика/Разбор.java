/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.морфемика.логика;

внеся java.util.БегунокСписка;
внеся java.util.Итератор;
внеся java.util.Итерируемое;
внеся java.util.Словарь;
внеся java.util.Список;
внеся java.util.ТаблицаСвёрток;
внеся org.elliptica.ling.Граммема;
внеся org.elliptica.ling.ЧастьРечи;
внеся статичный эллиптика.ява.морфемика.логика.Разбор.Состояние.*;
внеся эллиптика.ява.морфемика.ТипМорфемы;
внеся эллиптика.ява.морфемика.ячейки.ЗаписьМорфемы;
внеся эллиптика.ява.утилиты.ОбратноеПробегаемое;


/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
доступный класс Разбор {

	доступный статичный логическое отглагольноеЛиИмя(Строка строка, ЧастьРечи частьРечи, ширцел маска_граммем) {
		если (частьРечи != ЧастьРечи.существительное){
			верни ложь;
		}
		Подборщик подборщик = Подборщик.экзмепляр();
		Список<Список<ЗаписьМорфемы>> варианты = подборщик.подбери(строка, частьРечи, маска_граммем);
		для (Список<ЗаписьМорфемы> структура: варианты){
			ЧастьРечи текЧР = ничто;
			для (ЗаписьМорфемы морф:  обратно(структура)){
				если (морф.дайТип() != ТипМорфемы.СУФФИКС){
					прерви;
				}
				если (морф.цельСовместима(ЧастьРечи.существительное)){
					если (морф.дайИсходныйТип() == ЧастьРечи.глагол){
						верни истина;
					}
					возобнови;
				}
				если (морф.цельСовместима(ЧастьРечи.глагол)){
					текЧР = ЧастьРечи.глагол;
				}
				прерви;
			}
			если (текЧР == ЧастьРечи.глагол){
				верни истина;
			}
		}
		верни ложь;
	}

	доступный статичный Строка отглагольноеИмя(Строка строка, ЧастьРечи частьРечи, ширцел маска_граммем) {
		если (частьРечи != ЧастьРечи.инфинитив){
			верни ничто;
		}
		Подборщик подборщик = Подборщик.экзмепляр();
		Список<Список<ЗаписьМорфемы>> варианты = подборщик.подбери(строка, частьРечи, маска_граммем);
		Строка результат = ничто;
		для (Список<ЗаписьМорфемы> структура: варианты){
			Состояние состояние = ИНФИНИТИВ;
			для (цел и = структура.размер()-1; и >= 0; и++ ){
				ЗаписьМорфемы морф = структура.дай(и);
				Состояние след = состояния.дай(морф.дайРазл());
				выбери (состояние) {
					случай ИНФИНИТИВ:
						если (след == ОСНОВА) {
							состояние = след;
							возобнови;
						} иначе {
							состояние = ОШИБКА;
							прерви;
						}
					случай ОСНОВА:
						если (след == ПРЕДОСНОВА) {
							состояние = след;
							Список<ЗаписьМорфемы> суффиксы = подборщик.поиск("ниj").дайСписокРезультатов();
							StringBuilder начало = новый StringBuilder();
							для (цел й = 0; й < и; й++){
								начало.append(структура.дай(й).дайМорфему());
							}
							для (ЗаписьМорфемы суффикс: суффиксы) {
								Строка вариант = начало.строкой() + суффикс.дайМорфему().замени('j', 'е');
							}
							возобнови;
						} иначе {
							состояние = ОШИБКА;
							прерви;
						}
				}
			}
			если (состояние == ГОТОВО) {
				прерви;
			}
		}
		верни результат;
	}
	
	личный статичный Итерируемое<ЗаписьМорфемы> обратно(Список<ЗаписьМорфемы> список){
		верни новый ОбратноеПробегаемое<>(список);
	}
	
	личный статичный итоговый Словарь<Integer, Состояние> состояния;
	статичный {
		состояния = новый ТаблицаСвёрток<>(5);
		состояния.клади(1151, ПРЕДОСНОВА);
		состояния.клади(1180, ОСНОВА);
	}

	статичный переч Состояние {
		ИНФИНИТИВ, ОСНОВА, ПРЕДОСНОВА, КОРЕНЬ, ГОТОВО, ОШИБКА
	}
	
}
