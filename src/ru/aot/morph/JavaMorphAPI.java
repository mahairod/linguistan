пакет ru.aot.morph;

внеся java.io.File;
внеся java.io.UnsupportedEncodingException;
внеся java.util.Коллекция;
внеся java.util.Множество;
внеся java.util.HashSet;
внеся java.util.МножествоСвёрток;
внеся java.util.Список;
внеся статичный ru.aot.morph.ТипГраммемы.*;

внеся ru.aot.morph.JavaMorphAPI.РезультатСлова.Парадигма;

доступный класс JavaMorphAPI{
	доступный статичный переч Язык{Русский};
	
	доступный статичный класс ИсключениеЯваСопряженияМорфологии расширяет RuntimeException{
		личный статичный итоговый ширцел serialVersionUID = 6844719078250020184L;
		доступный ИсключениеЯваСопряженияМорфологии() {поверх();}
		доступный ИсключениеЯваСопряженияМорфологии(Строка сообщение, Throwable причина) {поверх(сообщение, причина);}
		доступный ИсключениеЯваСопряженияМорфологии(Строка сообщение) {поверх(сообщение);}
		доступный ИсключениеЯваСопряженияМорфологии(Throwable причина) {поверх(причина);}
	}

	доступный статичный тщетный приготовьСловари(Множество<Язык> языкиДляОзначивания) кидает ИсключениеЯваСопряженияМорфологии {
		цел наборБитов = 0;
		для(Язык яз:языкиДляОзначивания) {
			наборБитов|=(1<<яз.ordinal());
		}
		initImpl(наборБитов, РАБОЧИЙ_КАТАЛОГ==ничто? ничто: РАБОЧИЙ_КАТАЛОГ.getAbsolutePath() );
	}
	
	доступный статичный тщетный закройСловари(){
		closeImpl();
	}

	доступный статичный переч ЧастьРечи {
		существительное,	// 0
		прилагательное,		// 1
		глагол,				// 2
		местоименное_существительное,	// 3
		местоименное_прилагательное,	// 4
		местоименный_предикатив,			// 5
		числительное_количественное,	// 6
		числительное_порядковое,		// 7
		наречие,			// 8
		предикатив,			// 9
		предлог,				// 10
		пословица,			// 11
		союз,				// 12
		междометие,			// 13
		вводное_слово,		// 14
		фраза,				// 15
		частица,				// 16
		краткое_прилагательное,			// 17
		причастие,			//18
		деепричастие,		//19
		краткое_причастие,	//20
		инфинитив			//21
		;

		@Подмени
		доступный Строка toString() {
			верни name().replace('_', ' ');
		}

		доступный Строка кратко(){
			если (ordinal() <= предлог.ordinal()){
				верни краткие_названия[ordinal()];
			} иначе {
				верни name();
			}
		}

		личный итоговый Строка[] краткие_названия = новый Строка[] {"сущ", "прил", "гл", "мест", "нар", "пред"};
	};

	личный статичный итоговый Строка[][] названия = Названия.полные_имена;

	личный статичный итоговый Строка[][] названия_кратко = Названия.краткие_имена;

	доступный статичный переч Граммема {
		// 0..1
		множественное(Число), единственное(Число),
		// 2..8
		именительный(Падеж), родительный(Падеж), дательный(Падеж), винительный(Падеж), творительный(Падеж), предложный(Падеж), звательный(Падеж),
		// род 9-12
		мужской(Род), женский(Род), средний(Род), обоюдный(Род),
		// 13..15
		настоящее(Время), будущее(Время), прошлое(Время),
		// 16..18
		первое(Лицо), второе(Лицо), третье(Лицо),
		// 19
		повелительное(Наклонение),
		// 20..21
		одушевлённое(Одушевлённость), неодушевлённое(Одушевлённость),
		// 22
		сравнительная(Степень_сравнения),
		// 23..24
		совершенный(Вид), несовершенный(Вид),
		// 25..26
		непереходный(Переходность), переходный(Переходность),
		// 27..28
		действительный(Залог), страдательный(Залог),
		// 29-31
		неизменяемое(НетТипа), аббревиатура(Собственное), отчество(Собственное),
		// 32-33
		локативность(Собственное), организация(Собственное),
		// 34-35
		качественное(Разряд),
		neImeetMnojestvChisla(НетТипа),
		// 36-37 (наречия)
		voprositNarech(НетТипа), ukazat(НетТипа),
		// 38..39
		имя(Собственное), фамилия(Собственное),
		// 40
		безличный(НетТипа),
		// 41,42
		жаргонизм(Стиль), опечатка(Стиль),
		// 43,44,45
		разговорное(Стиль), притяжательное(Специальный_падеж), архаизм(Стиль),
		// для второго родительного и второго предложного
		padej2(Специальный_падеж),
		поэтизм(Стиль), профессионализм(Стиль),
		превосходная(Степень_сравнения), poloj(НетТипа)
		;

		Граммема(ТипГраммемы типГраммемы){
			это.типГраммемы = типГраммемы;
			типГраммемы.updateLimits(это);
		}

		личный итоговый ТипГраммемы типГраммемы;

		доступный Строка коротко() {
			если (ordinal() <= третье.ordinal() ){
				цел смещение = ordinal()-база().ordinal();
				верни названия_кратко[типГраммемы.ordinal()][смещение];
			} иначе {
				верни toString();
			}
		}

		доступный Граммема база() {
			верни тип().границы()[0];
		}
		доступный ТипГраммемы тип(){
			верни типГраммемы;
		}

		доступный логическое тип(ТипГраммемы проверка){
			верни это.тип() == проверка;
		}

		личный Строка описание(цел смещение){
			StringBuilder sb = новый StringBuilder(64);
			Строка название = названия[тип().ordinal()][смещение];
			sb.append(название).append(' ').append(типГраммемы.имя());
			верни sb.toString();
		}

		@Подмени
		доступный Строка toString() {
			выбери (это){
				случай повелительное:
					верни описание(2);
				случай сравнительная:
					верни описание(1);
				случай превосходная:
					верни описание(2);
/*
				neImeetMnojestvChisla,
				// 36-37 (наречия)
				voprositNarech, ukazat,
				bezlichnGlagol,
				// для второго родительного и второго предложного
				padej2,
				poloj;
*/
				запасной:
					если ( ordinal() <= страдательный.ordinal() ){
						цел смещение = ordinal()-база().ordinal();
						верни описание(смещение);
					} иначе {
						верни это.name();
					}
			}
		}

	};

	доступный статичный сопряжение РезультатСлова{
		доступный статичный сопряжение Парадигма{
			логическое былоНайдено();
			Строка дайБазовуюФорму();
			ЧастьРечи дайЧастьРечи();
			Множество<Граммема> дайГраммемы();
			Список<ФормаСлова> формы();
			@Подмени
			Строка toString();
		}
		Множество<Парадигма> дайПарадигмы();
	}

	доступный статичный РезультатСлова найдиСлово(Язык язык, Строка слово) кидает ИсключениеЯваСопряженияМорфологии {
		итоговый байт[] байты = байтыСлова(язык, слово);
		верни lookupWordImpl(язык.ordinal(), байты);
	}

	доступный статичный ФормаСлова найдиФорму(Язык язык, Строка слово, Множество<Граммема> граммемы) кидает ИсключениеЯваСопряженияМорфологии {
		итоговый байт[] байты = байтыСлова(язык, слово);
		ширцел маска = маскаГраммем( граммемы );
		итоговый РезультатСлова рс = lookupFormImpl(язык.ordinal(), байты);
		для (Парадигма парадигма: рс.дайПарадигмы() ){
			для (ФормаСлова словоформа: парадигма.формы()){
				ширцел образец = словоформа.дайМаскуГраммем();
				если ( согласиеФорм(маска, образец) ){
					верни словоформа;
				}
			}
		}
		верни ничто;
	}

	доступный статичный РезультатСлова формыСлова(Язык язык, Строка слово) кидает ИсключениеЯваСопряженияМорфологии {
		итоговый байт[] байты = байтыСлова(язык, слово);
		итоговый РезультатСлова рс = lookupWordImpl(язык.ordinal(), байты);
		Множество<Парадигма> парадигмы = новый МножествоСвёрток<>();
		для (Парадигма парадигма: рс.дайПарадигмы() ){
			итоговый байт[] байты_парадигмы = байтыСлова(язык, парадигма.дайБазовуюФорму());
			итоговый РезультатСлова рс_формы = lookupFormImpl(язык.ordinal(), байты_парадигмы);
			парадигмы.добавьВсе( рс_формы.дайПарадигмы() );
		}
		верни новый РезультатСловаВопл(парадигмы);
	}

	личный статичный логическое согласиеФорм(ширцел ф1, ширцел ф2){
		ширцел маскаРода =	ТипГраммемы.Род.маска();
		ширцел маскаЧисла =	ТипГраммемы.Число.маска();
		ширцел маскаПад =	ТипГраммемы.Падеж.маска();
		верни
			((маскаПад	& ф1 & ф2) > 0 || 0==(маскаПад	& ф1) || 0==(маскаПад	& ф2)) &&
			((маскаЧисла& ф1 & ф2) > 0 || 0==(маскаЧисла	& ф1) || 0==(маскаЧисла	& ф2)) &&
		    ((маскаРода	& ф1 & ф2) > 0 || 0==(маскаРода	& ф1) || 0==(маскаРода	& ф2));
	}

	личный статичный байт[] байтыСлова(Язык язык, Строка слово) {
		выбери(язык){
		случай Русский:
			попробуй {
				верни слово.getBytes("cp1251");
			} ловя (UnsupportedEncodingException и) {
				кинь новый AssertionError(и);
			}
		запасной:
			кинь новый AssertionError("неизвестный язык: " + язык);
		}
	}

	личный статичный туземный РезультатСлова lookupWordImpl(цел идЯзыка, байт[] слово);
	личный статичный туземный РезультатСлова lookupFormImpl(цел идЯзыка, байт[] слово);
	личный статичный туземный тщетный initImpl(цел битовыйНаборЯзыков, Строка env_path);
	личный статичный туземный тщетный closeImpl();

	//used in natives
	личный статичный Строка convertFromCP1251(байт[] байты_cp1251){
		попробуй {
			верни новый Строка(байты_cp1251, "cp1251");
		} ловя (UnsupportedEncodingException e) {
			кинь новый AssertionError(e);
		}
	}
	
	личный статичный ширцел маскаГраммем(Коллекция<Граммема> граммемы){
		ширцел result = 0;
		для (Граммема г: граммемы){
			result |= (1 << г.ordinal());
		}
		верни result;
	}

	личный статичный итоговый Граммема[] значения_граммем = Граммема.values();
	личный статичный итоговый ЧастьРечи[] значения_чречи = ЧастьРечи.values();

	//used in natives
	личный статичный тщетный добавьГраммемуКМножеству(HashSet<Граммема> множествоГраммем, цел идГраммемы){
		множествоГраммем.add(значения_граммем[идГраммемы]);
	}

	//used in natives
	личный статичный тщетный добавьПарадигмуКМножеству(HashSet<Парадигма> множествоПарадигм, итоговый HashSet<Граммема> множествоГраммем, итоговый Строка базоваяФорма, итоговый логическое найдено, цел идЧастиРечи){
		итоговый ЧастьРечи чречи = значения_чречи[идЧастиРечи];
		множествоПарадигм.add(новый ПарадигмаНормальная(найдено, чречи, множествоГраммем, базоваяФорма));
	}

	//used in natives
	личный статичный тщетный добавьПарадигму(HashSet<Парадигма> множествоПарадигм, Парадигма парадигма){
		множествоПарадигм.add(парадигма);
	}

	//used in natives
	личный статичный РезультатСлова создайРезультатСлова(итоговый HashSet<Парадигма> множествоПарадигм){
		верни новый РезультатСловаВопл(множествоПарадигм);
	}

	//used in natives
	личный статичный Парадигма добавьСловоформуКПарадигме(Парадигма парадигма, Строка форма, ширцел граммемы, цел идЧастиРечи){
		итоговый ЧастьРечи частьРечи = значения_чречи[идЧастиРечи];
		если (парадигма == ничто){
			парадигма = новый ПарадигмаПолная(истина, частьРечи);
		}
		если (!(парадигма экземпляр ПарадигмаПолная)){
			верни ничто;
		}
		ПарадигмаПолная парадигмаПолная = (ПарадигмаПолная) парадигма;
		ФормаСлова формаСлова = новый ФормаСлова(частьРечи, форма, граммемы, парадигма);
		парадигмаПолная.добавьФорму(формаСлова);
		верни парадигма;
	}

	личный статичный тщетный загрузиБиблиотеку(Строка библ){
		System.load(новый File(ТЕКУЩИЙ_КАТАЛОГ, библ + ".so").getAbsolutePath());
	}
	итоговый личный статичный File ТЕКУЩИЙ_КАТАЛОГ;
	итоговый личный статичный File РАБОЧИЙ_КАТАЛОГ;
	статичный{
		{
			Строка раб_катал = Система.дайСвойство("JNIMorphAPI-rml-dir");
			РАБОЧИЙ_КАТАЛОГ = (раб_катал==ничто) ? ничто : новый File(раб_катал);

			Строка бин_катал = Система.дайСвойство("JNIMorphAPI-jni-lib-dir");
			если(бин_катал!=ничто){
				ТЕКУЩИЙ_КАТАЛОГ = новый File(бин_катал);
			} иначе {
				если (РАБОЧИЙ_КАТАЛОГ!=ничто){
					ТЕКУЩИЙ_КАТАЛОГ = новый File(РАБОЧИЙ_КАТАЛОГ, "Bin/");
				} иначе {
					ТЕКУЩИЙ_КАТАЛОГ = новый File("jni-lib");
				}
			}
		}

		попробуй{
			загрузиБиблиотеку("JNIMorphAPI");
		}ловя(Throwable tr){
			System.err.println("Ошибка загрузки библиотеки JNIMorphAPI");
			кинь новый ExceptionInInitializerError(tr);
		}
	}

}