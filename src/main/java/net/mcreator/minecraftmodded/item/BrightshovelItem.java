
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightshovelItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightshovel")
	public static final Item block = null;

	public BrightshovelItem(MinecraftmoddedModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BrightcrossItem.block));
			}
		}, 1, -3f, new Item.Properties().group(LucascrapItemGroup.tab).isImmuneToFire()) {

		}.setRegistryName("brightshovel"));
	}

}
