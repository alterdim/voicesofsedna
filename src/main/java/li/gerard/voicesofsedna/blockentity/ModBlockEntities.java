package li.gerard.voicesofsedna.blockentity;

import li.gerard.voicesofsedna.VoicesofSedna;
import li.gerard.voicesofsedna.block.ModBlocks;
import li.gerard.voicesofsedna.blockentity.radio.RadioControllerBlockEntity;
import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, VoicesofSedna.MODID);

    public static final Supplier<BlockEntityType<RadioControllerBlockEntity>> RADIO_CONTROLLER_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "radio_controller_block_entity",
                    () -> new BlockEntityType<>(
                            RadioControllerBlockEntity::new,
                            false,
                            ModBlocks.RADIO_CONTROLLER_BLOCK.get()
                    )
            );

    public static final Supplier<BlockEntityType<RadioScreenBlockEntity>> RADIO_SCREEN_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "radio_screen_block_entity",
                    () -> new BlockEntityType<>(
                            RadioScreenBlockEntity::new,
                            false,
                            ModBlocks.RADIO_SCREEN_BLOCK.get()
                    )
            );
}
