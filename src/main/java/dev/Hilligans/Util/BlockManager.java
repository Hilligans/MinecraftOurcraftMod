package dev.Hilligans.Util;

import Hilligans.Block.Block;
import Hilligans.Block.Blocks;
import Hilligans.Client.Rendering.NewRenderer.BlockModel;
import Hilligans.Data.Other.BlockProperties;
import Hilligans.Data.Other.BlockShapes.BlockShape;
import Hilligans.ModHandler.Content.ModContent;
import Hilligans.WorldSave.WorldLoader;
import dev.Hilligans.Main;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class BlockManager {

    public static Int2ObjectOpenHashMap<Block> blocks = new Int2ObjectOpenHashMap<Block>();
    public static HashMap<String, BlockShape> blockShapes = new HashMap<>();
    public static HashMap<String, Boolean> transparentBlocks = new HashMap<>();

    static{
        blocks.put(0, Blocks.AIR);
        blocks.put(9670,Blocks.AIR);//CAVE AIR
        transparentBlocks.put("minecraft:block/leaves",true);
        transparentBlocks.put("minecraft:block/cross",true);
        transparentBlocks.put("minecraft:block/tinted_cross",true);
    }

    public static void loadVersion(String name) {
        String a = WorldLoader.readString("/Versions/" + name);

        ModContent modContent = Main.modContent;

        JSONObject jsonObject = new JSONObject(a);
        for (String s : jsonObject.keySet()) {
            String blockName = s.split(":")[1];
            String modelString = WorldLoader.readString("/minecraft/blockstates/" + blockName + ".json");
            String path = "";
            BlockProperties blockProperties = new BlockProperties();
            try {
                JSONObject blockState = new JSONObject(modelString);
                JSONObject variants = blockState.getJSONObject("variants");
                String modelPath = variants.has("") ? variants.getJSONObject("").getString("model").substring(10) : variants.getJSONObject(variants.keys().next()).getString("model").substring(10);
                JSONObject model = new JSONObject(WorldLoader.readString("/minecraft/models/" + modelPath + ".json"));
                JSONObject texture = model.getJSONObject("textures");

                if (transparentBlocks.getOrDefault(model.getString("parent"),false)) {
                    blockProperties.transparent();
                }
                blockProperties.blockShape = getBlockShape(model.getString("parent"));

                path = texture.optString("texture");
                if (path.equals("")) {
                    path = texture.optString("side");
                    if (path.equals("")) {
                        path = texture.optString("all");
                        if (path.equals("")) {
                            path = texture.optString("top");
                            if (path.equals("")) {
                                path = texture.optString("bottom");
                                if (path.equals("")) {
                                    path = texture.optString("cross");
                                }
                            }
                        }
                    }
                }

                if (path.startsWith("minecraft:")) {
                    path = path.substring(16) + ".png";
                } else {

                    path = path.substring(6) + ".png";
                }


            } catch (Exception e) {
            }

            if (!path.equals("")) {
                blockProperties.withTexture(path);
            }
            Block block = new Block(s, blockProperties);
            modContent.registerBlock(block);
            JSONObject jsonObject1 = jsonObject.getJSONObject(s);
            JSONArray jsonArray = jsonObject1.getJSONArray("states");
            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject state = jsonArray.getJSONObject(x);
                blocks.putIfAbsent(state.getInt("id"), block);
            }
        }
    }

    public static BlockShape getBlockShape(String path) {
        if(path.startsWith("minecraft")) {
            path = "/minecraft/models/" + path.substring(10) + ".json";
        } else {
            if(path.startsWith("block/block")) {
                path = "/minecraft/models/" + path.substring(6) + ".json";
            } else {
                path = "/minecraft/models/" + path + ".json";
            }
        }
        if(path.equals("/minecraft/models/block.json")) {
            return BlockProperties.defaultShape;
        }
        if(!blockShapes.containsKey(path)) {
            JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
            if(jsonObject.has("parent") && !jsonObject.has("elements")) {
                return getBlockShape(jsonObject.getString("parent"));
            } else {
                BlockModel blockModel = BlockModelParser.getBlockModel(jsonObject);
                BlockShape blockShape = new BlockShape(blockModel);
                blockShapes.put(path, blockShape);
            }
        }
        return blockShapes.get(path);
    }

}
