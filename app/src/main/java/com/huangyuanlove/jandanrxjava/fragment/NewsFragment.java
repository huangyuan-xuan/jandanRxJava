package com.huangyuanlove.jandanrxjava.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.RecyclerViewScrollListener;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.NewsVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:新鲜事
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.news_list_view)
    RecyclerView newsListView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;
    private Activity context;
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
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData(false);
        return view;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        newsListView.setLayoutManager(linearLayoutManager);
        adapter = new NewsAdapter(context, newsVOs);
        newsListView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this);
        newsListView.setAdapter(adapter);
        newsListView.setItemAnimator(new DefaultItemAnimator());
        newsListView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        newsListView.addOnScrollListener(new RecyclerViewScrollListener() {
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
                        swipeRefreshLayout.setRefreshing(false);
                        if (newsVORequestResultBean != null && "ok".equals(newsVORequestResultBean.getStatus())) {
                            if (isLoadMore) {
                                newsVOs.addAll(newsVORequestResultBean.getPosts());
                            } else {
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
