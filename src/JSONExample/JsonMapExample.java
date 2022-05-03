package JSONExample;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapExample {

    public static void updateFieldInMappings(Map<String, Object> fields, String type, String formField) {

        if(type.equals("nested")){
            fields = (Map<String, Object>) fields.get(formField);
            fields.put("type", "nested");
        } else {
            
            if(!type.equals("delete")
                && !type.equals("doc")){
                if (type.startsWith("text")) {
                    String[] propeStrings = type.split("[(,)]");
                    Map<String, Object> keyword = new HashMap<>();
                    keyword.put("type", "keyword");
                    Map<String, Object> typeField = new HashMap<>();

                    if(propeStrings.length == 1){
                        keyword.put("ignore_above", 256);
                        typeField.put("keyword", keyword);                      
                    }
                    else{
                        if(propeStrings.length > 2){
                            keyword.put("ignore_above", Integer.parseInt(propeStrings[2]));
                        }
                        typeField.put(propeStrings[1], keyword);
                    }

                    Map<String, Object> typeConf = new HashMap<>();
                    typeConf.put("fields", typeField);
                    typeConf.put("type", "text");
                    fields.put(formField, typeConf);
                } else if (type.startsWith("keyword")) {
                    String[] propeStrings = type.split("[(,)]");
                    Map<String, Object> typeConf = new HashMap<>();
                    int ignore_above = 256;
                    if(propeStrings.length > 1){
                        ignore_above = Integer.parseInt(propeStrings[1]);
                    }
                    typeConf.put("ignore_above", ignore_above);
                    typeConf.put("type", "keyword");
                    fields.put(formField, typeConf);

                } else if (type.equals("long")) {
                    Map<String, Object> typeConf = new HashMap<>();
                    typeConf.put("ignore_malformed", true);
                    typeConf.put("type", "long");
                    fields.put(formField, typeConf);

                } else if (type.equals("float")) {
                    Map<String, Object> typeConf = new HashMap<>();
                    typeConf.put("ignore_malformed", true);
                    typeConf.put("type", "float");
                    fields.put(formField, typeConf);
                } else if (type.startsWith("date")) {
                    String[] propeStrings = type.split("[(,)]");
                    Map<String, Object> typeConf = new HashMap<>();
                    typeConf.put("type", "date");
                    typeConf.put("ignore_malformed", true);
                    if(fields.containsKey(formField)){
                        Map<String, Object> field = (Map<String, Object>) fields.get(formField);
                        if(field.get("type").equals("date")){

                            if(field.containsKey("format")){

                                if(!((String) field.get("format")).contains(propeStrings[1])){

                                    boolean isOnly = false;
                                    if(propeStrings.length > 1){
                                        if(propeStrings[2].equals("only")){
                                            isOnly = true;
                                        }
                                    }

                                    if(isOnly){
                                        typeConf.put("format", propeStrings[1]);
                                    }
                                    else{
                                        String format = (String) field.get("format");
                                        format = format + "||" + propeStrings[1];
                                        typeConf.put("format", format);
                                    }

                                }
                                else{
                                    typeConf.put("format", (String) field.get("format"));
                                }

                            }else {

                                typeConf.put("format", propeStrings[1]);

                            }
                            
                            fields.put(formField, typeConf);
                        }
                        else{
                            typeConf.put("format", propeStrings[1]);
                            fields.put(formField, typeConf);
                        }
                    }
                    else{
                        typeConf.put("format", propeStrings[1]);
                        fields.put(formField, typeConf);
                    }
                } else if (type.equals("object")){
                    Map<String, Object> typeConf = new HashMap<>();
                    typeConf.put("type", "object");
                    fields.put(formField, typeConf);
                }

            }
            else{
                fields.remove(formField);
            }
        }

    }
    
    public static void updateMappingConfiguration(Map<String, String> updateFields, Map<String, Object> updateFieldsDocs, Map<String, Object> mapping) {

        String formField;
        for (Map.Entry<String, String> entry : updateFields.entrySet()) {

            StringTokenizer multiTokenizer = new StringTokenizer(entry.getKey(), ".");
            Map<String, Object> tmp = mapping;
            while (multiTokenizer.hasMoreTokens()) {

                formField = multiTokenizer.nextToken();
                Map<String, Object> fields = (Map<String, Object>) tmp.get("properties");
                if (fields.containsKey(formField)) {
                    if (multiTokenizer.countTokens() > 0) {
                        tmp = (Map<String, Object>) fields.get(formField);
                        if(!tmp.containsKey("properties")){
                            Map<String, Object> properties = new HashMap<>();
                            tmp.put("properties", properties);
                        }
                    } else {
                        updateFieldInMappings(fields, entry.getValue(), formField);
                        /* if(entry.getValue().equals("delete")){
                            deleteFieldInMappings(mapping, entry.getKey());
                        } 
                        else*/ if(entry.getValue().equals("doc")){
                            fields.put(formField, updateFieldsDocs);
                        }
                    }
                } else {
                    if (multiTokenizer.countTokens() > 0) {
                        Map<String, Object> properties = new HashMap<>();
                        Map<String, Object> newProperties = new HashMap<>();
                        newProperties.put("properties", properties);
                        fields.put(formField, newProperties);
                        tmp = (Map<String, Object>) fields.get(formField);
                    } else {
                        updateFieldInMappings(fields, entry.getValue(), formField);
                    }
                }

            }

        }

    }

    public static void main(String[] args) throws JsonProcessingException {
        
        Map<String, String> newFields = new HashMap<>();
        newFields.put("formData.ATSAmountTL", "text(subfield,512)");
        newFields.put("formData.countryName", "text");

        Map<String, Object> mappings = new HashMap<>();
        Map<String, Object> properties = new HashMap<>();
        mappings.put("properties", properties);
        
        updateMappingConfiguration(newFields,null,mappings);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(mappings));

    }

}
