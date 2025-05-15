package com.one;

import javax.swing.JOptionPane;

public class Menu {
    private final String menu = """
            *********************************************
            Sea bienvenido/a a ForexCalc =]
            1) Dólar ==> Peso argentino
            2) Peso argentino ==> Dólar
            3) Dólar ==> Real Brasileño
            4) Real Brasileño ==> Dólar
            5) Dólar ==> Peso colombiano
            6) Peso colombiano ==> Dólar
            7) Convertir otra moneda
            8) Salir
            Elija una opción válida:
            *********************************************
            """;

    private final ConsultaMoneda consulta = new ConsultaMoneda();

    public void mostrarMenu() {
        String opcion;
        double cantidad;

        while (true) {
            opcion = JOptionPane.showInputDialog(menu);

            if (opcion == null || opcion.equals("8")) {
                JOptionPane.showMessageDialog(null, "Saliendo...");
                break;
            }

            try {
                String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad a convertir:");
                cantidad = Double.parseDouble(cantidadStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case "1" -> ConvertirMoneda.convertir("USD", "ARS", consulta, cantidad);
                case "2" -> ConvertirMoneda.convertir("ARS", "USD", consulta, cantidad);
                case "3" -> ConvertirMoneda.convertir("USD", "BRL", consulta, cantidad);
                case "4" -> ConvertirMoneda.convertir("BRL", "USD", consulta, cantidad);
                case "5" -> ConvertirMoneda.convertir("USD", "COP", consulta, cantidad);
                case "6" -> ConvertirMoneda.convertir("COP", "USD", consulta, cantidad);
                case "7" -> {

                    ConvertirMoneda.convertirOtraMoneda(consulta, cantidad);
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida, intenta de nuevo.");
            }
        }
    }
}
