package rbasamoyai.createbigcannons.munitions.autocannon.bullet;

import com.simibubi.create.foundation.utility.Lang;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import rbasamoyai.createbigcannons.CreateBigCannons;
import rbasamoyai.createbigcannons.index.CBCEntityTypes;
import rbasamoyai.createbigcannons.index.CBCItems;
import rbasamoyai.createbigcannons.munitions.autocannon.AbstractAutocannonProjectile;
import rbasamoyai.createbigcannons.munitions.autocannon.AutocannonAmmoItem;

import javax.annotation.Nullable;

import java.util.List;

public class MachineGunRoundItem extends Item implements AutocannonAmmoItem {


	public MachineGunRoundItem(Properties properties) {
		super(properties);
	}

	@Override
	public @Nullable AbstractAutocannonProjectile getAutocannonProjectile(ItemStack stack, Level level) {
		return CBCEntityTypes.MACHINE_GUN_BULLET.create(level);
	}

	@Override public boolean isTracer(ItemStack stack) { return stack.getOrCreateTag().getBoolean("Tracer"); }

	@Override
	public void setTracer(ItemStack stack, boolean value) {
		if (!stack.isEmpty()) stack.getOrCreateTag().putBoolean("Tracer", value);
	}

	@Override public ItemStack getSpentItem(ItemStack stack) { return CBCItems.EMPTY_MACHINE_GUN_ROUND.asStack(); }

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
		if (stack.getOrCreateTag().getBoolean("Tracer")) {
			Lang.builder("tooltip").translate(CreateBigCannons.MOD_ID + ".tracer").addTo(tooltipComponents);
		}
	}

}
