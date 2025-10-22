import java.util.*;

public class Hill {

    // Function to calculate determinant (mod 26)
    static int determinant(int[][] m) {
        int det = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) % 26;
        if (det < 0) det += 26;
        return det;
    }

    // Function to calculate modular inverse of determinant (mod 26)
    static int modInverse(int det) {
        for (int i = 1; i < 26; i++) {
            if ((det * i) % 26 == 1) return i;
        }
        return -1; // not invertible
    }

    // Function to compute adjoint of 2x2 matrix
    static int[][] adjoint(int[][] m) {
        int[][] adj = new int[2][2];
        adj[0][0] = m[1][1];
        adj[1][1] = m[0][0];
        adj[0][1] = -m[0][1];
        adj[1][0] = -m[1][0];

        // Fix negatives mod 26
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                adj[i][j] = (adj[i][j] % 26 + 26) % 26;
            }
        }
        return adj;
    }

    // Multiply 2x2 matrix with 2x1 vector
    static int[] multiply(int[][] m, int[] v) {
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = (m[i][0] * v[0] + m[i][1] * v[1]) % 26;
            if (result[i] < 0) result[i] += 26;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 2x2 key matrix
        int[][] key = new int[2][2];
        System.out.println("Enter 2x2 key matrix (must be invertible mod 26):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                key[i][j] = sc.nextInt();
            }
        }

        sc.nextLine(); // consume leftover newline

        // Input plaintext
        System.out.print("Enter plaintext (2 letters, lowercase): ");
        String word = sc.nextLine().toLowerCase();

        if (word.length() != 2) {
            System.out.println("Plaintext must be exactly 2 characters");
            sc.close();
            return;
        }

        // Convert plaintext to vector
        int[] textVec = new int[2];
        for (int i = 0; i < 2; i++) {
            textVec[i] = word.charAt(i) - 'a';
        }

        // Encrypt
        int[] encryptedVec = multiply(key, textVec);
        StringBuilder encrypted = new StringBuilder();
        for (int val : encryptedVec) {
            encrypted.append((char) (val + 'a'));
        }
        System.out.println("Encrypted text: " + encrypted);

        // Compute determinant and modular inverse
        int det = determinant(key);
        int invdet = modInverse(det);
        if (invdet == -1) {
            System.out.println("Key is not invertible. Decryption not possible.");
            sc.close();
            return;
        }

        // Compute inverse key
        int[][] adj = adjoint(key);
        int[][] invkey = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int val = adj[i][j] * invdet;
                val %= 26;
                if (val < 0) val += 26;
                invkey[i][j] = val;
            }
        }

        // Decrypt
        int[] decryptedVec = multiply(invkey, encryptedVec);
        StringBuilder decrypted = new StringBuilder();
        for (int val : decryptedVec) {
            decrypted.append((char) (val + 'a'));
        }
        System.out.println("Decrypted text: " + decrypted);

        sc.close();
    }
}
This too make sure it's not too large
