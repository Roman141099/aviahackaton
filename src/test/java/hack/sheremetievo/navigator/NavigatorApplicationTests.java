package hack.sheremetievo.navigator;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hack.sheremetievo.navigator.model.Path;
import hack.sheremetievo.navigator.service.PathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootTest
class NavigatorApplicationTests {

    @Autowired
    PathService service;
    @Autowired
    EntityManagerFactory factory;

    @Test
    void find() {
        Path p = service.findById(new Path.PathId(BigDecimal.valueOf(123), BigDecimal.valueOf(132))).get();
        System.out.println(p);
    }
}
