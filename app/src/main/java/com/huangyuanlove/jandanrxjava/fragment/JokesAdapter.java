package com.huangyuanlove.jandanrxjava.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.databinding.ItemJokesBinding;
import com.huangyuanlove.jandanrxjava.model.JokeVO;

import java.util.List;


public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {

    private List<JokeVO> lists;
    private LayoutInflater inflater;

    public JokesAdapter(Context context, List<JokeVO> lists) {
        this.lists = lists;
        this.inflater = LayoutInflater.from(context);
    }

    public void setLists(List<JokeVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemJokesBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_jokes, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setJoke(lists.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemJokesBinding binding;

        public ViewHolder(ItemJokesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemJokesBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemJokesBinding binding) {
            this.binding = binding;
        }
    }
}
