package com.parkinglot.repositories;

import com.parkinglot.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TicketRepository {
    private Map<String, Ticket> ticketMap = new HashMap<String, Ticket>();

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public Ticket createTicket(Ticket ticket) {
        ticketMap.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }
}
