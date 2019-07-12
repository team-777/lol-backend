package org.ajou.realcoding.lolbackend.lolbackend.config.domain;

import lombok.Data;

@Data
public class LeagueV4 {

    private String queueType;
    private String summonerName;
    private Boolean hotStreak;
    private int wins;
    private Boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private Boolean inactive;
    private Boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;

}
