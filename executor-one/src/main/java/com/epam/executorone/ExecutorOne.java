package com.epam.executorone;

import org.springframework.web.bind.annotation.GetMapping;

public interface ExecutorOne {
    @GetMapping("give")
    String give();
}
