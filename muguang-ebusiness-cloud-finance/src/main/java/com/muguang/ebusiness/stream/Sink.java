package com.muguang.ebusiness.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Jason
 * @date 10/27/17 11:03 PM.
 */
public interface Sink {
    String INPUT = "account";

    @Input(Sink.INPUT)
    SubscribableChannel input();
}
