package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.entity.myBean;
import com.example.myapplication.databinding.SearchBinding;

import java.util.ArrayList;
import java.util.List;

public class Search extends Fragment {
    private SearchBinding binding;
    private List<myBean> myBeanList = new ArrayList<>();//用来存放数据的数组

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = SearchBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = getView().findViewById(R.id.search_input);
                String key = "";
                if(editText != null && editText.getText() != null){
                    key = editText.getText().toString();
                }
                ListView listView = getView().findViewById(R.id.listview);//在视图中找到ListView
                init(key);
                myAdapter adapter = new myAdapter(getActivity(), R.layout.myitem, myBeanList);
                listView.setAdapter(adapter);

            }
        });

    }
    private void init(String key) {//初始化数据
        myBeanList.clear();
        String text = "";
        for (int i = 1; i < 100; i++){
            text = "第"+i+"行数据";
            if(text.contains(key)){
                myBean bean = new myBean(text, R.mipmap.ic_launcher);
                myBeanList.add(bean);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public List<List<String>> select(){
        SelectRecords selectRecords = new SelectRecords();
        List<List<String>> rs = selectRecords.selectAll();
        return rs;
    }

}
