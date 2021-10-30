package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.entity.myBean;

import java.util.List;

public class myAdapter extends ArrayAdapter {
 
    private final int ImageId;
    private String radiotext;
    public myAdapter(Context context, int headImage, List<myBean> obj){
        super(context,headImage,obj);
        ImageId = headImage;//这个是传入我们自己定义的界面
 
    }
 
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        myBean myBean = (myBean) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ImageId,null);//这个是实例化一个我们自己写的界面Item
        LinearLayout linearLayout = view.findViewById(R.id.line1);
//        ImageView headImage = view.findViewById(R.id.headimage);
        TextView headText = view.findViewById(R.id.headtext);
        RadioGroup radio = view.findViewById(R.id.radioBtn);
//        headImage.setImageResource(myBean.getImageID());
        headText.setText(myBean.getText());
//        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//检查Radio Button那个被点击了
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                switch (i){
//                    case R.id.radio1:
//                        radiotext = "不打";
//                        break;
//                    case R.id.radio2:
//                        radiotext = "打他";
//                        break;
//                }
//            }
//        });
//        linearLayout.setOnClickListener(new View.OnClickListener() {//检查哪一项被点击了
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(),"你点击了第"+position+"项"+"你选择"+radiotext,Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}