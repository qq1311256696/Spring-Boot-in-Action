package hys.mongodb.utils;

import org.bson.*;

import java.util.Date;
import java.util.UUID;

public class BsonTool {
    public static BsonValue object2BsonValue(Object obj) {
        if (obj instanceof Integer)
            return new BsonInt32((Integer) obj);

        if (obj instanceof String)
            return new BsonString((String) obj);

        if (obj instanceof Long)
            return new BsonInt64((Long) obj);

        if (obj instanceof Date)
            return new BsonInt64(((Date) obj).getTime());

        return new BsonNull();
    }

    /**
     * uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
