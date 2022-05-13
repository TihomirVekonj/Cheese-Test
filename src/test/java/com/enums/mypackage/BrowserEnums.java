package com.enums.mypackage;

public enum BrowserEnums {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge"),
        SAFARI("safari"),
        EDGE_HEADLESS("edge_headless"),
        CHROME_HEADLESS("chrome_headless"),
        FIREFOX_HEADLESS("firefox_headless");


        public final String stringBrowser;

        BrowserEnums(String stringBrowser) {
                this.stringBrowser=stringBrowser;
        }

        public String toString() {
                return stringBrowser;
        }
}
