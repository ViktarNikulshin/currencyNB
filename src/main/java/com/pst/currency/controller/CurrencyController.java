package com.pst.currency.controller;

import com.pst.currency.models.Currency;
import com.pst.currency.models.RateShort;
import com.pst.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/select")
    public String selectCurrency( Model model){
        model.addAttribute("currency", new Currency());
        return "selectCurrency";
    }

    @PostMapping("/currency")
    public String getCurrencyService(@ModelAttribute(value = "currency") Currency currency, Model model) {
        List<RateShort> list = currencyService.setCurrency(currency);
        model.addAttribute("ratelist",list);
        model.addAttribute("currency",currency);
        return "currency";
    }
}
