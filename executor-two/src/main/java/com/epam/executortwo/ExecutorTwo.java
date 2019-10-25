package com.epam.executortwo;

import org.springframework.web.bind.annotation.GetMapping;

public interface ExecutorTwo {
    @GetMapping("give")
    String give();
}
