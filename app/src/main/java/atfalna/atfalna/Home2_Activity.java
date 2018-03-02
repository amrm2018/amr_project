package atfalna.atfalna;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import atfalna.atfalna.Create_Post_Java.Create_Post_Found_Activity;
import atfalna.atfalna.Login_Register_Java.Login2_Activity;

public class Home2_Activity extends AppCompatActivity {

    TextView textView_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        textView_id=findViewById(R.id.tv_show_id);

    }

    public void relative_go_create_post(View view) {
        startActivity(new Intent(getApplicationContext(),Create_Post_Found_Activity.class));
    }

    public void btn_Logout(View view) {
        getSharedPreferences("MyPref1",MODE_PRIVATE).edit().clear().commit();
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));

    }

}
