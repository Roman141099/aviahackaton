package hack.sheremetievo.navigator.service;

import hack.sheremetievo.navigator.model.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathService extends JpaRepository<Path, Path.PathId> {

}
