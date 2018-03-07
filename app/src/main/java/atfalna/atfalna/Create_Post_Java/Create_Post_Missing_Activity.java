package atfalna.atfalna.Create_Post_Java;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

import atfalna.atfalna.GloablV;
import atfalna.atfalna.R;

public class Create_Post_Missing_Activity extends AppCompatActivity {

    ImageView img_m;
    String encodeimg_m;

    EditText ed_day_m , ed_year_m , ed_address_m ,ed_age_now_m ,
             ed_case_name_m , ed_nick_name_m, ed_phone_m ,
             ed_note_m , ed_bouns_m ;

    Spinner sp_month_m , sp_city_m ,
            sp_color_eye_m ,sp_color_hair_m, sp_color_body_m,
            sp_length_m , sp_wiegth_m;

    RadioButton rdo_male_m , rdo_female_m ;

    String S_month_m ,S_city_m,
            S_color_eye_m ,S_color_hair_m,S_color_body_m ,
            S_length_m ,S_wiegth_m;

    GloablV  gloablV;
    String   S_email_us ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post_missing);

        img_m = findViewById(R.id.img_post_missing);

        ed_day_m = findViewById(R.id.ed_day_m);
        ed_year_m = findViewById(R.id.ed_year_m);
        ed_address_m = findViewById(R.id.ed_address_m);
        ed_age_now_m = findViewById(R.id.ed_age_new_m);
        ed_case_name_m = findViewById(R.id.ed_case_name_m);
        ed_nick_name_m = findViewById(R.id.ed_nickname_m);
        ed_phone_m = findViewById(R.id.ed_phone_m);
        ed_note_m = findViewById(R.id.ed_notes_m);
        ed_bouns_m = findViewById(R.id.ed_bouns_m);

        sp_month_m=findViewById(R.id.sp_month_m);
        sp_city_m=findViewById(R.id.sp_city_m);
        sp_color_eye_m=findViewById(R.id.sp_color_eye_m);
        sp_color_hair_m=findViewById(R.id.sp_color_hair_m);
        sp_color_body_m=findViewById(R.id.sp_color_body_m);
        sp_length_m=findViewById(R.id.sp_hength_m);
        sp_wiegth_m=findViewById(R.id.sp_wiegth_m);

        rdo_male_m=findViewById(R.id.rdo_male_m);
        rdo_female_m=findViewById(R.id.rdo_female_m);

        sp_month_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_month_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_month

        sp_city_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_city_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_city_m

        sp_color_eye_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_color_eye_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_color_eye_m

        sp_color_hair_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_color_hair_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_color_hair_m

        sp_color_body_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_color_body_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_color_body_m

        sp_length_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_length_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_length_m

        sp_wiegth_m.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectspinnerMonth =adapterView.getItemAtPosition(i).toString();
                S_wiegth_m = selectspinnerMonth;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });//--------sp_wiegth_m


        gloablV = (GloablV)getApplicationContext();
        S_email_us = gloablV.getEmail_user();

    }

    ProgressDialog pdialog ;

    public void btn_create_post_m (View view){

        pdialog=new ProgressDialog(this);
        pdialog.show();
        pdialog.setMessage("لحظة");

        // image_m
        Bitmap Bimg_m=((BitmapDrawable)img_m.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Bimg_m.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream);
        encodeimg_m= Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
        // encodeimg_m  هو دا المتغير اللي شايل الصورة

        String S_gender_m;
        if (rdo_male_m.isChecked()){
            S_gender_m="ذكر";
        }else {
            S_gender_m="أنثى";
        }
        String S_phone_m = ed_phone_m.getText().toString().trim();
        String S_day_m = ed_day_m.getText().toString().trim();
        String S_year_m = ed_year_m.getText().toString().trim();

        String S_address_m = ed_address_m.getText().toString().trim();

        String S_bouns_m = ed_bouns_m.getText().toString().trim();


        String S_case_name_m = ed_case_name_m.getText().toString().trim();
        String S_nickname_m = ed_nick_name_m.getText().toString().trim();
        String S_age_now_m = ed_age_now_m.getText().toString().trim();

        String S_note_m = ed_note_m.getText().toString().trim();

        Response.Listener<String> responseLisener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Toast.makeText( getApplicationContext() , "تم نشر الحالة .. ِشكرا لك", Toast.LENGTH_SHORT).show();
                        pdialog.dismiss();
                    } else {
                        Toast.makeText( getApplicationContext() , "يوجد خطأ ( تاكد من البيانات المدخلة)", Toast.LENGTH_SHORT).show();
                        pdialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Send_Data_Post_Missing send_Data_missing = new Send_Data_Post_Missing(
                S_city_m, S_gender_m,S_phone_m,
                S_day_m, S_month_m ,S_year_m,
                S_color_eye_m, S_color_hair_m, S_color_body_m,
                S_address_m,
                S_bouns_m,S_length_m,S_wiegth_m,
                S_case_name_m,S_nickname_m,S_age_now_m,
                S_note_m , encodeimg_m, S_email_us, responseLisener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(send_Data_missing);

    }


    public  void btn_pick_photo_m (View view){
        Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode , Intent data){
        super.onActivityResult(requestCode,resultCode ,data);
        if (requestCode==100 && resultCode==RESULT_OK){
            Uri uri=data.getData();
            img_m.setImageURI(uri); //  هتحوط الصورة فين
        }
    }

    public void back_finish(View view) {
        finish();
    }
}
