package net.pokemaniac.texturemod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class BlockTextureCycleGenerator {

    private static final Gson GSON = new Gson();

    private BlockTextureCycleGenerator() {
    }

    private static Block resolveBlock(String id) {
        var holder = BuiltInRegistries.BLOCK.get(
                Identifier.parse(id)
        );

        if (holder.isEmpty()) {
            System.out.println(
                    "[TextureArchive] Skipping missing block: " + id
            );
            return null;
        }

        return holder.get().value();
    }

    public static Map<Block, Block> load(MinecraftServer server) {
        Map<Block, Block> cycles = new HashMap<>();

        try {
            ResourceManager resourceManager = server.getResourceManager();

            Identifier resourceId = Identifier.fromNamespaceAndPath(
                    "texturemod",
                    "chisel_cycles.json"
            );

            Optional<Resource> resource = resourceManager.getResource(resourceId);

            if (resource.isEmpty()) {
                throw new IllegalStateException(
                        "Could not find data/texturemod/chisel_cycles.json"
                );
            }

            try (
                    InputStream stream = resource.get().open();
                    InputStreamReader reader = new InputStreamReader(stream)
            ) {
                Type mapType = new TypeToken<Map<String, List<String>>>() {
                }.getType();

                Map<String, List<String>> json =
                        GSON.fromJson(reader, mapType);

                for (List<String> cycle : json.values()) {

                    if (cycle.size() < 2) {
                        continue;
                    }

                    for (int i = 0; i < cycle.size(); i++) {

                        Block current = resolveBlock(cycle.get(i));
                        Block next = resolveBlock(cycle.get((i + 1) % cycle.size()));

                        if (current == null || next == null) {
                            continue;
                        }

                        cycles.put(current, next);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load chisel cycles", e);
        }

        return cycles;
    }
}