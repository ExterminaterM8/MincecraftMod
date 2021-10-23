
package net.mcreator.minecraftmodded.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@MinecraftmoddedModElements.ModElement.Tag
public class EeeeeBlock extends MinecraftmoddedModElements.ModElement {

	@ObjectHolder("minecraftmodded:eeeee")
	public static final Block block = null;

	public EeeeeBlock(MinecraftmoddedModElements instance) {
		super(instance, 42);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LucascrapItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("eeeee");
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

	private static Feature<OreFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH = null;

	private static class CustomRuleTest extends RuleTest {

		static final CustomRuleTest INSTANCE = new CustomRuleTest();
		static final com.mojang.serialization.Codec<CustomRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;

			if (blockAt.getBlock() == PureobsidianBlock.block)
				blockCriteria = true;

			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

	private static class FeatureRegisterHandler {

		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("minecraftmodded:eeeee_match"), () -> CustomRuleTest.codec);

			feature = new OreFeature(OreFeatureConfig.CODEC) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

					if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("minecraftmodded:thebright")))
						dimensionCriteria = true;

					if (!dimensionCriteria)
						return false;

					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature.withConfiguration(new OreFeatureConfig(CustomRuleTest.INSTANCE, block.getDefaultState(), 16)).range(64)
					.square().func_242731_b(10);

			event.getRegistry().register(feature.setRegistryName("eeeee"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("minecraftmodded:eeeee"), configuredFeature);
		}

	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("badlands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("badlands_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}

}
