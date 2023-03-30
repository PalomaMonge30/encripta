/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monge
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Scanner;
public class encriptar2 {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Generamos una clave de cifrado aleatoria
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();

            // Creamos el objeto Cipher con el modo de cifrado DES/ECB/PKCS5Padding
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Definimos el mensaje a cifrar
            // Pedir al usuario que ingrese el texto a encriptar
            System.out.print("Ingrese el texto a encriptar: ");
            String mensaje = scanner.nextLine();
            

            // Ciframos el mensaje
            byte[] mensajeCifrado = cipher.doFinal(mensaje.getBytes());

            // Imprimimos el mensaje cifrado en Base64
            System.out.println("Mensaje cifrado: " + Base64.getEncoder().encodeToString(mensajeCifrado));
            
            

            // Cambiamos el modo del Cipher a modo de descifrado
            System.out.print("Ingrese el texto a desencriptar: ");
            String desencriptar = scanner.nextLine();
            //byte[] ciphertextBytes = Base64.getDecoder().decode(desencriptar);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Desciframos el mensaje
             byte[] mensajeDescifrado = cipher.doFinal(Base64.getDecoder().decode(desencriptar));

            // Imprimimos el mensaje descifrado
            System.out.println("Mensaje descifrado: " + new String(mensajeDescifrado));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
    

}
