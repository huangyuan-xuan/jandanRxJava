package com.huangyuanlove.jandanrxjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NewsVO implements Parcelable {
    private int id;
    private String title;
    private String excerpt;
    private AuthorVO author;

    @SerializedName("custom_fields")
    private CustomFieldsThumbCVO customFields;

    @SerializedName("comment_count")
    private int commentCount;
    private String  date;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public AuthorVO getAuthor() {
        return author;
    }

    public void setAuthorVO(AuthorVO author) {
        this.author = author;
    }

    public CustomFieldsThumbCVO getCustomFields() {
        return customFields;
    }

    public void setCustomFields(CustomFieldsThumbCVO customFields) {
        this.customFields = customFields;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.excerpt);
        dest.writeParcelable(this.author, flags);
        dest.writeParcelable(this.customFields, flags);
        dest.writeInt(this.commentCount);
        dest.writeString(this.date);
    }

    public NewsVO() {
    }

    protected NewsVO(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.excerpt = in.readString();
        this.author = in.readParcelable(AuthorVO.class.getClassLoader());
        this.customFields = in.readParcelable(CustomFieldsThumbCVO.class.getClassLoader());
        this.commentCount = in.readInt();
        this.date = in.readString();
    }

    public static final Creator<NewsVO> CREATOR = new Creator<NewsVO>() {
        @Override
        public NewsVO createFromParcel(Parcel source) {
            return new NewsVO(source);
        }

        @Override
        public NewsVO[] newArray(int size) {
            return new NewsVO[size];
        }
    };
}
