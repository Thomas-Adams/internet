package org.enargit.karaf.core.audit;

public class CurrentUser {

    private static CurrentUser INSTANCE;

    private static ThreadLocal<String> storage;

    public void logIn(String username) {
        storage.set(username);
    }

    public void logOut() {
        storage.remove();
    }

    public String get() {
        return storage.get();
    }

    private CurrentUser() {
        this.logIn("tadams");
    }

    public synchronized static CurrentUser getInstance(){
        if (INSTANCE == null) {
            storage =  new ThreadLocal<>();
            INSTANCE = new CurrentUser();
        }
        return INSTANCE;
    }
}
