package rbasamoyai.createbigcannons.crafting;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.level.Level;

public class BlockRecipeFinder {

	private static Cache<Object, List<CannonCastingRecipe>> cannonRecipeCache = CacheBuilder.newBuilder().build();
	
	public static List<CannonCastingRecipe> get(@Nullable Object cacheKey, Level level, Predicate<CannonCastingRecipe> predicates) {
		if (cacheKey == null) return startSearch(level, predicates);
		
		try {
			return cannonRecipeCache.get(cacheKey, () -> startSearch(level, predicates));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	private static List<CannonCastingRecipe> startSearch(Level level, Predicate<? super CannonCastingRecipe> predicates) {
		return BlockRecipesManager.getRecipes().stream().filter(predicates).collect(Collectors.toList());
	}
	
	public static final ResourceManagerReloadListener LISTENER = manager -> {
		cannonRecipeCache.invalidateAll();
	};
	
}
