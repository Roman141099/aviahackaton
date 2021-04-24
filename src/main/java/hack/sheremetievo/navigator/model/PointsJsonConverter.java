package hack.sheremetievo.navigator.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PointsJsonConverter implements AttributeConverter<List<Point>, Object> {
    @Override
    public Object convertToDatabaseColumn(List<Point> attribute) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(attribute);
    }

    @Override
    public List<Point> convertToEntityAttribute(Object dbData) {
        Type type = new TypeToken<List<Point>>(){}.getType();
        return new Gson().fromJson(dbData.toString(), type);
    }
}
