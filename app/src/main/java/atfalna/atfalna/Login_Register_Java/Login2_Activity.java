package atfalna.atfalna.Login_Register_Java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import atfalna.atfalna.GloablV;
import atfalna.atfalna.MainActivity;
import atfalna.atfalna.R;

public class Login2_Activity extends AppCompatActivity {

    EditText Login_email , Login_password ;
    CheckBox chk_remember;

    GloablV gloablV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        gloablV = (GloablV) getApplicationContext();

        SharedPreferences pref = getSharedPreferences("MyPref1",MODE_PRIVATE);
        String email = pref.getString("email",null);
        String password = pref.getString("password",null);
        if (email !=null && password!=null)
        {
            gloablV.setEmail_user(email);
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        chk_remember=findViewById(R.id.chk_remember);

        Login_email=findViewById(R.id.ed_email_log2);
        Login_password=findViewById(R.id.ed_pass_log2);
        Button btn_Login = findViewById(R.id.btn_login2);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login_btn_Login(view);
            }
        });
    }

    ProgressDialog dialog;
    //Login
    public void Login_btn_Login (View v){

        dialog =new ProgressDialog(Login2_Activity.this);
        dialog.show();
        dialog.setMessage(" لحظة");

        final String Log_in_email=Login_email.getText().toString().trim();
        final String Log_in_password=Login_password.getText().toString().trim();

        Response.Listener<String>responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success){
                        Toast.makeText(Login2_Activity.this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();
                        gloablV.setEmail_user(Log_in_email);
                        if (chk_remember.isChecked()) {
                            getSharedPreferences("MyPref1",MODE_PRIVATE)
                                    .edit().putString("email", Log_in_email)
                                    .putString("password", Log_in_password)
                                    .apply();

//                                    OR
//                                        SharedPreferences shrd =  getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//                                        SharedPreferences.Editor editor= shrd.edit();
//                                        editor.putString("email",Log_in_name);
//                                        editor.putString("password",Log_in_password);
//                                        editor.apply();
                        }
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        dialog.dismiss();
                    }else {
                        dialog.dismiss();
                        Toast.makeText(Login2_Activity.this, "البيانات غير صحيحة", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Send_Data_Login send_data =new Send_Data_Login(Log_in_email,Log_in_password,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Login2_Activity.this);
        queue.add(send_data);

    }

    public void btn_go_Register2(View view) {
        startActivity(new Intent(getApplicationContext(),Registration2_Activity.class));
    }

   public void go_main(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
   }
}
