package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.calculos.Calculo;
import com.aluracursos.conversor.calculos.Relacion;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String opciones = """
                ******************************
                Bienvenido al conversor de monedas
                
                A continuacion elige una opcion 
                1 Dolar a Peso argentino
                2 Peso argentino a Dolar
                3 Dolar a Real brasileño
                4 Real brasileño a Dolar
                5 Dolar a Peso colombiano
                6 Peso colombiano a Dolar
                7 Salir
                *******************************
                """;

            while (true){

                int eleccion;
                System.out.println(opciones);
                eleccion = teclado.nextInt();
                if (eleccion==7){
                    break;
                }else if(eleccion<1||eleccion>7){
                    System.out.println("Ingrese una opcion valida");
                }else{

                    System.out.println("Ingrese la cantidad que desea convertir");

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://v6.exchangerate-api.com/v6/8e5a4c9438f6f15c61a46e93/latest/USD"))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();
                    System.out.println(response.body());

                   // Relacion relacion = new gson.fromJson(json, Relacion.class);

                    Calculo cantidad = new Calculo(1,1, teclado.nextInt());
                }

            }
    }
}
