package hack.sheremetievo.navigator.repository;

import hack.sheremetievo.navigator.model.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface PathRepository extends JpaRepository<Path, Path.PathId> {
}
