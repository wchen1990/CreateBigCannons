package rbasamoyai.createbigcannons.crafting.foundry;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.PathComputationType;
import rbasamoyai.createbigcannons.CreateBigCannons;
import rbasamoyai.createbigcannons.index.fluid_utils.CBCLiquidBlock;
import rbasamoyai.createbigcannons.munitions.CBCDamageSource;

public class MoltenMetalLiquidBlock extends CBCLiquidBlock {

	public static final DamageSource MOLTEN_METAL = new CBCDamageSource(CreateBigCannons.MOD_ID + ".molten_metal").setIsFire();

	public MoltenMetalLiquidBlock(NonNullSupplier<? extends FlowingFluid> fluid, Properties properties) {
		super(fluid, properties);
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
		return false;
	}

}
