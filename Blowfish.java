import java.util.*;
import java.security.GeneralSecurityException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Blowfish{

	public static void main(String args[]) throws GeneralSecurityException{
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter msg to encrypt: ");
		String msg = sc.nextLine();
		byte[] message = msg.getBytes();
		
		System.out.print("Enter Custom Key: ");
		String key = sc.nextLine();
		byte[] KeyData = key.getBytes();

        SecretKeySpec secretkey = new SecretKeySpec(KeyData,"BlowFish");

        Cipher cipher = Cipher.getInstance("BlowFish");
        cipher.init(Cipher.ENCRYPT_MODE,secretkey);
        byte[] encrypted = cipher.doFinal(message);

        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        System.out.println("Message: " + msg);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decryptedMsg);
		
	}

}
