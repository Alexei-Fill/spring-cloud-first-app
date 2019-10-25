package com.epam.executortwo;

import com.epam.executorone.ExecutorOne;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("executor-one")
public interface FirstExecutorFeign extends ExecutorOne {
}
