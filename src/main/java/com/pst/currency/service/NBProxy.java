package com.pst.currency.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(value = "NB", url = "https://www.nbrb.by/api")
public interface NBProxy {
    @GetMapping(value = "/exrates/rates/dynamics/{id}", params = "startdate, enddate")
    public String setRatesById(@PathVariable("id") Integer id,
                               @RequestParam("startdate")String startDate,
                               @RequestParam("enddate")String endDate);
}
