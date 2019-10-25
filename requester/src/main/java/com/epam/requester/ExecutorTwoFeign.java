package com.epam.requester;

import com.epam.executortwo.ExecutorTwo;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("executor-two")
public interface ExecutorTwoFeign extends ExecutorTwo {
}
