
package net.mcreator.minecraftmodded.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftmodded.itemgroup.AidensStuffItemGroup;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

@MinecraftmoddedModElements.ModElement.Tag
public class Igniter2Item extends MinecraftmoddedModElements.ModElement {
	@ObjectHolder("minecraftmodded:igniter_2")
	public static final Item block = null;
	public Igniter2Item(MinecraftmoddedModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AidensStuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("igniter_2");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
