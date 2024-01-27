package DesignPattern.StructuralDP;

import java.util.HashMap;
import java.util.Map;

// Subject Interface
interface WebPage {
    void display();
}

// RealSubject - ActualWebPage
class ActualWebPage implements WebPage {
    private String url;

    public ActualWebPage(String url) {
        this.url = url;
        loadPageFromServer();
    }

    private void loadPageFromServer() {
        System.out.println("Loading web page from server: " + url);
        // Simulate loading the web page content from the server
    }

    public void display() {
        System.out.println("Displaying web page: " + url);
        // Display the web page content
    }
}

// Proxy - WebPageProxy
class WebPageProxy implements WebPage {
    private Map<String, ActualWebPage> pageCache = new HashMap<>();
    private String url;

    public WebPageProxy(String url) {
        this.url = url;
    }

    public void display() {
        if (!pageCache.containsKey(url)) {
            ActualWebPage actualWebPage = new ActualWebPage(url);
            pageCache.put(url, actualWebPage);
        }

        ActualWebPage cachedPage = pageCache.get(url);
        cachedPage.display();
    }
}

// Client Code
public class Proxy {
    public static void main(String[] args) {
        // Using RealSubject directly
        WebPage actualWebPage = new ActualWebPage("https://example.com");
        actualWebPage.display();

        System.out.println("---------------------------------------------------");

        // Using Proxy
        System.out.println("Proxy gives same o/p as Real: ");
        WebPage webPageProxy = new WebPageProxy("https://example.com");
        webPageProxy.display();
    }
}

/*
 Explanation:

    The WebPage interface is the common interface for both ActualWebPage (RealSubject) and WebPageProxy (Proxy).
    ActualWebPage represents the real web page, and it loads the page content from the server when instantiated.
    WebPageProxy is the proxy that controls access to the real web page. It caches the web page and displays it without reloading if it's already in the cache.
    The client code demonstrates using both the real subject and the proxy to display web pages.
    */
