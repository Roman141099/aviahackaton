package hack.sheremetievo.navigator.model;

import com.google.gson.*;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PathJsonConverter implements AttributeConverter<JsonElement, Object> {

    @Override
    public Object convertToDatabaseColumn(JsonElement attribute) {
        return attribute.toString();
    }

    @Override
    public JsonElement convertToEntityAttribute(Object dbData) {
        return new Gson().fromJson(dbData.toString(), JsonElement.class);
    }
}
