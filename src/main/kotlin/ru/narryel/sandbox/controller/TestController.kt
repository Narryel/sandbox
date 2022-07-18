package ru.narryel.sandbox.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.narryel.sandbox.configuration.Metrics

@RestController
@RequestMapping("test")
class TestController(
    private val metrics: Metrics,
) {

    @GetMapping
    fun getHello(): String {
        metrics.testControllerRequestCounter.increment()
        val count = metrics.testControllerRequestCounter.count()
        return "Hello $count"
    }
}