package com.huangyuanlove.jandanrxjava.http;

import com.huangyuanlove.jandanrxjava.model.GirlPicsVO;
import com.huangyuanlove.jandanrxjava.model.JokeVO;
import com.huangyuanlove.jandanrxjava.model.NewsDetailBean;
import com.huangyuanlove.jandanrxjava.model.NewsVO;
import com.huangyuanlove.jandanrxjava.model.PicsVO;
import com.huangyuanlove.jandanrxjava.model.RequestResultBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    /**
     * 妹子图列表
     * @param pageNumber 页码
     * @return Observable<RequestResultBean<GirlPicsVO>>
     */
    @GET("?oxwlxojflwblxbsapi=jandan.get_ooxx_comments")
    Observable<RequestResultBean<GirlPicsVO>> getGirlPicsList(@Query("page") int pageNumber);


    /**
     * 段子列表
     * @param pageNumber 页码
     * @return Observable<RequestResultBean<JokeVO>>
     */
    @GET("?oxwlxojflwblxbsapi=jandan.get_duan_comments")
    Observable<RequestResultBean<JokeVO>> getJokeList(@Query("page") int pageNumber);


    /**
     * 新鲜事列表
     * @param pageNumber 页码
     * @return Observable<RequestResultBean<NewsVO>>
     */
    @GET("?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&custom_fields=thumb_c,views&dev=1")
    Observable<RequestResultBean<NewsVO>> getNewsList(@Query("page") int pageNumber);

    /**
     * 新鲜事详情
     * @param id 新鲜事id
     * @return Observable<NewsDetailBean>
     */
    @GET("?oxwlxojflwblxbsapi=get_post&include=content,date,modified")
    Observable<NewsDetailBean> getNewsDetail(@Query("id") int id);


    /**
     * 无聊图列表
     * @param page 页码
     * @return Observable<RequestResultBean<PicsVO>>
     */
    @GET("?oxwlxojflwblxbsapi=jandan.get_pic_comments")
    Observable<RequestResultBean<PicsVO>> getPicsList(@Query("page") int page);


    /**
     * 无聊图投票
     * @param option 赞成或反对
     * @param id 无聊图id
     * @return Observable<ResponseBody>
     */
    @POST("index.php?acv_ajax=true")
    Observable<ResponseBody> votePic(@Query("option") int option, @Field("ID") String id);
}
