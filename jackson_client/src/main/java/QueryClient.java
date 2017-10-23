import com.srh.server.QueryException;
import com.srh.server.QueryResult;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;


public class QueryClient {

    public QueryResult runQuery(String expression, int limit, int offset) throws QueryException {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client
                .resource(String.format("http://localhost:8080/jackson_server/rest/v1/queryImplController/runQuery" +
                        "?expression=%s&limit=%d&offset=%d", expression, limit, offset));
        QueryResult res = null;
        try {
            res = webResource.type(MediaType.APPLICATION_JSON_TYPE).get(QueryResult.class);
        } catch (UniformInterfaceException e) {
            System.out.println(e.getMessage());
            throw e.getResponse().getEntity(QueryException.class);
        }
        return res;
    }

    public static void main(String[] args) throws QueryException {
        // Successful case
        System.out.print(new QueryClient().runQuery("name:*", 100, 10).toString());
        // Exception case
        System.out.print(new QueryClient().runQuery("name:*", 10000, 10).toString());
    }
}