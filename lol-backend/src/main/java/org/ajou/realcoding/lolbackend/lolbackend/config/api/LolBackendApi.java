package org.ajou.realcoding.lolbackend.lolbackend.config.api;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.SummonerV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LolBackendApi {

    private final String api_key = "RGAPI-db474eb5-9bb0-43b9-a2f4-6cb8c8a2c9b8";
    private final String summonerV4Url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={api_key}";
    private final String leagueV4Url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{summonerId}?api_key={api_key}";

    @Autowired
    RestTemplate restTemplate;

    public SummonerV4 requestSummonerId(String summonerName){
        return restTemplate.exchange(summonerV4Url, HttpMethod.GET, null, SummonerV4.class, summonerName, api_key)
                .getBody();
    }

    public LeagueV4 requestPerformance(String summonerId){
        LeagueV4[] leagueV4s = restTemplate.exchange(leagueV4Url, HttpMethod.GET, null, LeagueV4[].class, summonerId, api_key)
                .getBody();
        return leagueV4s[0];
    }
}