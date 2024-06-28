package BehaviouralDP_CCMMSSO;

// Real-World Analogy of State Design Pattern //

// Imagine a traffic light as a robot. It has different moods like “Stop” (Red), “Get Ready” (Yellow), and “Go” (Green).

// The robot changes its mood based on the time or if cars are waiting.
// When it’s “Stop”, cars stop, and people can walk. When it’s “Get Ready”,
//  it’s about to change. And when it’s “Go”, cars can drive.
// This setup makes it easy to add new moods or 
// change how the robot behaves without messing up everything else.
//  So, it’s like having a robot traffic light that knows when to stop, get ready, or go!
// Scene 2==========================
// Imagine a vending machine that sells various products.
//  The vending machine needs to manage different states such as ready to serve,
//   waiting for product selection, processing payment, and handling out-of-stock situations. 
// Design a system that models the behavior of this vending machine efficiently.

interface VendingMachineState {
    void handleRequest();
}

class ReadyState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Ready state: Please select a product.");
    }
}

class ProductSelectedState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Product selected state: Processing payment.");
    }
}

class PaymentPendingState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Payment pending state: Dispensing product.");
    }
}

class OutOfStockState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Out of stock state: Product unavailable. Please select another product.");
    }
}

class VendingMachineContext {
    private VendingMachineState state;

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}

public class StateDP {
    public static void main(String[] args) {
        // Create context
        VendingMachineContext vendingMachine = new VendingMachineContext();

        // Set initial state
        vendingMachine.setState(new ReadyState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new ProductSelectedState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new PaymentPendingState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new OutOfStockState());

        // Request state change
        vendingMachine.request();
    }
}
