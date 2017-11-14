package com.foldingapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.foldingapplication.R;
import com.foldingapplication.bean.TBean;
import com.foldingapplication.units.CommonListAdapter;
import com.foldingapplication.units.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shijie.yang on 2017/11/14.
 */

public class RecylerViewActivcity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Button res, gridview, Stagger,cardView;
    private List<TBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        this.setTitle("RecyclerView");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        res = (Button) findViewById(R.id.res);
        gridview = (Button) findViewById(R.id.gridview);
        Stagger = (Button) findViewById(R.id.Stagger);
        cardView = (Button) findViewById(R.id.cardView);
        res.setOnClickListener(this);
        gridview.setOnClickListener(this);
        Stagger.setOnClickListener(this);
        cardView.setOnClickListener(this);

        LinearLayoutManager nn = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(nn);

        data();
        showList();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.res:
                LinearLayoutManager nf = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(nf);
                showList();
                break;
            case R.id.gridview://GridView
                StaggeredGridLayoutManager nn = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(nn);
                data();
                showList();
                break;
            case R.id.Stagger://瀑布
                //Layout 布局： R.layout.recycler_item
                StaggeredGridLayoutManager n = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(n);
                setStagger();
                showList();
                break;
            case R.id.cardView://卡片布局
                StaggeredGridLayoutManager g = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(g);
                setStagger();
                //Layout 布局： R.layout.card_item
                recyclerView.setAdapter(new CommonListAdapter<TBean>(this, R.layout.card_item, list) {

                    @Override
                    public void convert(ViewHolder holder, TBean tBean) {
                        holder.setText(R.id.name, tBean.getName());
                        holder.setText(R.id.descrip, tBean.getDescrip());
                        holder.setImageResource(R.id.imageUrl, tBean.getImageId());
                    }
                });

                break;
            default:
                break;

        }

    }


    private void showList() {
        recyclerView.setAdapter(new CommonListAdapter<TBean>(this, R.layout.recycler_item, list) {

            @Override
            public void convert(ViewHolder holder, TBean tBean) {
                holder.setText(R.id.name, tBean.getName());
                holder.setText(R.id.descrip, tBean.getDescrip());
                holder.setImageResource(R.id.imageUrl, tBean.getImageId());

            }
        });
    }

    //初始数据
    private void data() {
        TBean bean;
        list.clear();
        for (int i = 0; i < 9; i++) {
            bean = new TBean();
            bean.setImageId(R.mipmap.ic_launcher);
            bean.setName("黄老邪" + i);
            bean.setDescrip("一江春水向东流");
            list.add(bean);
        }
    }

    //设置瀑布数据
    private void setStagger() {
        list.clear();

        TBean bean = new TBean();
        bean.setImageId(R.mipmap.ic_launcher);
        bean.setName("乔峰");
        bean.setDescrip("一江春水向东流");
        list.add(bean);

        TBean bean1 = new TBean();
        bean1.setImageId(R.mipmap.ic_launcher);
        bean1.setName("乔峰");
        bean1.setDescrip("一江春水向烦得很的更换会计东流");
        list.add(bean1);

        TBean bean2 = new TBean();
        bean2.setImageId(R.mipmap.ic_launcher);
        bean2.setName("乔峰");
        bean2.setDescrip("一江春水向东流");
        list.add(bean2);

        TBean bean3 = new TBean();
        bean3.setImageId(R.mipmap.ic_launcher);
        bean3.setName("乔峰");
        bean3.setDescrip("一江春水割发代首了刚好放假看好公司了火炬个教后反思登记后向东流");
        list.add(bean3);

        TBean bean4 = new TBean();
        bean4.setImageId(R.mipmap.ic_launcher);
        bean4.setName("乔峰");
        bean4.setDescrip("一江春流");
        list.add(bean4);

        TBean bean5 = new TBean();
        bean5.setImageId(R.mipmap.ic_launcher);
        bean5.setName("乔峰");
        bean5.setDescrip("一江春大锅饭山东黄金水向东流");
        list.add(bean5);

        TBean bean6 = new TBean();
        bean6.setImageId(R.mipmap.ic_launcher);
        bean6.setName("乔峰");
        bean6.setDescrip("一江春水向东流");
        list.add(bean6);

        TBean bean7 = new TBean();
        bean7.setImageId(R.mipmap.ic_launcher);
        bean7.setName("乔峰");
        bean7.setDescrip("一江春水rtgjrui向东流");
        list.add(bean7);

        TBean bean8 = new TBean();
        bean8.setImageId(R.mipmap.ic_launcher);
        bean8.setName("乔峰");
        bean8.setDescrip("一江春水黑寡妇");
        list.add(bean8);


    }


}
