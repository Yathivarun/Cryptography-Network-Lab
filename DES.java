import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.util.Scanner;
import java.util.Arrays;

public class DES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter plain text: ");
        String msg = sc.nextLine();

        System.out.print("Enter 8-character key: ");
        String key = sc.nextLine();

        // Convert key to byte[]
        byte[] keyData = key.getBytes();
        DESKeySpec desKeySpec = new DESKeySpec(keyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        // Create cipher instance for DES
        Cipher cipher = Cipher.getInstance("DES");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(msg.getBytes());

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        //Output formats
        System.out.println("\n------ OUTPUT ------");
        System.out.println("Original Message: " + msg);
        System.out.println("Encrypted (byte array): " + Arrays.toString(encrypted));
        System.out.println("Encrypted (Hex): " + bytesToHex(encrypted));
        System.out.println("Encrypted (Base64): " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted: " + decryptedMsg);
    }

    //Helper: Convert byte[] → Hex String
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
