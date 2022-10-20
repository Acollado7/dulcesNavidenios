package dulcesnavidenios;

import javax.swing.*;

public class Esteponera {
    public static void main(String[] args) {

        //Declaración de variables

        final double COSTE_MANO_OBRA_M1_T1 = 0.15;
        final double COSTE_MANO_OBRA_M2_T2_P1 = 0.22;

        //La materia prima utilizada para producir unidades con código M1 y T1 supone 0.25€; para los que tienen código M2, T2 y P1, supone 0.35€.
        final double COSTE_MATERIA_PRIMA_M1_T1 = 0.25;
        final double COSTE_MATERIA_PRIMA_M2_T2_P1 = 0.35;

        //Además, cada producto tiene un precio de venta que se calcula en función del coste de producción.
        //Artículos M1, M2 y P1. Precio de venta unitario = coste de producción + 50 % del coste de producción
        //Resto de artículos. Precio de venta unitario = coste de producción + 65 % del coste de producción

        final double PORCENTAJE_M1_M2_P1 = 0.5;
        final double PORCENTAJE_RESTO = 0.65;



        //Declaracion de variables
        String codigo;
        double precioMateriaPrima;
        double costeProduccion;
        double precioVenta;
        int unidades;
        double beneficio;

        //Creamos un menu donde el usuario pueda elegir el codigo del producto
        String[] opciones = {"M1", "P1", "T1", "T2", "M2"};
        codigo = (String) JOptionPane.showInputDialog(null, "Elige el codigo del producto", "Menu", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);


        //Comprobar que el codigo es correcto

        if (codigo.equals("M1") || codigo.equals("M2") || codigo.equals("P1") || codigo.equals("T1") || codigo.equals("T2")) {
            //Solicitar el precio de la materia prima con JOptionPane
            precioMateriaPrima = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio de la materia prima"));

            //Comprobar que el precio de la materia prima es correcto
            if (precioMateriaPrima >= 0.1 && precioMateriaPrima <= 1) {
                //Calcular el coste de produccion
                if (codigo.equals("M1") || codigo.equals("T1")) {
                    costeProduccion = precioMateriaPrima + COSTE_MANO_OBRA_M1_T1;
                } else {
                    costeProduccion = precioMateriaPrima + COSTE_MANO_OBRA_M2_T2_P1;
                }

                //Calcular el precio de venta
                if (codigo.equals("M1") || codigo.equals("M2") || codigo.equals("P1")) {
                    precioVenta = costeProduccion + (costeProduccion * PORCENTAJE_M1_M2_P1);
                } else {
                    precioVenta = costeProduccion + (costeProduccion * PORCENTAJE_RESTO);
                }

                //Calcular el numero de unidades
                unidades = (int) (2500 / (precioVenta - costeProduccion));

                //Calcular el beneficio
                beneficio = (precioVenta - costeProduccion) * unidades;

                //Mostrar el resultado
                JOptionPane.showMessageDialog(null, "El coste de produccion es " + costeProduccion + "€\n"
                        + "El precio de venta es " + precioVenta + "€\n"
                        + "El numero de unidades es " + unidades + "\n"
                        + "El beneficio es " + beneficio + "€");
            } else {
                JOptionPane.showMessageDialog(null, "El precio de la materia prima no es correcto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El codigo introducido no es correcto");
        }






    }
}
