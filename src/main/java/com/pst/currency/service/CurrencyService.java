package com.pst.currency.service;

import com.pst.currency.models.Currency;
import com.pst.currency.models.RateShort;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyService {
    List<RateShort> setCurrency(Currency currency);
}
