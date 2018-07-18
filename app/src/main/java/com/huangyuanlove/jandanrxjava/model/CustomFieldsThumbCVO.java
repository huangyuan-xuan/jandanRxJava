package com.huangyuanlove.jandanrxjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HuangYuan on 2017/8/15.
 */

public class CustomFieldsThumbCVO implements Parcelable {

    @SerializedName("thumb_c")
    private List<String> thumbC;

    public List<String> getThumbC() {
        return thumbC;
    }

    public void setThumbC(List<String> thumbC) {
        this.thumbC = thumbC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.thumbC);
    }

    public CustomFieldsThumbCVO() {
    }

    protected CustomFieldsThumbCVO(Parcel in) {
        this.thumbC = in.createStringArrayList();
    }

    public static final Creator<CustomFieldsThumbCVO> CREATOR = new Creator<CustomFieldsThumbCVO>() {
        @Override
        public CustomFieldsThumbCVO createFromParcel(Parcel source) {
            return new CustomFieldsThumbCVO(source);
        }

        @Override
        public CustomFieldsThumbCVO[] newArray(int size) {
            return new CustomFieldsThumbCVO[size];
        }
    };
}
