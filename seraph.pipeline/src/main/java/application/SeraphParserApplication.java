package application;

import engine.SeraphQueryParser;

import java.util.Date;

public class SeraphParserApplication {

    public static void main(final String[] args){
        SeraphQueryParser parser = new SeraphQueryParser();
        parser.parseQuery();

    }
}
