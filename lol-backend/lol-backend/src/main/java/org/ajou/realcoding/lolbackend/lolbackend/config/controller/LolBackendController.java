package org.ajou.realcoding.lolbackend.lolbackend.config.controller;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.SummonerV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.service.LolBackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LolBackendController {

    @Autowired
    LolBackendService lolBackendService;

    @GetMapping("/LOL-backend/SummonerId/BySummonerName/{summonerName}")
    public SummonerV4 getSummonerId(@PathVariable String summonerName) {
        return lolBackendService.getSummonerIdByName(summonerName);
    }

    @GetMapping("/LOL-backend/Performance/BySummonerId/{summonerId}")
    public LeagueV4 getPerformance(@PathVariable String summonerId){
        return lolBackendService.getPerformanceById(summonerId);
    }
}