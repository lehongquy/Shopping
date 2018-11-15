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



public class DienthoaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraydienthoai;

    public DienthoaiAdapter(Context context, ArrayList<Sanpham> arraydienthoai) {
        this.context = context;
        this.arraydienthoai = arraydienthoai;
    }

    @Override
    public int getCount() {
        return arraydienthoai.size();
    }

    @Override
    public Object getItem(int i) {
        return arraydienthoai.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHoder{
        public TextView txttendienthoai,txtgiadienthoai,txtmotadienthoai;
        public ImageView imgdienthoai;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder = null;
        if (view == null){
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dienthoai,null);
            viewHoder.txttendienthoai = (TextView) view.findViewById(R.id.textviewdienthoai);
            viewHoder.txtgiadienthoai = (TextView) view.findViewById(R.id.textviewgiadienthoai);
            viewHoder.txtmotadienthoai = (TextView) view.findViewById(R.id.textviewmotadienthoai);
            viewHoder.imgdienthoai = (ImageView) view.findViewById(R.id.imageviewdienthoai);
            view.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHoder.txttendienthoai.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHoder.txtgiadienthoai.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham())+ "Đ");
        viewHoder.txtmotadienthoai.setMaxLines(2);
        viewHoder.txtmotadienthoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHoder.txtmotadienthoai.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.home)
                .error(R.drawable.erro)
                .into(viewHoder.imgdienthoai);
        return view;
    }
}
