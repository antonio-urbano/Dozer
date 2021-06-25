package processors;

import engine.SeraphQueryParser;

import java.util.Date;

public class AAA {

    public static void main(final String[] args){

        System.out.println(new Date(1624456200000L));
        SeraphQueryParser parser = new SeraphQueryParser();
        parser.parseQuery();

    }
}
