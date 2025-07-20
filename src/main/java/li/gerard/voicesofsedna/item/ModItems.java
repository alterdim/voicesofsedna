package li.gerard.voicesofsedna.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static li.gerard.voicesofsedna.VoicesofSedna.MODID;
import static li.gerard.voicesofsedna.block.ModBlocks.*;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
    public static final DeferredItem<BlockItem> RADIO_CONTROLLER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("radio_controller_block", RADIO_CONTROLLER_BLOCK);
    public static final DeferredItem<BlockItem> RADIO_SCREEN_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("radio_screen_block", RADIO_SCREEN_BLOCK);
}
