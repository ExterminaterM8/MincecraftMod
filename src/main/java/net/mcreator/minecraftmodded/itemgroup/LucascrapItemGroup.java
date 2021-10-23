
package net.mcreator.minecraftmodded.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.minecraftmodded.item.BrightcrossItem;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

@MinecraftmoddedModElements.ModElement.Tag
public class LucascrapItemGroup extends MinecraftmoddedModElements.ModElement {
	public LucascrapItemGroup(MinecraftmoddedModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablucascrap") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BrightcrossItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
