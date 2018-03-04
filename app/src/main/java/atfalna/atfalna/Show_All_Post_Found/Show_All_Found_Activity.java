package atfalna.atfalna.Show_All_Post_Found;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import atfalna.atfalna.GloablV;
import atfalna.atfalna.R;

public class Show_All_Found_Activity extends AppCompatActivity {

    RequestQueue requestQueue;
    String url="http://192.168.1.3/app_atfalna/show_all_found_db_atf.php";
    ArrayList<listitme> listMovis= new ArrayList<listitme>();
    ListView listView ;
    TextView text_total , text_email_user ;

    GloablV gloablV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_found);

        listView =findViewById(R.id.listview_show_all_found);
        text_total = findViewById(R.id.tv_total_post);
        text_email_user=findViewById(R.id.tv_show_email_user2);

        assert text_email_user !=null;
        gloablV =(GloablV)getApplicationContext();
        text_email_user.setText("مرحبا : "+gloablV.getEmail_user());

        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("allpost_found");
                            text_total.setText("الحالات التى تم رؤيتها: " + jsonArray.length());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject res = jsonArray.getJSONObject(i);

                                String code_post_found = res.getString("code_post");
                                String date_time = res.getString("date_time_post");
                                String img = res.getString("img_found");
                                String city = res.getString("city");
                                String day = res.getString("day");
                                String month = res.getString("month");
                                String year = res.getString("year");
                                String gender = res.getString("gender_the_case");
                                String phone = res.getString("phone");
                                String place_thecase = res.getString("place_the_case");
                                String info_thecase = res.getString("info_the_case");
                                String email_user = res.getString("email_user");

                                listMovis.add(new listitme(code_post_found,date_time,img,city,day,month,year,gender,phone,place_thecase,info_thecase,email_user));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        listData();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","Error");
            }
        });requestQueue.add(jsonObjectRequest);

    }
    public void listData(){
       ListAdapter ad = new ListAdapter(listMovis);
       listView.setAdapter(ad);
    }

    class ListAdapter extends BaseAdapter{

        ArrayList<listitme> listA = new ArrayList<listitme>();

      ListAdapter(ArrayList<listitme> listitme) {
            this.listA=listitme;
        }


        @Override
        public int getCount() {
            return listA.size();
        }

        @Override
        public Object getItem(int i) {
            return listA.get(i).code_p;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater=getLayoutInflater();
            View v1 =layoutInflater.inflate(R.layout.row_itme_fonud,null);

            TextView code_p =v1.findViewById(R.id.tv_code_post_f_list);
            TextView email_user =v1.findViewById(R.id.tv_email_user_list);
            TextView city =v1.findViewById(R.id.tv_city_list);
            TextView datetime =v1.findViewById(R.id.tv_datetime_list);
            //TextView phone =v1.findViewById(R.id.tv_phone_list);

            ImageView imgfound =v1.findViewById(R.id.img_post_found_list);

            code_p.setText(listA.get(i).code_p);
            email_user.setText(listA.get(i).email_user_f);
            city.setText(listA.get(i).city_f);
            datetime.setText(listA.get(i).date_time_p);
           // phone.setText(listA.get(i).phone);

            Picasso.with(getApplicationContext()).load("http://192.168.1.3/app_atfalna/img_atfalna/"+listA.get(i).img_f).into(imgfound);

            imgfound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                Intent openPost= new Intent(getApplicationContext(),Post_Found_Activity.class);

                    openPost.putExtra("text_code",listA.get(i).code_p);
                    openPost.putExtra("text_date",listA.get(i).date_time_p);
                    openPost.putExtra("text_img",listA.get(i).img_f);
                    openPost.putExtra("text_city",listA.get(i).city_f);
                    openPost.putExtra("text_day",listA.get(i).day_f);
                    openPost.putExtra("text_month",listA.get(i).month_f);
                    openPost.putExtra("text_year",listA.get(i).year_f);
                    openPost.putExtra("text_gender",listA.get(i).gender_thecase);
                    openPost.putExtra("text_phone",listA.get(i).phone);
                    openPost.putExtra("text_place",listA.get(i).place_thecase);
                    openPost.putExtra("text_info",listA.get(i).info_thecase);
                    openPost.putExtra("text_email",listA.get(i).email_user_f);

                 startActivity(openPost);
                }
            });

            return v1;
        }
    }



}
