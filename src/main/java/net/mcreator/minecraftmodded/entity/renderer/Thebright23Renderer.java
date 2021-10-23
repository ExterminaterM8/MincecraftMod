package net.mcreator.minecraftmodded.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class Thebright23Renderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(Thebright23Entity.entity,
					renderManager -> new MobRenderer(renderManager, new SlimeModel(0), 0.5f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("minecraftmodded:textures/slime_gel.png");
						}
					});

		}
	}

}
