
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightsludgeItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightsludge")
	public static final Item block = null;

	public BrightsludgeItem(MinecraftmoddedModElements instance) {
		super(instance, 29);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LucascrapItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("brightsludge");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
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
