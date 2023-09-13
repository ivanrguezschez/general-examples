package com.irs.generalexamples;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Clase que transforma un numero a su representación en texto.
 * Ejemplo: 1 = Uno, 100 = Cien.
 *
 * @author IRS
 * @version 1.0.0
 *
 * 	NOTAS:
 * 	Como solo hay un metodo estatico para transformar considero siempre la moneda EUROS
 * 	Si se le indicara otra moneda, la posibilidad de crear una instaciá de la clase
 * 	NumberToText y en el constructor o via set estableceria la moneda y los centimos (por ejemplo)
 *
 *	Hacer un único getNumero(Integer number, int tipo) donde tipo = unidad, decena, centena, etc etc
 *
 *	UNIDAD
 *	DECENA
 *	CENTENA
 *	UNIDAD DE MILLAR
 *	DECENA DE MILLAR
 *	CENTENA DE MILLAR
 *	UNIDAD DE MILLON
 *	DECENA DE MILLON
 *	CENTENA DE MILLON
 *	UNIDAD DE MILLAR DE MILLON
 *	DECENA DE MILLAR DE MILLON
 *	CENTENA DE MILLAR DE MILLON
 */
public class NumberToText {
    private static final String CENTIMOS_PREFIJO = " con ";

    private static final String EURO = "euro";
    private static final String CENTIMO = "centimo";

    private static final String UNIDAD_MILLAR_SUFIJO = "mil";
    private static final String UNIDAD_MILLON_SUFIJO_1 = "millon";
    private static final String UNIDAD_MILLON_SUFIJO = "millones";
    private static final String CERO = "cero";
    private static final String[] UNIDAD = {
            "",
            "un",
            "dos",
            "tres",
            "cuatro",
            "cinco",
            "seis",
            "siete",
            "ocho",
            "nueve"
    };
    private static final String DECENA_VEINTE = "veinti";
    private static final String[] DECENA = {
            "diez",
            "once",
            "doce",
            "trece",
            "catorce",
            "quince",
            "dieciseis",
            "diecisiete",
            "dieciocho",
            "diecinueve",
            "veinte",
            "treinta", // 11
            "cuarenta",
            "cincuenta",
            "sesenta",
            "setenta",
            "ochenta",
            "noventa"
    };
    private static final String[] CENTENA = {
            "cien",
            "ciento",
            "doscientos",
            "trescientos",
            "cuatrocientos",
            "quinientos",
            "seiscientos",
            "setecientos",
            "ochocientos",
            "novecientos"
    };

    public NumberToText() {
        super();
    }

    /**
     * Transforma un numero entero desde 0 hasta 999999999 en letras.
     *
     * @param number El número a transformar en letras.
     * @param appendCoin Flag que indica si se debe añadir la moneda (true) o no
     * (false)
     * @return La representación en letras del numero.
     */
    public static String transform(Integer number, boolean appendCoin) {
        if (number == null || number > 999999999) {
            throw new RuntimeException("Número '" + number + "' a transformar en letras fuera de rango (0 - 999999999)");
        }
        StringBuilder sb = new StringBuilder();

        // si fuera negativo añadiria el codigo comentado
        /*
		if (number < 0) {
			sb.append("menos ");
			number = number * (-1);
		}
         */
        if (number > 999999) {
            // millon (unidad de millon, decena de millon, centena de millon)
            transformMillon(sb, number);
        } else if (number > 999) {
            // millar (unidad de millar, decena de millar, centena de millar)
            transformMillar(sb, number);
        } else if (number > 99) {
            // centena
            transformCentena(sb, number);
        } else if (number > 9) {
            // decena
            transformDecena(sb, number);
        } else if (number > 0) {
            // unidad
            transformUnidad(sb, number);
        } else {
            sb.append(CERO);
        }
        if (appendCoin) {
            appendCoin(sb, number);
        }
        return sb.toString().trim();
    }

