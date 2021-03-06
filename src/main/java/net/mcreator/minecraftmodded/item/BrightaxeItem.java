
package net.mcreator.minecraftmodded.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.minecraftmodded.itemgroup.LucascrapItemGroup;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightaxeItem extends MinecraftmoddedModElements.ModElement {
	@ObjectHolder("minecraftmodded:brightaxe")
	public static final Item block = null;
	public BrightaxeItem(MinecraftmoddedModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BrightcrossItem.block));
			}
		}, 1, 5.6f, new Item.Properties().group(LucascrapItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("brightaxe"));
	}
}
