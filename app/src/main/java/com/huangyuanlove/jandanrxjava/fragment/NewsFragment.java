package com.huangyuanlove.jandanrxjava.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.RecyclerViewScrollListener;
import com.huangyuanlove.jandanrxjava.databinding.NewsFragmentBinding;
import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.NewsVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:新鲜事
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private Activity context;
    private NewsFragmentBinding binding;
    private List<NewsVO> newsVOs = new ArrayList<>();
    private NewsAdapter adapter;
    private int pageNum = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false);
        initView();
        initData(false);
        return binding.getRoot();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.newsListView.setLayoutManager(linearLayoutManager);
        adapter = new NewsAdapter(context, newsVOs);
        binding.newsListView.setAdapter(adapter);
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        binding.newsListView.setAdapter(adapter);
        binding.newsListView.setItemAnimator(new DefaultItemAnimator());
        binding.newsListView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        binding.newsListView.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void onLoadMore() {
                initData(true);
            }
        });

    }

    private void initData(final boolean isLoadMore) {
        if (isLoadMore) {
            pageNum += 1;
        } else {
            pageNum = 1;
        }
        RetrofitFactory.getInstance().getNewsList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestResultBean<NewsVO>>() {
                    @Override
                    public void accept(RequestResultBean<NewsVO> newsVORequestResultBean) throws Exception {
                        if(newsVORequestResultBean!=null && "ok".equals(newsVORequestResultBean.getStatus())){
                            if(isLoadMore){
                                newsVOs.addAll(newsVORequestResultBean.getPosts());
                            }else{
                                newsVOs = newsVORequestResultBean.getPosts();
                            }
                            adapter.setLists(newsVOs);
                        }
                    }
                });


    }

    @Override
    public void onRefresh() {
        initData(false);
    }

}
