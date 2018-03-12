package atfalna.atfalna.Login_Register_Java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import atfalna.atfalna.R;


public class Registration2_Activity extends AppCompatActivity {

    EditText name , email , password1 , password2 , phone ;
    RadioButton RD_male , RD_female ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        name =(EditText) findViewById(R.id.ed_username_reg2);
        email =(EditText) findViewById(R.id.ed_email_reg2);
        password1 =(EditText) findViewById(R.id.ed_pass1_reg2);
        password2 =(EditText) findViewById(R.id.ed_pass2_reg2);
        phone =(EditText) findViewById(R.id.ed_phone_reg2);

        RD_male=findViewById(R.id.rdo_male);
        RD_female=findViewById(R.id.rdo_female);
    }

    public void btn_go_login2(View view) {
        startActivity(new Intent(getApplicationContext(),Login2_Activity.class));
    }

    //Send_Data_to_Serveries
    public void btn_Reg(View view) {

        String Ename = name.getText().toString();
        String Email = email.getText().toString().trim();
        String Pass = password1.getText().toString().trim();
        String Pass2 = password2.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Gender ;
        if (RD_male.isChecked()){
              Gender="ذكر";
        }else Gender="أنثي";

        if (!Pass.equals(Pass2)) {
            Toast.makeText(Registration2_Activity.this, "اكتب الرقم السري بشكل صحيح", Toast.LENGTH_LONG).show();
        }else{
            Response.Listener<String> responseLisener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            Toast.makeText( Registration2_Activity.this , "تم التسجيل بنجاح,أذهب و سجل دخول", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText( Registration2_Activity.this , "يوجد خطأ ( تاكد من البريد او التليفون )", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            Send_Data_Registration send_Data = new Send_Data_Registration(Ename, Email, Pass ,Gender, Phone, responseLisener);
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(send_Data);
        }
    }


    public void back_finish(View view) {
        finish();
    }
}
