package atfalna.atfalna.Show_All_Post_Found;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import atfalna.atfalna.R;

public class Post_Found_Activity extends AppCompatActivity {

    TextView tv_code_p, tv_email_user, tv_datetime, tv_city,
            tv_day, tv_month, tv_year,
            tv_gender, tv_phone,tv_place, tv_info ;
    ImageView img_p_f ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_found);

        tv_code_p=findViewById(R.id.code_p);
        tv_email_user=findViewById(R.id.email);
        tv_datetime=findViewById(R.id.date);
        tv_city=findViewById(R.id.city);
        tv_day=findViewById(R.id.tv_day);
        tv_month=findViewById(R.id.tv_month);
        tv_year=findViewById(R.id.tv_year);
        tv_gender=findViewById(R.id.tv_gender);
        tv_phone=findViewById(R.id.tv_phone);
        tv_place=findViewById(R.id.tv_place);
        tv_info=findViewById(R.id.tv_info);

        img_p_f = findViewById(R.id.img_p_f);

        Intent data_p_f = getIntent();

        tv_code_p.setText(data_p_f.getExtras().getString("text_code").trim());
        tv_email_user.setText(data_p_f.getExtras().getString("text_email").trim());
        tv_code_p.setText(data_p_f.getExtras().getString("text_code").trim());
        tv_datetime.setText(data_p_f.getExtras().getString("text_date").trim());
        tv_city.setText(data_p_f.getExtras().getString("text_city").trim());
        tv_day.setText(data_p_f.getExtras().getString("text_day").trim());
        tv_month.setText(data_p_f.getExtras().getString("text_month").trim());
        tv_year.setText(data_p_f.getExtras().getString("text_year").trim());
        tv_gender.setText(data_p_f.getExtras().getString("text_gender").trim());
        tv_phone.setText(data_p_f.getExtras().getString("text_phone").trim());
        tv_place.setText(data_p_f.getExtras().getString("text_place"));
        tv_info.setText(data_p_f.getExtras().getString("text_info").trim());

        String simg = data_p_f.getExtras().getString("text_img");
//        Uri uri =Uri.parse(img);
//        img_p.setImageURI(uri);

        Picasso.with(getApplicationContext())
                .load("http://192.168.1.5/app_atfalna/img_found/"+simg)
                .into(img_p_f);












    }
}
