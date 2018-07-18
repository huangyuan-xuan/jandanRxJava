package com.huangyuanlove.jandanrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huangyuan on 2017/8/15.
 */

public class GirlPicsVO {


    /**
     * comment_ID : 3536015
     * comment_post_ID : 21183
     * comment_author : 考据党
     * comment_author_email : pphn@yeah.net
     * comment_author_url :
     * comment_author_IP : 113.46.78.252
     * comment_date : 2017-08-15 20:56:53
     * comment_date_gmt : 2017-08-15 12:56:53
     * comment_content : <img src="http://wx3.sinaimg.cn/mw600/005VghJvly1fikpelf85yj30go0m8wg6.jpg" />
     * comment_karma : 0
     * comment_approved : 1
     * comment_agent : Jandan Android App V4.3.1.1;eyJzaWduIjoiZDg5ZmQzOTI3MDUxZDY3MzdkOGMxNjUyMmVhNDc2ZWIifQ==
     * comment_type :
     * comment_parent : 0
     * user_id : 0
     * comment_subscribe : N
     * comment_reply_ID : 0
     * vote_positive : 14
     * vote_negative : 3
     * vote_ip_pool :
     * sub_comment_count : 1
     * text_content :
     * pics : ["http://wx3.sinaimg.cn/mw600/005VghJvly1fikpelf85yj30go0m8wg6.jpg"]
     */


    @SerializedName("comment_author")
    private String commentAuthor;

    @SerializedName("comment_date_gmt")
    private String commentDateGmt;

    @SerializedName("vote_positive")
    private String votePositive;

    @SerializedName("vote_negative")
    private String voteNegative;

    @SerializedName("sub_comment_count")
    private String subCommentCount;

    @SerializedName("text_content")
    private String textContent;

    private List<String> pics;

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(String commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public String getVotePositive() {
        return votePositive;
    }

    public void setVotePositive(String votePositive) {
        this.votePositive = votePositive;
    }

    public String getVoteNegative() {
        return voteNegative;
    }

    public void setVoteNegative(String voteNegative) {
        this.voteNegative = voteNegative;
    }

    public String getSubCommentCount() {
        return subCommentCount;
    }

    public void setSubCommentCount(String subCommentCount) {
        this.subCommentCount = subCommentCount;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }
}
