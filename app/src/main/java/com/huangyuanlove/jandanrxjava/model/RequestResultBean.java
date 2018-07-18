package com.huangyuanlove.jandanrxjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestResultBean<T> {

    private String status;

    @SerializedName("current_page")
    private int currentPage;

    @SerializedName("total_comments")
    private int totalComments;

    @SerializedName("page_count")
    private int pageCount;

    private int count;
    private List<T> comments;
    private List<T> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getComments() {
        return comments;
    }

    public void setComments(List<T> comments) {
        this.comments = comments;
    }

    public List<T> getPosts() {
        return posts;
    }

    public void setPosts(List<T> posts) {
        this.posts = posts;
    }
}
