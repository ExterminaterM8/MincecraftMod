
package net.mcreator.minecraftmodded.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.minecraftmodded.item.Igniter2Item;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

@MinecraftmoddedModElements.ModElement.Tag
public class AidensStuffItemGroup extends MinecraftmoddedModElements.ModElement {
	public AidensStuffItemGroup(MinecraftmoddedModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaidens_stuff") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Igniter2Item.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
