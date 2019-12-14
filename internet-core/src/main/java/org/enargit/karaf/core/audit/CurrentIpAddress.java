package org.enargit.karaf.core.audit;

public class CurrentIpAddress {

    public static final CurrentIpAddress INSTANCE = new CurrentIpAddress();

    private static final ThreadLocal<String> storage = new ThreadLocal<>();

    public void logIn(String ipAdress) {
        storage.set(ipAdress);
    }

    public void logOut() {
        storage.remove();
    }

    public String get() {
        return storage.get();
    }

    private CurrentIpAddress() {
        this.logIn("127.0.0.1");
    }
}
