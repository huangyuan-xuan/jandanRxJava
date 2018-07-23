package com.huangyuanlove.jandanrxjava.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.RecyclerViewScrollListener;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.databinding.GirlsFragmentBinding;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.GirlPicsVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:妹子图
 */
public class GirlsFragment extends BaseFragment {
    private GirlsFragmentBinding binding;
    private Activity context;

    private List<GirlPicsVO> girlPicsVOs = new ArrayList<>();
    private GirlPicsAdapter adapter;
    private int pageNum = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.girls_fragment, container, false);
        initView();
        initData(false);
        return binding.getRoot();
    }

    private void initView() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(false);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.findFirstVisibleItemPosition();
        adapter = new GirlPicsAdapter(context, girlPicsVOs);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.addOnScrollListener(new RecyclerViewScrollListener() {
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


        RetrofitFactory.getInstance()
                .getGirlPicsList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestResultBean<GirlPicsVO>>() {
                    @Override
                    public void accept(RequestResultBean<GirlPicsVO> girlPicsVORequestResultBean) throws Exception {
                        binding.swipeRefreshLayout.setRefreshing(false);
                        if (girlPicsVORequestResultBean != null && "ok".equals(girlPicsVORequestResultBean.getStatus())) {
                            if (isLoadMore) {
                                girlPicsVOs.addAll(girlPicsVORequestResultBean.getComments());
                            } else {
                                girlPicsVOs = girlPicsVORequestResultBean.getComments();
                            }
                            adapter.setLists(girlPicsVOs);
                        }
                    }
                });


    }
}
