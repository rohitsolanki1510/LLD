package com.parkinglot.controller;

import com.parkinglot.enums.ResponseStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.exception.NotFoundException;
import com.parkinglot.exception.ParkingSpotNotAvailableException;
import com.parkinglot.model.IssueTicketRequest;
import com.parkinglot.model.IssueTicketResponse;
import com.parkinglot.model.Ticket;
import com.parkinglot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.parkinglot.constants.ResponseMessages.SUCCESS_RESPONSE_MSG;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    @PostMapping("/")
    public IssueTicketResponse issueTicket(@RequestBody IssueTicketRequest issueTicketRequest){
        try {
            Ticket ticket = ticketService.generateTicket(issueTicketRequest.getVehicleNumber(), VehicleType.valueOf(issueTicketRequest.getVehicleType()),
                    issueTicketRequest.getParkingLotNumber(), issueTicketRequest.getGateNumber());


            return IssueTicketResponse.builder()
                    .responseStatus(ResponseStatus.SUCCESS)
                    .responseMessage(SUCCESS_RESPONSE_MSG)
                    .ticket(ticket)
                    .build();
        }catch(NotFoundException | ParkingSpotNotAvailableException exception){
            return IssueTicketResponse.builder()
                    .responseStatus(ResponseStatus.FAILURE)
                    .responseMessage(exception.getMessage())
                    .ticket(null)
                    .build();
        }

    }
}
