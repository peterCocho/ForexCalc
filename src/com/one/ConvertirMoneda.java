package com.one;

import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir(String monedaBase, String monedaObjetivo, ConsultaMoneda consulta, Scanner scanner) {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscaMonedabuscaMoneda(monedaBase, monedaObjetivo);
        System.out.println("La taza de conversion para hoy\nl " + monedaBase + " * " + monedas.conversion_rate() + " " + monedaObjetivo);
        System.out.println("Ingrese la cantidad de: " + monedaBase);
        cantidad = Double.parseDouble(scanner.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad + " " + monedaBase + " * " + cantidadConvertida + " " + monedas.target_code());
    }

    public static void convertirOtraMoneda (ConsultaMoneda consulta, Scanner scanner) {
        System.out.println("Ingrese el codigo de la moneda base: ");
        String monedaBase = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el codigo de la moneda objetivo: ");
        String monedaObjetivo = scanner.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, scanner);
    }
}
