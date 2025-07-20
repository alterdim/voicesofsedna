package li.gerard.voicesofsedna.blockentity.radio;

import li.gerard.voicesofsedna.blockentity.LinkableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animatable.processing.AnimationTest;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import static li.gerard.voicesofsedna.blockentity.ModBlockEntities.RADIO_CONTROLLER_BLOCK_ENTITY;

public class RadioControllerBlockEntity extends LinkableBlockEntity implements GeoBlockEntity {

    //protected static final RawAnimation DEPLOY_ANIM = RawAnimation.begin().thenPlay("misc.deploy").thenLoop("misc.idle");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public RadioControllerBlockEntity(BlockPos pos, BlockState blockState) {
        super(RADIO_CONTROLLER_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
     //   controllers.add(new AnimationController<>(this::deployAnimController));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
