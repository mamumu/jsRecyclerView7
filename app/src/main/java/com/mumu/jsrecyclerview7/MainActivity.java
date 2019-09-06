package com.mumu.jsrecyclerview7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : zlf
 * date    : 2019/9/6
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.iv_history_dele)
    ImageView ivHistoryDele;
    @BindView(R.id.rv_history)
    RecyclerView rvHistory;

    private HistoryAdapter mHistoryAdapter;
    private List<HistoryEntity> mHistoryEntityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        //1，填充假数据，正常情况应该是从接口取
        mHistoryEntityList.add(new HistoryEntity("我", 1));
        mHistoryEntityList.add(new HistoryEntity("我爱", 2));
        mHistoryEntityList.add(new HistoryEntity("我爱你", 3));
        mHistoryEntityList.add(new HistoryEntity("我爱你我", 4));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的", 5));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的祖", 6));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的祖国", 7));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的祖国", 8));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的祖国", 9));
        mHistoryEntityList.add(new HistoryEntity("我爱你我的祖国", 10));

        //2，增加谷歌流式布局
        FlexboxLayoutManager manager = new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvHistory.setLayoutManager(manager);
        mHistoryAdapter = new HistoryAdapter(mHistoryEntityList);
        rvHistory.setAdapter(mHistoryAdapter);
        mHistoryAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //打印点击的选项
                Toast.makeText(MainActivity.this, mHistoryEntityList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.iv_history_dele)
    public void onViewClicked() {
        //清空数据
        mHistoryEntityList.clear();
        mHistoryAdapter.setNewData(mHistoryEntityList);
    }
}
