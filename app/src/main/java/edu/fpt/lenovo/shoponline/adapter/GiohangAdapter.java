package edu.fpt.lenovo.shoponline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edu.fpt.lenovo.shoponline.R;
import edu.fpt.lenovo.shoponline.activity.GiohangActivity;
import edu.fpt.lenovo.shoponline.activity.MainActivity;
import edu.fpt.lenovo.shoponline.model.Giohang;

public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> arraygiohang;

    public GiohangAdapter(Context context, ArrayList<Giohang> arraygiohang) {
        this.context = context;
        this.arraygiohang = arraygiohang;
    }


    @Override
    public int getCount() {
        return arraygiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arraygiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imggiohang;
        public Button btnminus,btnvalues,btnplus;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_giohang,null);
            viewHolder.txttengiohang = view.findViewById(R.id.textviewgiohang);
            viewHolder.txtgiagiohang = view.findViewById(R.id.textviewgiagiohang);
            viewHolder.imggiohang = view.findViewById(R.id.imageviewgiohang);
            viewHolder.btnminus = view.findViewById(R.id.buttonminus);
            viewHolder.btnvalues = view.findViewById(R.id.buttonvalues);
            viewHolder.btnplus = view.findViewById(R.id.buttonplus);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Giohang giohang = (Giohang) getItem(position);
        viewHolder.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(giohang.getGiasp()) + "Đ");
        Picasso.with(context).load(giohang.getHinhsp())
                .placeholder(R.drawable.home)
                .error(R.drawable.erro)
                .into(viewHolder.imggiohang);
        viewHolder.btnvalues.setText(Integer.toString(giohang.getSoluongsp()));
        int sl = Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if (sl >= 10){
            viewHolder.btnplus.setVisibility(View.INVISIBLE);
            viewHolder.btnminus.setVisibility(View.VISIBLE);
        }else if(sl <=1){
            viewHolder.btnminus.setVisibility(View.INVISIBLE);
        }else if (sl >=1){
            viewHolder.btnminus.setVisibility(View.VISIBLE);
            viewHolder.btnplus.setVisibility(View.INVISIBLE);
        }
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btnvalues.getText().toString())+1;
                int slht = MainActivity.manggiohang.get(position).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) /slht;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat) + "Đ");
                GiohangActivity.EventUltil();
                if (slmoinhat > 9 ){
                    finalViewHolder.btnplus.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnvalues.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btnvalues.setText(String.valueOf(slmoinhat));
                    finalViewHolder.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnplus.setVisibility(View.VISIBLE);
                }
            }
        });
        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btnvalues.getText().toString())-1;
                int slht = MainActivity.manggiohang.get(position).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) /slht;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat) + "Đ");
                GiohangActivity.EventUltil();
                if (slmoinhat < 2 ){
                    finalViewHolder.btnminus.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnvalues.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btnvalues.setText(String.valueOf(slmoinhat));
                    finalViewHolder.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnplus.setVisibility(View.VISIBLE);
                }
            }
        });
        {
            return view;
        }
    }
}
