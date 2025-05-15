package com.one;

import javax.swing.JOptionPane;

public class ConvertirMoneda {
    public static void convertir(String monedaBase, String monedaObjetivo, ConsultaMoneda consulta, double cantidad) {
        double cantidadConvertida;

        Monedas monedas = consulta.buscaMoneda(monedaBase, monedaObjetivo);
        JOptionPane.showMessageDialog(null, "La tasa de conversión para hoy\n1 " + monedaBase + " => " + monedas.conversion_rate() + " " + monedaObjetivo);
        cantidadConvertida = cantidad * monedas.conversion_rate();
        JOptionPane.showMessageDialog(null, cantidad + " " + monedaBase + " => " + cantidadConvertida + " " + monedas.target_code());
    }

    public static void convertirOtraMoneda(ConsultaMoneda consulta, double cantidad) {
        String monedaBase = JOptionPane.showInputDialog("Ingrese el código de la moneda base:").toUpperCase();
        String monedaObjetivo = JOptionPane.showInputDialog("Ingrese el código de la moneda objetivo:").toUpperCase();

        if (monedaBase == null || monedaBase.isEmpty() || monedaObjetivo == null || monedaObjetivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Los códigos de moneda no pueden estar vacíos.");
            return;
        }

        convertir(monedaBase, monedaObjetivo, consulta, cantidad);
    }
}
