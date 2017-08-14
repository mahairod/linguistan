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

внеся java.io.Serializable;
внеся java.util.List;
внеся java.util.Список;
внеся javax.persistence.Basic;
внеся javax.persistence.CascadeType;
внеся javax.persistence.Column;
внеся javax.persistence.Convert;
внеся javax.persistence.Entity;
внеся javax.persistence.FetchType;
внеся javax.persistence.Lob;
внеся javax.persistence.NamedQueries;
внеся javax.persistence.NamedQuery;
внеся javax.persistence.OneToMany;
внеся javax.persistence.Table;
внеся org.elliptica.ling.ЧастьРечи;
внеся эллиптика.ява.вэб.сущности.СущностьАХЯНаКлючеInteger;
внеся эллиптика.ява.морфемика.ТипМорфемы;


/**
 *
 * @автор Антон Александрович Астафьев {@буквально <anton@astafiev.me>} (Anton Astafiev)
 */
@Entity
@Table(name = "morphem_descr")
@NamedQueries({
	@NamedQuery(name = "MorphemDescr.найдиВсе", query = "SELECT m FROM MorphemDescr m"),
	@NamedQuery(name = "MorphemDescr.найдиПоМорфеме", query = "SELECT m FROM MorphemDescr m WHERE m.морфема = :морфема"),
	@NamedQuery(name = "MorphemDescr.найдиПоЧасти", query = "SELECT m FROM MorphemDescr m WHERE m.часть = :часть"),
	@NamedQuery(name = "MorphemDescr.найдиПоОбразует", query = "SELECT m FROM MorphemDescr m WHERE m.образует = :образует"),
	@NamedQuery(name = "MorphemDescr.найдиПоЗнач", query = "SELECT m FROM MorphemDescr m WHERE m.знач = :знач"),
	@NamedQuery(name = "MorphemDescr.найдиПоЯзыку", query = "SELECT m FROM MorphemDescr m WHERE m.язык = :язык"),
	@NamedQuery(name = "MorphemDescr.найдиПоОригиналу", query = "SELECT m FROM MorphemDescr m WHERE m.оригинал = :оригинал")})
