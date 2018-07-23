package com.huangyuanlove.jandanrxjava.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.RecyclerViewScrollListener;
import com.huangyuanlove.jandanrxjava.databinding.JokeFragmentBinding;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.JokeVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:段子
 */
public class JokeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private Activity context;

    private JokeFragmentBinding binding;
    private List<JokeVO> jokeVOs = new ArrayList<>();
    private JokesAdapter adapter;
    private int pageNum = 1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.joke_fragment, container, false);
        initView();
        initData(false);
        return binding.getRoot();
    }

    private void initData(final boolean isLoadMore) {
        if (isLoadMore) {
            pageNum += 1;
        } else {
            pageNum = 1;
        }

        RetrofitFactory.getInstance().getJokeList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestResultBean<JokeVO>>() {
                    @Override
                    public void accept(RequestResultBean<JokeVO> jokeVORequestResultBean) throws Exception {
                        if(jokeVORequestResultBean!=null && "ok".equals(jokeVORequestResultBean.getStatus())){
                            if(isLoadMore){
                                jokeVOs.addAll(jokeVORequestResultBean.getComments());
                            }else{
                                jokeVOs = jokeVORequestResultBean.getComments();
                            }
                            adapter.setLists(jokeVOs);
                        }
                    }
                });


    }

    private void initView() {

        adapter = new JokesAdapter(context, jokeVOs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        binding.recyclerView.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void onLoadMore() {
                initData(true);
            }
        });

    }

    @Override
    public void onRefresh() {
        initData(false);
    }
}
