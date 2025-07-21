package li.gerard.voicesofsedna.client.renderer.radio;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import li.gerard.voicesofsedna.block.radio.RadioScreenBlock;
import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.cache.object.BakedGeoModel;
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
    }

    @Override
    public void render(GeoRenderState renderState, PoseStack poseStack, BakedGeoModel model,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {

        RadioScreenBlockEntity screen = renderState.getGeckolibData(ENTITY_TICKET);

        poseStack.pushPose();
        poseStack.translate(-0.5f, 0.3f, -0.35f); // adjust position
        poseStack.scale(1.6f, 1.6f, 1f);        // adjust size

        Matrix4f mat = poseStack.last().pose();
        VertexConsumer vc = bufferSource.getBuffer(RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath("minecraft", "textures/misc/white.png")));


        long time = screen.getLevel() != null ? screen.getLevel().getGameTime() : 0;

        float height = screen.getSineWaveHeight();
        float speed = screen.getSineWaveSpeed();

        renderSineWave(vc, mat, 0xFF00FF00, time, packedLight, height, speed);

        poseStack.popPose();
    }

    private void renderSineWave(VertexConsumer vc, Matrix4f mat, int color, long time, int light, float height, float speed) {
        float r = ((color >> 16) & 0xFF) / 255f;
        float g = ((color >> 8) & 0xFF) / 255f;
        float b = (color & 0xFF) / 255f;
        float a = ((color >> 24) & 0xFF) / 255f;

        float width = 0.6f;
        int segments = 64;

        float dx = width / segments;
        float phase = ((time * speed )% 40) / 40f * (float) Math.PI * 2;

        for (int i = 0; i < segments - 1; i++) {
            float x1 = i * dx;
            float x2 = (i + 1) * dx;

            float y1 = height / 2f + (float) Math.sin(i * 0.3f + phase) * (height / 2f);
            float y2 = height / 2f + (float) Math.sin((i + 1) * 0.3f + phase) * (height / 2f);

            int lightU = light & 0xFFFF;
            int lightV = (light >> 16) & 0xFFFF;

            float thickness = 0.01f; // Controls how thick the wave looks
            int repeats = 5; // How many extra lines to draw

            for (int o = -repeats; o <= repeats; o++) {
                float offset = o * thickness;

                vc.addVertex(mat, x1, y1 + offset, 0).setColor(r, g, b, a).setUv(0, 0).setUv1(0, 0).setUv2(lightU, lightV).setNormal(0, 0, 1);
                vc.addVertex(mat, x2, y2 + offset, 0).setColor(r, g, b, a).setUv(1, 0).setUv1(0, 0).setUv2(lightU, lightV).setNormal(0, 0, 1);
            }
        }
    }
}
