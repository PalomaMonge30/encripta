/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monge
 */
import java.security.SecureRandom;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Scanner;
import java.util.Base64;

public class encriptacion {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Obtener la clave secreta DES
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey desKey = keyGen.generateKey();

        // Obtener el cifrador DES en modo CBC con relleno PKCS5Padding
        Cipher desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        // Generar un vector de inicialización aleatorio
        byte[] iv = new byte[8];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        // Mostrar el vector de inicialización
        System.out.println("Vector de inicialización: " + Base64.getEncoder().encodeToString(iv));

        // Pedir al usuario que ingrese el texto a encriptar
        System.out.print("Ingrese el texto a encriptar: ");
        String escanear = scanner.nextLine();

        // Encriptar el texto
        desCipher.init(Cipher.ENCRYPT_MODE, desKey, new IvParameterSpec(iv));
        byte[] ciphertext = desCipher.doFinal(escanear.getBytes());

        // Mostrar el texto encriptado
        System.out.println("Texto encriptado: " + Base64.getEncoder().encodeToString(ciphertext));

        // Pedir al usuario que ingrese el texto a desencriptar
        System.out.print("Ingrese el texto a desencriptar: ");
        String desencriptar = scanner.nextLine();
        byte[] ciphertextBytes = Base64.getDecoder().decode(desencriptar);

        // Desencriptar el texto
        desCipher.init(Cipher.DECRYPT_MODE, desKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = desCipher.doFinal(ciphertextBytes);
        String desencriptarTexto = new String(decryptedBytes);

        // Mostrar el texto desencriptado
        System.out.println("Texto desencriptado: " + desencriptarTexto);
    }
    
    
}
