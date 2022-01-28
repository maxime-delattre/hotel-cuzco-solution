package org.hotel.cuzco;

public class Room {

    public Result addBooking(int i) {
        if (i == 1) {
            return Result.failed();
        }

        if (i == 2) {
            return Result.failed();
        }

        return Result.ok();
    }
}
