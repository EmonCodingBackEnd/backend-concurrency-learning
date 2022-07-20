package com.coding.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {

    ExecutorService executorService = Executors.newCachedThreadPool();

    // ab -n 1000 -c 50 http://localhost:8080/test
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/asyncTest")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deferredResult.setResult("Hello Async Request");
        });
        return deferredResult;
    }

}