
package net.mcreator.minecraftmodded.item;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightcrossItem extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightcross")
	public static final Item block = null;

	public BrightcrossItem(MinecraftmoddedModElements instance) {
		super(instance, 27);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LucascrapItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("brightcross");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("melt and cover obsidian and make a portal"));
		}

	}

}
