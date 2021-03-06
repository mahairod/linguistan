/*
 *  Лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет org.elliptica.ling;

внеся java.util.Массивы;

/**
 *
 * @author Антон Александрович Астафьев {@literal <anton@astafiev.me>} (Anton Astafiev)
 */
доступный переч ТипГраммемы {

	НетТипа, Число, Падеж, Род, Время, Лицо, Одушевлённость, Вид, Переходность, Залог, Наклонение, Степень_сравнения, Разряд, Стиль, Собственное, Специальный_падеж;

	личный статичный итоговый Граммема[][] границы = новый Граммема[ ТипГраммемы.values().length ][];
	личный статичный итоговый Граммема иницГраммема = Граммема.аббревиатура;

	личный статичный Граммема[][] дайГраницы(){
		верни границы;
	}

	тщетный обновиГраницы(Граммема граммема) {
		цел номер = ordinal();
		Граммема[] границыТипа = границы[номер];
		если (границыТипа==ничто) {
			границы[номер] = новый Граммема[] {граммема, граммема};
			верни;
		}
		если			(граммема.ordinal() < границыТипа[0].ordinal() ) {
			границыТипа[0] = граммема;
		} иначе если	(граммема.ordinal() > границыТипа[1].ordinal() ) {
			границыТипа[1] = граммема;
		}
	}

	защищённый Строка имя() {
		выбери (это) {
			случай Переходность:
				верни "глагол";
			случай Одушевлённость:
				верни "имя";
			случай Степень_сравнения:
				верни "степень сравнения";
			запасной:
				символ[] символы = name().toCharArray();
				символы[0] = Character.toLowerCase(символы[0]);
				верни новый Строка(символы);
		}
	}

	доступный Граммема[] границы() {
		верни границы[ordinal()];
	}

	доступный Граммема[] значения() {
		Граммема[] диапазон = границы();
		верни Массивы.copyOfRange(Граммема.values(), диапазон[0].ordinal(), диапазон[1].ordinal() + 1);
	}

	доступный Граммема начальная() {
		если (Число == это){
			верни Граммема.единственное;
		}
		верни границы[ordinal()][0];
	}

	доступный ширцел маска() {
		если (маска==ничто) {
			Граммема[] диапазон = границы();
			маска = ( 1L << (диапазон[1].ordinal()+1) ) - ( 1L <<  диапазон[0].ordinal() );
		}
		верни маска;
	}

	личный Long маска;

}
