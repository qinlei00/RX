package com.example.administrator.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andexert.library.RippleView;
import com.example.administrator.newworks.R;


/**
 * Created by Administrator on 2016/8/3.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder>{
    private  Context context;
    public RecyclerAdapter(Context context){
        this.context=context;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.tem,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        //holder.textView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public  class Myholder extends RecyclerView.ViewHolder{
        private RippleView textView;
        public Myholder(View itemView) {
            super(itemView);
           // textView= (RippleView) itemView.findViewById(R.id.tv);
        }
    }
}
