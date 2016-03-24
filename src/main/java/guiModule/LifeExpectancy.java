package guiModule;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Created by samif on 02/03/2016.
 */
public class LifeExpectancy extends PApplet {
    UnfoldingMap map;

    public void setup(){
        size(800, 600, OPENGL);

        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
    }

    public void draw(){
        map.draw();
    }
}
