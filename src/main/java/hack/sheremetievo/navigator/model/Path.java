package hack.sheremetievo.navigator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.List;

import com.google.gson.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "paths")
@Setter
@Getter
public class Path {
    @EmbeddedId
    private PathId id;

    @Convert(converter = PointsJsonConverter.class)
    private List<Point> points;

    @Embeddable
    @Data
    public static class PathId implements Serializable {
        @Column(name = "point_a_x")
        private BigDecimal pointAX;
        @Column(name = "point_a_y")
        private BigDecimal pointAY;
        @Column(name = "point_b_x")
        private BigDecimal pointBX;
        @Column(name = "point_b_y")
        private BigDecimal pointBY;

        public PathId() {
        }

        public PathId(BigDecimal pointAX, BigDecimal pointAY, BigDecimal pointBX, BigDecimal pointBY) {
            this.pointAX = pointAX;
            this.pointAY = pointAY;
            this.pointBX = pointBX;
            this.pointBY = pointBY;
        }
    }
}
