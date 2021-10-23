
package net.mcreator.minecraftmodded.fuel;

@Mod.EventBusSubscriber
public class CyhgkiFuel {

	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Blocks.DARK_OAK_WOOD.asItem())
			event.setBurnTime(1600);
	}

}
