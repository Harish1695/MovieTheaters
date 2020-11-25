package com.movietheaters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AllMoviesAdapter extends BaseAdapter {
    ProgressDialog progressDialog;
    List<MoviesPojo> moviesPojos;
    String theatername;
    Context cnt;
    public AllMoviesAdapter(List<MoviesPojo> ar, String theatername, Context cnt)
    {
        this.moviesPojos=ar;
        this.theatername=theatername;
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return moviesPojos.size();
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
        View obj2=obj1.inflate(R.layout.list_all_movies,null);

        TextView tv_theater_name=(TextView)obj2.findViewById(R.id.tv_theater_name);
        tv_theater_name.setText("Movie Name :"+moviesPojos.get(pos).getMovie_name());

        Button btn_book=(Button)obj2.findViewById(R.id.btn_book);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cnt, "Your Ticket Booked Succussfullly in "+theatername +"  "+moviesPojos.get(pos).getMovie_name() +"  Movie", Toast.LENGTH_LONG).show();
                cnt.startActivity(new Intent(cnt, TheatersActivity.class));
                ((Activity)cnt).finish();
            }
        });




        return obj2;
    }

}