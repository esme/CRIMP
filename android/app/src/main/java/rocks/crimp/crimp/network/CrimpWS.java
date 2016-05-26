package rocks.crimp.crimp.network;

import java.io.IOException;

import rocks.crimp.crimp.network.model.CategoriesJs;
import rocks.crimp.crimp.network.model.ClearActiveJs;
import rocks.crimp.crimp.network.model.GetScoreJs;
import rocks.crimp.crimp.network.model.HelpMeJs;
import rocks.crimp.crimp.network.model.LoginJs;
import rocks.crimp.crimp.network.model.LogoutJs;
import rocks.crimp.crimp.network.model.PostScoreJs;
import rocks.crimp.crimp.network.model.ReportJs;
import rocks.crimp.crimp.network.model.RequestBean;
import rocks.crimp.crimp.network.model.SetActiveJs;

/**
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 */
public interface CrimpWS {
    CategoriesJs getCategories() throws IOException;

    GetScoreJs getScore(RequestBean requestBean) throws IOException;

    SetActiveJs setActive(RequestBean requestBean) throws IOException;

    ClearActiveJs clearActive(RequestBean requestBean) throws IOException;

    LoginJs login(RequestBean requestBean) throws IOException;

    ReportJs reportIn(RequestBean requestBean) throws IOException;

    HelpMeJs requestHelp(RequestBean requestBean) throws IOException;

    PostScoreJs postScore(RequestBean requestBean) throws IOException;

    LogoutJs logout(RequestBean requestBean) throws IOException;

    /*
    boolean getCategoriesAsync(Callback<CategoriesJs> callback);

    boolean getScoreAsync(Callback<GetScoreJs> callback, @Nullable Long climberId,
                          @Nullable Long categoryId, @Nullable Long routeId,
                          @Nullable String markerId, @NonNull String fbUserId,
                          @NonNull String fbAccessToken, long sequentialToken);

    boolean setActiveAsync(Callback<SetActiveJs> callback, @NonNull String fbUserId,
                           @NonNull String fbAccessToken, long sequentialToken, long routeId,
                           long climberId);

    boolean clearActiveAsync(Callback<ClearActiveJs> callback, @NonNull String fbUserId,
                             @NonNull String fbAccessToken, long sequentialToken, long routeId);

    boolean loginAsync(Callback<LoginJs> callback, @NonNull String fbUserId,
                       @NonNull String fbAccessToken, boolean forceLogin);

    boolean reportInAsync(Callback<ReportJs> callback, @NonNull String fbUserId,
                          @NonNull String fbAccessToken, long sequentialToken, long categoryId,
                          long routeId, boolean force);

    boolean requestHelpAsync(Callback<HelpMeJs> callback, @NonNull String fbUserId,
                             @NonNull String fbAccessToken, long sequentialToken, long routeId);

    boolean postScoreAsync(Callback<PostScoreJs> callback, long routeId, long climberId,
                           @NonNull String fbUserId, @NonNull String fbAccessToken,
                           long sequentialToken, @NonNull String score);

    boolean logoutAsync(Callback<LogoutJs> callback, @NonNull String fbUserId,
                        @NonNull String fbAccessToken, long sequentialToken);
    */
}
