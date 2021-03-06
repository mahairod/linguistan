/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2016 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 *
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет эллиптика.ява.язык;

внеся java.util.Коллекция;
внеся org.elliptica.ling.Граммема;
внеся org.elliptica.ling.ЧастьРечи;
внеся эллиптика.ява.морфология.Сложение;

/**
 *
 * @author Антон Астафьев
 */
сопряжение ДелегатЛингвистики {
	Строка подбериМножЧислоФразы(Строка фраза);
	Коллекция<Граммема> определиФормуФразы(Строка фраза);
	Строка подбериЗаданнуюФормуФразы(Строка фраза, Коллекция<Граммема> целевыеГраммемы);
	Строка подбериНачальнуюФормуФразы(Строка фраза, Коллекция<Граммема> исходныеГраммемы);
	Строка подмениЧастьФразы(Строка фраза, Строка... замены);
	Строка измениНаЗаданнуюФормуСлова(Строка фраза, ЧастьРечи частьРечи, Коллекция<Граммема> целевыеГраммемы);
	Строка согласуйФормуСлова(Строка образец, Строка исходное, ЧастьРечи частьРечи);
	Строка сложноеСлово(Строка начало, Строка конец, Сложение.Характер характер, Сложение.Слитность слитность);
}
