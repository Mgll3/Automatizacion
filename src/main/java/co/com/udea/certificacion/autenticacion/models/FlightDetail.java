package co.com.udea.certificacion.autenticacion.models;

public class FlightDetail {
    private String departureTime;
    private String arrivalTime;
    private String price;
    private String stops;

    public FlightDetail(String departureTime, String arrivalTime, String price, String stops) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.stops = stops;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getPrice() {
        return price;
    }

    public String getStops() {
        return stops;
    }

    @Override
    public String toString() {
        return "FlightDetail{" +
                "departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price='" + price + '\'' +
                ", stops='" + stops + '\'' +
                '}';
    }
}
