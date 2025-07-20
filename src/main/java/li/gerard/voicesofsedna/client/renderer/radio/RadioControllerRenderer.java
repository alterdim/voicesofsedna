package li.gerard.voicesofsedna.client.renderer.radio;

import li.gerard.voicesofsedna.blockentity.radio.RadioControllerBlockEntity;
import li.gerard.voicesofsedna.gecko.block.RadioControllerGeoModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class RadioControllerRenderer extends GeoBlockRenderer<RadioControllerBlockEntity> {

    public RadioControllerRenderer(BlockEntityRendererProvider.Context context) {
        super(new RadioControllerGeoModel());
    }

}
