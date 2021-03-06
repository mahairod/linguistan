/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> ѱ 2017.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2017 Anton Astafiev <anton@astafiev.me>. All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.морфемика.ячейки;

внеся java.sql.SQLException;
внеся javax.persistence.AttributeConverter;
внеся javax.persistence.Converter;
внеся org.postgresql.util.PGobject;
внеся эллиптика.ява.утилиты.журналирование.Журналарь;
внеся эллиптика.ява.утилиты.журналирование.Уровень;


/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
@Converter
доступный класс ПреобразовательОтношенияМорфем воплощает AttributeConverter<ТипОтношенияМорфем, PGobject> {

	@Подмени
	доступный PGobject convertToDatabaseColumn(ТипОтношенияМорфем атрибут) {
		если (атрибут == ничто){
			верни ничто;
		}
		PGobject зн = новый PGobject();
		попробуй {
			зн.setType("отношение_морфем");
			зн.setValue(атрибут.name());
		} ловя (SQLException ex) {
			ЖУРНАЛ.запись(Уровень.ОШИБКА, ничто, ex);
		}
		верни зн;
	}

	@Подмени
	доступный ТипОтношенияМорфем convertToEntityAttribute(PGobject данныеБД) {
		если (данныеБД экземпляр PGobject){
			верни ТипОтношенияМорфем.valueOf(данныеБД.getValue());
		} иначе {
			верни ничто;
		}
	}

	личный статичный итоговый Журналарь ЖУРНАЛ = Журналарь.дайЖурналарь(ПреобразовательОтношенияМорфем.класс.дайИмя());
}
