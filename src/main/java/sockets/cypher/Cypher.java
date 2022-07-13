package sockets.cypher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Cypher {
    String key = "LlavePrueva";
    //clave
    public SecretKeySpec GenerateKey(String key){

        try{
            byte [] string = key.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            string = md.digest(string);
            string = Arrays.copyOf(string, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(string, "AES");
            return secretKeySpec;


        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    //encriptar
    public String Encrypt(String encrypt){
        try{
            SecretKeySpec secretKeySpec = GenerateKey(key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec );

            byte [] string = encrypt.getBytes("UTF-8");
            byte [] encryptData= cipher.doFinal(string);
            String stringCrypt = Base64.getEncoder().encodeToString(encryptData);
            return stringCrypt;


        }catch (Exception e){
            throw new RuntimeException();

        }


    }
    //Desenriptar
    public String Decrypt(String decrypt){
        try{
            SecretKeySpec secretKeySpec = GenerateKey(key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte [] string = Base64.getDecoder().decode(decrypt);
            byte [] decryptData= cipher.doFinal(string);
            String stringDecrypt = new String(decryptData);
            return stringDecrypt;


        }catch (Exception e){
            throw new RuntimeException();

        }

    }



}
