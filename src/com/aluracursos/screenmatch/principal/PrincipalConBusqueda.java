package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        /* Para que los atributos en clase TituloOmdb puedan empezar con letra minúscula, y no tengan que empezar como la respusta del servidor los envía (Title, Year, etc.)
        Y para poner formato bonito al JSON cuando lo grabemos/escribamos en un archivo */
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(true){
            System.out.println("Escriba el nombre de la película");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            String direccion = "http://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") +
                    "&apikey=ad587ba3";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //Aquí asignamos a la variable json la respuesta del servidor
                String json = response.body();

                //hacemos el cambio del JSON a clases. Y en TituloOmdb ponemos los atributos (en tipo String)
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                /*Creamos el nuevo objeto de Titulo y le creamos un constructor para que acepte directamente objetos de la clase TituloOmdb,
                PARA QUE en ese constructor le indiquemos que title=name, year=fechaDeLanzamiento, etc.*/
                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMensaje());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizó la ejecución del programa!");
    }
}
