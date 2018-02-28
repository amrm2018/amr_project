package atfalna.atfalna.Create_Post_Java;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import atfalna.atfalna.Create_Post_Java.Send_Data_Post_Found;
import atfalna.atfalna.GloablV;
import atfalna.atfalna.Login_Register_Java.Registration2_Activity;
import atfalna.atfalna.Login_Register_Java.Send_Data_Registration;
import atfalna.atfalna.R;

public class Create_Post_Found_Activity extends AppCompatActivity {


    EditText ED_day,ED_year,ED_phone,ED_place_the_case , ED_info_the_case ;
    Spinner SP_month ,SP_city;
    RadioButton RD_male , RD_female ;
    TextView TV_show_month , TV_show_City ,TV_show_email_user;

    GloablV gloablV;

    ImageView imgV ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post_found);

        imgV=findViewById(R.id.img_post_found);

        ED_day=findViewById(R.id.ed_day);
        ED_year=findViewById(R.id.ed_year);
        ED_phone=findViewById(R.id.ed_phone);
        ED_place_the_case=findViewById(R.id.ed_place_the_case);
        ED_info_the_case=findViewById(R.id.ed_info_the_case);

        RD_male=findViewById(R.id.rdo_male);
        RD_female=findViewById(R.id.rdo_female);

        SP_month=findViewById(R.id.spinner_month);
        SP_city=findViewById(R.id.sp_city);
        TV_show_month=findViewById(R.id.tv_show_spinner_month);
        TV_show_City=findViewById(R.id.tv_show_spinner_city);

        SP_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                TV_show_month.setText(selectspinnerMonth);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });//--------SP_month

        SP_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectspinnerCity =adapterView.getItemAtPosition(i).toString();
                TV_show_City.setText(selectspinnerCity);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });//----------SP_city


        gloablV = (GloablV)getApplicationContext();
        TV_show_email_user=findViewById(R.id.tv_show_email_user);
        TV_show_email_user.setText(gloablV.getEmail_user());

    }
    public void back_finish(View view) {
        finish();
    }

    public void btn_create_post_found(View view) {

        String City = TV_show_City.getText().toString();
        String Day = ED_day.getText().toString().trim();
        String Month = TV_show_month.getText().toString();
        String Year = ED_year.getText().toString().trim();
        String Gender_thecase;
        if (RD_male.isChecked()){
            Gender_thecase="ذكر";
        }else
            Gender_thecase="أنثى";
        String Phone = ED_phone.getText().toString().trim();
        String Place = ED_place_the_case.getText().toString();
        String Info = ED_info_the_case.getText().toString();
        String Email_Us = TV_show_email_user.getText().toString().trim();

        Response.Listener<String> responseLisener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Toast.makeText( getApplicationContext() , "تم نشر الحالة ِشكرا لك", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText( getApplicationContext() , "يوجد خطأ ( تاكد من البيانات المدخلة)", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Send_Data_Post_Found send_Data_found = new Send_Data_Post_Found(City, Day, Month ,Year,Gender_thecase,Phone,Place,Info, Email_Us,responseLisener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(send_Data_found);
    }


    public  void btn_pick_photo (View view){
        Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode , Intent data){
        super.onActivityResult(requestCode,resultCode ,data);
        if (requestCode==100 && resultCode==RESULT_OK){
            Uri uri=data.getData();
            imgV.setImageURI(uri); //  هتحوط الصورة فين
        }
    }
}