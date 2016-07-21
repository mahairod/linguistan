пакет org.elliptica.ling;

внеся java.io.File;
внеся java.io.UnsupportedEncodingException;
внеся java.util.Коллекция;
внеся java.util.Множество;
внеся java.util.HashSet;
внеся java.util.МножествоСвёрток;

доступный класс Morph{
	доступный статичный переч Язык{Русский};

	доступный статичный тщетный приготовьСловари(Множество<Язык> языкиДляОзначивания) кидает ОтклонениеМорфологии {
		цел наборБитов = 0;
		для(Язык яз:языкиДляОзначивания) {
			наборБитов|=(1<<яз.ordinal());
		}
		initImpl(наборБитов, РАБОЧИЙ_КАТАЛОГ==ничто? ничто: РАБОЧИЙ_КАТАЛОГ.getAbsolutePath() );
	}

	доступный статичный тщетный закройСловари(){
		closeImpl();
	}

	доступный статичный РезультатСлова найдиСлово(Язык язык, Строка слово) кидает ОтклонениеМорфологии {
		итоговый байт[] байты = байтыСлова(язык, слово);
		верни lookupWordImpl(язык.ordinal(), байты);
	}

	доступный статичный ФормаСлова найдиФорму(Язык язык, Строка слово, Множество<Граммема> граммемы) кидает ОтклонениеМорфологии {
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

	доступный статичный РезультатСлова формыСлова(Язык язык, Строка слово) кидает ОтклонениеМорфологии {
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