доступный класс MorphemDescr расширяет СущностьАХЯНаКлючеInteger воплощает Serializable {

	личный статичный итоговый ширцел serialVersionUID = 1L;

	@Basic(optional = ложь)
    @Column(name = "морфема")
	личный Строка морфема;
    @Column(name = "часть")
	личный Строка часть;
    @Column(name = "образует")
	личный Строка образует;
    @Column(name = "знач")
	личный Строка знач;

    @Column(name = "целевой_тип")
	@Convert(converter = ПреобразовательЧастиРечи.класс)
	личный ЧастьРечи целевойТип;

    @Column(name = "исходный_тип")
	@Convert(converter = ПреобразовательЧастиРечи.класс)
	личный ЧастьРечи исходныйТип;

    @Column(name = "язык")
	личный Строка язык;
    @Column(name = "оригинал")
	личный Строка оригинал;

	@Basic(optional = ложь)
	@Convert(converter = ПреобразовательТипаМорфемы.класс)
    @Column(name = "тип")
	личный ТипМорфемы тип;

	@Basic(optional = ложь)
    @Column(name = "обрат")
	личный Строка обрат;

	@Basic(optional = истина)
    @Column(name = "исходные_граммемы")
	личный Long исходныеГраммемы;

	@Basic(optional = истина)
    @Column(name = "целевые_граммемы")
	личный Long целевыеГраммемы;

	@Basic(optional = истина)
    @Column(name = "части_речи")
	личный Integer частиРечи;

	@Basic(optional = истина)
    @Column(name = "буквы_перед")
	личный Integer буквыПеред;

	@Basic(optional = истина)
    @Column(name = "буквы_после")
	личный Integer буквыПосле;

	@Basic(optional = истина)
    @Column(name = "макс_левая_позиция")
	личный Integer максЛеваяПозиция;

	@Basic(optional = истина)
    @Column(name = "макс_правая_позиция")
	личный Integer максПраваяПозиция;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "morphemDescr", fetch = FetchType.EAGER)
	личный List<MorphemExample> списокMorphemExample;

	доступный MorphemDescr() {
	}

	доступный логическое применимаК(ЧастьРечи чр, ширцел исхГраммемы, Строка перед, символ после) {
		если (частиРечи != ничто) {
			верни битЕсть(частиРечи, чр.ordinal());
		}
		если (буквыПеред != ничто && !перед.пуста()) {
			символ сим = перед.вНижнемРегистре().символВ(перед.длина()-1);
			верни битЕсть(буквыПеред, сим-'а');
		}
		если (буквыПосле != ничто && после !='∅') {
			верни битЕсть(буквыПосле, после -'а');
		}
		если (исходныеГраммемы != ничто) {
			верни исходныеГраммемы == (исходныеГраммемы & исхГраммемы);
		}
		если (целевыеГраммемы != ничто) {
			верни целевыеГраммемы == (целевыеГраммемы & исхГраммемы);
		}
		верни истина;
	}

	личный статичный логическое битЕсть(цел маска, цел позиция) {
		верни (маска & (1 << позиция)) != 0;
	}

	доступный Integer getБуквыПеред() {
		верни буквыПеред;
	}

	доступный тщетный setБуквыПеред(Integer буквыПеред) {
		это.буквыПеред = буквыПеред;
	}

	@Deprecated
	доступный Строка getМорфема() {
		верни дайМорфему();
	}

	доступный Строка дайМорфему() {
		верни морфема;
	}

	@Deprecated
	доступный тщетный setМорфема(Строка морфема) {
		это.задайМорфему(морфема);
	}

	доступный тщетный задайМорфему(Строка морфема) {
		это.морфема = морфема;
	}

	@Deprecated
	доступный Строка getЧасть() {
		верни дайЧасть();
	}

	доступный Строка дайЧасть() {
		верни часть;
	}

	@Deprecated
	доступный тщетный setЧасть(Строка часть) {
		это.задайЧасть(часть);
	}

	доступный тщетный задайЧасть(Строка часть) {
		это.часть = часть;
	}

	@Deprecated
	доступный Строка getОбразует() {
		верни дайОбразует();
	}

	доступный Строка дайОбразует() {
		верни образует;
	}

	@Deprecated
	доступный тщетный setОбразует(Строка образует) {
		это.задайОбразует(образует);
	}

	доступный тщетный задайОбразует(Строка образует) {
		это.образует = образует;
	}

	@Deprecated
	доступный Строка getЗнач() {
		верни дайЗнач();
	}

	доступный Строка дайЗнач() {
		верни знач;
	}

	@Deprecated
	доступный тщетный setЗнач(Строка знач) {
		это.задайЗнач(знач);
	}

	доступный тщетный задайЗнач(Строка знач) {
		это.знач = знач;
	}

	@Deprecated
	доступный ЧастьРечи getЦелевойТип() {
		верни дайЦелевогоТип();
	}

	доступный ЧастьРечи дайЦелевогоТип() {
		верни целевойТип;
	}

	@Deprecated
	доступный тщетный setЦелевойТип(ЧастьРечи целевойТип) {
		это.задайЦелевойТип(целевойТип);
	}

	доступный тщетный задайЦелевойТип(ЧастьРечи целевойТип) {
		это.целевойТип = целевойТип;
	}

	@Deprecated
	доступный ЧастьРечи getИсходныйТип() {
		верни дайИсходныйТип();
	}

	доступный ЧастьРечи дайИсходныйТип() {
		верни исходныйТип;
	}

	@Deprecated
	доступный тщетный setИсходныйТип(ЧастьРечи исходныйТип) {
		это.задайИсходныйТип(исходныйТип);
	}

	доступный тщетный задайИсходныйТип(ЧастьРечи исходныйТип) {
		это.исходныйТип = исходныйТип;
	}

	@Deprecated
	доступный Строка getЯзык() {
		верни дайЯзык();
	}

	доступный Строка дайЯзык() {
		верни язык;
	}

	@Deprecated
	доступный тщетный setЯзык(Строка язык) {
		это.задайЯзыка(язык);
	}

	доступный тщетный задайЯзыка(Строка язык) {
		это.язык = язык;
	}

	@Deprecated
	доступный Строка getОригинал() {
		верни дайОригинала();
	}

	доступный Строка дайОригинала() {
		верни оригинал;
	}

	@Deprecated
	доступный тщетный setОригинал(Строка оригинал) {
		это.задайОригинал(оригинал);
	}

	доступный тщетный задайОригинал(Строка оригинал) {
		это.оригинал = оригинал;
	}

	@Deprecated
	доступный ТипМорфемы getТип() {
		верни дайТип();
	}

	доступный ТипМорфемы дайТип() {
		верни тип;
	}

	@Deprecated
	доступный тщетный setТип(ТипМорфемы тип) {
		это.задайТип(тип);
	}

	доступный тщетный задайТип(ТипМорфемы тип) {
		это.тип = тип;
	}

	@Deprecated
	доступный List<MorphemExample> getСписокMorphemExample() {
		верни дайСписокmorphemExample();
	}

	доступный List<MorphemExample> дайСписокmorphemExample() {
		верни списокMorphemExample;
	}

	@Deprecated
	доступный тщетный setСписокMorphemExample(List<MorphemExample> списокMorphemexample) {
		это.задайСписокmorphEmexample(списокMorphemexample);
	}

	доступный тщетный задайСписокmorphEmexample(List<MorphemExample> списокMorphemexample) {
		это.списокMorphemExample = списокMorphemexample;
	}

	доступный Строка getОбрат() {
		верни обрат;
	}

	доступный тщетный setОбрат(Строка обрат) {
		это.обрат = обрат;
	}

	доступный Long getИсходныеГраммемы() {
		верни исходныеГраммемы;
	}

	доступный тщетный setИсходныеГраммемы(Long исходныеГраммемы) {
		это.исходныеГраммемы = исходныеГраммемы;
	}

	доступный Long getЦелевыеГраммемы() {
		верни целевыеГраммемы;
	}

	доступный тщетный setЦелевыеГраммемы(Long целевыеГраммемы) {
		это.целевыеГраммемы = целевыеГраммемы;
	}

	доступный Integer getЧастиРечи() {
		верни частиРечи;
	}

	доступный тщетный setЧастиРечи(Integer частиРечи) {
		это.частиРечи = частиРечи;
	}

	доступный Integer getМаксЛеваяПозиция() {
		верни максЛеваяПозиция == ничто ? Integer.MAX_VALUE : максЛеваяПозиция;
	}

	доступный тщетный setМаксЛеваяПозиция(Integer максЛеваяПозиция) {
		это.максЛеваяПозиция = максЛеваяПозиция;
	}

	доступный Integer getМинПраваяПозиция() {
		верни максПраваяПозиция;
	}

	доступный тщетный setМинПраваяПозиция(Integer максПраваяПозиция) {
		это.максПраваяПозиция = максПраваяПозиция;
	}

	доступный Integer getБуквыПосле() {
		верни буквыПосле;
	}

	доступный тщетный setБуквыПосле(Integer буквыПосле) {
		это.буквыПосле = буквыПосле;
	}

	@Подмени
	доступный Строка строкой() {
		верни "MorphemDescr{" + тип + " " + морфема + ", " + исходныйТип + " => " + целевойТип + '}';
	}

}
