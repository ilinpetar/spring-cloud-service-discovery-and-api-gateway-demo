package net.ddns.ilinpetar.servicea;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import java.net.URI;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceTwoController {

    private final EurekaClient eurekaClient;

    private static final Logger log = LoggerFactory.getLogger(ServiceTwoController.class);

    public ServiceTwoController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> greeting() {
        log.info("++++++++++++ Service Two Greeting endpoint ++++++++++++");

        // get reference to random service-one instance
        InstanceInfo serviceOne = eurekaClient
            .getApplication("service-one")
            .getInstances()
            .getFirst();

        // invoke service-one info endpoint
        URI url = URI.create("http://" + serviceOne.getHostName() + ":" + serviceOne.getPort() + "/greeting");
        Map response = new RestTemplate().getForObject(url, Map.class);
        assert response != null;

        // find its own instance identifier
        var instanceId = eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();
        return Map.of("message", "hello", "service", instanceId, "greeting", response);
    }
}
