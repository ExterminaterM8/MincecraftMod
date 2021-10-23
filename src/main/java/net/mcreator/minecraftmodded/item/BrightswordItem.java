
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightswordItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightsword")
	public static final Item block = null;

	public BrightswordItem(MinecraftmoddedModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BrightcrossItem.block));
			}
		}, 3, -0.3000000000000003f, new Item.Properties().group(LucascrapItemGroup.tab).isImmuneToFire()) {

		}.setRegistryName("brightsword"));
	}

}
