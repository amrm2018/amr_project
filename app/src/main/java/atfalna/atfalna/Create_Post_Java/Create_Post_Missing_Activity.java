package atfalna.atfalna.Create_Post_Java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import atfalna.atfalna.R;

public class Create_Post_Missing_Activity extends AppCompatActivity {

    ImageView img_m;

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

    }

    public void back_finish(View view) {
        finish();
    }
}
