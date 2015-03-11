/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.File;
import java.io.IOException;
import sun.misc.BASE64Decoder;

/**
 *
 * @author moh.afifun
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = "halo".getBytes();
        System.out.println(b);
        String input = "";
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            input = input + c;
            
        }
        System.out.println(input);
        System.out.println(convertHexToString(input));
    }
    public static String convertHexToString(String hex){
 
	  StringBuilder sb = new StringBuilder();
	  StringBuilder temp = new StringBuilder();
 
	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<hex.length()-1; i+=2 ){
 
	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);
 
	      temp.append(decimal);
	  }
	  System.out.println("Decimal : " + temp.toString());
 
	  return sb.toString();
  }
    public static String convertStringToHex(String str){
 
	  char[] chars = str.toCharArray();
 
	  StringBuffer hex = new StringBuffer();
	  for(int i = 0; i < chars.length; i++){
	    hex.append(Integer.toHexString((int)chars[i]));
	  }
 
	  return hex.toString();
  }
    
}
