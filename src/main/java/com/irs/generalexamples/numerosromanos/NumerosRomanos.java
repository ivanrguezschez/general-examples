package com.irs.generalexamples.numerosromanos;

/**
 * Clase que convierte un numero en numeros romanos.
 *
 * @author IRS
 * @version 1.0.0
 */
public class NumerosRomanos {

    private static final String[][] SIMBOLOS = {
            {"I", "V", "X"}, // simbolos para las unidades (el base, el de 5 y el siguiente I, II, III, IV, V, VI, VII, VIII, IX)
            {"X", "L", "C"}, // simbolos para las decenas
            {"C", "D", "M"}, // simbolos para las centenas
            {"M", "", ""} // simbolos para las unidades de millar
    };

    public NumerosRomanos() {
        super();
    }

    /**
     * Convierte un numero (arábico) en su representación en numeros romanos.
     * @param numero El numero a convertir. Debe estar comprendido entre 1 y 3999
     * @return La representación del numero en numeros romanos.
     * @throws Exception si el numero no está comprendido entre 1 y 3999.
     */
    public String convetir(int numero) throws Exception{
        StringBuilder sb = new StringBuilder();

        if (numero < 1 || numero > 3999) {
            throw new Exception("Numero inválido (Rango válido comprendido entre 1 y 3999)");
        }

        int tipo = 1; // 1=unidad, 2=decena, 3=centena, 4=unidad de millar, etc
        int resto;
        while (numero > 0) {
            // Primero obtenemos las unidades, luego las decenas, centenas, etc
            resto = numero % 10;
            numero /= 10;

            sb.insert(0, convertirTipo(tipo, resto));

            // Incremento el tipo para pasar de las unidades a las decenas, centenas, etc
            tipo++;
        }

        return sb.toString();
    }

    private String convertirTipo(int tipo, int valor) {
        StringBuilder result = new StringBuilder();

        int idxTipo = tipo - 1;

        switch (valor) {
            case 1:
            case 2:
            case 3:
                for (int idx = 1; idx <= valor; idx++) {
                    result.append(SIMBOLOS[idxTipo][0]);
                }
                break;
            case 4:
                result.append(SIMBOLOS[idxTipo][0]);
                result.append(SIMBOLOS[idxTipo][1]);
                break;
            case 5:
                result.append(SIMBOLOS[idxTipo][1]);
                break;
            case 6:
            case 7:
            case 8:
                result.append(SIMBOLOS[idxTipo][1]);
                for (int idx = 6; idx <= valor; idx++) {
                    result.append(SIMBOLOS[idxTipo][0]);
                }
                break;
            case 9:
                result.append(SIMBOLOS[idxTipo][0]);
                result.append(SIMBOLOS[idxTipo][2]);
                break;
            default:
                break;

        }

        return result.toString();
    }
}
