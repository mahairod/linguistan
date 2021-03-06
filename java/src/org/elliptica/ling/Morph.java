пакет org.elliptica.ling;

внеся java.io.FileOutputStream;
внеся java.io.IOException;
внеся java.io.InputStream;
внеся java.io.OutputStream;
внеся java.util.Множество;
внеся java.util.HashSet;
внеся java.util.МножествоСвёрток;
внеся эллиптика.ява.ввыв.Файл;
внеся эллиптика.ява.язык.Система;
внеся java.util.logging.Level;
внеся java.util.logging.Logger;
внеся java.util.Коллекции;
внеся эллиптика.ява.язык.Настройки;

доступный класс Morph {
	доступный статичный переч Язык{Русский};

	доступный статичный тщетный приготовьСловари(Множество<Язык> языкиДляОзначивания) кидает ОтклонениеМорфологии {
		цел наборБитов = 0;
		для(Язык яз:языкиДляОзначивания) {
			наборБитов|=(1<<яз.ordinal());
		}
		initImpl(наборБитов, РАБОЧИЙ_КАТАЛОГ==ничто? ничто: РАБОЧИЙ_КАТАЛОГ.getAbsolutePath() );
	}

	доступный статичный тщетный закройСловари() {
		closeImpl();
	}

	доступный статичный РезультатСлова найдиСлово(Строка слово) кидает ОтклонениеМорфологии {
		Язык язык = Язык.Русский;
		итоговый байт[] байты = байтыСлова(язык, слово);
		верни lookupWordImpl(язык.ordinal(), байты);
	}

	доступный статичный ФормаСлова найдиФорму(Строка слово, ЧастьРечи частьРечи, Множество<Граммема> граммемы) кидает ОтклонениеМорфологии {
		Язык язык = Язык.Русский;
		итоговый байт[] байты = байтыСлова(язык, слово);
		ширцел маска = Граммема.маскаГраммем( граммемы );
		если (частьРечи == ЧастьРечи.инфинитив && (маска & (М_ЛИЦО|М_ЧИСЛО|М_РОД|М_ВРЕМЯ))!=0 ) {
			частьРечи = ЧастьРечи.глагол;
		}
		итоговый РезультатСлова рс = lookupFormImpl(язык.ordinal(), байты);
		для (Парадигма парадигма: рс.дайПарадигмы() ) {
			для (ФормаСлова словоформа: парадигма.формы()) {
				если (частьРечи != словоформа.дайЧастьРечи()){
					возобнови;
				}
				ширцел образец = словоформа.дайМаскуГраммем();
				если ( согласиеФорм(маска, образец) ) {
					верни словоформа;
				}
			}
		}
		верни ничто;
	}

	доступный статичный РезультатСлова формыСлова(Строка слово) кидает ОтклонениеМорфологии {
		Язык язык = Язык.Русский;
		итоговый байт[] байты = байтыСлова(язык, слово);
		итоговый РезультатСлова рс = lookupWordImpl(язык.ordinal(), байты);
		Множество<Парадигма> парадигмы = новый МножествоСвёрток<>();
		для (Парадигма парадигма: рс.дайПарадигмы() ) {
			итоговый байт[] байты_парадигмы = байтыСлова(язык, парадигма.дайБазовуюФорму());
			итоговый РезультатСлова рс_формы = lookupFormImpl(язык.ordinal(), байты_парадигмы);
			парадигмы.добавьВсе( рс_формы.дайПарадигмы() );
		}
		верни новый РезультатСловаВопл(парадигмы);
	}

	личный статичный логическое согласиеФорм(ширцел ф1, ширцел ф2) {
		ширцел ф12 = ф1 & ф2;
		верни
			((М_ВРЕМЯ	& ф12) > 0 || 0==(М_ВРЕМЯ	& ф1) || 0==(М_ВРЕМЯ	& ф2)) &&
			((М_ЛИЦО	& ф12) > 0 || 0==(М_ЛИЦО		& ф1) || 0==(М_ЛИЦО	& ф2)) &&
			((М_ЗАЛОГ	& ф12) > 0 || 0==(М_ЗАЛОГ	& ф1) || 0==(М_ЗАЛОГ	& ф2)) &&
			((М_ПАДЕЖ	& ф12) > 0 || 0==(М_ПАДЕЖ	& ф1) || 0==(М_ПАДЕЖ	& ф2)) &&
			((М_ЧИСЛО	& ф12) > 0 || 0==(М_ЧИСЛО	& ф1) || 0==(М_ЧИСЛО	& ф2)) &&
		    ((М_РОД		& ф12) > 0 || 0==(М_РОД		& ф1) || 0==(М_РОД	& ф2)) &&
		    ((М_ОДУШЕВ	& ф12) > 0 || 0==(М_ОДУШЕВ	& ф1) || 0==(М_ОДУШЕВ&ф2)) &&
			( (М_НАКЛ & ф1) == (М_НАКЛ & ф2) )
			;
	}

	личный статичный итоговый ширцел М_РОД =	ТипГраммемы.Род.маска();
	личный статичный итоговый ширцел М_ЧИСЛО =	ТипГраммемы.Число.маска();
	личный статичный итоговый ширцел М_ПАДЕЖ =	ТипГраммемы.Падеж.маска();
	личный статичный итоговый ширцел М_ВРЕМЯ =	ТипГраммемы.Время.маска();
	личный статичный итоговый ширцел М_ЛИЦО =	ТипГраммемы.Лицо.маска();
	личный статичный итоговый ширцел М_ЗАЛОГ =	ТипГраммемы.Залог.маска();
	личный статичный итоговый ширцел М_НАКЛ =	ТипГраммемы.Наклонение.маска();
	личный статичный итоговый ширцел М_ОДУШЕВ =	ТипГраммемы.Одушевлённость.маска();

	личный статичный байт[] байтыСлова(Язык язык, Строка слово) {
		выбери(язык) {
		случай Русский:
			попробуй {
				верни слово.getBytes(КОДИРОВКА);
			} ловя (Exception откл) {
				кинь новый IllegalStateException(откл);
			}
		запасной:
			кинь новый IllegalArgumentException("неизвестный язык: " + язык);
		}
	}

	личный статичный туземный тщетный initImpl(цел битовыйНаборЯзыков, Строка env_path);
	личный статичный туземный тщетный closeImpl();
	личный статичный туземный РезультатСлова lookupWordImpl(цел идЯзыка, байт[] слово);
	личный статичный туземный РезультатСлова lookupFormImpl(цел идЯзыка, байт[] слово);

	// вызывается из низкоуровнего кода
	личный статичный Строка преобразованиеРегионКодировки(байт[] байты) {
		попробуй {
			верни новый Строка(байты, КОДИРОВКА);
		} ловя (Exception откл) {
			кинь новый IllegalArgumentException(откл);
		}
	}

	// вызывается из низкоуровнего кода
	личный статичный тщетный добавьГраммемуКМножеству(HashSet<Граммема> множествоГраммем, цел идГраммемы) {
		множествоГраммем.добавь(значения_граммем[идГраммемы]);
	}

	// вызывается из низкоуровнего кода
	личный статичный тщетный добавьПарадигмуКМножеству(HashSet<Парадигма> множествоПарадигм, итоговый HashSet<Граммема> множествоГраммем, итоговый Строка базоваяФорма, итоговый логическое найдено, цел идЧастиРечи) {
		итоговый ЧастьРечи чречи = значения_чречи[идЧастиРечи];
		множествоПарадигм.добавь(новый ПарадигмаНормальная(найдено, чречи, множествоГраммем, базоваяФорма));
	}

	// вызывается из низкоуровнего кода
	личный статичный тщетный добавьПарадигму(HashSet<Парадигма> множествоПарадигм, Парадигма парадигма) {
		множествоПарадигм.добавь(парадигма);
	}

	// вызывается из низкоуровнего кода
	личный статичный РезультатСлова создайРезультатСлова(итоговый HashSet<Парадигма> множествоПарадигм) {
		верни новый РезультатСловаВопл(множествоПарадигм);
	}

	// вызывается из низкоуровнего кода
	личный статичный Парадигма добавьСловоформуКПарадигме(Парадигма парадигма, Строка форма, ширцел граммемы, цел идЧастиРечи) {
		итоговый ЧастьРечи частьРечи = значения_чречи[идЧастиРечи];
		если (парадигма == ничто) {
			парадигма = новый ПарадигмаПолная(истина, частьРечи);
		}
		если (!(парадигма экземпляр ПарадигмаПолная)) {
			верни ничто;
		}
		ПарадигмаПолная парадигмаПолная = (ПарадигмаПолная) парадигма;
		ФормаСлова формаСлова = новый ФормаСлова(частьРечи, форма, граммемы, парадигма);
		парадигмаПолная.добавьФорму(формаСлова);
		верни парадигма;
	}

	личный статичный тщетный загрузиБиблиотеку(Строка библ) {
		Система.загрузи(новый Файл(ТЕКУЩИЙ_КАТАЛОГ, библ + ".so").дайОтделённыйПуть());
	}
	итоговый личный статичный Файл ТЕКУЩИЙ_КАТАЛОГ;
	итоговый личный статичный Файл РАБОЧИЙ_КАТАЛОГ;
	личный статичный итоговый Строка имяМодуля = "JMorph";

	статичный {
		Настройки.загрузи();
		{
			Строка раб_катал = Система.дайСвойство("jmorph.rml.dir");
			РАБОЧИЙ_КАТАЛОГ = (раб_катал==ничто) ? ничто : новый Файл(раб_катал);

			Строка бин_катал = Система.дайСвойство("JNIMorphAPI-jni-lib-dir");
			если(бин_катал!=ничто) {
				ТЕКУЩИЙ_КАТАЛОГ = новый Файл(бин_катал);
			} иначе {
				если (РАБОЧИЙ_КАТАЛОГ!=ничто) {
					ТЕКУЩИЙ_КАТАЛОГ = новый Файл(РАБОЧИЙ_КАТАЛОГ, "Bin/");
				} иначе {
					ТЕКУЩИЙ_КАТАЛОГ = новый Файл(".");
					байт[] buf = новый байт[1024];
					Файл libFile = новый Файл(ТЕКУЩИЙ_КАТАЛОГ, имяМодуля + ".so");
					если (libFile.exists()) {
						libFile.delete();
					}
					попробуй {
						libFile.createNewFile();
					} ловя (IOException ex) {
						Logger.getLogger(Morph.класс.getName()).log(Level.SEVERE, ничто, ex);
					}
					попробуй (
						InputStream is = Morph.класс.getResourceAsStream("/" + имяМодуля + ".so");
						OutputStream os = новый FileOutputStream( новый Файл(ТЕКУЩИЙ_КАТАЛОГ, имяМодуля + ".so") );
						) {
						цел ready = 0;
						делай {
							ready = is.read(buf);
							если (ready>0) {
								os.write(buf, 0, ready);
							}
						} пока (ready>=0);
					} ловя (IOException ex) {
						Logger.getLogger(Morph.класс.getName()).log(Level.SEVERE, ничто, ex);
					}
				}
			}
			
		}

		попробуй {
			загрузиБиблиотеку(имяМодуля);
		}ловя(Throwable tr) {
			Система.ошибки.печатайстр("Ошибка загрузки библиотеки " + имяМодуля);
			кинь новый ExceptionInInitializerError(tr);
		}
		Множество<Morph.Язык> языкиДляОзначивания = Коллекции.одиночка(Morph.Язык.Русский);
		приготовьСловари(языкиДляОзначивания);
	}
	личный статичный итоговый Граммема[] значения_граммем = Граммема.values();
	личный статичный итоговый ЧастьРечи[] значения_чречи = ЧастьРечи.values();
	личный статичный итоговый Строка КОДИРОВКА = "cp1251";
}