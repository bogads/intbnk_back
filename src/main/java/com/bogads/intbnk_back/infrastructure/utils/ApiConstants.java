package com.bogads.intbnk_back.infrastructure.utils;

public final class ApiConstants {
    private ApiConstants() {
    }

    public static final String API_V1 = "/api/v1";
    public static final String API_V1_COMPANIES = API_V1 + "/companies";
    public static final String API_V1_BANK_TRANSFER = API_V1 + "/bank-transfers";
    public static final String API_V1_ACCOUNT = API_V1 + "/accounts";
    public static final String JOINED_LAST_MONTH = "/joined/last-month";
    public static final String TRANSFER_LAST_MONTH = "/transfer/last-month";
}
