package hack.sheremetievo.navigator.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Point {
    @SerializedName("\"x\"")
    private BigDecimal x;
    @SerializedName("\"y\"")
    private BigDecimal y;
    @SerializedName("\"type\"")
    private String type;

    public Point(BigDecimal x, BigDecimal y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
