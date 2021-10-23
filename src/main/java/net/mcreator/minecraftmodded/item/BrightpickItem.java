
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightpickItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightpick")
	public static final Item block = null;

	public BrightpickItem(MinecraftmoddedModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 17f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 41;
			}

			public int getEnchantability() {
				return 16;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BrightcrossItem.block));
			}
		}, 1, -3f, new Item.Properties().group(LucascrapItemGroup.tab).isImmuneToFire()) {

		}.setRegistryName("brightpick"));
	}

}
