package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonPair extends Tuple<String, Json>{
    public JsonPair(String name, Json value) {
        super(name, value);
    }

    public String toJson(){
        String toReturn = "";
        toReturn += "'" + key + "'" + ": " + value.toJson();
        return toReturn;
    }

//    public static void main(String[] args) {
//        JsonPair pair = new JsonPair("Surname", new JsonString("Rodionov"));
//        System.out.println(pair.toJson());
//    }
}