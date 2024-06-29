package BehaviouralDP_CCMMSSO;

// It defines how a mediator object facilitates the interaction between other objects, 
// guiding their behavior and communication without them being directly aware of each other.
//  This pattern emphasizes the behavior and communication patterns among objects.

// =========== Scene =============
// In an airport, there are multiple airplanes that need to communicate and 
// coordinate their movements to avoid collisions and ensure safe takeoffs and landings.
//  Without a centralized system,
//  direct communication between airplanes could lead to chaos and increased risk.

// Colleague Interface
interface Airplane {
    void requestTakeoff();

    void requestLanding();

    void notifyAirTrafficControl(String message);
}

// Concrete Colleague
class CommercialAirplane implements Airplane {
    private AirTrafficControlTower mediator;

    public CommercialAirplane(AirTrafficControlTower mediator) {
        this.mediator = mediator;
    }

    @Override
    public void requestTakeoff() {
        mediator.requestTakeoff(this);
    }

    @Override
    public void requestLanding() {
        mediator.requestLanding(this);
    }

    @Override
    public void notifyAirTrafficControl(String message) {
        System.out.println("Commercial Airplane: " + message);
    }
}

// Mediator Interface
interface AirTrafficControlTower {
    void requestTakeoff(Airplane airplane);

    void requestLanding(Airplane airplane);
}

// Concrete Mediator
class AirportControlTower implements AirTrafficControlTower {
    @Override
    public void requestTakeoff(Airplane airplane) {
        // Logic for coordinating takeoff
        airplane.notifyAirTrafficControl("Requesting takeoff clearance.");
    }

    @Override
    public void requestLanding(Airplane airplane) {
        // Logic for coordinating landing
        airplane.notifyAirTrafficControl("Requesting landing clearance.");
    }
}

// Main class
public class Mediator {
    public static void main(String[] args) {
        // Instantiate the Mediator (Airport Control Tower)
        AirTrafficControlTower controlTower = new AirportControlTower();

        // Instantiate Concrete Colleagues (Commercial Airplanes)
        Airplane airplane1 = new CommercialAirplane(controlTower);
        Airplane airplane2 = new CommercialAirplane(controlTower);

        // Set up the association between Concrete Colleagues and the Mediator
        airplane1.requestTakeoff();
        airplane2.requestLanding();

        // Output:
        // Commercial Airplane: Requesting takeoff clearance.
        // Commercial Airplane: Requesting landing clearance.
    }
}
