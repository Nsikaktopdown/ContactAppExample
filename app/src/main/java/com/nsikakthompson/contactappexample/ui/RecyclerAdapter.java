package com.nsikakthompson.contactappexample.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsikakthompson.contactappexample.R;
import com.nsikakthompson.contactappexample.data.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nsikak on 2/16/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Person> contactList;
    private Context context;
    private View.OnClickListener deleteClickListener;
    private View.OnClickListener viewClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mContactName_txt, mContactPhone_txt;
        ImageView mPhoto;

        public MyViewHolder(View view) {
            super(view);

           mContactName_txt = (TextView) view.findViewById(R.id.contact_name);
           mContactPhone_txt = (TextView) view.findViewById(R.id.contact_phone);
           mPhoto = itemView.findViewById(R.id.contact_thumb);


        }

    }


    public RecyclerAdapter(Context mContext, List<Person> contactList) {

        this.context = mContext;
        this.contactList = contactList;
        //this.deleteClickListener = deleteClickListener;
        //this.viewClickListener = viewClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Person item = contactList.get(position);
        holder.itemView.setTag(item);
        holder.mContactName_txt.setText(item.getContactName());
        holder.mContactPhone_txt.setText(item.getContactPhone());
        Picasso.with(holder.mPhoto.getContext()).load(item.getPhotoUrl()).into(holder.mPhoto);


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setItems(List<Person> contacts) {
        this.contactList = contacts;
        notifyDataSetChanged();
    }
}