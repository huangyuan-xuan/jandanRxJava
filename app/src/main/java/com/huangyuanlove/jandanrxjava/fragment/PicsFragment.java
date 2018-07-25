package com.huangyuanlove.jandanrxjava.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.RecyclerViewScrollListener;
import com.huangyuanlove.jandanrxjava.base.BaseFragment;
import com.huangyuanlove.jandanrxjava.http.RetrofitFactory;
import com.huangyuanlove.jandanrxjava.model.PicsVO;
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
 * Description:无聊图
 */
public class PicsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.pics_list_view)
    RecyclerView picsListView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;
    private Activity context;
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
        View view = inflater.inflate(R.layout.pics_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData(false);
        return view;
    }

    private void initView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new PicsAdapter(context, picsVOs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        picsListView.setLayoutManager(linearLayoutManager);
        picsListView.setAdapter(adapter);
        picsListView.addOnScrollListener(new RecyclerViewScrollListener() {
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

        RetrofitFactory.getInstance().getPicsList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RequestResultBean<PicsVO>>() {
                    @Override
                    public void accept(RequestResultBean<PicsVO> picsVORequestResultBean) throws Exception {
                        swipeRefreshLayout.setRefreshing(false);
                        if (picsVORequestResultBean != null && "ok".equals(picsVORequestResultBean.getStatus())) {
                            if (isLoadMore) {
                                picsVOs.addAll(picsVORequestResultBean.getComments());
                            } else {
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
