package connectors.opentsdb;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kamir on 29.06.17.
 */
public class OpenTSDBEvent {

    transient Gson gson = new Gson();

    public String timestamp; // ZEIT
    public String value;  // WERT
    public String metric; // SIGNALNAME  // TEMP


    // SENSOR: SENS_ID
    // CAR: CAR_ID
    public Map<String,String> tags = new HashMap<String,String>();

    public String toJSON() {
        return gson.toJson( this,  OpenTSDBEvent.class );
    }

}
