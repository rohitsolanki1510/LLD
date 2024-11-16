package com.parkinglot;

import com.parkinglot.enums.GateType;
import com.parkinglot.enums.OperationalStatus;
import com.parkinglot.enums.SpotStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.*;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.service.TicketService;
import com.parkinglot.strategy.FindFirstSpotAllotmentStrategy;
import com.parkinglot.strategy.HourlyPricingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ParkinglotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkinglotApplication.class, args);
		System.out.println("Parking Lot!");
		Attendant attendant1=new Attendant("Baburao Ganpatrao Apte","10001");
		Attendant attendant2=new Attendant("Anuradha Laxmi","10002");

		Gate gate1= new Gate("1", GateType.ENTRY_GATE, OperationalStatus.OPEN,attendant1);
		Gate gate2 = new Gate("2", GateType.ENTRY_GATE, OperationalStatus.OPEN,attendant2);

		Floor floor1 = new Floor("B1");

		for(int i=1; i<=10; i++) {
			floor1.getParkingSpots().add(
					new ParkingSpot(String.valueOf(i), SpotStatus.VACANT, VehicleType.FOUR_WHEELER,floor1.getName()));
		}

		Floor floor2 = new Floor("B2");

		for(int i=1; i<=10; i++) {
			floor1.getParkingSpots().add(
					new ParkingSpot(String.valueOf(i), SpotStatus.VACANT,VehicleType.TWO_WHEELER,floor2.getName()));
		}

		ArrayList<Floor> floors = new ArrayList<Floor>();
		floors.add(floor1);
		floors.add(floor2);
		ArrayList<Gate> gates = new ArrayList<Gate>();
		gates.add(gate1);
		gates.add(gate2);

		ParkingLot parkingLot = new ParkingLot("Phoenix", floors, gates, OperationalStatus.OPEN,new HourlyPricingStrategy(),
				new FindFirstSpotAllotmentStrategy());


		GateRepository gateRepository = new GateRepository();
		gateRepository.getGateDB().put(gate1.getGateNumber(), gate1); //saving the gate in db
		gateRepository.getGateDB().put(gate2.getGateNumber(), gate2); //saving the gate in db

		ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
		parkingLotRepository.getParkingLotMap().put(parkingLot.getName(), parkingLot);//saving the parkinglot in db


		TicketService ticketService=new TicketService();

	}

}
