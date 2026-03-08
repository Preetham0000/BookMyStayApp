package com.manager;

import java.util.Scanner;

import com.model.Service;
import com.service.AddOnServiceService;

/**
 * @author: Preetham
 * @version: 5.0
 */
public class ServiceManager {

    private AddOnServiceService addOnServiceService;

    public ServiceManager(AddOnServiceService service) {
        this.addOnServiceService = service;
    }

    public void addServiceToReservation(Scanner scanner) {

        System.out.print("Enter Reservation ID (Room ID): ");
        String reservationId = scanner.nextLine();

        System.out.println("Select Service");
        System.out.println("1 Breakfast (₹500)");
        System.out.println("2 Spa (₹2000)");
        System.out.println("3 Airport Pickup (₹1000)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Service service = null;

        switch(choice) {

            case 1:
                service = new Service("Breakfast", 500);
                break;

            case 2:
                service = new Service("Spa", 2000);
                break;

            case 3:
                service = new Service("Airport Pickup", 1000);
                break;

            default:
                System.out.println("Invalid service");
                return;
        }

        addOnServiceService.addService(reservationId, service);
    }

    public void viewReservationServices(Scanner scanner) {

        System.out.print("Enter Reservation ID: ");
        String reservationId = scanner.nextLine();

        addOnServiceService.viewServices(reservationId);
    }
}