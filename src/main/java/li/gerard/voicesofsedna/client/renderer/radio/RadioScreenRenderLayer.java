package li.gerard.voicesofsedna.client.renderer.radio;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.joml.Matrix4f;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import javax.annotation.Nullable;

public class RadioScreenRenderLayer extends GeoRenderLayer<RadioScreenBlockEntity, Void, GeoRenderState> {
    public RadioScreenRenderLayer(RadioScreenRenderer radioScreenRenderer) {
        super(radioScreenRenderer);
    }

    private static final DataTicket<RadioScreenBlockEntity> ENTITY_TICKET =
            DataTicket.create("radio_screen_entity", RadioScreenBlockEntity.class);

    @Override
    public void addRenderData(RadioScreenBlockEntity animatable, Void relatedObject, GeoRenderState renderState) {
        renderState.addGeckolibData(ENTITY_TICKET, animatable);
        super.addRenderData(animatable, relatedObject, renderState);
    }

    @Override
    public void render(GeoRenderState renderState, PoseStack poseStack, BakedGeoModel model,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {

        // If the block isn't visible, skip rendering bars
        if (buffer == null) return;

        RadioScreenBlockEntity screen = renderState.getGeckolibData(ENTITY_TICKET);

        float[] bars = screen.getBarHeights();

        poseStack.pushPose();
        poseStack.translate(0.2f, 0.05f, 0.01f); // Position over the screen

        Matrix4f mat = poseStack.last().pose();
        VertexConsumer vc = bufferSource.getBuffer(RenderType.solid());

        for (int i = 0; i < bars.length; i++) {
            float x = i * 0.03f;
            float h = bars[i] * 0.3f + 0.05f;
            renderBar(vc, mat, x, 0f, h, 0xFF00FF00); // Green
        }

        poseStack.popPose();
    }

    private void renderBar(VertexConsumer vc, Matrix4f mat, float x, float y, float height, int color) {
        float w = 0.025f;
        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >> 8) & 0xFF) / 255f;
        float b = (color & 0xFF) / 255f;
        float a = ((color >> 24) & 0xFF) / 255f;

        vc.addVertex(mat, x, y, 0).setColor(r, g, b, a).setUv(0, 0).setUv2(0, 0).setNormal(0, 0, 1);
        vc.addVertex(mat, x + w, y, 0).setColor(r, g, b, a).setUv(1, 0).setUv2(0, 0).setNormal(0, 0, 1);
        vc.addVertex(mat, x + w, y + height, 0).setColor(r, g, b, a).setUv(1, 1).setUv2(0, 0).setNormal(0, 0, 1);
        vc.addVertex(mat, x, y + height, 0).setColor(r, g, b, a).setUv(0, 1).setUv2(0, 0).setNormal(0, 0, 1);
    }
}
