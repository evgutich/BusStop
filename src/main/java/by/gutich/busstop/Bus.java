package by.gutich.busstop;

import java.time.LocalTime;

public class Bus{

    private String busCompany;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    public Bus(String busCompany, LocalTime departureTime, LocalTime arrivalTime) {
        this.busCompany = busCompany;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getBusCompany() {
        return busCompany;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public static BusBuilder builder() {
        return new BusBuilder();
    }

    public static class BusBuilder {
        private String busCompany;
        private LocalTime departureTime;
        private LocalTime arrivalTime;

        public Bus build() {
            return new Bus(this.busCompany, this.departureTime, this.arrivalTime);
        }

        public BusBuilder busCompany(String company) {
            this.busCompany = company;
            return this;
        }

        public BusBuilder departureTime(String time) {
            this.departureTime = LocalTime.parse(time);
            return this;
        }

        public BusBuilder arrivalTime(String time) {
            this.arrivalTime = LocalTime.parse(time);
            return this;
        }
    }

    @Override
    public String toString() {
        return busCompany + ' ' +
                departureTime + ' ' +
                arrivalTime;
    }
}
