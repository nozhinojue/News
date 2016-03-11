package com.example.cjj.news.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cjj.core.ActionCallbackListener;
import com.example.cjj.core.AppActionImpl;
import com.example.cjj.model.NewItemData;
import com.example.cjj.model.NewsListModel;
import com.example.cjj.news.R;
import com.example.cjj.news.activity.WebViewActivity;
import com.example.cjj.news.adapter.RvAdapter;
import com.example.cjj.news.util.dpullrefresh_loadmore.DNormalRefreshViewHolder;
import com.example.cjj.news.util.dpullrefresh_loadmore.DPullRefreshLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    public static final String DATA_URL_TAG = "ARG_PAGE";
    private String  dataUrlStr;
    private DPullRefreshLayout dPullRefreshLayout;


    private List<NewsListModel> listData;
    private LinearLayout llLoading;

    private RecyclerView recyclerView;
    private RvAdapter rvAdapter;
    private int oldSize; //原来数据的大小
    private int pageNum=1;//页数
    private boolean isRefresh=false;//是否刷新
    private boolean isLoadMore=false;//是否加载更多
    private boolean isOver=false;//是否已加载完。


    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(String dataUrl) {
        Bundle args = new Bundle();
        args.putString(DATA_URL_TAG, dataUrl);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataUrlStr = getArguments().getString(DATA_URL_TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);

            llLoading= (LinearLayout) view.findViewById(R.id.ll_loading);
            listData = new ArrayList<NewsListModel>();

            dPullRefreshLayout= (DPullRefreshLayout) view.findViewById(R.id.fg_drl);
            DNormalRefreshViewHolder dNormalRefreshViewHolder = new DNormalRefreshViewHolder(getContext(), true);
            dPullRefreshLayout.setRefreshViewHolder(dNormalRefreshViewHolder);
            dPullRefreshLayout.setDelegate(new DPullRefreshLayout.DPullRefreshLayoutDelegate() {
                @Override
                public void onDPullRefreshLayoutBeginRefreshing(final DPullRefreshLayout refreshLayout) {
                    //下拉刷新
                    pageNum = 1;
                    isRefresh = true;
                    listData.clear(); //清空原来数据。
                    rvAdapter.notifyDataSetChanged();//通知adapter数据更新了。
                    //获取数据
                    getData();
                }

                @Override
                public boolean onDPullRefreshLayoutBeginLoadingMore(DPullRefreshLayout refreshLayout) {
                    //加载更多
                    if (isOver) {
                        return false;
                    }
                    llLoading.setVisibility(View.VISIBLE);
                    pageNum++;
                    isLoadMore = true;
                    getData();
                    return false;
                }
            });

            recyclerView = (RecyclerView) view.findViewById(R.id.fg_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));   //设置线性布局
            rvAdapter = new RvAdapter(getContext(), listData);
            recyclerView.setAdapter(rvAdapter);
            rvAdapter.setmItemOnclickListener(new RvAdapter.ItemOnClickListener() {
                @Override
                public void onClick(int position, View view) {
                    NewsListModel newsModel = listData.get(position);
                    //Toast.makeText(MainActivity.this, "点击了index："+newsModel.getUrl(), Toast.LENGTH_SHORT).show();
//                    String url = newsModel.getUrl();
//                    Intent intent = new Intent(Intent.ACTION_VIEW); //调用系统浏览器打开详细页面。
//                    intent .setData(Uri.parse(url));
//                    startActivity(intent);

                String url = newsModel.getUrl();
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("URL", url);
                startActivity(intent);
                }
            });

            getData();




        // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));  //线性布局，添加item间的分割线
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));  //网格布局，添加item间的分割线
        return view;
    }



    /**
     * 获取数据
     */
    private void getData() {

        //new MyAsyncTask().execute(pageNum);
        new AppActionImpl().getNewsData(dataUrlStr, pageNum, new ActionCallbackListener<NewItemData>() {
            @Override
            public void onSuccessed(NewItemData newItemData) {
                if(isRefresh){
                    dPullRefreshLayout.endRefreshing();//结束刷新。
                    isRefresh=false;
                }

                if(isLoadMore){
                    llLoading.setVisibility(View.GONE);
                    dPullRefreshLayout.endLoadingMore();//结束加载更多。
                    isLoadMore=false;
                }

                setData(newItemData);
            }

            @Override
            public void onFailure(String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //更新数据
    private void setData(NewItemData newItemData){
        if(newItemData!=null && newItemData.getNewslist()!=null){
            oldSize=listData.size();
            listData.addAll(newItemData.getNewslist());
            rvAdapter.notifyItemRangeInserted(oldSize,listData.size()-oldSize); //通知list加载更多数据。
        }else {
            if(pageNum==1){
                //没有数据。
                Toast.makeText(getActivity(), "没有数据。", Toast.LENGTH_LONG).show();
            }else if(pageNum>1){
                //没有更多数据了。
                isOver=true;
                Toast.makeText(getActivity(), "没有更多数据了。", Toast.LENGTH_LONG).show();
            }
        }
    }
}



