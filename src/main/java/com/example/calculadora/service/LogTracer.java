package com.example.calculadora.service;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class LogTracer {

    private TracerImpl tracerImpl;

    public LogTracer() {
        this.tracerImpl = new TracerImpl();
    }

    private TracerImpl getTracerImpl() {
        return tracerImpl == null ? tracerImpl = new TracerImpl() : tracerImpl;
    }

    public void logEvent(String messageToLog) {
        getTracerImpl().trace(messageToLog);
    }
}