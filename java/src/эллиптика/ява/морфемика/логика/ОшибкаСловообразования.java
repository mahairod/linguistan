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

/**
 *
 * @автор Антон Астафьев
 */
доступный класс ОшибкаСловообразования расширяет Exception {

    /**
     * Creates a new instance of <code>ОшибкаСловообразования</code> without detail message.
     */
    доступный ОшибкаСловообразования() {
    }


    /**
     * Constructs an instance of <code>ОшибкаСловообразования</code> with the specified detail message.
     * @парам msg the detail message.
     */
    доступный ОшибкаСловообразования(Строка msg) {
        поверх(msg);
    }
}
