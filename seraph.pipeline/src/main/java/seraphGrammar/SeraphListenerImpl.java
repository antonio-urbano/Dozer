package seraphGrammar;

import org.apache.commons.lang3.StringUtils;
import org.openseraph.antrl4.SeraphBaseListener;
import org.openseraph.antrl4.SeraphParser;

import java.time.Duration;
import java.time.Instant;

public class SeraphListenerImpl extends SeraphBaseListener {

    private Query query;
    private String queryID;
    private String inputStream;
    private String outputStream;
    private Start windowStart;
    private Range windowRange;
    private StreamOperator streamOperator;
    private Range reportRange;
    private String cypherQuery;

    @Override
    public void exitOS_RegisterQuery(SeraphParser.OS_RegisterQueryContext ctx) {
        this.query = new RegisterQuery(
                this.queryID,
                new SeraphQuery(
                        this.inputStream,
                        this.outputStream,
                        new Window(this.windowStart, this.windowRange),
                        new Report(this.streamOperator, this.reportRange),
                        this.cypherQuery
                )
        );
    }

    @Override
    public void exitOS_UnregisterQuery(SeraphParser.OS_UnregisterQueryContext ctx) {
        this.query = new UnregisterQuery(this.queryID);
    }

    @Override
    public void exitOS_QueryID(SeraphParser.OS_QueryIDContext ctx) {
        this.queryID = StringUtils.substringBetween(ctx.IRIREF().getText(), "<", ">");
    }

    @Override
    public void exitOS_S2R_InputStream(SeraphParser.OS_S2R_InputStreamContext ctx) {
        this.inputStream = StringUtils.substringBetween(ctx.oS_Stream().IRIREF().getText(), "<", ">");
    }

    @Override
    public void exitOS_R2S_OutputStream(SeraphParser.OS_R2S_OutputStreamContext ctx) {
        this.outputStream = StringUtils.substringBetween(ctx.oS_Stream().IRIREF().getText(), "<", ">");
    }

    @Override
    public void exitOS_S2R_EventRange(SeraphParser.OS_S2R_EventRangeContext ctx) {
        this.windowRange = new EventRange(Long.parseLong(ctx.oS_EventRange().EVENTS().getText()));
    }

    @Override
    public void exitOS_S2R_TimeRange(SeraphParser.OS_S2R_TimeRangeContext ctx) {
        this.windowRange = new TimeRange(Duration.parse(ctx.oS_TimeRange().getText()));
    }

    @Override
    public void exitOS_S2R_StartLatest(SeraphParser.OS_S2R_StartLatestContext ctx) {
        this.windowStart = new EventStart(Event.Latest);
    }

    @Override
    public void exitOS_S2R_StartEarliest(SeraphParser.OS_S2R_StartEarliestContext ctx) {
        this.windowStart = new EventStart(Event.Earliest);
    }

    @Override
    public void exitOS_S2R_StartTimeInstant(SeraphParser.OS_S2R_StartTimeInstantContext ctx) {
        this.windowStart = new TimeStart(Instant.parse(ctx.getText()));
    }

    @Override
    public void exitOS_R2R(SeraphParser.OS_R2RContext ctx) {
        this.cypherQuery = ctx.getText();
    }


    @Override
    public void exitOS_R2S_EventRange(SeraphParser.OS_R2S_EventRangeContext ctx) {
        this.reportRange = new EventRange(Long.parseLong(ctx.oS_EventRange().oC_IntegerLiteral().getText()));
    }

    @Override
    public void exitOS_R2S_TimeRange(SeraphParser.OS_R2S_TimeRangeContext ctx) {
        this.reportRange = new TimeRange(Duration.parse(ctx.oS_TimeRange().getText()));
    }

    @Override
    public void exitOS_R2S_ReportOnEntering(SeraphParser.OS_R2S_ReportOnEnteringContext ctx) {
        this.streamOperator = StreamOperator.IStream;
    }

    @Override
    public void exitOS_R2S_ReportOnExit(SeraphParser.OS_R2S_ReportOnExitContext ctx) {
        this.streamOperator = StreamOperator.DStream;
    }

    @Override
    public void exitOS_R2S_ReportSnapshot(SeraphParser.OS_R2S_ReportSnapshotContext ctx) {
        this.streamOperator = StreamOperator.RStream;
    }

    public Query getSeraphQuery() {
        return this.query;
    }
}
