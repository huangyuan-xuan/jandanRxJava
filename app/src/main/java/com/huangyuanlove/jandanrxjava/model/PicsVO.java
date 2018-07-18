package com.huangyuanlove.jandanrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public class PicsVO {

    @SerializedName("comment_ID")
    private String commentID;

    @SerializedName("comment_author")
    private String commentAuthor;

    @SerializedName("comment_author_IP")
    private String commentAuthorIP;

    @SerializedName("vote_positive")
    private String votePositive;

    @SerializedName("vote_negative")
    private String voteNegative;

    @SerializedName("sub_comment_count")
    private String subCommentCount;

    @SerializedName("text_content")
    private String textContent;

    @SerializedName("comment_date_gmt")
    private String commentDateGmt;
    private List<String> pics;

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentAuthorIP() {
        return commentAuthorIP;
    }

    public void setCommentAuthorIP(String commentAuthorIP) {
        this.commentAuthorIP = commentAuthorIP;
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

    public String getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(String commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }
}
