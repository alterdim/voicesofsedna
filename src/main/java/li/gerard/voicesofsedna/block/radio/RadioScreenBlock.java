package li.gerard.voicesofsedna.block.radio;

import li.gerard.voicesofsedna.blockentity.radio.RadioScreenBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static li.gerard.voicesofsedna.blockentity.ModBlockEntities.RADIO_SCREEN_BLOCK_ENTITY;

public class RadioScreenBlock extends Block implements EntityBlock {
    public RadioScreenBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RadioScreenBlockEntity(pos, state);
    }

    @SuppressWarnings("unchecked") // Due to generics, an unchecked cast is necessary here.
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == RADIO_SCREEN_BLOCK_ENTITY.get()
                ? (lvl, pos, st, be) -> RadioScreenBlockEntity.tick(lvl, pos, st, (RadioScreenBlockEntity) be)
                : null;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        return Shapes.empty();
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE; // Let GeckoLib handle the rendering
    }
}
