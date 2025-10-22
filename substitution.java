import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
    
        char[] sub1 = { 
    'A','B','C','D','E','F','G','H','I','J','K','L','M',
    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
};
        
        char[] sub2 = { 
    '!','@','%','^','&','+','-','=','?','>','<','x','r',
    's','f','v','1','6','9','7','8','0','2','3','4','m' 
};

    Scanner s = new Scanner(System.in); 
    System.out.println("Enter ptext: ");

    String ptext = s.nextLine();
    String upper_ptext = ptext.toUpperCase();
    
    StringBuilder ctext = new StringBuilder("");
    for (int i = 0; i<ptext.length(); i++){
        int ind = upper_ptext.charAt(i) - 'A';
        ctext.append(sub2[ind]);   
    }
    
    System.out.println("Ciphered text: " + ctext);
    
    StringBuilder dtext = new StringBuilder("");
    for (int j = 0; j<ptext.length(); j++){
        char target = ctext.charAt(j);
        int ind = -1;

        for (int i = 0; i < sub2.length; i++) {
            if (sub2[i] == target) {
                ind = i;
                break;
            }
        }
        dtext.append(sub1[ind]);   
    }
    
    System.out.println("De-Ciphered text: " + dtext);

    }
}
