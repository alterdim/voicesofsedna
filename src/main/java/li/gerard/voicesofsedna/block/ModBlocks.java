package li.gerard.voicesofsedna.block;

import li.gerard.voicesofsedna.VoicesofSedna;
import li.gerard.voicesofsedna.block.radio.RadioControllerBlock;
import li.gerard.voicesofsedna.block.radio.RadioScreenBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VoicesofSedna.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredBlock<RadioControllerBlock> RADIO_CONTROLLER_BLOCK = BLOCKS.register(
            "radio_controller_block",
            registryName -> new RadioControllerBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GRAVEL)
                    .lightLevel(state -> 7)
            ));

    public static final DeferredBlock<RadioScreenBlock> RADIO_SCREEN_BLOCK = BLOCKS.register(
            "radio_screen_block",
            registryName -> new RadioScreenBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> 7)
            ));

}
