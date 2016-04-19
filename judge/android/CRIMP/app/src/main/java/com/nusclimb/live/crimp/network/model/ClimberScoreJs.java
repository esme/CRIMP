package com.nusclimb.live.crimp.network.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 */
public class ClimberScoreJs implements Serializable{
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonProperty("climber_id")
    private long climberId;
    @JsonProperty("climber_name")
    private String climberName;
    @JsonProperty("scores")
    private ArrayList<ScoreJs> scores;

    public long getClimberId() {
        return climberId;
    }

    public void setClimberId(long climberId) {
        this.climberId = climberId;
    }

    public String getClimberName() {
        return climberName;
    }

    public void setClimberName(String climberName) {
        this.climberName = climberName;
    }

    public ArrayList<ScoreJs> getScores() {
        return scores;
    }

    public void setScores(ArrayList<ScoreJs> scores) {
        this.scores = scores;
    }
}