    /**
     * Transforma un numero real desde 0.00 hasta 999999999.99 en letras.
     *
     * @param number El número a transformar en letras.
     * @param appendCoin Flag que indica si se debe añadir la moneda (true) o no
     * (false)
     * @return La representación en letras del numero.
     */
    public static String transform(Double number, boolean appendCoin) {
        if (number == null || number > 999999999.99) {
            throw new RuntimeException("Número '" + number + "' a transformar en letras fuera de rango (0.00 - 999999999.99)");
        }
        StringBuilder sb = new StringBuilder();

        // si fuera negativo añadiria el codigo comentado
        /*
		if (number < 0) {
			sb.append("menos ");
			number = number * (-1);
		}
         */
        String doubleAsString = number.toString();
        //int decimal = Integer.parseInt(doubleAsString.split("\\.")[0]);
        //int fractional = Integer.parseInt(doubleAsString.split("\\.")[1]);
        Integer entera = Integer.valueOf(doubleAsString.substring(0, doubleAsString.lastIndexOf(".")));
        Integer decimal = Integer.valueOf(doubleAsString.substring(doubleAsString.lastIndexOf(".") + 1));

        sb.append(transform(entera, appendCoin));
        sb.append(CENTIMOS_PREFIJO);
        sb.append(transform(decimal, false));
        if (appendCoin) {
            appendCoinCent(sb, decimal);
        }

        return sb.toString().trim();
    }

    private static void transformMillon(StringBuilder sb, Integer number) {
        Integer unidadMillon = getUnidadMillon(number);
        Integer decenaMillon = 0;
        Integer centenaMillon = 0;
        if (number > 999999 && number < 10000000) {
            sb.append(UNIDAD[unidadMillon]);
            sb.append(" ");
            if (unidadMillon == 1) {
                sb.append(UNIDAD_MILLON_SUFIJO_1);
            } else {
                sb.append(UNIDAD_MILLON_SUFIJO);
            }
            sb.append(" ");
        } else if (number > 9999999 && number < 100000000) {
            decenaMillon = getDecenaMillon(number);
            transformDecena(sb, decenaMillon * 10 + unidadMillon);
            sb.append(" ");
            sb.append(UNIDAD_MILLON_SUFIJO);
            sb.append(" ");
        } else if (number > 99999999 & number < 1000000000) {
            decenaMillon = getDecenaMillon(number);
            centenaMillon = getCentenaMillon(number);
            transformCentena(sb, (centenaMillon * 100) + (decenaMillon * 10) + unidadMillon);
            sb.append(" ");
            sb.append(UNIDAD_MILLON_SUFIJO);
            sb.append(" ");
        }
        number = number - (((centenaMillon * 100) + (decenaMillon * 10) + unidadMillon) * 1000000);
        if (number < 10) {
            transformUnidad(sb, number);
        } else if (number < 100) {
            transformDecena(sb, number);
        } else if (number < 1000) {
            transformCentena(sb, number);
        } else {
            transformMillar(sb, number);
        }
    }

    private static void transformMillar(StringBuilder sb, Integer number) {
        if (number > 0) {
            Integer unidadMillar = getUnidadMillar(number);
            Integer decenaMillar = 0;
            Integer centenaMillar = 0;
            if (number > 999 && number < 10000) {
                if (unidadMillar == 1) {
                    sb.append(UNIDAD_MILLAR_SUFIJO);
                    sb.append(" ");
                } else {
                    sb.append(UNIDAD[unidadMillar]);
                    sb.append(" ");
                    sb.append(UNIDAD_MILLAR_SUFIJO);
                    sb.append(" ");
                }
            } else if (number > 9999 && number < 100000) {
                decenaMillar = getDecenaMillar(number);
                transformDecena(sb, decenaMillar * 10 + unidadMillar);
                sb.append(" ");
                sb.append(UNIDAD_MILLAR_SUFIJO);
                sb.append(" ");
            } else if (number > 99999 & number < 1000000) {
                decenaMillar = getDecenaMillar(number);
                centenaMillar = getCentenaMillar(number);
                transformCentena(sb, (centenaMillar * 100) + (decenaMillar * 10) + unidadMillar);
                sb.append(" ");
                sb.append(UNIDAD_MILLAR_SUFIJO);
                sb.append(" ");
            }

            number = number - (((centenaMillar * 100) + (decenaMillar * 10) + unidadMillar) * 1000);
            if (number < 10) {
                transformUnidad(sb, number);
            } else if (number < 100) {
                transformDecena(sb, number);
            } else {
                transformCentena(sb, number);
            }
        }
    }

