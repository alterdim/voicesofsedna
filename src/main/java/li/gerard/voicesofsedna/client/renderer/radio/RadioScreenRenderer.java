package li.gerard.voicesofsedna.client.renderer.radio;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import li.gerard.voicesofsedna.gecko.block.RadioScreenGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class RadioScreenRenderer extends GeoBlockRenderer<RadioScreenBlockEntity> {

    private RadioScreenBlockEntity currentAnimatable;

    public RadioScreenRenderer(BlockEntityRendererProvider.Context context) {
        super(new RadioScreenGeoModel());
        addRenderLayer(new RadioScreenRenderLayer(this));
    }



}

