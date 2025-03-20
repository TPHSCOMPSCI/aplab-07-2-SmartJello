
import java.awt.Color;


public class Steganography {
    
    /** * Clear the lower (rightmost) two bits in a pixel. */ 
    public static void clearLow( Pixel p ) { 
        /* To be implemented **/ 
        int red = (p.getRed()/4)*4;
        int green = (p.getGreen()/4)*4;
        int blue = (p.getBlue()/4)*4;
        int alpha = (p.getAlpha())*4;

        p.updatePicture(alpha, red, green, blue);
        System.out.println(red + p.getRed());
    } 

    public static Picture testClearLow(Picture pic){
        Picture p = new Picture(pic);
        Pixel[][] pixelArray = p.getPixels2D();
   
        // loop through height rows from top to bottom
        for (int row = 0; row < pixelArray.length; row++){
            for(int col = 0; col < pixelArray[row].length; col++){
                clearLow(pixelArray[row][col]);
            }
        } 
    
        return p;
        
    }

    /** * Set the lower 2 bits in a pixel to the highest 2 bits in c */ 
    public static void setLow (Pixel p, Color c) { 
        /* To bbe implemented */ 
    } 

    public static void main(String[] args) {
        // Picture beach = new Picture ("beach.jpg"); 
        // beach.explore(); 
        // Picture copy = testClearLow(beach); 
        // copy.explore(); 
        System.out.println();
    }
}
