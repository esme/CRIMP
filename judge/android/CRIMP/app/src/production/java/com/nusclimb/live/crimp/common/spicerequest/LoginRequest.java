package com.nusclimb.live.crimp.common.spicerequest;

import com.nusclimb.live.crimp.network.model.LoginJackson;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Spice request for POST '/api/judge/login'
 *
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 */
public class LoginRequest extends SpringAndroidSpiceRequest<LoginJackson> {
    private static final String TAG = LoginRequest.class.getSimpleName();

    private String accessToken;
    // TODO: this field is present in the api doc. Talk to dw to ask him to remove this.
    private boolean isProductionApp = true;
    private String url;

    public LoginRequest(String accessToken, String url) {
        super(LoginJackson.class);
        this.accessToken = accessToken;
        this.url = url;
    }

    @Override
    public LoginJackson loadDataFromNetwork() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cache-Control", "no-cache");

        HttpBody body = new HttpBody(accessToken, isProductionApp);
        HttpEntity<HttpBody> request = new HttpEntity<>(body, headers);

        RestTemplate mRestTemplate = getRestTemplate();
        ResponseEntity<LoginJackson> response = mRestTemplate.exchange(url, HttpMethod.POST,
                request, LoginJackson.class);

        return response.getBody();
    }

    /**
     * Jackson POJO for Login request body.
     */
    private static class HttpBody {
        @JsonProperty("accessToken")
        private String accessToken;
        @JsonProperty("isProductionApp")
        private boolean isProductionApp;

        public HttpBody(String accessToken, boolean isProductionApp){
            this.accessToken = accessToken;
            this.isProductionApp = isProductionApp;
        }

        @Override
        public String toString(){
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String prettyString = null;
            try {
                prettyString = ow.writeValueAsString(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prettyString;
        }
    }
}