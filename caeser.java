import java.util.Scanner; 

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in); 
    System.out.println("Enter ptext");

    String ptext = s.nextLine();
    int key = 5;
    StringBuilder ctext = new StringBuilder("");
    for (int i = 0; i<ptext.length(); i++){
        int ascii = (int) ptext.charAt(i) + key;
        char x = (char) ascii;
        ctext.append(x);   
    }
    System.out.println("cyper text:  "+ctext);
    
    StringBuilder dtext = new StringBuilder("");
    for (int i = 0; i<ptext.length(); i++){
        int ascii = (int) ctext.charAt(i) - key;
        char x = (char) ascii;
        dtext.append(x);   
    }
    System.out.println("Decyper text:  "+dtext);
  }
}

