package atfalna.atfalna.Login_Register_Java;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by amr1 on 2/21/2018.
 */

class Send_Data_Login extends StringRequest  {



    private static final String SEND_DATA_URL = "http://192.168.1.3/login_db_atf.php";
    private Map<String,String> MapData;

    public Send_Data_Login(String Login_name, String Login_password, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();
        MapData.put("Login_email", Login_name);
        MapData.put("Login_password", Login_password);
    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}
