package com.huangyuanlove.jandanrxjava.fragment;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huangyuanlove.jandanrxjava.R;
import com.huangyuanlove.jandanrxjava.glide.GlideApp;
import com.huangyuanlove.jandanrxjava.model.JokeVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {

    private List<JokeVO> lists;
    private LayoutInflater inflater;
    private Context context;
    public JokesAdapter(Context context, List<JokeVO> lists) {
        this.context = context;
        this.lists = lists;
        this.inflater = LayoutInflater.from(context);
    }

    public void setLists(List<JokeVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_jokes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JokeVO vo = lists.get(position);
        holder.commentAuthor.setText(vo.getCommentAuthor());
        holder.commentDateGmt.setText(vo.getCommentDateGmt());
        holder.commentContent.setText(vo.getCommentContent());
        holder.OO.setText("OO "+ vo.getVotePositive());
        holder.XX.setText("XX " + vo.getVoteNegative());
        holder.subCommentCount.setText("吐槽 " + vo.getSubCommentCount());

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
        @BindView(R.id.comment_content)
        TextView commentContent;
        @BindView(R.id.OO)
        TextView OO;
        @BindView(R.id.XX)
        TextView XX;
        @BindView(R.id.sub_comment_count)
        TextView subCommentCount;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }


    }


}
