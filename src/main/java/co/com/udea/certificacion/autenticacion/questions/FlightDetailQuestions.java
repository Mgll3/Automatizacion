package co.com.udea.certificacion.autenticacion.questions;

import co.com.udea.certificacion.autenticacion.models.FlightDetail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FlightDetailQuestions {

    public static class FlightDepartureTime implements Question<String> {
        private final FlightDetail flightDetail;

        public FlightDepartureTime(FlightDetail flightDetail) {
            this.flightDetail = flightDetail;
        }

        @Override
        public String answeredBy(Actor actor) {
            return flightDetail.getDepartureTime();
        }

        public static Question<String> of(FlightDetail flightDetail) {
            return new FlightDepartureTime(flightDetail);
        }
    }

    public static class FlightArrivalTime implements Question<String> {
        private final FlightDetail flightDetail;

        public FlightArrivalTime(FlightDetail flightDetail) {
            this.flightDetail = flightDetail;
        }

        @Override
        public String answeredBy(Actor actor) {
            return flightDetail.getArrivalTime();
        }

        public static Question<String> of(FlightDetail flightDetail) {
            return new FlightArrivalTime(flightDetail);
        }
    }

    public static class FlightPrice implements Question<String> {
        private final FlightDetail flightDetail;

        public FlightPrice(FlightDetail flightDetail) {
            this.flightDetail = flightDetail;
        }

        @Override
        public String answeredBy(Actor actor) {
            return flightDetail.getPrice();
        }

        public static Question<String> of(FlightDetail flightDetail) {
            return new FlightPrice(flightDetail);
        }
    }

    public static class FlightStops implements Question<String> {
        private final FlightDetail flightDetail;

        public FlightStops(FlightDetail flightDetail) {
            this.flightDetail = flightDetail;
        }

        @Override
        public String answeredBy(Actor actor) {
            return flightDetail.getStops();
        }

        public static Question<String> of(FlightDetail flightDetail) {
            return new FlightStops(flightDetail);
        }
    }
}

