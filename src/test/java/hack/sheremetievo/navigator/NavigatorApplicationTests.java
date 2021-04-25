package hack.sheremetievo.navigator;

import hack.sheremetievo.navigator.model.Path;
import hack.sheremetievo.navigator.model.Point;
import hack.sheremetievo.navigator.model.PointsJsonConverter;
import hack.sheremetievo.navigator.repository.PathRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.*;
@SpringBootTest
class NavigatorApplicationTests {

    @Autowired
    PathRepository service;
    @Autowired
    EntityManagerFactory factory;

    @Test
    void testJson(){
        System.out.println(service.findPathByInitialPoints(new Path.InitialPoints()));
    }
}
