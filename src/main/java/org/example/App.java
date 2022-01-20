package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        String file = "C:\\Users\\adrian.mosquera\\Desktop\\Proyectos Intelly\\Formacion\\Streams\\empleados.txt";

        List<Persona> listapersona = new ArrayList<>();
        String cadena;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((cadena = br.readLine()) != null) {

                String[] partes = cadena.split(":");
                Persona persona = new Persona();

                if (partes.length >= 3) {
                    persona.setNombre(Optional.ofNullable(String.valueOf(partes[0])));
                    persona.setPoblacion(Optional.ofNullable(String.valueOf(partes[1])));
                    persona.setEdad(Optional.of(Integer.parseInt(partes[2])));
                } else {
                    persona.setNombre(Optional.ofNullable(String.valueOf(partes[0])));
                    persona.setPoblacion(Optional.ofNullable(String.valueOf(partes[1])));
                    persona.setEdad(Optional.of(0));
                }

                listapersona.add(persona);
            }

            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pintarLista(listapersona);

    }

    public static Boolean pintarLista (List<Persona> listPersona){

        AtomicInteger contador = new AtomicInteger(1);

        listPersona.stream()
                .filter(x -> x.getEdad().isPresent())
                .filter(x -> x.getEdad().get() < 25)
                .forEach(x -> System.out.println(
                        "Linea " + contador.getAndIncrement() +
                        ". Nombre: " + x.getNombre().orElse("Desconocido") +
                        ". Población: " + x.getPoblacion().orElse("Desconocido") +
                        ". Edad: " + x.getEdad().orElse(null)));
        return true;
    }
}