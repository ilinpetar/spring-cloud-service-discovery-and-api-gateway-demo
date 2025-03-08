package net.ddns.ilinpetar.servicea;

import com.netflix.discovery.EurekaClient;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

    private final EurekaClient eurekaClient;

    private static final Logger log = LoggerFactory.getLogger(ServiceOneController.class);

    public ServiceOneController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> greeting() {
        log.info("++++++++++++ Service One Greeting endpoint ++++++++++++");

        // find its own instance identifier
        var instanceId = eurekaClient.getApplicationInfoManager().getInfo().getInstanceId();
        return Map.of("message", "hello", "service", instanceId);
    }
}
