package hack.sheremetievo.navigator.config;

import hack.sheremetievo.navigator.model.Path;
import hack.sheremetievo.navigator.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/paths")
@RestController
public class PathController {

    @Autowired
    private PathService service;

    @GetMapping
    public ResponseEntity<?> getPath(@RequestBody Path.PathId points){
        return ResponseEntity.ok(service.findById(points).get());
    }

}
