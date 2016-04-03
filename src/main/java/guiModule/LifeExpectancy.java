package guiModule;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samif on 02/03/2016.
 */
public class LifeExpectancy extends PApplet {
    private UnfoldingMap map;
    private Map<String, Float> lifeExpByCountry;
    private List<Feature> countries;
    private List<Marker> countryMarkers;

    public void setup(){
        size(800, 600, OPENGL);

        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);

        lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBank.csv");
        println("Loaded " + lifeExpByCountry.size() + " data entries");

        countries = GeoJSONReader.loadData(this, "countries.geo.json");
        countryMarkers = MapUtils.createSimpleMarkers(countries);

        map.addMarkers(countryMarkers);
        shadeCountries();
    }

    private void shadeCountries() {
        for (Marker marker : countryMarkers){
            String countryId = marker.getId();
            if(lifeExpByCountry.containsKey(countryId)){
                float lifeExp = lifeExpByCountry.get(countryId);
                int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
                marker.setColor(color(255 - colorLevel, 100, colorLevel));
            }else{
                marker.setColor(color(150, 150, 150));
            }
        }
    }

    private Map<String,Float> loadLifeExpectancyFromCSV(String fileName) {

        Map<String, Float> lifeExpDataMap = new HashMap<String, Float>();

        String[] rows = loadStrings(fileName);
        for (String row : rows) {
            String[] columns = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            if(columns.length == 17 && !columns[4].equals("..")){
                float value = Float.parseFloat(columns[4]);
                lifeExpDataMap.put(columns[3], value);
            }
        }

        return lifeExpDataMap;
    }

    public void draw() {
        map.draw();
    }
}
