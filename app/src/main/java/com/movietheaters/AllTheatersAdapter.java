package com.movietheaters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AllTheatersAdapter extends BaseAdapter {
    ProgressDialog progressDialog;
    List<TheatersPojo> theatersPojos;
    Context cnt;
    public AllTheatersAdapter(List<TheatersPojo> ar, Context cnt)
    {
        this.theatersPojos=ar;
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return theatersPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup viewGroup)
    {
        LayoutInflater obj1 = (LayoutInflater)cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View obj2=obj1.inflate(R.layout.list_all_theaters,null);

        TextView tv_theater_name=(TextView)obj2.findViewById(R.id.tv_theater_name);
        tv_theater_name.setText("Theater Name :"+theatersPojos.get(pos).getTheater_name());

        tv_theater_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cnt, "ccc", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(cnt,MoviessActivity.class);
                intent.putExtra("theatername",theatersPojos.get(pos).getTheater_name());
                cnt.startActivity(intent);
                //((Activity)cnt).finish();

            }
        });


        return obj2;
    }

}