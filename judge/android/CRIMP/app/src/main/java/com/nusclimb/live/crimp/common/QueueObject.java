package com.nusclimb.live.crimp.common;

import android.content.Context;

import com.nusclimb.live.crimp.common.spicerequest.PostScoreRequest;
import com.nusclimb.live.crimp.uploadlist.UploadStatus;

public class QueueObject {
    private PostScoreRequest request;
    private UploadStatus status;
    private String timeStamp;

    public QueueObject(String xUserId, String xAuthToken,
                       String r_id, String c_id, String currentScore, int msgId, Context context){
        // Time stamp
        this.timeStamp = Helper.getCurrentTimeStamp();

        // Status
        this.status = UploadStatus.PAUSED;

        // Score request
        this.request = new PostScoreRequest(xUserId, xAuthToken, r_id, c_id, currentScore, context);
    }

    public PostScoreRequest getRequest(){
        return request;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public UploadStatus getStatus(){
        return status;
    }

    public void setStatus(UploadStatus status){
        this.status = status;
    }
}