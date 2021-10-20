package system;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.util.Config;
import seraphGrammar.Query;
import seraphGrammar.SeraphQuery;

import java.io.IOException;
import java.util.Arrays;

public class KubernetesClient {
    private static final String NAMESPACE = "default";

    public static void apply(Query query) throws ApiException, IOException {
        try {
            switch (query.getQueryType()) {
                case REGISTER:
                    createDeploy(query);
                    break;
                case UNREGISTER:
                    deleteDeploy(query);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createDeploy(Query query) throws IOException, ApiException {
        System.out.println("CREATE");
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1Pod pod2 =
                new V1Pod()
                        .metadata(new V1ObjectMeta().name("ciao"))
                        .spec(
                                new V1PodSpec()
                                        .containers(Arrays.asList(new V1Container().name("prova").image("ealen/echo-server"))));

        api.createNamespacedPod(NAMESPACE, pod2, null, null, null);
    }

    private static void deleteDeploy(Query query) throws IOException, ApiException {
        System.out.println("DELETE");

        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();

        api.deleteNamespacedPod("ciao", NAMESPACE, null, null,100,false,null, null);
    }
}
