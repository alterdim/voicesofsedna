package li.gerard.voicesofsedna.gecko.block;

import li.gerard.voicesofsedna.blockentity.radio.RadioControllerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class RadioControllerGeoModel extends DefaultedBlockGeoModel<RadioControllerBlockEntity> {

    public RadioControllerGeoModel() {
        super(ResourceLocation.fromNamespaceAndPath("voicesofsedna", "radio_controller_block"));
    }

    @Override
    public ResourceLocation getModelResource(GeoRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath("voicesofsedna", "block/radio_controller_block");
    }

    @Override
    public ResourceLocation getTextureResource(GeoRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath("voicesofsedna", "textures/block/radio_controller_block.png");
    }

}
