package system;

import io.kubernetes.client.openapi.ApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seraphGrammar.Query;
import seraphGrammar.SeraphQueryParser;

import java.io.IOException;

@RestController
public class QueryController {

    @PostMapping(value = "/", consumes = "text/plain", produces = "application/json")
    public void postQuery(@RequestBody String command) throws IOException, ApiException {
        System.out.println(command);
        Query query = SeraphQueryParser.parse(command);
        KubernetesClient.apply(query);
    }
}
