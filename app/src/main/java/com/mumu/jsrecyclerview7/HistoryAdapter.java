package com.mumu.jsrecyclerview7;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author : zlf
 * date    : 2019/9/6
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class HistoryAdapter extends BaseQuickAdapter<HistoryEntity, BaseViewHolder> {
    public HistoryAdapter(@Nullable List<HistoryEntity> data) {
        super(R.layout.item_history_around, data);
    }

    public HistoryAdapter() {
        super(R.layout.item_history_around);
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryEntity data) {
        //将每一个需要赋值的id和对应的数据绑定
        helper.setText(R.id.item_tv_around_name, data.getName());//名字
    }
}
