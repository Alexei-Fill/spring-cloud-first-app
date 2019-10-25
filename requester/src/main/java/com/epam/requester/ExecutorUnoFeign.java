package com.epam.requester;

import com.epam.executorone.ExecutorOne;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("executor-one")
public interface ExecutorUnoFeign extends ExecutorOne {
}
