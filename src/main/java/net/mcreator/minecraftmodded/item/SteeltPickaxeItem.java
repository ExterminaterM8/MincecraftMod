
package net.mcreator.minecraftmodded.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.minecraftmodded.itemgroup.AidensStuffItemGroup;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

@MinecraftmoddedModElements.ModElement.Tag
public class SteeltPickaxeItem extends MinecraftmoddedModElements.ModElement {
	@ObjectHolder("minecraftmodded:steelt_pickaxe")
	public static final Item block = null;
	public SteeltPickaxeItem(MinecraftmoddedModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelingotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(AidensStuffItemGroup.tab)) {
		}.setRegistryName("steelt_pickaxe"));
	}
}
