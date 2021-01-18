package com.pst.currency.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Currency {
    private String name;
    private String abbreviation;
    private Integer code;
    private String startDate;
    private String endDate;
}
