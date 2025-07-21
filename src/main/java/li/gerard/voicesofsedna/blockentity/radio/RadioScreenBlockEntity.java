package li.gerard.voicesofsedna.blockentity.radio;

import li.gerard.voicesofsedna.block.radio.RadioScreenBlock;
import li.gerard.voicesofsedna.blockentity.LinkableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

import static li.gerard.voicesofsedna.blockentity.ModBlockEntities.RADIO_SCREEN_BLOCK_ENTITY;

public class RadioScreenBlockEntity extends LinkableBlockEntity implements GeoBlockEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final float[] barHeights = new float[16];
    private int tick = 0;
    private Status status = Status.UNSTABLE;
    private Random random = new Random();

    private enum Status {
        OFF,
        SEARCHING,
        FOUND,
        UNSTABLE
    }

    public float getSineWaveHeight() {
        switch (getStatus()) {
            case OFF:
                return 0.0f;
            case SEARCHING:
                return 0.1f;
            case FOUND:
                return 0.3f;
            case UNSTABLE:
                return 0.35f;
        }
        return 0.0f;
    }

    public float getSineWaveSpeed() {
        switch (getStatus()) {
            case OFF:
                return 0.0f;
            case SEARCHING:
                return 0.1f;
            case FOUND:
                return 0.3f;
            case UNSTABLE:
                return random.nextFloat(1, 2);
        }
        return 0.0f;
    }

    public Status getStatus() {
        return status;
    }


    public RadioScreenBlockEntity(BlockPos pos, BlockState blockState) {
        super(RADIO_SCREEN_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    public Direction getFacing() {
        return getBlockState().getValue(RadioScreenBlock.FACING);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, RadioScreenBlockEntity blockEntity) {
        blockEntity.tick++;
        for (int i = 0; i < blockEntity.barHeights.length; i++) {
            blockEntity.barHeights[i] = (float) ((Math.sin((blockEntity.tick + i * 3) * 0.15f) + 1f) / 2f);
        }
    }

    public float[] getBarHeights() {
        return barHeights;
    }
}
