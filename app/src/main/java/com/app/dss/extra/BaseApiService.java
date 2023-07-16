package com.app.dss.extra;



import com.app.dss.data.Commondata;
import com.app.dss.data.Complaintdata;
import com.app.dss.data.Eventdata;
import com.app.dss.data.Expensedata;
import com.app.dss.data.Incomedata;
import com.app.dss.data.MMdata;
import com.app.dss.data.Memberdata;
import com.app.dss.data.Notidata;
import com.app.dss.data.UMdata;
import com.app.dss.data.Udata;
import com.app.dss.data.Visitordata;
import com.app.dss.data.WLdata;
import com.app.dss.data.Wingdata;
import com.app.dss.data.Workerdata;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface BaseApiService {
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Udata> dssloginRequest(@Field("dss_app") String dss_app,
                                @Field("u_data") String u_data);
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Eventdata> dsseventRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Notidata> dssnotiRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Workerdata> dssworkerRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Complaintdata> dsscomplaintRequest(@Field("dss_app") String dss_app,
                                            @Field("u_data") String u_data);
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Commondata> dssaddcomplaintRequest(@Field("dss_app") String dss_app,
                                            @Field("u_data") String u_data);
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Visitordata> dssvisitorRequest(@Field("dss_app") String dss_app,
                                        @Field("u_data") String u_data);
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Incomedata> dssincomeRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Expensedata> dssexpenseRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<MMdata> dssMMRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<UMdata> dssUMRequest(@Field("dss_app") String dss_app,
                              @Field("u_data") String u_data);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Wingdata> dssWingRequest(@Field("dss_app") String dss_app);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Memberdata> dssMemberRequest(@Field("dss_app") String dss_app,
                                      @Field("u_data") String u_data);
    @FormUrlEncoded
    @POST("dss_api.php")
    Call<WLdata> dssWLRequest(@Field("dss_app") String dss_app,
                              @Field("u_data") String u_data);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Commondata> dssaddvisitorRequest(@Field("dss_app") String dss_app,
                              @Field("u_data") String u_data);

    @FormUrlEncoded
    @POST("dss_api.php")
    Call<Commondata> dsspaymRequest(@Field("dss_app") String dss_app,
                                          @Field("u_data") String u_data);


}
