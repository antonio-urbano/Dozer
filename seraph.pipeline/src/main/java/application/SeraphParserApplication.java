package application;

import engine.SeraphQueryParser;

import java.util.Date;

//todo javadoc
public class SeraphParserApplication {

    public static void main(final String[] args){
        SeraphQueryParser parser = new SeraphQueryParser();
        parser.parseQuery();

    }
}
