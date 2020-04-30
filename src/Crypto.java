import java.util.Scanner;
import java.util.stream.IntStream;

public class Crypto {
    public static void main(String [] args){

        //Input used for upcomming methods
        Scanner input = new Scanner(System.in);
        System.out.print("Write text: ");
        String text = input.nextLine();

        //Result of normalised text
        System.out.println(normalizeText(text));
        String basetxt = (normalizeText(text));

        //Obscure text
        System.out.println(obify(basetxt));
        String obtxt = (obify(basetxt));

        //Get keysize
        System.out.print("Enter Keysize: ");
        int key = input.nextInt();

        //Encrypt obscured text
        String cetxt = (caeserify(obtxt, key));
        System.out.println(cetxt);
    }

    public static String normalizeText(String tempin){
        // String temp = "";
        String tempout = tempin.replaceAll("\\W","").toUpperCase();
        return tempout;
    }

    public static String obify(String tempin){
        // String txta = cleartxt.replaceAll("A","OBA").replaceAll("E","OBE").replaceAll("I","OBI").replaceAll("O","OBO").replaceAll("U","OBU").replaceAll("Y","OBY");
        String txto = tempin.replaceAll("O","OBO");
        String txte = txto.replaceAll("E","OBE");
        String txti = txte.replaceAll("I","OBI");
        String txta = txti.replaceAll("A","OBA");
        String txtu = txta.replaceAll("U","OBU");
        String tempout = txtu.replaceAll("Y","OBY");
        return  tempout;
    }

    public static String caeserify(String tempin, Integer keyin){
        if(keyin>26){
            keyin = keyin%26;
        }
        else if(keyin<0){
            keyin = (keyin%26)+26;
        }
        String cleartext = "";
        int length = tempin.length();
        for(int i = 0; i<length; i++){
            char ch = tempin.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isLowerCase(ch)){
                    char c = (char)(ch+keyin);
                    if(c>'z'){
                        cleartext += (char)(ch - (26-keyin));
                    }
                    else{
                        cleartext += c;
                    }
                }
                else if(Character.isUpperCase(ch)){
                    char c = (char)(ch+keyin);
                    if(c>'Z'){
                    cleartext += (char)(ch - (26-keyin));
                    }
                    else{
                    cleartext += c;
                    }
                }
            }
            else{
                cleartext += ch;
            }
        }
        return cleartext;
    }


}



