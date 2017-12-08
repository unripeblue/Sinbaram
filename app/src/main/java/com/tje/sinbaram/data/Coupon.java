package com.tje.sinbaram.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-12-01.
 */

public class Coupon implements Serializable {
    private int id;
    private Calendar limitDay;
    private String couponName;

}
