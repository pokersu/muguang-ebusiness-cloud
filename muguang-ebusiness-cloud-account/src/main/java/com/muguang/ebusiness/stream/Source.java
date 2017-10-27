package com.muguang.ebusiness.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Jason
 * @date 10/27/17 11:03 PM.
 */
public interface Source {

    String OUTPUT = "account";
    @Output(Source.OUTPUT)
    MessageChannel output();
}
