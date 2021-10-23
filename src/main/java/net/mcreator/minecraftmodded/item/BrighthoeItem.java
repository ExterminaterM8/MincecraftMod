
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrighthoeItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brighthoe")
	public static final Item block = null;

	public BrighthoeItem(MinecraftmoddedModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 0, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("brighthoe"));
	}

}
