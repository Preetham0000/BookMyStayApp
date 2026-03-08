package com.manager;

import java.util.List;

import com.model.RoomDetails;
import com.service.SearchService;

/**
 * Acts as the controller for guest search operations.
 * Interacts with SearchService and displays results.
 *
 * @author Preetham	
 * @version 1.0
 */
public class SearchManager {

    private SearchService searchService;

    public SearchManager(SearchService searchService) {
        this.searchService = searchService;
    }

    public void displayAvailableRooms() {

        List<RoomDetails> rooms = searchService.searchAvailableRooms();

        if (rooms.isEmpty()) {
            System.out.println("No rooms available at the moment.");
            return;
        }

        System.out.println("\n======= Available Rooms =======");

        for (RoomDetails room : rooms) {

            System.out.println("Room Type : " + room.getRoomType());
            System.out.println("Price     : " + room.getPrice());
            System.out.println("Available : " + room.getAvailableCount());
            System.out.println("Amenities : " + room.getAmenities());
            System.out.println();
        }
    }
}