package guiModule;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by samif on 29/02/2016.
 */
public class MyApplet extends PApplet {
    PImage backImage;

    public void setup(){
        size(400, 400);
        background(180);
        stroke(0);
        backImage = loadImage("C:\\Users\\samif\\Pictures\\Salome.jpg", "jpg");
        backImage.resize(0, height);
        image(backImage, 0, 0);
    }

    public void draw(){
        //Add drawing code for MyApplet
        int[] color = sunColor(second()); //Calculate color code
        fill(color[0], color[1], color[2]); //Set sun color
        ellipse(width / 4, height / 5, width / 4, height / 4); // draw sun
    }

    public int[] sunColor(float seconds){
        int [] rgb = new int[3];
        float diffFrom30 = Math.abs(30 - seconds);

        float ratio = diffFrom30 / 30;

        rgb[0] = (int)(255 * ratio);
        rgb[1] = (int)(255 * ratio);
        rgb[2] = 0;

        return rgb;
    }
}
