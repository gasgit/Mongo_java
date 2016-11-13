package ie.gasgit;

/**
 * Created by glen on 13/11/16.
 */
public class Location {

    private String lat;
    private String lng;
    private String id;

    public Location(String lat, String lng, String id) {
        this.lat = lat;
        this.lng = lng;
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
