package com.huangyuanlove.jandanrxjava.fragment;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.glide.GlideApp;
import com.huangyuanlove.jandanrxjava.model.PicsVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public class PicsAdapter extends RecyclerView.Adapter<PicsAdapter.ViewHolder> {

    private List<PicsVO> lists;
    private LayoutInflater inflater;
    private OnItemClick onItemClick;
    private Context context;

    public PicsAdapter(Context context, List<PicsVO> lists) {
        this.context = context;
        this.lists = lists;
        this.inflater = LayoutInflater.from(context);
    }

    public void setLists(List<PicsVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_pics, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PicsVO vo = lists.get(position);
        holder.commentAuthor.setText(vo.getCommentAuthor());
        holder.commentDateGmt.setText(vo.getCommentDateGmt());
        holder.textContent.setText(vo.getTextContent());
        holder.oo.setText("OO " + vo.getVotePositive());
        holder.xx.setText("XX " +vo.getVoteNegative());
        holder.commentCount.setText("吐槽 " + vo.getSubCommentCount());
        String imageUrl  = vo.getPics()==null?"":vo.getPics().get(0);
        if (imageUrl.toLowerCase().endsWith("gif")) {
            GlideApp.with(context)
                    .asGif()
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)

                    .into(holder.image);
        } else {
            GlideApp.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.comment_author)
        TextView commentAuthor;
        @BindView(R.id.comment_date_gmt)
        TextView commentDateGmt;
        @BindView(R.id.text_content)
        TextView textContent;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.oo)
        TextView oo;
        @BindView(R.id.xx)
        TextView xx;
        @BindView(R.id.comment_count)
        TextView commentCount;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    public interface OnItemClick {
    }


}
