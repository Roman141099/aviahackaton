package hack.sheremetievo.navigator.controller;

import hack.sheremetievo.navigator.exception.PathNotFoundException;
import hack.sheremetievo.navigator.model.Path;
import hack.sheremetievo.navigator.repository.PathRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/paths")
@RestController
public class PathController {

    private final PathRepository service;

    public PathController(PathRepository service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getPath(@RequestBody Path.PathId points){
        return ResponseEntity.ok(service.findById(points).orElseThrow(()
                -> new PathNotFoundException("Path not found")));
    }

}
