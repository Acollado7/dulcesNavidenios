package dulcesnavidenios;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*

        La fábrica de dulces "La Esteponera Turronera" produce algunos de estos manjares con los siguientes códigos:
        M1 (Mantecados de Limón), P1 (Polvorones), T1 (Turrón de chocolate), T2 (Turrón clásico) y M2 (Mazapanes).

        Cada especialidad tiene un coste de producción que se calcula según la materia prima gastada y la mano de obra
       empleada en producir una unidad (coste producción = materia prima + mano de obra). El coste de la mano de
        obra para producir unidades con código M1 y T1 supone 0.15€; para los que tienen código M2, T2 y P1, supone 0.22€.


*/
        final double COSTE_MANO_OBRA_M1_T1 = 0.15;
        final double COSTE_MANO_OBRA_M2_T2_P1 = 0.22;

        final double PORCENTAJE_VENTA_UNITARIA_M1_M2_P1 = 0.4;
        final double PORCENTAJE_VENTA_RESTO = 0.3;

        double costeMateriaPrima;
        String costeMateriaPrimaString;

        double costeProduccion = 0;
        double costeVentaUnitaria;

        final double BENEFICIO = 2500;

        double unidadesVendidas;
        /*Además, cada producto tiene un precio de venta que se calcula en función del coste de producción.
        Hay que tener en cuenta lo siguiente:
        Artículos M1, M2 y P1. Precio de venta unitario = coste de producción + 50 % del coste de producción
        Resto de artículos. Precio de venta unitario = coste de producción + 65 % del coste de producción
        La fábrica necesita un programa que realice algunos cálculos para ver si es rentable vender un tipo de producto.
       El programa debe solicitar el código de un dulce (si el código no es válido, el programa termina informando de
        que no existe el código introducido) y el precio de la materia prima que se gasta en fabricar una unidad de ese tipo
       (siempre entre 0.1€ y 1€, en otro caso el programa terminará indicando que el precio de la materia prima no es correcto).
       Se debe mostrar el coste de producción unitario y precio de venta unitario. Además debe calcular y mostrar el número de
       unidades a producir para que haya un beneficio de al menos 2500€.

        Todas las entradas y salidas de datos deben hacerse usando JOptionPane. Limita la salida a dos decimales en los casos necesarios.*/
        String codigo;
        String menu = """
                Introduzca el código del dulce:
                M1 (Mantecados de Limón), P1 (Polvorones), T1 (Turrón de chocolate), T2 (Turrón clásico) y M2 (Mazapanes).
                """;
        JOptionPane.showMessageDialog(null, menu);
        codigo = JOptionPane.showInputDialog("Elija el codigo para calcular el coste de produccion y" +
                " el precio de venta unitario");

        if (codigo.equals("M1")
                || codigo.equals("P1")
                || codigo.equals("T1")
                || codigo.equals("T2")
                || codigo.equals("M2")) {
            JOptionPane.showMessageDialog(null, "El codigo introducido es correcto");
            costeMateriaPrimaString = JOptionPane.showInputDialog("Introduzca el precio de la materia prima");

            costeMateriaPrima = Double.parseDouble(costeMateriaPrimaString);

            if (costeMateriaPrima >= 0.1 && costeMateriaPrima <= 1) {
                JOptionPane.showMessageDialog(null, "El precio de la materia prima es correcto");
                if (codigo.equals("M1") || codigo.equals("T1")) {
                    costeProduccion = costeMateriaPrima + COSTE_MANO_OBRA_M1_T1;
                } else if (codigo.equals("M2") || codigo.equals("T2") || codigo.equals("P1")) {
                    costeProduccion = costeMateriaPrima + COSTE_MANO_OBRA_M2_T2_P1;
                }
                if (codigo.equals("M1") || codigo.equals("M2") || codigo.equals("P1")) {
                    costeVentaUnitaria = costeProduccion + (costeProduccion * PORCENTAJE_VENTA_UNITARIA_M1_M2_P1);
                } else {
                    costeVentaUnitaria = costeProduccion + (costeProduccion * PORCENTAJE_VENTA_RESTO);
                }
                unidadesVendidas = BENEFICIO / (costeVentaUnitaria - costeProduccion);
                JOptionPane.showMessageDialog(null, "El coste de produccion es: " + costeProduccion + "€" +
                        " y el precio de venta unitario es: " + costeVentaUnitaria + "€" + " y el numero de unidades a producir para" +
                        " obtener un beneficio de 2500€ es: " + unidadesVendidas);

            } else {
                JOptionPane.showMessageDialog(null, "El codigo introducido no es correcto");
                System.exit(0);
            }


        }
    }
}
