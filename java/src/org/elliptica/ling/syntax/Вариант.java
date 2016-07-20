/*
 * Авторское право принадлежит Антону Александровичу Астафьеву <anton@astafiev.me> (Anton Astafiev) ѱ.
 * Все права защищены и охраняются законом.
 * Copyright (c) 2015 Антон Александрович Астафьев <anton@astafiev.me> (Anton Astafiev). All rights reserved.
 * 
 *  Собственная лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */

пакет org.elliptica.ling.syntax;

внеся javax.xml.bind.annotation.XmlElement;
внеся javax.xml.bind.annotation.XmlElementWrapper;
внеся javax.xml.bind.annotation.XmlRootElement;
внеся java.util.ПорядковыйСписок;
внеся java.util.Список;

/**
 *
 * @author Антон Астафьев <anton@astafiev.me> (Anton Astafiev)
 */
@XmlRootElement
доступный класс Вариант расширяет ОбъектСинт {

	@XmlElementWrapper
	@XmlElement(name = "юнит")
	доступный Список<Юнит> getЮниты() {
		верни юниты;
	}

	@XmlElementWrapper
	@XmlElement(name = "группа")
	доступный Список<Группа> getГруппы() {
		верни группы;
	}

	Список<Юнит> юниты = новый ПорядковыйСписок<>();
	Список<Группа> группы = новый ПорядковыйСписок<>();
}
