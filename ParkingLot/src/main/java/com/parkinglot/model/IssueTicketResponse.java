package com.parkinglot.model;

import com.parkinglot.enums.ResponseStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IssueTicketResponse {
    private ResponseStatus responseStatus;
    private String responseMessage;
    private Ticket ticket;
}
