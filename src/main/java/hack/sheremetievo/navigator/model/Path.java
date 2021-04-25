package hack.sheremetievo.navigator.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paths")
@Data
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private InitialPoints initialPoints;

    @Convert(converter = PointsJsonConverter.class)
    private List<Point> points;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "types",
            joinColumns = @JoinColumn(name = "path_id"))
    @Column(name = "type")
    private List<String> types = new ArrayList<>();

    @Embeddable
    @Data
    public static class InitialPoints implements Serializable {
        @Column(name = "id_1")
        private String id1;
        @Column(name = "id_2")
        private String id2;

        public InitialPoints() {
        }

        public InitialPoints(String id1, String id2) {
            this.id1 = id1;
            this.id2 = id2;
        }
    }
}
