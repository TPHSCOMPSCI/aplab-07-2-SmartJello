
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
        clearLow(p);
        int red = (p.getRed()+(c.getRed()/64));
        int green = (p.getGreen() + c.getGreen()/64);
        int blue = (p.getBlue())+(c.getBlue()/64);

        p.setColor(new Color(red, green, blue));
    } 

    public static Picture testSetLow(Picture pic, Color c){
        Picture p = new Picture(pic);
        Pixel[][] pixelArray = p.getPixels2D();
   
        // loop through height rows from top to bottom
        for (int row = 0; row < pixelArray.length; row++){
            for(int col = 0; col < pixelArray[row].length; col++){
                setLow(pixelArray[row][col], c);
            }
        } 
    
        return p;
        
    }

    public static void main(String[] args) {
        Picture beach = new Picture ("beach.jpg"); 
        beach.explore(); 
        Picture copy = testClearLow(beach); 
        copy.explore();

        Picture beach2 = new Picture ("beach.jpg"); 
        beach2.explore(); 
        Picture copy2 = testSetLow(beach2, Color.PINK); 
        copy2.explore(); 


        Picture copy3 = revealPicture(copy2); 
        copy3.explore(); 

    }

    /** o * Sets the highest two bits of each pixel’s colors * to the lowest two bits of each pixel’s color s */ 
    public static Picture revealPicture(Picture hidden){ 
        Picture copy = new Picture(hidden) ; 
        Pixel[][] pixels = copy.getPixels2D(); 
        Pixel[][] source = hidden.getPixels2D(); 
        for (int r = 0; r < pixels.length; r++){ 
            for (int c = 0; c < pixels[0].length; c++ ) { 
                Color col = source[r][c].getColor(); 
                int red = (col.getRed()/64)*(col.getRed()%4);
                int green = (col.getGreen()/4)*(col.getGreen()%4);
                int blue = (col.getBlue()/4)*(col.getBlue()%4);

                pixels[r][c].setColor(new Color(red, green, blue));
            }
        } 
        return copy;  
    }

    /** * Determines whether secret can be hidden in source, 
     * wh hich is * true if source and secret are the same dimensions(pixels x pixels). * 
     * @param source is not null 
     * * @param secret is not nul ll * 
     * @return true if secret can be hidden in source, false e otherwise. */
     public static boolean canHide(Picture source, Picture secret) {
        
     }

    /** * Creates a new Picture with data from secret hidden in n data from source * 
     * @param source is not null * 
     * @param se ecret is not null *
     *  @return combined Picture with secret h hidden in source * 
     * precondition: source is same width and height as secret */ 
    public static Picture hidePicture(Picture source, Picture secret) {

    }
}
