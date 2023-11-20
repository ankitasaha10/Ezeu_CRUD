import java.io.Serializable;
import java.lang.reflect.Field;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "data")
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    private String name;
    private String address;
    private String phoneNo;

    public void removeAttribute(String attribute) {
        try {
            Field field = getClass().getDeclaredField(attribute);
            field.set(this, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException("Unknown attribute: " + attribute);
        }
    }
}