    private static void transformCentena(StringBuilder sb, Integer number) {
        if (number == 100) {
            sb.append(CENTENA[0]);
        } else {
            Integer centena = getCentena(number);
            sb.append(CENTENA[centena]);
            sb.append(" ");
            number = number - (centena * 100);
            if (number < 10) {
                transformUnidad(sb, number);
            } else {
                transformDecena(sb, number);
            }
        }
    }

    private static void transformDecena(StringBuilder sb, Integer number) {
        Integer unidad = getUnidad(number);
        Integer decena = getDecena(number);
        if (number <= 20) {
            sb.append(DECENA[number - 10]);
        } else if (number > 20 && number < 30) {
            sb.append(DECENA_VEINTE);
            transformUnidad(sb, unidad);
        } else {
            sb.append(DECENA[decena + 8]);
            if (unidad != null && unidad != 0) {
                sb.append(" y ");
                transformUnidad(sb, unidad);
            }
        }
    }

    private static void transformUnidad(StringBuilder sb, Integer number) {
        sb.append(UNIDAD[number]);
    }

    private static Integer getUnidad(Integer number) {
        String numberString = number.toString();
        return Integer.parseInt(numberString.substring(numberString.length() - 1));
    }

    private static Integer getDecena(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 2;
        int endIndex = numberString.length() - 1;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getCentena(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 3;
        int endIndex = numberString.length() - 2;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getUnidadMillar(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 4;
        int endIndex = numberString.length() - 3;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getDecenaMillar(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 5;
        int endIndex = numberString.length() - 4;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getCentenaMillar(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 6;
        int endIndex = numberString.length() - 5;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getUnidadMillon(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 7;
        int endIndex = numberString.length() - 6;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getDecenaMillon(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 8;
        int endIndex = numberString.length() - 7;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static Integer getCentenaMillon(Integer number) {
        String numberString = number.toString();
        int beginIndex = numberString.length() - 9;
        int endIndex = numberString.length() - 8;
        return Integer.parseInt(numberString.substring(beginIndex, endIndex));
    }

    private static void appendCoin(StringBuilder sb, Integer number) {
        if (sb.charAt(sb.length() - 1) != ' ') {
            sb.append(" ");
        }
        sb.append(EURO);
        if (number != 1) {
            sb.append("s");
        }
    }

    private static void appendCoinCent(StringBuilder sb, Integer number) {
        sb.append(" ");
        sb.append(CENTIMO);
        if (number != 1) {
            sb.append("s");
        }
    }

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("###,###,###,###.##");
        int number = 0;
        try {
//			System.out.println(nf.format(Integer.valueOf(1000000)) + "->" + NumberToText.transform(Integer.valueOf(1000000)) + "<-");
//			System.out.println(nf.format(Integer.valueOf(1000001)) + "->" + NumberToText.transform(Integer.valueOf(1000001)) + "<-");
//			System.out.println(nf.format(Double.valueOf(0)) + "->" + NumberToText.transform(Double.valueOf(0), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(1)) + "->" + NumberToText.transform(Double.valueOf(1), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(0.21)) + "->" + NumberToText.transform(Double.valueOf(0.21), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(123400.99)) + "->" + NumberToText.transform(Double.valueOf(123400.99), true) + "<-");
//			System.out.println(nf.format(Integer.valueOf(400)) + "->" + NumberToText.transform(Integer.valueOf(400), true) + "<-");
//			System.out.println(nf.format(Integer.valueOf(123400)) + "->" + NumberToText.transform(Integer.valueOf(123400), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(1.01)) + "->" + NumberToText.transform(Double.valueOf(1.01), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(1.02)) + "->" + NumberToText.transform(Double.valueOf(1.02), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(1.12)) + "->" + NumberToText.transform(Double.valueOf(1.12), true) + "<-");
//			System.out.println(nf.format(Double.valueOf(1.00)) + "->" + NumberToText.transform(Double.valueOf(1.00), true) + "<-");

            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                number = i;
                NumberToText.transform(Integer.valueOf(i), false);
            }
            long end = System.currentTimeMillis();
            System.out.println("Tiempo: " + (end - start) + " ms");
            System.out.println("Tiempo: " + (end - start) / 1000 + "s " + (end - start) % 1000 + "ms");
        } catch (Exception e) {
            System.out.println("Error en el numero " + number);
            e.printStackTrace();
        }
    }
}
