package com.huangyuanlove.jandanrxjava.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.glide.GlideApp;
import com.huangyuanlove.jandanrxjava.model.NewsVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangyuan on 2017/8/14.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsVO> lists;
    private LayoutInflater inflater;
    private Context context;

    public NewsAdapter(Context context, List<NewsVO> lists) {
        this.context = context;
        this.lists = lists;
        this.inflater = LayoutInflater.from(context);
    }

    public void setLists(List<NewsVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsVO vo = lists.get(position);
        holder.title.setText(vo.getTitle());
        holder.authName.setText(vo.getAuthor()==null?"":vo.getAuthor().getName());
        holder.date.setText(vo.getDate());
        holder.commentCount.setText("评论 " + vo.getCommentCount());
        String imageUrl = vo.getCustomFields()==null?"":vo.getCustomFields().getThumbC()==null?"":vo.getCustomFields().getThumbC().get(0);
        if (imageUrl.toLowerCase().endsWith("gif")) {
            GlideApp.with(context)
                    .asGif()
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(holder.image);
        } else {
            GlideApp.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.auth_name)
        TextView authName;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.comment_count)
        TextView commentCount;
        @BindView(R.id.image)
        ImageView image;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
