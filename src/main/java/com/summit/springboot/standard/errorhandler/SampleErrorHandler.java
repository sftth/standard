package com.summit.springboot.standard.errorhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleErrorHandler {
    @GetMapping("/errorhandler")
    public String errorHandler() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();

        appError.setMessage("error.app.key");
        appError.setReason("no reason");

        return appError;
    }

}
