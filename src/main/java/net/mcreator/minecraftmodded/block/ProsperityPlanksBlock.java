
package net.mcreator.minecraftmodded.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.minecraftmodded.itemgroup.LucascrapItemGroup;
import net.mcreator.minecraftmodded.MinecraftmoddedModElements;

import java.util.List;
import java.util.Collections;

@MinecraftmoddedModElements.ModElement.Tag
public class ProsperityPlanksBlock extends MinecraftmoddedModElements.ModElement {
	@ObjectHolder("minecraftmodded:prosperity_planks")
	public static final Block block = null;
	public ProsperityPlanksBlock(MinecraftmoddedModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LucascrapItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.6f, 3.7006323122135223f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool());
			setRegistryName("prosperity_planks");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 7;
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
