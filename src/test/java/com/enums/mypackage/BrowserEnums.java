package com.enums.mypackage;

public enum BrowserEnums {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge"),
        SAFARI("safari");


        public final String stringBrowser;

        BrowserEnums(String stringBrowser) {
                this.stringBrowser=stringBrowser;
        }

        public String toString() {
                return stringBrowser;
        }
}
