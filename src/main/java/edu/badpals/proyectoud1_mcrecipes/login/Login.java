package edu.badpals.proyectoud1_mcrecipes.login;

import java.io.*;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {

    /*

    hasher() recibe una cadena String, genera un algoritmo de hasheo, y crea una lista de bytes basado en ese algoritmo,
    luego, convierte esos bytes (Que se formaron usando una palabra) a hexadecimal, y nos regresa un string.

     */

    public static String hasher(String password) throws NoSuchAlgorithmException {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("No se encontró el algoritmo de hashing", e);
        }

    }


    /*

    Creador de Properties genera el archivo properties, en este usamos un objeto tipo properties, al cual le añadimos
    una mezcla clave-valor,  donde la clave es el nombre del usuario, y el valor, es un string pasado por el metodo hasher(),
    así que son strings de una comprensión en hexadecimal de una contraseña, cifrados.

     */

    public static void creadorProperties() throws NoSuchAlgorithmException, FileNotFoundException {

        Properties propiedades = new Properties();

        propiedades.setProperty("Administrador", hasher("renaido"));
        propiedades.setProperty("Evan", hasher("abc"));
        propiedades.setProperty("Aman", hasher("1234"));

        try (FileOutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            propiedades.store(output, "Usuarios y contraseñas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*

    validatePass() toma un usuario y una contraseña, además, va al archivo config.properties y lo carga en un objeto tipo properties.
    En ese objeto estan los usuarios y las contraseñas guardados, las contraseñas están hasheadas, asi que cuando recibe la contraseña,
    la guarda hasheada, y luego la compara con el hash de la contraseña ya existente en el usuario que se le pasa como parámetro.

     */

    public static boolean validatePass(String user, String password) {

        Properties properties = new Properties();

        try (FileInputStream propertiesFile = new FileInputStream("src/main/resources/config.properties")) {

            properties.load(propertiesFile);

            if (!properties.containsKey(user)) {
                return false;
            } else {

                String actualPassword = properties.getProperty(user);
                String inputedPassword = hasher(password);

                return actualPassword.equals(inputedPassword);
            }

        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}