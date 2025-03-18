import java.awt.Color;

public class Steganography {
    
    /** * Clear the lower (rightmost) two bits in a pixel. */ 
    public static void clearLow( Pixel p ) { 
        /* To be implemented **/ 
        int red = p.getRed()/4;
        int green = p.getGreen()/4;
        int blue = p.getBlue()/4;
        int alpha = p.getAlpha();

        p.updatePicture(alpha,red, green, blue);
    } 
}
