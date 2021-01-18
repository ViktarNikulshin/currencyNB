package com.pst.currency.models;

import lombok.Data;


@Data
public class RateShort {
    private String Cur_ID;
    private String Date;
    private Double Cur_OfficialRate;
}
