package edu.fpt.lenovo.shoponline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.fpt.lenovo.shoponline.R;
import edu.fpt.lenovo.shoponline.model.Loaisp;


public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class viewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder viewHolder = null;
        if (view == null){
            viewHolder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_listview_loaisp,null);
            viewHolder.txttenloaisp = (TextView) view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = (ImageView) view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);
        }else{
            viewHolder = (LoaispAdapter.viewHolder) view.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(i);
        viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.home)
                .error(R.drawable.erro)
                .into(viewHolder.imgloaisp);
        return view;
    }
}