package by.gutich.busstop;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static by.gutich.busstop.InputReaderWriter.*;

public class Main {

    public static void main(String[] args) {

        Comparator<Bus> comparatorBusByDepartureTime = Comparator.comparing(Bus::getDepartureTime);

        List<Bus> busList = inputReader().filter(b -> Duration.between(b.getDepartureTime(), b.getArrivalTime()).toHours() <= 1)
                .sorted(comparatorBusByDepartureTime)
                .collect(Collectors.toList());

        int i = busList.size() - 1;
        // LocalTime implement comparable, so no need to use Duration

        while (i > 0) {
            if (Duration.between(busList.get(i).getDepartureTime(), busList.get(i - 1).getDepartureTime()).toMinutes() == 0
                    && Duration.between(busList.get(i).getArrivalTime(), busList.get(i - 1).getArrivalTime()).toMinutes() < 0) {
                busList.remove(i - 1);
                i--;
            } else if (Duration.between(busList.get(i).getDepartureTime(), busList.get(i - 1).getDepartureTime()).toMinutes() < 0
                    && Duration.between(busList.get(i).getArrivalTime(), busList.get(i - 1).getArrivalTime()).toMinutes() == 0) {
                busList.remove(i - 1);
                i--;
            } else if (Duration.between(busList.get(i).getDepartureTime(), busList.get(i - 1).getDepartureTime()).toMinutes() < 0
                    && Duration.between(busList.get(i).getArrivalTime(), busList.get(i - 1).getArrivalTime()).toMinutes() > 0) {
                busList.remove(i - 1);
                i--;
            } else if (Duration.between(busList.get(i).getDepartureTime(), busList.get(i - 1).getDepartureTime()).toMinutes() == 0
                    && Duration.between(busList.get(i).getArrivalTime(), busList.get(i - 1).getArrivalTime()).toMinutes() == 0) {
                if (busList.get(i - 1).getBusCompany().equals(POSH)) {
                    busList.remove(i);
                } else busList.remove(i - 1);
                i--;
            } else i--;
        }
        outputWriter(busList);
    }
}
