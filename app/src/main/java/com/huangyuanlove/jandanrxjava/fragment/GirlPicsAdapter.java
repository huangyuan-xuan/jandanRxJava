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
import com.huangyuanlove.jandanrxjava.model.GirlPicsVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangyuan on 2017/8/15.
 */

public class GirlPicsAdapter extends RecyclerView.Adapter<GirlPicsAdapter.ViewHolder> {
    private List<GirlPicsVO> lists;
    private LayoutInflater inflater;
    private Context context;

    public GirlPicsAdapter(Context context, List<GirlPicsVO> lists) {
        this.context = context;
        this.lists = lists;
        inflater = LayoutInflater.from(context);
    }

    public void setLists(List<GirlPicsVO> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_girl_pics, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GirlPicsVO vo = lists.get(position);
        holder.commentAuthor.setText(vo.getCommentAuthor());
        holder.commentDateGmt.setText(vo.getCommentDateGmt());
        holder.textContent.setText(vo.getTextContent());
        holder.OO.setText("OO " + vo.getVotePositive());
        holder.XX.setText("XX " + vo.getVoteNegative());
        holder.commentNumber.setText("吐槽 " + vo.getSubCommentCount());
        String imageUrl = vo.getPics() == null ? "" : vo.getPics().get(0);
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
        @BindView(R.id.OO)
        TextView OO;
        @BindView(R.id.XX)
        TextView XX;
        @BindView(R.id.comment_number)
        TextView commentNumber;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }


}
