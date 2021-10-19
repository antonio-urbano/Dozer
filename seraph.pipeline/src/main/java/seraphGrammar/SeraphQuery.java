package seraphGrammar;

public class SeraphQuery {
    private String inputStream;
    private String outputStream;
    private Window window;
    private Report report;
    private String cypherQuery;

    public SeraphQuery(String inputStream, String outputStream, Window window, Report report, String cypherQuery) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.window = window;
        this.report = report;
        this.cypherQuery = cypherQuery;
    }

    public String getInputStream() {
        return inputStream;
    }

    public String getOutputStream() {
        return outputStream;
    }

    public Window getWindow() {
        return window;
    }

    public Report getReport() {
        return report;
    }

    public String getCypherQuery() {
        return cypherQuery;
    }
}
