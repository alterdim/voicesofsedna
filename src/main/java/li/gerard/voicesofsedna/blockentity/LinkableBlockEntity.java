package li.gerard.voicesofsedna.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class LinkableBlockEntity extends BlockEntity {

    private LinkableBlockEntity linkedBlock;

    public LinkableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public void link(LinkableBlockEntity linkedBlock){
        this.linkedBlock = linkedBlock;
    }

    public void linkBlockAtPos(BlockPos pos) {
        if (level == null) return;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LinkableBlockEntity linkableBlock) {
            link(linkableBlock);
        }
    }

    public boolean isLinked() {
        return linkedBlock != null;
    }
}
