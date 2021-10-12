package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.Block.Block;
import dev.Hilligans.ourcraft.Client.Rendering.NewRenderer.BlockModel;
import dev.Hilligans.ourcraft.Client.Rendering.NewRenderer.PrimitiveBuilder;
import dev.Hilligans.ourcraft.Client.Rendering.NewRenderer.Shader;
import org.joml.Vector3f;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BlockModelParser {

    public static BlockModel getBlockModel(JSONObject model) {
        JSONArray elements = model.getJSONArray("elements");
        JSONObject blockModel = new JSONObject();

        for(int x = 0; x < elements.length(); x++) {
            JSONObject element = elements.getJSONObject(x);
            JSONArray fromArray = element.getJSONArray("from");
            JSONArray toArray = element.getJSONArray("to");
            Vector3f from = new Vector3f(fromArray.getNumber(0).floatValue(),fromArray.getNumber(1).floatValue(),fromArray.getNumber(2).floatValue());
            Vector3f to = new Vector3f(toArray.getNumber(0).floatValue(),toArray.getNumber(1).floatValue(),toArray.getNumber(2).floatValue());
            JSONObject faces = element.getJSONObject("faces");
            for(String string : faces.keySet()) {
                JSONObject face = faces.getJSONObject(string);
                addTo(from,to,face,blockModel,string);
            }
        }
        BlockModel block = new BlockModel(blockModel.toString());

        return block;

    }


    public static void addTo(Vector3f from, Vector3f to, JSONObject side, JSONObject blockModel, String sideName) {
        PrimitiveBuilder primitiveBuilder = new PrimitiveBuilder(0,new Shader(0).addShaderElement(0,5,false));

        JSONArray uv = side.optJSONArray("uv");

        float minX, minY = 0;
        float maxX, maxY = 1;

        if(uv != null) {
            minX = uv.getNumber(0).floatValue() / 16;
            minY = uv.getNumber(1).floatValue() / 16;
            maxX = uv.getNumber(2).floatValue() / 16;
            maxY = uv.getNumber(3).floatValue() / 16;
        }

        switch (sideName) {
            case "down" -> {
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, from.z / 16f, 0, 0);
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, to.z / 16f, 0, 1);
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, from.z / 16f, 1, 0);
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, to.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndicesInverse();
            }
            case "up" -> {
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, from.z / 16f, 0, 0);
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, to.z / 16f, 0, 1);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, from.z / 16f, 1, 0);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, to.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndices();
            }
            case "north" -> {
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, from.z / 16f, 0, 0);
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, from.z / 16f, 0, 1);
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, from.z / 16f, 1, 0);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, from.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndices();
            }
            case "south" -> {
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, to.z / 16f, 0, 0);
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, to.z / 16f, 0, 1);
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, to.z / 16f, 1, 0);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, to.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndicesInverse();
            }
            case "west" -> {
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, from.z / 16f, 0, 0);
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, from.z / 16f, 0, 1);
                primitiveBuilder.addMinus(from.x / 16f, from.y / 16f, to.z / 16f, 1, 0);
                primitiveBuilder.addMinus(from.x / 16f, to.y / 16f, to.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndices();
            }
            case "east" -> {
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, from.z / 16f, 0, 0);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, from.z / 16f, 0, 1);
                primitiveBuilder.addMinus(to.x / 16f, from.y / 16f, to.z / 16f, 1, 0);
                primitiveBuilder.addMinus(to.x / 16f, to.y / 16f, to.z / 16f, 1, 1);
                primitiveBuilder.addQuadIndices();
            }
        }
        JSONObject jsonObject = new JSONObject();
        JSONArray indices = new JSONArray();
        JSONArray vertexArray = new JSONArray();
        for(int x = 0; x < primitiveBuilder.indices.size(); x++) {
            indices.put(primitiveBuilder.indices.get(x));
        }
        if(primitiveBuilder.size != 0) {
            for (int x = 0; x < 4; x++) {
                JSONArray jsonArray = new JSONArray();
                vertexArray.put(jsonArray);
                for (int y = 0; y < 5; y++) {
                    jsonArray.put(primitiveBuilder.vertices.elementData[x * 5 + y]);
                }
            }
            jsonObject.put("vertices", vertexArray);
            jsonObject.put("indices", indices);

            blockModel.put(getSide(sideName) + "", jsonObject);
        }

    }

    public static int getSide(String name) {
        return switch (name) {
            case "up" -> Block.UP;
            case "down" -> Block.DOWN;
            case "north" -> Block.NORTH;
            case "south" -> Block.SOUTH;
            case "east" -> Block.EAST;
            case "west" -> Block.WEST;
            default -> 0;
        };
    }


}
