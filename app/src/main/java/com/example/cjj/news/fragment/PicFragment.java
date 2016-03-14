package com.example.cjj.news.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.cjj.core.ActionCallbackListener;
import com.example.cjj.core.AppActionImpl;
import com.example.cjj.model.PicTypeData;
import com.example.cjj.news.R;
import com.example.cjj.news.activity.PicDetailActivity;
import com.example.cjj.news.adapter.PicFgRVAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PicFragment extends BaseFragment implements PicFgRVAdapter.ItemOnClickListener {
    private RecyclerView mRecyclerView;
    private List<PicTypeData.ResEntity.CategoryEntity> lists;
    private PicFgRVAdapter picFgRVAdapter;
    public PicFragment() {
        lists=new ArrayList<>();
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.fragment_pic;
    }

    @Override
    protected void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_picFg);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);  //设置网格布局，每行显示2个。

        getData();
    }

    //获取数据
    private void getData() {
        new AppActionImpl().getPicData(new ActionCallbackListener<PicTypeData>() {
            @Override
            public void onSuccessed(PicTypeData data) {
                setData(data);
            }

            @Override
            public void onFailure(String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //设置数据
    private void setData(PicTypeData data){
        lists.addAll(data.getRes().getCategory());
        picFgRVAdapter = new PicFgRVAdapter(getContext(),lists);
        picFgRVAdapter.setmItemOnclickListener(this);
        mRecyclerView.setAdapter(picFgRVAdapter);

    }

    //item的点击事件
    @Override
    public void onClick(int position, View view) {
        PicTypeData.ResEntity.CategoryEntity caterEntity= lists.get(position);
        String id =caterEntity.getId();
        Intent intent = new Intent(getActivity(), PicDetailActivity.class);
        intent.putExtra("typeId", id);
        intent.putExtra("typeName", caterEntity.getName());
        startActivity(intent);
        //Toast.makeText(getActivity(), "进入详细页面。id="+caterEntity.getId(), Toast.LENGTH_SHORT).show();
    }
}
