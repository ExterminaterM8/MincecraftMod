
package net.mcreator.minecraftmodded.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@MinecraftmoddedModElements.ModElement.Tag
public class BrightinfusedobsidianBlock extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:brightinfusedobsidian")
	public static final Block block = null;

	public BrightinfusedobsidianBlock(MinecraftmoddedModElements instance) {
		super(instance, 34);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LucascrapItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("brightinfusedobsidian");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
