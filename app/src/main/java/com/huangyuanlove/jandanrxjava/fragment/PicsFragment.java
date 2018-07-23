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
import com.huangyuanlove.jandanrxjava.databinding.PicsFragmentBinding;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.PicsVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:无聊图
 */
public class PicsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    private Activity context;
    private PicsFragmentBinding binding;
    private int pageNum = 1;
    private List<PicsVO> picsVOs = new ArrayList<>();
    private PicsAdapter adapter;

    public PicsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.pics_fragment,container,false);
        initView();
        initData(false);
        return binding.getRoot();
    }

    private void initView() {
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new PicsAdapter(context,picsVOs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.picsListView.setLayoutManager(linearLayoutManager);
        binding.picsListView.setAdapter(adapter);
        binding.picsListView.addOnScrollListener(new RecyclerViewScrollListener() {
            @Override
            public void onLoadMore() {
                initData(true);
            }
        });

    }
    private void initData(final boolean isLoadMore) {
        if(isLoadMore){
            pageNum += 1;
        }else{
            pageNum = 1;
        }

        RetrofitFactory.getInstance().getPicsList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestResultBean<PicsVO>>() {
                    @Override
                    public void accept(RequestResultBean<PicsVO> picsVORequestResultBean) throws Exception {
                        if(picsVORequestResultBean!=null && "ok".equals(picsVORequestResultBean.getStatus())){
                            if(isLoadMore){
                                picsVOs.addAll(picsVORequestResultBean.getComments());
                            }else{
                                picsVOs = picsVORequestResultBean.getComments();
                            }
                            adapter.setLists(picsVOs);
                        }
                    }
                });



    }

    @Override
    public void onRefresh() {
        initData(false);
    }



}
