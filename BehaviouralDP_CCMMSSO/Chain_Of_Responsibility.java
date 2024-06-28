package BehaviouralDP_CCMMSSO;

import java.util.Arrays;
import java.util.List;

// Request Class
class Request {
    private String ipAddress;
    private String username;
    private String password;
    private String twoFactorCode;

    public Request(String ipAddress, String username, String password, String twoFactorCode) {
        this.ipAddress = ipAddress;
        this.username = username;
        this.password = password;
        this.twoFactorCode = twoFactorCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTwoFactorCode() {
        return twoFactorCode;
    }
}

// Handler Interface
interface Handler {
    void setNextHandler(Handler nextHandler);

    void handleRequest(Request request);
}

// IP Filtering Handler
class IPFilteringHandler implements Handler {
    private Handler nextHandler;
    private List<String> allowedIPs = Arrays.asList("192.168.1.1", "192.168.1.2");

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (allowedIPs.contains(request.getIpAddress())) {
            System.out.println("IP Filtering passed.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("IP Filtering failed. Access denied.");
        }
    }
}

// User-Password Authentication Handler
class UserPassAuthHandler implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if ("user".equals(request.getUsername()) && "pass".equals(request.getPassword())) {
            System.out.println("User-Password Authentication passed.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("User-Password Authentication failed. Access denied.");
        }
    }
}

// Two-Factor Authentication Handler
class TwoFactorAuthHandler implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if ("123456".equals(request.getTwoFactorCode())) {
            System.out.println("Two-Factor Authentication passed.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("Connected to DB.");
            }
        } else {
            System.out.println("Two-Factor Authentication failed. Access denied.");
        }
    }
}

// Main Class
public class Chain_Of_Responsibility {
    public static void main(String[] args) {
        // Create handlers
        Handler ipFilterHandler = new IPFilteringHandler();
        Handler userPassAuthHandler = new UserPassAuthHandler();
        Handler twoFactorAuthHandler = new TwoFactorAuthHandler();

        // Set the chain of responsibility
        ipFilterHandler.setNextHandler(userPassAuthHandler);
        userPassAuthHandler.setNextHandler(twoFactorAuthHandler);

        // Create a request
        Request request = new Request("192.168.1.1", "user", "pass", "123456");

        // Pass the request through the chain
        ipFilterHandler.handleRequest(request);
    }
}
