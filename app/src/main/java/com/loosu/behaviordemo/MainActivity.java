package com.loosu.behaviordemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.loosu.behaviordemo.adapter.recyclerview.ARecyclerAdapter;
import com.loosu.behaviordemo.adapter.recyclerview.RecyclerHolder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView(savedInstanceState);
        initView(savedInstanceState);
    }


    private void findView(Bundle savedInstanceState) {
//        mViewList = (RecyclerView) findViewById(R.id.view_list);
    }

    private void initView(Bundle savedInstanceState) {
//        mViewList.setLayoutManager(new LinearLayoutManager(this));
//        mViewList.setAdapter(new Adapter(null));
    }

    public static class Adapter extends ARecyclerAdapter<Integer> {
        private int[] colors = {
                0xffffAAAA,
                0xffAAffAA,
                0xffAAAAff,
        };

        public Adapter(@Nullable List<Integer> datas) {
            super(datas);
        }

        @Override
        protected void onBindViewData(RecyclerHolder holder, int position, List<Integer> datas) {
            holder.setText(R.id.text, String.valueOf(position));
            holder.itemView.setBackgroundColor(colors[position % colors.length]);
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_simple;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
