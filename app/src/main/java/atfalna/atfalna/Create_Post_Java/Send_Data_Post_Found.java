package atfalna.atfalna.Create_Post_Java;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amr1 on 2/28/2018.
 */

public class Send_Data_Post_Found extends StringRequest {

    private static final String SEND_DATA_URL = "http://192.168.1.3/app_atfalna/test_create_post_found.php"; // "http://localhost/app_atf/register_db_atf.php"
    private Map<String, String> MapData;

    public Send_Data_Post_Found(String simg,String scity, String sday, String smonth, String syear,
                                String sgender, String sphone ,
                                String splace, String sinfo, String semail_us, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("iimg", simg);
        MapData.put("ccity", scity);
        MapData.put("dday", sday);
        MapData.put("mmonth", smonth);
        MapData.put("yyear", syear);
        MapData.put("ggender", sgender);
        MapData.put("pphone", sphone);
        MapData.put("pplace", splace);
        MapData.put("iinfo", sinfo);
        MapData.put("eemail", semail_us);

    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}