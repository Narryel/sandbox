package ru.narryel.sandbox.configuration

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class Metrics(private val meterRegistry: MeterRegistry) {

    //  why adds total?
    val testControllerRequestCounter = meterRegistry.counter("test-controller-request-count")
}