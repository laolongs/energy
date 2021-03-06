package tties.cn.energy.api;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tties.cn.energy.model.result.Loginbean;
import tties.cn.energy.model.result.Opsbean;
import tties.cn.energy.model.result.Versionbean;


public interface Api {


    // login请求方法
    @POST("login.htm")
    @FormUrlEncoded
    Observable<Loginbean> getLogin(@FieldMap Map<String,Object> map);
    //版本号请求方法
    @POST("getUpdateVersion.htm")
    Observable<Versionbean> getVersion();
    //Ops问题接口
    @POST("queryQuertionAction.do")
    @FormUrlEncoded
    Observable<Opsbean> getOps(@FieldMap Map<String,Object> map);
//    //获取订单计划详情
//    @POST(Content.PAGE_DETAILS)
//    Observable<ConfirmBean> getDetatlsData(@Query("id") int id);
//    //获取用户地址
//    @POST(Content.USER_ADDRESS)
//    Observable<ReceiptInformationBean> getAdderssData();
//    //登录
//    @POST(Content.LANDING)
//    Observable<LandingBean> getLandData(@Query("username") String username,
//                                        @Query("password") String password);



}
