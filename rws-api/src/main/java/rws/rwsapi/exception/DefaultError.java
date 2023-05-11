package rws.rwsapi.exception;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DefaultError {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("timestamp", timestamp);
        object.put("status", status);
        object.put("error", error);
        object.put("message", message);
        object.put("path", path);
        return object.toString();
    }
}
