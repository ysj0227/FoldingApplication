package com.foldingapplication.activity.myListview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.foldingapplication.R;
import com.foldingapplication.commons.views.FoldingCell;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import okhttp3.Call;

/**
 * Created by shijie.yang on 2017/11/3.
 */

public class MyTestListViewActivity extends AppCompatActivity {
    String url = "http://192.168.20.40:8853/is/app/appActivityOrderAction.do";
    //@BindView(R.id.mainListView)
    ListView mainListView;

    private List<Bean> list = new ArrayList<>();

    private MyListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cell_listview);
        //ButterKnife.bind(this);
        this.setTitle("ListView");
        mainListView = (ListView) findViewById(R.id.mainListView);
        getList();


        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                ((FoldingCell) view).toggle(false);
                adapter.registerToggle(pos);
            }
        });
    }

    private void getList() {
        OkHttpUtils.post()
                .url(url)
                .addParams("loginName", "hn001")
                .addParams("beginDate", "2016-01-01")
                .addParams("endDate", "2017-10-01")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onResponse(Call call, String s) {
                 Log.i("TAG",s);
                try {
                    JSONObject object = new JSONObject(s);
                    JSONObject object2 = object.getJSONObject("returnData");
                    JSONArray jsonArray = object2.getJSONArray("data");
                    Bean bean;
                    list.clear();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object1 = (JSONObject) jsonArray.opt(i);
                        bean = new Bean();
                        bean.setTime(object1.getString("time"));
                        bean.setState(object1.getString("state")); //0等待发放 1已发放
                        bean.setProductName(object1.getString("productName"));
                        bean.setName("种植户：" + object1.getString("name"));
                        bean.setImageId(object1.getString("imageId"));
                        bean.setOrigPrice("¥" + object1.getString("origPrice"));
                        bean.setPrice("¥" + object1.getString("price"));
                        //  Log.i("TAG",bean.getName());
                        list.add(bean);
                    }
                    adapter = new MyListViewAdapter(MyTestListViewActivity.this, list);
                    mainListView.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    class MyListViewAdapter extends BaseAdapter {
        private Context context;
        private List<Bean> list;
        private HashSet<Integer> unfoldedIndexes = new HashSet<>();
        private View.OnClickListener defaultRequestBtnClickListener;

        public MyListViewAdapter(Context context, List<Bean> list) {
            this.context = context;
            this.list = list;
        }


        public int getCount() {
            return list.size();
        }

        public Object getItem(int position) {
            return getItem(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Bean bs = list.get(position);
            FoldingCell cell = (FoldingCell) convertView;
            ViewHolder holder;

            if (cell == null) {
                holder = new ViewHolder();
                LayoutInflater vi = LayoutInflater.from(context);
                cell = (FoldingCell) vi.inflate(R.layout.my_list, parent, false);

                holder.name = (TextView) cell.findViewById(R.id.name);
                holder.productName = (TextView) cell.findViewById(R.id.productName);
                holder.state = (TextView) cell.findViewById(R.id.state);
                holder.price = (TextView) cell.findViewById(R.id.price);
                holder.orgPrice = (TextView) cell.findViewById(R.id.origPrice);
                holder.time = (TextView) cell.findViewById(R.id.time);

                cell.setTag(holder);
            } else {
                if (unfoldedIndexes.contains(position)) {
                    cell.unfold(true);
                } else {
                    cell.fold(true);
                }
                holder = (ViewHolder) cell.getTag();
            }


            holder.name.setText(bs.getName());
            holder.productName.setText(bs.getProductName());

            holder.state.setText("状态：等待发放");
            holder.price.setText("优惠价格："+bs.getPrice());
            holder.orgPrice.setText("原始价格："+bs.getOrigPrice());
            holder.time.setText("起始时间："+bs.getTime());

            return cell;
        }
        public void registerToggle(int position) {
            if (unfoldedIndexes.contains(position))
                registerFold(position);
            else
                registerUnfold(position);
        }

        public void registerFold(int position) {
            unfoldedIndexes.remove(position);
        }

        public void registerUnfold(int position) {
            unfoldedIndexes.add(position);
        }

        public View.OnClickListener getDefaultRequestBtnClickListener() {
            return defaultRequestBtnClickListener;
        }

        public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
            this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
        }

       class ViewHolder {
            TextView name;
            TextView productName;

            TextView state;
            TextView price;
            TextView orgPrice;
            TextView time;

        }


    }


}
