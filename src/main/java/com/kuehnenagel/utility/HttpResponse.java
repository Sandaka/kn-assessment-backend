package com.kuehnenagel.utility;

import com.kuehnenagel.entity.People;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 7/30/22
 */
@Data
@SuperBuilder
public class HttpResponse {

    protected int statusCode;

    protected HttpStatus status;

    protected String message;

    protected String timeStamp;

    protected Map<String, Page<People>> data;
}
