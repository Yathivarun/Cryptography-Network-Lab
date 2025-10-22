import java.util.*;

public class DiffieHellman {
    public static void main(String[] args) {
        // Publicly known prime number (p) and primitive root (g)
        int p = 23; // prime number
        int g = 5;  // primitive root modulo p

        // Private keys (chosen secretly)
        int a = 6;  // Alice's private key
        int b = 15; // Bob's private key

        // Calculate public keys
        // A = g^a mod p
        // B = g^b mod p
        int A = (int) Math.pow(g, a) % p;
        int B = (int) Math.pow(g, b) % p;

        System.out.println("Publicly Shared Values:");
        System.out.println("Prime number (p): " + p);
        System.out.println("Primitive root (g): " + g);

        System.out.println("\nAlice's Public Key: " + A);
        System.out.println("Bob's Public Key: " + B);

        // Generate shared secret key
        // Alice computes: s = B^a mod p
        // Bob computes: s = A^b mod p
        int sharedKeyA = (int) Math.pow(B, a) % p;
        int sharedKeyB = (int) Math.pow(A, b) % p;

        System.out.println("\nShared Secret Key computed by Alice: " + sharedKeyA);
        System.out.println("Shared Secret Key computed by Bob: " + sharedKeyB);

        if (sharedKeyA == sharedKeyB) {
            System.out.println("\n Key Exchange Successful! Shared Key = " + sharedKeyA);
        } else {
            System.out.println("\n Key Exchange Failed!");
        }
    }
}
