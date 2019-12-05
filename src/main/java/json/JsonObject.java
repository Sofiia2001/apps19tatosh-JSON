package json;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private JsonPair[] jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

    public boolean isEmpty(){
        return jsonPairs.length == 0;
    }

    @Override
    public String toJson() {
        if (isEmpty()) {
            return "{}";
        }
        String toReturn = "{";
        for (int i = 0; i < jsonPairs.length - 1; i++){
            toReturn += jsonPairs[i].toJson() + ", ";
        }
        toReturn += jsonPairs[jsonPairs.length - 1].toJson() + "}";
        return toReturn;
    }

    public void add(JsonPair jsonPair) {
        boolean sameName = false;
        for (int i = 0; i < jsonPairs.length; i++) {
            if (jsonPairs[i].key.equals(jsonPair.key)){
                jsonPairs[i] = jsonPair;
                sameName = true;
            }
        }
        if (!sameName){
            jsonPairs = Arrays.copyOf(jsonPairs, jsonPairs.length + 1);
            jsonPairs[jsonPairs.length - 1] = jsonPair;
        }
    }

    public Json find(String name) {
        for (int i = 0; i < jsonPairs.length; i++) {
            if (jsonPairs[i].key.equals(name)) {
                return jsonPairs[i].value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject toReturn = new JsonObject();
        for (int j = 0; j < names.length; j++){
            for (int i = 0; i < jsonPairs.length; i++) {
                if (names[j].equals(jsonPairs[i].key)){
                    toReturn.add(jsonPairs[i]);
                }
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        JsonObject obj = new JsonObject(new JsonPair("name", new JsonString("Andrii")));
        System.out.println(obj.toJson());
        JsonPair pair = new JsonPair("Surname", new JsonString("Rodionov"));
        obj.add(pair);
        System.out.println(obj.toJson());


    }
}
