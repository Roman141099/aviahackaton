package hack.sheremetievo.navigator.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import com.google.gson.*;

@Entity
@Table(name = "paths")
@Data
public class Path {
    @EmbeddedId
    private PathId id;

    @Column(name = "path")
    private JsonElement obj;

    public PathId getId() {
        return id;
    }

    public void setId(PathId id) {
        this.id = id;
    }

    public JsonElement getObj() {
        return obj;
    }

    public void setObj(JsonElement obj) {
        this.obj = obj;
    }

    @Embeddable
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
