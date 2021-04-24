package hack.sheremetievo.navigator.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.List;

import com.google.gson.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "paths")
@Data
public class Path {
    @EmbeddedId
    private PathId id;

    @Convert(converter = PointsJsonConverter.class)
    private List<Point> points;

    @Embeddable
    @Data
    public static class PathId implements Serializable {
        @Column(name = "point_a")
        private BigDecimal pointA;
        @Column(name = "point_b")
        private BigDecimal pointB;

        public PathId() {
        }

        public PathId(BigDecimal pointA, BigDecimal pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }
    }
}
