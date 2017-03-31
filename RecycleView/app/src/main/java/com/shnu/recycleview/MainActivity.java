package com.shnu.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Context mContext;
    private RecyclerView mainRecyclerView;
    private MainRecycleViewAdapter mainAdapter;
    private List<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initData();
        mainAdapter = new MainRecycleViewAdapter();
        mainRecyclerView = (RecyclerView) findViewById(R.id.rcv_main);
        mainRecyclerView.setAdapter(mainAdapter);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    private void initData(){
        data = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            data.add("simple recyclerview");
        }
    }

    class MainRecycleViewAdapter extends RecyclerView.Adapter<MainViewHolder> {

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_recy,parent,false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            holder.btnInfo.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size() >= 0 ? data.size() : 0;
        }
    }


    class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(View itemView) {
            super(itemView);
            btnInfo = (TextView) itemView.findViewById(R.id.tv_item_main_recycler);
        }
            TextView btnInfo;
    }
}
