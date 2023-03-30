/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monge
 */
//api seguridad de java
//algoritmo aes
//bloque 
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class desencriptar {
    private static final String ALGORITMO_ENCRIPTACION = "AES";
    private static final int TAMANO_CLAVE = 128;

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la palabra a encriptar: ");
        String palabra = scanner.nextLine();

        // Generar la clave
        SecretKey clave = generarClave();

        // Encriptar el mensaje
        Cipher cifrador = Cipher.getInstance(ALGORITMO_ENCRIPTACION);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] mensajeEncriptado = cifrador.doFinal(palabra.getBytes());

        System.out.println("El mensaje encriptado es: " + Base64.getEncoder().encodeToString(mensajeEncriptado));

        // Desencriptar el mensaje
        System.out.print("Ingrese la cadena de texto encriptada a desencriptar: ");
        String cadenaEncriptada = scanner.nextLine();
        byte[] bytesEncriptados = Base64.getDecoder().decode(cadenaEncriptada);
        
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] mensajeDesencriptado = cifrador.doFinal(bytesEncriptados);

        System.out.println("El mensaje desencriptado es: " + new String(mensajeDesencriptado));
    }

    private static SecretKey generarClave() throws NoSuchAlgorithmException {
        KeyGenerator generadorClave = KeyGenerator.getInstance(ALGORITMO_ENCRIPTACION);
        generadorClave.init(TAMANO_CLAVE);
        return generadorClave.generateKey();
    }
}
