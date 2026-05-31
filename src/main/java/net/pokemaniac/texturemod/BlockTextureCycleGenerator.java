package net.pokemaniac.texturemod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BlockTextureCycleGenerator {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Map<Block, Block> load(MinecraftServer server) {
        Map<Block, Block> result = new HashMap<>();

        try {
            ResourceManager manager = server.getResourceManager();

            Identifier fileId = Identifier.of("texturemod", "chisel_cycles.json");

            Optional<Resource> resource = manager.getResource(fileId);
            if (resource.isEmpty()) {
                throw new RuntimeException("Could not find data/texturemod/chisel_cycles.json");
            }

            InputStream stream = resource.get().getInputStream();

            Map<String, List<String>> json = MAPPER.readValue(
                    stream,
                    new TypeReference<Map<String, List<String>>>() {}
            );

            for (List<String> ids : json.values()) {
                List<Block> blocks = ids.stream()
                        .map(id -> Registries.BLOCK.get(Identifier.of(id)))
                        .toList();

                for (int i = 0; i < blocks.size(); i++) {
                    Block current = blocks.get(i);
                    Block next = blocks.get((i + 1) % blocks.size());
                    result.put(current, next);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load chisel cycles", e);
        }

        return result;
    }
}
