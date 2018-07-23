package com.huangyuanlove.jandanrxjava.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.databinding.ItemPicsBinding;
import com.huangyuanlove.jandanrxjava.model.PicsVO;

import java.util.List;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public class PicsAdapter extends RecyclerView.Adapter<PicsAdapter.ViewHolder>{

    private List<PicsVO> lists;
    private LayoutInflater inflater;
    private OnItemClick onItemClick;
    public PicsAdapter(Context context, List<PicsVO> lists) {
        this.lists = lists;
        this.inflater = LayoutInflater.from(context);
    }

    public void setLists(List<PicsVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }
    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPicsBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_pics,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setPicsVO(lists.get(position));
        holder.getBinding().getRoot().setTag(position);
        holder.getBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return lists == null?0:lists.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemPicsBinding binding;
        public ViewHolder(ItemPicsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.oo.setOnClickListener(this);
            binding.xx.setOnClickListener(this);
        }

        public ItemPicsBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemPicsBinding binding) {
            this.binding = binding;
        }

        @Override
        public void onClick(View v) {
            if(onItemClick!=null){
            }
        }
    }
  public  interface OnItemClick{
    }
}
