/*
 *  Лицензия Астафьева
 * Данный программный код является собственностью Астафьева Антона Александровича
 * и может быть использован только с его личного разрешения
 */
package org.elliptica.ling;

/**
 *
 * @author Антон Астафьев <anton@astafiev.me> (Anton Astafiev)
 */
public enum ЧастьРечи {
		существительное,	// 0
		прилагательное,
		глагол,				// 2
		местоименное_существительное,	// 3
		местоименное_прилагательное,
		местоименный_предикатив,
		числительное_количественное,
		числительное_порядковое,		// 7
		наречие,			// 8
		предикатив,
		предлог,	
		пословица,
		союз,
		междометие,
		вводное_слово,		// 14
		фраза,
		частица,
		краткое_прилагательное,//17
		причастие,
		деепричастие,
		краткое_причастие,	//20
		инфинитив
		;

	@Override
	public String toString() {
		return name().replace('_', ' ');
	}

	public String кратко() {
		if (ordinal() <= предлог.ordinal()) {
			return краткие_названия[ordinal()];
		} else {
			return name();
		}
	}
	private final String[] краткие_названия = new String[]{"сущ", "прил", "гл", "мест", "нар", "пред"};

}
