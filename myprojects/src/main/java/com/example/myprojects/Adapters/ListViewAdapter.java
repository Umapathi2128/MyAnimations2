package com.example.myprojects.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myprojects.ModelClass.ListAdapters;
import com.example.myprojects.MyInterface;
import com.example.myprojects.R;

import java.util.ArrayList;

/**
 * Created by umapa on 11/16/2017.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {

    ArrayList<ListAdapters> list;
    Context context;
//    ImageView profile;
    View view;
    int type;
    MyInterface myInterface;
//    private TextView name,email,phone;


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView profile;
        ImageView mProfile;
        private TextView name,email,age,phone,address;
        private TextView mName,mEmail,mAge,mPhone,mAddress;

        public MyViewHolder(View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.tv_name);
            phone= itemView.findViewById(R.id.tv_phone);
            email= itemView.findViewById(R.id.tv_email);
//            address=itemView.findViewById(R.id.tv_address);
//            age=itemView.findViewById(R.id.tv_age);
            profile= itemView.findViewById(R.id.img_image);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            myInterface= (MyInterface) context;
            myInterface.getPosition(getAdapterPosition(),view);
        }
    }


    public ListViewAdapter(Context context, ArrayList<ListAdapters> list, int type) {
        this.list = list;
        this.type=type;
        this.context= context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(type==0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_layout, parent, false);


        }else if(type==1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_layout, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        ListAdapters m=list.get(position);
        ListAdapters adapters=list.get(position);

        holder.phone.setText(adapters.getPHONE());
       holder.email.setText(adapters.getEMAIL());
//        holder.address.setText(adapters.getADDRESS());
//        holder.age.setText(adapters.getAGE());
        holder.profile.setBackgroundResource(list.get(position).getIMAGE());
        holder.name.setText(list.get(position).getNAME());

//        holder.mPhone.setText(adapters.getPHONE());
//        holder.mEmail.setText(adapters.getEMAIL());
//        holder.mAddress.setText(adapters.getADDRESS());
//        holder.mAge.setText(adapters.getAGE());
//        holder.mProfile.setImageResource(list.get(position).getIMAGE());
//        holder.mName.setText(list.get(position).getNAME());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
