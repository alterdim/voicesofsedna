package li.gerard.voicesofsedna.gecko.block;

import li.gerard.voicesofsedna.blockentity.radio.RadioControllerBlockEntity;
import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class RadioScreenGeoModel extends DefaultedBlockGeoModel<RadioScreenBlockEntity> {

    public RadioScreenGeoModel() {
        super(ResourceLocation.fromNamespaceAndPath("voicesofsedna", "radio_screen_block"));
    }

    @Override
    public ResourceLocation getModelResource(GeoRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath("voicesofsedna", "block/radio_screen_block");
    }

    @Override
    public ResourceLocation getTextureResource(GeoRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath("voicesofsedna", "textures/block/radio_screen_block.png");
    }

}
