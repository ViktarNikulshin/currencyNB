package com.pst.currency.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pst.currency.models.Currency;
import com.pst.currency.models.RateShort;
import com.pst.currency.service.CurrencyService;
import com.pst.currency.service.NBProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final NBProxy nbProxy;
    @Override
    public List<RateShort> setCurrency(Currency currency) {
        switch (currency.getName()){
            case "Доллар США": {
                currency.setCode(145);
                break;
            }
            case "Российский рубль": {
                currency.setCode(298);
                break;
            }
            case "Евро": {
                currency.setCode(292);
                break;
            }
        }
        String str = nbProxy.setRatesById(currency.getCode(), currency.getStartDate(),currency.getEndDate());
        Gson gson = new Gson();
//        List<RateShort> listRate= new ArrayList<>();
        List<RateShort> list = gson.fromJson(str, new TypeToken<List<RateShort>>(){}.getType());
        list.stream().forEachOrdered((r) -> r.setDate(r.getDate().substring(0,10)));

            return list;
    }
}
