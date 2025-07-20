package li.gerard.voicesofsedna.client.renderer;

import li.gerard.voicesofsedna.blockentity.ModBlockEntities;
import li.gerard.voicesofsedna.client.renderer.radio.RadioControllerRenderer;
import li.gerard.voicesofsedna.client.renderer.radio.RadioScreenRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "voicesofsedna", value = Dist.CLIENT)
public class ModRenderers {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.RADIO_CONTROLLER_BLOCK_ENTITY.get(), RadioControllerRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.RADIO_SCREEN_BLOCK_ENTITY.get(), RadioScreenRenderer::new);
    }
}
