package atfalna.atfalna.Show_All_Post_Found;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import atfalna.atfalna.R;

public class Post_Found_Activity extends AppCompatActivity {

    TextView tv_code_p, tv_email_user, tv_datetime, tv_city,
            tv_day, tv_month, tv_year,
            tv_gender, tv_phone,tv_place, tv_info ;
    ImageView img_p_f ;

    RelativeLayout rel_comm_p_f ;

    ListView list_comm_p_f;

    EditText ed_comm_p_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_found);

        tv_code_p=findViewById(R.id.code_p);
        tv_email_user=findViewById(R.id.tv_email_f);
        tv_datetime=findViewById(R.id.tv_date_f);
        tv_city=findViewById(R.id.tv_city_f);
        tv_day=findViewById(R.id.tv_day_f);
        tv_month=findViewById(R.id.tv_month_f);
        tv_year=findViewById(R.id.tv_year_f);
        tv_gender=findViewById(R.id.tv_gender_f);
        tv_phone=findViewById(R.id.tv_phone_f);
        tv_place=findViewById(R.id.tv_place_f);
        tv_info=findViewById(R.id.tv_info_f);

        img_p_f = findViewById(R.id.img_p_f);

        Intent data_p_f = getIntent();

        tv_code_p.setText(data_p_f.getExtras().getString("text_code_p_f").trim());
      //  tv_email_user.setText(data_p_f.getExtras().getString("text_email").trim());
        tv_datetime.setText(data_p_f.getExtras().getString("text_date_p_f").trim());
//        tv_city.setText(data_p_f.getExtras().getString("text_city_f").trim());
//        tv_day.setText(data_p_f.getExtras().getString("text_day_f").trim());
//        tv_month.setText(data_p_f.getExtras().getString("text_month_f").trim());
//        tv_year.setText(data_p_f.getExtras().getString("text_year_f").trim());
//        tv_gender.setText(data_p_f.getExtras().getString("text_gender").trim());
//        tv_phone.setText(data_p_f.getExtras().getString("text_phone").trim());
//        tv_place.setText(data_p_f.getExtras().getString("text_place"));
//        tv_info.setText(data_p_f.getExtras().getString("text_info").trim());
//
        String simg = data_p_f.getExtras().getString("text_img_f");
//        Uri uri =Uri.parse(img);
//        img_p.setImageURI(uri);

        Picasso.with(getApplicationContext())
                .load("http://192.168.43.104/atfalna_app/img_found/"+simg)
                .into(img_p_f);

        // Comment_p_f
        rel_comm_p_f =findViewById(R.id.rel_comment_p_f);

        //List
        list_comm_p_f = findViewById(R.id.listview_show_all_comment_p_f);

        ed_comm_p_f =findViewById(R.id.ed_comment_p_f);
        ed_comm_p_f.setSelected(false);

    }
    public  void btn_exit_comment_p_f (View view){
        rel_comm_p_f.setVisibility(View.INVISIBLE);
        list_comm_p_f.setVisibility(View.VISIBLE);
    }

    public  void btn_show_rel_comment_p_f (View view){
        rel_comm_p_f.setVisibility(View.VISIBLE);
        list_comm_p_f.setVisibility(View.INVISIBLE);
    }


}
