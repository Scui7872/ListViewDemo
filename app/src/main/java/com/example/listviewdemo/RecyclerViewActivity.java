package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    //1.准备模拟数据
    //商品名称与价格数据的集合
    private String[] titles = {"桌子","苹果","蛋糕","线衣","猕猴桃","围巾"};
    private String[] prices = {"1800元","10元/kg","300元","350元","10元/kg","280元"};
    //图片数据的集合
    private int[] icons = {
            R.drawable.table,R.drawable.apple,R.drawable.cake,
            R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initData();
        initView();
    }
    private void initView() {
        RecyclerView lvGoods = findViewById(R.id.lv_goods);
        lvGoods.setLayoutManager(new LinearLayoutManager(this));
        lvGoods.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        RecyclerAdapter adapter = new RecyclerAdapter(goods);
        lvGoods.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Goods good = goods.get(position);
                Toast.makeText(RecyclerViewActivity.this,good.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //1.获取ListView控件对象
//        ListView lvGoods = findViewById(R.id.lv_goods);
        //2.创建一个Adapter对象
//        BaseAdapter adapter = new GoodsAdapter(this,goods);
        //3.给ListView设置适配器Adapter
//        lvGoods.setAdapter(adapter);
        //4.给ListView的Item设置点击事件的监听器
//        lvGoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            //5.点击事件的处理
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Goods good = (Goods) parent.getItemAtPosition(position);
//                Toast.makeText(RecyclerViewActivity.this,good.toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //BaseAdapter要求的数据集合
    private List<Goods> goods;
    private void initData() {
        goods = new ArrayList<>();
        for (int i = 0; i < titles.length;i++) {
            goods.add(new Goods(titles[i],prices[i],icons[i]));
        }
    }
}