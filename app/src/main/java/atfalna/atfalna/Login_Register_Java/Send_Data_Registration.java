package atfalna.atfalna.Login_Register_Java;

/**
 * Created by amr1 on 2/21/2018.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Send_Data_Registration extends StringRequest {

    private static final String SEND_DATA_URL = "http://192.168.1.5/app_atfalna/register_db_atf.php"; // "http://localhost/app_atf/register_db_atf.php"
    private Map<String, String> MapData;

    public Send_Data_Registration(String name, String email, String password,String gender, String phone, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();
        MapData.put("ename", name);
        MapData.put("email", email);
        MapData.put("epassword", password);
        MapData.put("egender", gender);
        MapData.put("ephone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}