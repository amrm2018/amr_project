package atfalna.atfalna;

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
