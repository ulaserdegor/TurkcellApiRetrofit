package com.seyir.tcellapi.utils;
/*
 * Created by Ulas ERDEGOR on 17-Jan-17.
 */


import com.seyir.tcellapi.models.ResponseError;
import com.seyir.tcellapi.rest.APIModule;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {
    public static ResponseError parseError(Response<?> response) {
        Converter<ResponseBody, ResponseError> converter =
                APIModule.connectTcellAPI()
                        .responseBodyConverter(ResponseError.class, new Annotation[0]);

        ResponseError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ResponseError();
        }

        return error;
    }
}
