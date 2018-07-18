package com.huangyuanlove.jandanrxjava.model;

import com.google.gson.annotations.SerializedName;

public class JokeVO {
    @SerializedName("comment_ID")
    private String commentID;

    @SerializedName("comment_post_ID")
    private String commentPostID;

    @SerializedName("comment_author")
    private String commentAuthor;

    @SerializedName("comment_author_email")
    private String commentAuthorEmail;

    @SerializedName("comment_author_url")
    private String commentAuthorUrl;

    @SerializedName("comment_date")
    private String commentDate;

    @SerializedName("comment_date_gmt")
    private String commentDateGmt;

    @SerializedName("comment_content")
    private String commentContent;

    @SerializedName("comment_karma")
    private String commentKarma;

    @SerializedName("comment_approved")
    private String commentApproved;

    @SerializedName("comment_agent")
    private String commentAgent;

    @SerializedName("comment_type")
    private String commentType;

    @SerializedName("comment_parent")
    private String commentParent;

    @SerializedName("user_id")
    private String userID;

    @SerializedName("comment_subscribe")
    private String commentSubscribe;

    @SerializedName("comment_reply_ID")
    private String commentReplyID;

    @SerializedName("vote_positive")
    private String votePositive;

    @SerializedName("vote_negative")
    private String voteNegative;

    @SerializedName("vote_ip_pool")
    private String voteIPPool;

    @SerializedName("sub_comment_count")
    private String subCommentCount;

    @SerializedName("text_content")
    private String textContent;

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentPostID() {
        return commentPostID;
    }

    public void setCommentPostID(String commentPostID) {
        this.commentPostID = commentPostID;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(String commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(String commentKarma) {
        this.commentKarma = commentKarma;
    }

    public String getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(String commentParent) {
        this.commentParent = commentParent;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCommentSubscribe() {
        return commentSubscribe;
    }

    public void setCommentSubscribe(String commentSubscribe) {
        this.commentSubscribe = commentSubscribe;
    }

    public String getCommentReplyID() {
        return commentReplyID;
    }

    public void setCommentReplyID(String commentReplyID) {
        this.commentReplyID = commentReplyID;
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

    public String getVoteIPPool() {
        return voteIPPool;
    }

    public void setVoteIPPool(String voteIPPool) {
        this.voteIPPool = voteIPPool;
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
}
