package atfalna.atfalna.Create_Post_Java;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amr1 on 3/7/2018.
 */

public class Send_Data_Post_Missing extends StringRequest {

    private static final String SEND_DATA_URL = "http://192.168.1.103/app_atfalna/post_missing.php"; // "http://localhost/app_atf/register_db_atf.php"
    private Map<String, String> MapData;

    public Send_Data_Post_Missing(String scity, String sgender, String sphone,
                                  String sday, String smonth, String syear,
                                  String scolor_eye, String scolor_hair, String scolor_body,
                                  String saddress,
                                  String sbouns, String slength, String swiegth,
                                  String scase_name, String snickname, String sage_now,
                                  String snote_m, String simg_m, String semail,

                                  Response.Listener<String> listener) {

        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("city_m", scity);
        MapData.put("gender_m", sgender);
        MapData.put("phone_m", sphone);

        MapData.put("day_m", sday);
        MapData.put("month_m", smonth);
        MapData.put("year_m", syear);

        MapData.put("color_eye_m", scolor_eye);
        MapData.put("color_hair_m", scolor_hair);
        MapData.put("color_body_m", scolor_body);

       // MapData.put("birth_date_m", sbirth_date);
        MapData.put("address_m", saddress);

        MapData.put("bouns_m", sbouns);
        MapData.put("length_m", slength);
        MapData.put("wiegth_m", swiegth);

        MapData.put("casename_m", scase_name);
        MapData.put("nickname_m", snickname);
        MapData.put("age_now_m", sage_now);

        MapData.put("note_m", snote_m);
        MapData.put("img_m", simg_m);
        MapData.put("eemail", semail);

    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}