package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
	//Metodo para transformar double em string DE DINHEIRO reais
	static NumberFormat numberFormat = 
			new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
	//* Vai receber Double e vai transformar em string
	public static String doubleToString(double value) {
		return numberFormat.format(value);
	}
}
