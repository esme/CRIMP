package rocks.crimp.crimp.network;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rocks.crimp.crimp.network.model.CategoriesJs;
import rocks.crimp.crimp.network.model.ClearActiveJs;
import rocks.crimp.crimp.network.model.GetScoreJs;
import rocks.crimp.crimp.network.model.HeaderBean;
import rocks.crimp.crimp.network.model.HelpMeJs;
import rocks.crimp.crimp.network.model.LoginJs;
import rocks.crimp.crimp.network.model.LogoutJs;
import rocks.crimp.crimp.network.model.PathBean;
import rocks.crimp.crimp.network.model.PostScoreJs;
import rocks.crimp.crimp.network.model.QueryBean;
import rocks.crimp.crimp.network.model.ReportJs;
import rocks.crimp.crimp.network.model.RequestBean;
import rocks.crimp.crimp.network.model.RequestBodyJs;
import rocks.crimp.crimp.network.model.SetActiveJs;

/**
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 */
public class CrimpWsImpl implements CrimpWS {
    public static final String BASEURL = "http://dev.crimp.rocks/";
    private final RetrofitWs webService;

    public CrimpWsImpl(String baseUrl){
        /*
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.MINUTES)
                .connectTimeout(60, TimeUnit.MINUTES)
                .build();
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                //.client(client)
                .build();
        webService = retrofit.create(RetrofitWs.class);
    }

    @Override
    public CategoriesJs getCategories() throws IOException {
        Call<CategoriesJs> call = webService.getCategories();
        return call.execute().body();
    }

    @Override
    public GetScoreJs getScore(RequestBean requestBean) throws IOException {
        QueryBean query = requestBean.getQueryBean();
        HeaderBean header = requestBean.getHeaderBean();

        Call<GetScoreJs> call = webService.getScore(query.getClimberId(), query.getCategoryId(),
                query.getRouteId(), query.getMarkerId(), header.getxUserId(),
                header.getxAuthToken());
        return call.execute().body();
    }

    @Override
    public SetActiveJs setActive(RequestBean requestBean) throws IOException {
        HeaderBean header = requestBean.getHeaderBean();
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<SetActiveJs> call = webService.setActive(header.getxUserId(),
                header.getxAuthToken(), requestBodyJs.getRouteId(), requestBodyJs.getMarkerId());
        return call.execute().body();
    }

    @Override
    public ClearActiveJs clearActive(RequestBean requestBean) throws IOException {
        HeaderBean header = requestBean.getHeaderBean();
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<ClearActiveJs> call = webService.clearActive(header.getxUserId(),
                header.getxAuthToken(), requestBodyJs.getRouteId());
        return call.execute().body();
    }

    @Override
    public LoginJs login(RequestBean requestBean) throws IOException {
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<LoginJs> call = webService.login(requestBodyJs.getFbAccessToken());
        return call.execute().body();
    }

    @Override
    public ReportJs reportIn(RequestBean requestBean) throws IOException {
        HeaderBean header = requestBean.getHeaderBean();
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<ReportJs> call = webService.reportIn(header.getxUserId(), header.getxAuthToken(),
                requestBodyJs.getCategoryId(), requestBodyJs.getRouteId(),
                requestBodyJs.isForceReport());
        return call.execute().body();
    }

    @Override
    public HelpMeJs requestHelp(RequestBean requestBean) throws IOException {
        HeaderBean header = requestBean.getHeaderBean();
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<HelpMeJs> call = webService.requestHelp(header.getxUserId(),
                header.getxAuthToken(), requestBodyJs.getRouteId());
        return call.execute().body();
    }

    @Override
    public PostScoreJs postScore(RequestBean requestBean) throws IOException {
        PathBean path = requestBean.getPathBean();
        HeaderBean header = requestBean.getHeaderBean();
        RequestBodyJs requestBodyJs = requestBean.getRequestBodyJs();

        Call<PostScoreJs> call = webService.postScore(path.getRouteId(), path.getMarkerId(),
                header.getxUserId(), header.getxAuthToken(), requestBodyJs.getScoreString());
        return call.execute().body();
    }

    @Override
    public LogoutJs logout(RequestBean requestBean) throws IOException {
        HeaderBean header = requestBean.getHeaderBean();

        Call<LogoutJs> call = webService.logout(header.getxUserId(),
                header.getxAuthToken());
        return call.execute().body();
    }

    /*
    @Override
    public boolean getCategoriesAsync(Callback<CategoriesJs> callback){
        Call<CategoriesJs> call = webService.getCategories();
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean getScoreAsync(Callback<GetScoreJs> callback, @Nullable Long climberId,
                                 @Nullable Long categoryId, @Nullable Long routeId,
                                 @Nullable String markerId, @NonNull String fbUserId,
                                 @NonNull String fbAccessToken, long sequentialToken){
        Call<GetScoreJs> call = webService.getScore(climberId, categoryId, routeId, markerId,
                fbUserId, fbAccessToken, sequentialToken);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean setActiveAsync(Callback<SetActiveJs> callback, @NonNull String fbUserId,
                                  @NonNull String fbAccessToken, long sequentialToken, long routeId,
                                  long climberId){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setRouteId(routeId);
        requestBodyJs.setClimberId(climberId);
        Call<SetActiveJs> call = webService.setActive(fbUserId, fbAccessToken, sequentialToken,
                requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean clearActiveAsync(Callback<ClearActiveJs> callback, @NonNull String fbUserId,
                                    @NonNull String fbAccessToken, long sequentialToken, long routeId){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setRouteId(routeId);
        Call<ClearActiveJs> call = webService.clearActive(fbUserId, fbAccessToken, sequentialToken,
                requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean loginAsync(Callback<LoginJs> callback, @NonNull String fbUserId,
                              @NonNull String fbAccessToken, boolean forceLogin){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setFbUserId(fbUserId);
        requestBodyJs.setFbAccessToken(fbAccessToken);
        requestBodyJs.setForceLogin(forceLogin);
        Call<LoginJs> call = webService.login(requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean reportInAsync(Callback<ReportJs> callback, @NonNull String fbUserId,
                                 @NonNull String fbAccessToken, long sequentialToken,
                                 long categoryId, long routeId, boolean force){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setCategoryId(categoryId);
        requestBodyJs.setRouteId(routeId);
        requestBodyJs.setForceReport(force);
        Call<ReportJs> call = webService.reportIn(fbUserId, fbAccessToken, sequentialToken,
                requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean requestHelpAsync(Callback<HelpMeJs> callback, @NonNull String fbUserId,
                                    @NonNull String fbAccessToken, long sequentialToken, long routeId){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setRouteId(routeId);
        Call<HelpMeJs> call = webService.requestHelp(fbUserId, fbAccessToken, sequentialToken,
                requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean postScoreAsync(Callback<PostScoreJs> callback, long routeId, long climberId,
                                  @NonNull String fbUserId, @NonNull String fbAccessToken,
                                  long sequentialToken, @NonNull String score){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setScoreString(score);
        Call<PostScoreJs> call = webService.postScore(routeId, climberId, fbUserId, fbAccessToken,
                sequentialToken, requestBodyJs);
        call.enqueue(callback);
        return true;
    }

    @Override
    public boolean logoutAsync(Callback<LogoutJs> callback, @NonNull String fbUserId,
                               @NonNull String fbAccessToken, long sequentialToken){
        RequestBodyJs requestBodyJs = new RequestBodyJs();
        requestBodyJs.setFbUserId(fbUserId);
        requestBodyJs.setFbAccessToken(fbAccessToken);
        requestBodyJs.setSequentialToken(sequentialToken);
        Call<LogoutJs> call = webService.logout(requestBodyJs);
        call.enqueue(callback);
        return true;
    }
    */

    private interface RetrofitWs{
        @GET("api/judge/categories")
        Call<CategoriesJs> getCategories();

        @GET("api/judge/score")
        Call<GetScoreJs> getScore(@Query("climber_id") @Nullable String climberId,
                                  @Query("category_id") @Nullable String categoryId,
                                  @Query("route_id") @Nullable String routeId,
                                  @Query("marker_id") @Nullable String markerId,
                                  @Header("X-User-Id") String xUserId,
                                  @Header("X-Auth-Token") String xAuthToken);

        @FormUrlEncoded
        @PUT("api/judge/setactive")
        Call<SetActiveJs> setActive(@Header("X-User-Id") String xUserId,
                                    @Header("X-Auth-Token") String xAuthToken,
                                    @Field("route_id") String routeId,
                                    @Field("marker_id") String markerId);

        @FormUrlEncoded
        @PUT("api/judge/clearactive")
        Call<ClearActiveJs> clearActive(@Header("X-User-Id") String xUserId,
                                        @Header("X-Auth-Token") String xAuthToken,
                                        @Field("route_id") String routeId);

        @FormUrlEncoded
        @POST("api/judge/login")
        Call<LoginJs> login(@Field("fb_access_token") String fbAccessToken);

        @FormUrlEncoded
        @POST("api/judge/report")
        Call<ReportJs> reportIn(@Header("X-User-Id") String xUserId,
                                @Header("X-Auth-Token") String xAuthToken,
                                @Field("category_id") String categoryId,
                                @Field("route_id") String routeId,
                                @Field("force") boolean force);

        @FormUrlEncoded
        @POST("api/judge/helpme")
        Call<HelpMeJs> requestHelp(@Header("X-User-Id") String xUserId,
                                   @Header("X-Auth-Token") String xAuthToken,
                                   @Field("route_id") String routeId);

        @FormUrlEncoded
        @POST("api/judge/score/{route_id}/{marker_id}")
        Call<PostScoreJs> postScore(@Path("route_id") String routeId,
                                    @Path("marker_id") String markerId,
                                    @Header("X-User-Id") String xUserId,
                                    @Header("X-Auth-Token") String xAuthToken,
                                    @Field("score_string") String scoreString);

        @POST("api/judge/logout")
        Call<LogoutJs> logout(@Header("X-User-Id") String xUserId,
                              @Header("X-Auth-Token") String xAuthToken);
    }
}
