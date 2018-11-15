package edu.fpt.lenovo.shoponline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edu.fpt.lenovo.shoponline.R;
import edu.fpt.lenovo.shoponline.model.Sanpham;


public class LapTopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraylaptop;

    public LapTopAdapter(Context context, ArrayList<Sanpham> arraylaptop) {
        this.context = context;
        this.arraylaptop = arraylaptop;
    }

    @Override
    public int getCount() {
        return arraylaptop.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylaptop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHoder{
        public TextView txttenlaptop,txtgialaptop,txtmotalaptop;
        public ImageView imglaptop;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder = null;
        if (view == null){
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_laptop,null);
            viewHoder.txttenlaptop = (TextView) view.findViewById(R.id.textviewlaptop);
            viewHoder.txtgialaptop = (TextView) view.findViewById(R.id.textviewgialaptop);
            viewHoder.txtmotalaptop = (TextView) view.findViewById(R.id.textviewmotalaptop);
            viewHoder.imglaptop = (ImageView) view.findViewById(R.id.imageviewlaptop);
            view.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHoder.txttenlaptop.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgialaptop.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham())+ "Đ");
        viewHoder.txtmotalaptop.setMaxLines(2);
        viewHoder.txtmotalaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotalaptop.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.home)
                .error(R.drawable.erro)
                .into(viewHoder.imglaptop);
        return view;
    }
}

