package guiModule;

import processing.core.PApplet;

/**
 * Created by samif on 29/02/2016.
 */
public class MyDisplay extends PApplet {

    public void setup(){
        size(600, 600);
        background(255, 209, 0);
    }
    public void draw(){
        fill(234, 54, 67);
        ellipse(300, 300, 390, 390);
        fill(0, 0, 0);
        ellipse(220, 230, 50, 70);
        ellipse(380, 230, 50, 70);

        arc(300, 480, 65, 75, 0, PI);

        noFill();
        arc(300, 380, 75, 75, 0, PI);
    }
}
