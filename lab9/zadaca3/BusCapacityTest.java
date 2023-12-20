package zadaca3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BusRides {
    String time;
    int passengersChange;

    public BusRides(String time, int passengersChange) {
        this.time = time;
        this.passengersChange = passengersChange;
    }
}

public class BusCapacityTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        List<BusRides> rides = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] times = br.readLine().split(" ");
            String boardTime = times[0];
            String exitTime = times[1];

            rides.add(new BusRides(boardTime, 1));
            rides.add(new BusRides(exitTime, -1));
        }

        rides.sort(Comparator.comparing(event -> event.time));

        int currentPassengers = 0;

        for (BusRides ride : rides) {
            currentPassengers += ride.passengersChange;

            if (currentPassengers > capacity) {
                System.out.println("false");
                br.close();
                return;
            }
        }

        System.out.println("true");
        br.close();
    }
}
